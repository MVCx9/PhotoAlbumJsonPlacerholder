package com.bcnc.photoalbum.api

import com.bcnc.photoalbum.domain.entity.Album
import com.bcnc.photoalbum.domain.entity.Photo
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus

@Validated
interface PhotoAlbumsApi {

    @GetMapping("/albums")
    @ResponseStatus(value = HttpStatus.OK)
    fun getAllAlbums(): List<Album>

    @GetMapping("/albums/{albumId}/photos")
    @ResponseStatus(value = HttpStatus.OK)
    fun getPhotosByAlbumId(@PathVariable albumId: Long): List<Photo>

}