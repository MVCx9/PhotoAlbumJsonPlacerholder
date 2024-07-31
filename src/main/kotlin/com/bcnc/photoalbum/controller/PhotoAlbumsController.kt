package com.bcnc.photoalbum.controller

import com.bcnc.photoalbum.entity.Album
import com.bcnc.photoalbum.entity.Photo
import com.bcnc.photoalbum.service.PhotoAlbumsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class AlbumController(private val photoalbumsService: PhotoAlbumsService) {

    @GetMapping("/albums")
    fun getAllAlbums(): List<Album> {
        return photoalbumsService.getAlbums()
    }

    @GetMapping("/albums/{albumId}/photos")
    fun getPhotosByAlbumId(@PathVariable albumId: Long): List<Photo> {
        return photoalbumsService.getPhotosFromAlbum(albumId.toInt())
    }
}
