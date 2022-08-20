package org.dkbfactory.controller

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class URLErrorController : ErrorController {
    @RequestMapping("/error")
    fun handleError(): String? {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "<h2>Destination url not found</h2>\n" +
                "</body>\n" +
                "</html>"
    }
}