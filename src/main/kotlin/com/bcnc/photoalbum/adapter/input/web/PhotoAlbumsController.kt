
package com.bcnc.photoalbum.adapter.input.web

import com.bcnc.photoalbum.domain.entity.Album
import com.bcnc.photoalbum.domain.entity.Photo
import com.bcnc.photoalbum.service.PhotoAlbumsService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class PhotoAlbumsController(private val photoAlbumsService: PhotoAlbumsService) {

    @GetMapping("/albums")
    @ResponseStatus(value = HttpStatus.OK)
    fun getAllAlbums(): List<Album> {
        return photoAlbumsService.getAlbums()
    }

    @GetMapping("/albums/{albumId}/photos")
    @ResponseStatus(value = HttpStatus.OK)
    fun getPhotosByAlbumId(@PathVariable albumId: Long): List<Photo> {
        return photoAlbumsService.getPhotosFromAlbum(albumId)
    }
}
