package com.bcnc.photoalbum.infrastructure

import com.bcnc.photoalbum.entity.Album
import com.bcnc.photoalbum.entity.Photo
import com.bcnc.photoalbum.infrastructure.config.RestTemplateConfig
import org.springframework.stereotype.Component
import org.springframework.web.client.getForObject

@Component
class JsonPlaceholderClient(private val restTemplate: RestTemplateConfig) {

    private val baseUrl = "https://jsonplaceholder.typicode.com"

    fun getAlbums(): List<Album> {
        val url = "$baseUrl/albums"
        val response: Array<Album> =
            restTemplate.restTemplate().getForObject(url)
                ?:
            throw RuntimeException("Error al obtener los álbumes de JSONPlaceholder")

        return response.toList()
    }

    fun getPhotosByAlbumId(albumId: Long): List<Photo> {
        val url = "$baseUrl/albums/$albumId/photos"
        val response: Array<Photo> =
            restTemplate.restTemplate().getForObject(url)
                ?:
            throw RuntimeException("Error al obtener las fotos del álbum $albumId de JSONPlaceholder")

        return response.toList()
    }
}

