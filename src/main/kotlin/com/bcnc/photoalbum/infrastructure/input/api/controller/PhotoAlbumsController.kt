
package com.bcnc.photoalbum.infrastructure.input.api.controller

import com.bcnc.photoalbum.application.input.web.PhotoAlbumsApi
import com.bcnc.photoalbum.domain.entity.Album
import com.bcnc.photoalbum.domain.entity.Photo
import com.bcnc.photoalbum.application.service.PhotoAlbumsService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PhotoAlbumsController (private val photoAlbumsService: PhotoAlbumsService) : PhotoAlbumsApi {

    override fun getAllAlbums(): List<Album> {
        return photoAlbumsService.getAlbums()
    }

    override fun getPhotosByAlbumId(@PathVariable albumId: Long): List<Photo> {
        return photoAlbumsService.getPhotosFromAlbum(albumId)
    }
}
