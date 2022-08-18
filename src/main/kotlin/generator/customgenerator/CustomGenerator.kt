package org.dkbfactory.generator.customgenerator

import org.dkbfactory.service.RedisService
import org.dkbfactory.service.UrlGenerator
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils

@Component
class CustomGenerator(private val redisService: RedisService) : UrlGenerator {

    // here goes the algorithm for generating smaller urls
    override fun generateRandomShortUrl(longUrl: String?): String? {
        // check if there is existing long url then return short url for that
        val shortUrl: String? = redisService[longUrl]
        if (StringUtils.hasText(shortUrl)) return shortUrl
        val randomString: String?
        while (true) {
            randomString = Util.getRandomShortString()
            if (redisService.save(longUrl, randomString))
                redisService.save(randomString, longUrl)
            break
        }
        return randomString
    }

    override fun getLongUrl(shortUrl: String?): String? {
        val longUrl: String? = redisService[shortUrl]
        if (StringUtils.hasText(longUrl)) {
            /*
                extending time for most accessed url more accesses url will live
                least used url will flush out as there is time to expire
            */
            redisService.extendTimeToLive(shortUrl)
            return longUrl
        } else {
            TODO("write module for fetching data from database and return")
            //return shortUrl;
        }

    }
}