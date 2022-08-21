package org.dkbfactory.generator.customgenerator

import org.dkbfactory.model.UrlDto
import org.dkbfactory.service.RedisService
import org.dkbfactory.service.URLStoreService
import org.dkbfactory.service.UrlGenerator
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils

@Component
class CustomGenerator(private val redisService: RedisService, private val urlStoreService: URLStoreService) :
    UrlGenerator {

    // here goes the algorithm for generating smaller urls
    override fun generateRandomShortUrl(longUrl: String?): String? {
        // check if there is existing long url then return short url for that
        val shortUrl: String? = redisService[longUrl]
        if (StringUtils.hasText(shortUrl)) return shortUrl
        var randomString: String?
        while (true) {
            randomString = Util.getRandomShortString()
            if (!urlStoreService.isShortUrlExist(randomString) && redisService.save(longUrl, randomString)) {
                redisService.save(randomString, longUrl)
                urlStoreService.saveShortUrl(UrlDto(randomString, longUrl))
                break
            }
        }
        return randomString
    }

    override fun getLongUrl(shortUrl: String?): String? {
        var longUrl: String? = redisService[shortUrl]
        return if (StringUtils.hasText(longUrl)) {
//          extending time for most accessed url more accesses url will live
//          least used url will flush out as there is time to expire
            redisService.extendTimeToLive(shortUrl)
            longUrl
        } else {
            if (shortUrl != null) {
                longUrl = urlStoreService.getShortUrl(shortUrl).longUrl
                println("longUrl$longUrl")
            }
            longUrl
        }
    }
}