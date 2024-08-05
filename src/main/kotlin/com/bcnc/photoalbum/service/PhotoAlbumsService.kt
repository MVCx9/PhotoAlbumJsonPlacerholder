package com.bcnc.photoalbum.service

import com.bcnc.photoalbum.domain.entity.Album
import com.bcnc.photoalbum.domain.entity.Photo
import com.bcnc.photoalbum.domain.repository.PhotoAlbumsRepository
import org.springframework.stereotype.Service

@Service
class PhotoAlbumsService(private val photoAlbumsRepository: PhotoAlbumsRepository) {

    fun getAlbums(): List<Album> {
        return photoAlbumsRepository.findAllAlbums()
    }

    fun getPhotosFromAlbum(albumId: Int): List<Photo> {
        return photoAlbumsRepository.findPhotosByAlbumId(albumId.toLong())
    }
}