package com.bcnc.photoalbum.application.service

import com.bcnc.photoalbum.domain.entity.Album
import com.bcnc.photoalbum.domain.entity.Photo
import com.bcnc.photoalbum.domain.exceptions.ApiCallException
import com.bcnc.photoalbum.domain.exceptions.ResourceNotFoundException
import com.bcnc.photoalbum.domain.repository.PhotoAlbumsRepository
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
class PhotoAlbumsService (private val photoAlbumsRepository: PhotoAlbumsRepository) {

    fun getAlbums(): List<Album> {
        return try {
            photoAlbumsRepository.findAllAlbums().also {
                if(it.isEmpty())
                    throw ResourceNotFoundException("Albums not found")
            }

        } catch (e: HttpClientErrorException) {
            throw ApiCallException("Error fetching albums: ${e.message}")
        }
    }

    fun getPhotosFromAlbum(albumId: Long): List<Photo> {
        return try {
            photoAlbumsRepository.findPhotosByAlbumId(albumId).also {
                if(it.isEmpty())
                    throw ResourceNotFoundException("Photos not found in Album $albumId")
            }

        } catch (e: HttpClientErrorException) {
            throw ApiCallException("Error fetching photos: ${e.message}")
        }
    }
}