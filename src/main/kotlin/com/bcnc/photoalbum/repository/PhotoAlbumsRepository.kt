package com.bcnc.photoalbum.repository

import com.bcnc.photoalbum.entity.Album
import com.bcnc.photoalbum.entity.Photo
import com.bcnc.photoalbum.infrastructure.JsonPlaceholderClient
import org.springframework.stereotype.Repository

@Repository
class PhotoAlbumsRepository (private val jsonPlaceholderClient: JsonPlaceholderClient){

    fun findAllAlbums(): List<Album> {
        return jsonPlaceholderClient.getAlbums()
    }

    fun findPhotosByAlbumid(albumId: Long): List<Photo> {
        return jsonPlaceholderClient.getPhotosByAlbumId(albumId)
    }
}