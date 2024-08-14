package com.bcnc.photoalbum.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

data class SimpleErrorResponse(
    val className: String,
    val type: String,
    val status: Int,
    val message: String
)

// General API Exception
open class ApiException(message: String) : RuntimeException(message)

// Specific Exception for Resource Not Found
class ResourceNotFoundException(message: String) : ApiException(message)

// Specific Exception for API Call Failure
class ApiCallException(message: String) : ApiException(message)

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleResourceNotFoundException (ex: ResourceNotFoundException): ResponseEntity<SimpleErrorResponse> {
        return buildErrorResponse(ex, "Resource Not Found", HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(ApiCallException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleApiCallException(ex: ApiCallException): ResponseEntity<SimpleErrorResponse> {
        return buildErrorResponse(ex, "API Call Failure", HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(ApiException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleApiException(ex: ApiException): ResponseEntity<SimpleErrorResponse> {
        return buildErrorResponse(ex, "API Exception", HttpStatus.INTERNAL_SERVER_ERROR)
    }

    private fun buildErrorResponse(ex: ApiException, type: String, status: HttpStatus): ResponseEntity<SimpleErrorResponse> {
        val response = SimpleErrorResponse(
            className = ex::class.java.canonicalName,
            type = type,
            status = status.value(),
            message = ex.message ?: "An unexpected error occurred"
        )
        return ResponseEntity(response, status)
    }
}
