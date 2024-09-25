package com.bcnc.photoalbum.infrastructure.repository

import com.bcnc.photoalbum.application.output.client.JsonPlaceholderClient
import com.bcnc.photoalbum.domain.entity.Album
import com.bcnc.photoalbum.domain.entity.Photo
import com.bcnc.photoalbum.domain.repository.PhotoAlbumsRepository
import org.springframework.stereotype.Repository

@Repository
class PhotoAlbumsRepositoryImpl (private val jsonPlaceholderClient: JsonPlaceholderClient) : PhotoAlbumsRepository {

    override fun findAllAlbums(): List<Album> {
        return jsonPlaceholderClient.getAlbums()
    }

    override fun findPhotosByAlbumId(albumId: Long): List<Photo> {
        return jsonPlaceholderClient.getPhotosByAlbumId(albumId)
    }

}