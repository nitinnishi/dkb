package org.dkbfactory.org.dkbfactory.controller

import org.dkbfactory.model.UrlDto
import org.dkbfactory.service.ShortUrlService
import org.springframework.web.bind.annotation.*

@RestController
class LittleURLController(val shortUrlService: ShortUrlService) {
    @PostMapping("/v1/create")
    fun createLittleUrl(@RequestBody urlDto: UrlDto): UrlDto {
        return shortUrlService.createShortUrl(urlDto.longUrl);
    }

    @GetMapping("/{shortUrl}")
    fun getLittleUrl(@PathVariable("shortUrl")shortUrl:String): UrlDto {
        return shortUrlService.getShortUrl(shortUrl);
    }
}