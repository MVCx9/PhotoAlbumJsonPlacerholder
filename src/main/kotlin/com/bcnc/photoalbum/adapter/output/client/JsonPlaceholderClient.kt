package com.bcnc.photoalbum.adapter.output.client

import com.bcnc.photoalbum.domain.entity.Album
import com.bcnc.photoalbum.domain.entity.Photo
import org.springframework.stereotype.Component

@Component
interface JsonPlaceholderClient {

    companion object {
        const val BASEURL = "https://jsonplaceholder.typicode.com"
    }

    fun getAlbums(): List<Album>
    fun getPhotosByAlbumId(albumId: Long): List<Photo>
}
