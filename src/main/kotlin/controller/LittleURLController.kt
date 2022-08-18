package org.dkbfactory.controller

import org.dkbfactory.model.CommonResponse
import org.dkbfactory.model.CommonStatusData
import org.dkbfactory.model.ResponseCode
import org.dkbfactory.model.UrlDto
import org.dkbfactory.service.ShortUrlService
import org.springframework.http.HttpEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@RestController
class LittleURLController(val shortUrlService: ShortUrlService) {
    @PostMapping("/v1/create")
    fun createLittleUrl(@RequestBody urlDto: UrlDto): HttpEntity<CommonResponse<Any>> {

        var urlbody: UrlDto = shortUrlService.createShortUrl(urlDto.longUrl)
        return if(urlbody.shortUrl.equals("")) {
             CommonResponse<Any>(
                status = CommonStatusData(
                    code = ResponseCode.ERROR.responseCode,
                    message = ResponseCode.ERROR.responseMessage
                ),
                data = "Error creating short url"
            ).build(ResponseCode.ERROR.httpStatus)
        } else {
             CommonResponse<Any>(
                status = CommonStatusData(
                    code = ResponseCode.SUCCESS.responseCode,
                    message = ResponseCode.SUCCESS.responseMessage
                ),
                data = urlbody
            ).build(ResponseCode.SUCCESS.httpStatus)
        }
    }

    @GetMapping("/{shortUrl}")
    fun getLittleUrl(@PathVariable("shortUrl") shortUrl: String): ModelAndView? {
        return ModelAndView("redirect:" + shortUrlService.getShortUrl(shortUrl))
    }
}