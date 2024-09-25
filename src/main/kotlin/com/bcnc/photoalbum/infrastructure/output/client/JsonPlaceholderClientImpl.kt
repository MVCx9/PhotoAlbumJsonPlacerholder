package com.bcnc.photoalbum.infrastructure.output.client

import com.bcnc.photoalbum.application.output.client.JsonPlaceholderClient
import com.bcnc.photoalbum.application.output.client.JsonPlaceholderClient.Companion.BASEURL
import com.bcnc.photoalbum.infrastructure.config.RestTemplateConfig
import com.bcnc.photoalbum.domain.entity.Album
import com.bcnc.photoalbum.domain.entity.Photo
import org.springframework.stereotype.Component
import org.springframework.web.client.getForObject

@Component
class JsonPlaceholderClientImpl (private val restTemplate: RestTemplateConfig) : JsonPlaceholderClient {

    override fun getAlbums(): List<Album> {
        val url = "$BASEURL/albums"
        return restTemplate.restTemplate().getForObject<Array<Album>>(url).toList()
    }

    override fun getPhotosByAlbumId(albumId: Long): List<Photo> {
        val url = "$BASEURL/albums/$albumId/photos"
        return restTemplate.restTemplate().getForObject<Array<Photo>>(url).toList()
    }
}