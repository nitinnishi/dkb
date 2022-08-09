package org.dkbfactory.service

import org.dkbfactory.model.UrlDto
import org.springframework.stereotype.Service

@Service
class ShortUrlService {

    fun createShortUrl(longUrl: String): UrlDto {
        return UrlDto(longUrl, "shortUrl");
    }

    fun getShortUrl(shortUrl: String): UrlDto {
        return UrlDto("longUrl", shortUrl);
    }

}