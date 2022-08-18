package org.dkbfactory.service

import org.dkbfactory.Util.Constants.DKB_URL
import org.dkbfactory.generator.customgenerator.CustomGenerator
import org.dkbfactory.model.UrlDto
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils

@Service
class ShortUrlService(private val customGenerator: CustomGenerator) {

    fun createShortUrl(longUrl: String?): UrlDto {
        val shortUrl = customGenerator.generateRandomShortUrl(longUrl)
        if (StringUtils.hasText(shortUrl))
            return UrlDto(longUrl, DKB_URL + shortUrl)
        return UrlDto(longUrl, "")
    }

    fun getShortUrl(shortUrl: String): String? {
        return customGenerator.getLongUrl(shortUrl)
    }
}