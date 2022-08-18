package org.dkbfactory.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class RedisConfiguration {

    @Bean
    fun redisTemplate(): RedisTemplate<String, Any> {
        val template: RedisTemplate<String, Any> = RedisTemplate()
        template.setDefaultSerializer(StringRedisSerializer())
        template.setConnectionFactory(jedisConnectionFactory())
        return template
    }

    @Bean
    fun jedisConnectionFactory(): JedisConnectionFactory {
        val redisStandaloneConfiguration = RedisStandaloneConfiguration("localhost", 6379)
        redisStandaloneConfiguration.database = 0
        val jedisConFactory = JedisConnectionFactory(redisStandaloneConfiguration)
        jedisConFactory.poolConfig?.maxTotal = 100
        jedisConFactory.poolConfig?.maxIdle = 10
        jedisConFactory.poolConfig?.minIdle = 2
        return jedisConFactory
    }
}