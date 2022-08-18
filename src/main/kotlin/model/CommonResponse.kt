package org.dkbfactory.model

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@JsonInclude(JsonInclude.Include.NON_NULL)
data class CommonResponse<T>(var status: CommonStatusData, var data: T? = null) {
    fun build(status: HttpStatus): HttpEntity<CommonResponse<T>> {
        return ResponseEntity(
            this,
            status
        )
    }
}