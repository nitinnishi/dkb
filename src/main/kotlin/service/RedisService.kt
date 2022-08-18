package org.dkbfactory.service

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import java.util.concurrent.TimeUnit


@Service
class RedisService(val redisTemplate: RedisTemplate<String, Any>) {

    fun save(keyUrl: String?, valueUrl: String?): Boolean {
        val valueOperations = redisTemplate.opsForValue()
        return valueOperations.setIfAbsent(keyUrl, valueUrl, 15, TimeUnit.DAYS)
    }

    @Throws(Exception::class)
    operator fun get(longUrl: String?): String? {
        val shortUrl: String?
        val valueOperations = redisTemplate.opsForValue()
        shortUrl = valueOperations.get(longUrl) as? String
        if (!StringUtils.hasText(shortUrl)) {
            return ""
        }
        return shortUrl
    }

    @Throws(Exception::class)
    fun extendTimeToLive(urlKey: String?) {
        try {
            redisTemplate.expire(urlKey, 15, TimeUnit.MINUTES)
        } catch (e: java.lang.Exception) {
            println("Error extending time to live")
            throw Exception("Error extending time to live")
        }
    }
}