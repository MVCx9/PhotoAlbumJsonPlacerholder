package com.bcnc.photoalbum.domain.repository

import com.bcnc.photoalbum.domain.entity.Album
import com.bcnc.photoalbum.domain.entity.Photo
import org.springframework.stereotype.Repository

@Repository
interface PhotoAlbumsRepository {

    fun findAllAlbums(): List<Album>
    fun findPhotosByAlbumId(albumId: Long): List<Photo>
}