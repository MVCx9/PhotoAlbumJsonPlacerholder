package com.bcnc.photoalbum.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.ErrorResponse
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

// General API Exception
open class ApiException(message: String) : RuntimeException(message)

// Specific Exception for Resource Not Found
class ResourceNotFoundException(message: String) : ApiException(message)

// Specific Exception for API Call Failure
class ApiCallException(message: String) : ApiException(message)

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ApiException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleApiException(ex: ApiException): ErrorResponse {
        return ErrorResponse.create(ex, HttpStatus.INTERNAL_SERVER_ERROR, ex.message.toString())
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleResourceNotFoundException(ex: ResourceNotFoundException): ErrorResponse {
        return ErrorResponse.create(ex, HttpStatus.NOT_FOUND, ex.message.toString())
    }

    @ExceptionHandler(ApiCallException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleApiCallException(ex: ApiCallException): ErrorResponse {
        return ErrorResponse.create(ex, HttpStatus.INTERNAL_SERVER_ERROR, ex.message.toString())
    }

}
