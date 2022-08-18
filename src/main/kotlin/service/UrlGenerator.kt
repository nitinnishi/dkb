package org.dkbfactory.service

interface UrlGenerator {
    fun generateRandomShortUrl(longUrl: String?): String?
    fun getLongUrl(shortUrl: String?): String?
}