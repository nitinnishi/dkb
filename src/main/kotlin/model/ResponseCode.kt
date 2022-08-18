package org.dkbfactory.model

import org.springframework.http.HttpStatus

enum class ResponseCode(
    val httpStatus: HttpStatus,
    val responseCode: String,
    val responseMessage: String
) {
    SUCCESS(HttpStatus.OK, "success", "Success"),
    ERROR(HttpStatus.BAD_REQUEST, "invalid_url", "Error in generating short url")
}