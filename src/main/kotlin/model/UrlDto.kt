package org.dkbfactory.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document("UrlStore")
@JsonIgnoreProperties(ignoreUnknown = true)
data class UrlDto(
    @Id
    var shortUrl: String?,
    var longUrl: String?

)
