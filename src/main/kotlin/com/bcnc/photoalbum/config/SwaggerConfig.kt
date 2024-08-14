package com.bcnc.photoalbum.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.FileNotFoundException

@Configuration
class SwaggerConfig {

    @Bean
    fun customOpenAPI(): OpenAPI {
        val openAPIInputStream = this::class.java.classLoader.getResourceAsStream("contract.yaml")
            ?: throw FileNotFoundException("contract.yaml not found in classpath")

        val mapper = ObjectMapper(YAMLFactory())
        val openAPISpec = mapper.readValue(openAPIInputStream, OpenAPI::class.java)

        return openAPISpec.info(
            Info()
                .title("Photo Album API")
                .description("API for managing photo albums and photos")
        )
    }

}