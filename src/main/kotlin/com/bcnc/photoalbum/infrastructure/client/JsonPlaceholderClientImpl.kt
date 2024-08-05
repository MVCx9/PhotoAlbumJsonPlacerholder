package com.bcnc.photoalbum.infrastructure.client

import com.bcnc.photoalbum.adapter.output.client.JsonPlaceholderClient
import com.bcnc.photoalbum.adapter.output.client.JsonPlaceholderClient.Companion.BASEURL
import com.bcnc.photoalbum.config.RestTemplateConfig
import com.bcnc.photoalbum.domain.entity.Album
import com.bcnc.photoalbum.domain.entity.Photo
import com.bcnc.photoalbum.exceptions.ApiCallException
import com.bcnc.photoalbum.exceptions.ResourceNotFoundException
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.getForObject

@Component
class JsonPlaceholderClientImpl (private val restTemplate: RestTemplateConfig) : JsonPlaceholderClient{

    override fun getAlbums(): List<Album> {
        val url = "$BASEURL/albums"

        return try {
            restTemplate.restTemplate().getForObject<Array<Album>>(url).toList().also {
                if(it.isEmpty())
                    throw ResourceNotFoundException("Albums not found")
            }

        } catch (e: HttpClientErrorException) {
            throw ApiCallException("Error fetching albums: ${e.message}")
        }
    }

    override fun getPhotosByAlbumId(albumId: Long): List<Photo> {
        val url = "$BASEURL/albums/$albumId/photos"

        return try {
            restTemplate.restTemplate().getForObject<Array<Photo>>(url).toList().also {
                if(it.isEmpty())
                    throw ResourceNotFoundException("Photos not found in Album $albumId")
            }

        } catch (e: HttpClientErrorException) {
            throw ApiCallException("Error fetching photos: ${e.message}")
        }
    }
}