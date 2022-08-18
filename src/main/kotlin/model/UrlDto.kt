package org.dkbfactory.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class UrlDto(
    var longUrl: String?,
    var shortUrl: String?
)
