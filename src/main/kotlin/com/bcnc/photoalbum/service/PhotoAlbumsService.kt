package com.bcnc.photoalbum.service

import com.bcnc.photoalbum.entity.Album
import com.bcnc.photoalbum.entity.Photo
import com.bcnc.photoalbum.repository.PhotoAlbumsRepository
import org.springframework.stereotype.Service

@Service
class PhotoAlbumsService(private val photoalbumsRepository: PhotoAlbumsRepository) {

    fun getAlbums(): List<Album> {
        return photoalbumsRepository.findAllAlbums()
    }

    fun getPhotosFromAlbum(albumId: Int): List<Photo> {
        return photoalbumsRepository.findPhotosByAlbumid(albumId.toLong())
    }
}