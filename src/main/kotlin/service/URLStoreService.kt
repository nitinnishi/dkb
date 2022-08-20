package org.dkbfactory.service

import org.dkbfactory.data.UrlRepository
import org.dkbfactory.model.UrlDto
import org.springframework.stereotype.Service

@Service
class URLStoreService(val urlRepository: UrlRepository) {

    fun getShortUrl(shortUrl: String): UrlDto {
        val urlDto = try {
            urlRepository.findById(shortUrl).get()
        }catch (nse:NoSuchElementException){
            UrlDto("","")
        }
        return urlDto
    }

    fun saveShortUrl(urlDto: UrlDto): UrlDto {
        return urlRepository.save(urlDto)
    }
}