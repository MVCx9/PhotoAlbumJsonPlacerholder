package com.bcnc.photoalbum.adapter

import com.bcnc.photoalbum.infrastructure.input.api.controller.PhotoAlbumsController
import com.bcnc.photoalbum.domain.entity.Album
import com.bcnc.photoalbum.domain.entity.Photo
import com.bcnc.photoalbum.domain.repository.PhotoAlbumsRepository
import com.bcnc.photoalbum.application.service.PhotoAlbumsService
import io.restassured.RestAssured
import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

@SpringBootTest
class PhotoAlbumsComponentTest {

    @MockBean
    private lateinit var photoAlbumsRepository: PhotoAlbumsRepository

    private lateinit var photoAlbumsService: PhotoAlbumsService

    @BeforeEach
    fun setup() {
        photoAlbumsService = PhotoAlbumsService(photoAlbumsRepository)
        RestAssuredMockMvc.standaloneSetup(PhotoAlbumsController(photoAlbumsService))
        RestAssured.baseURI = "http://localhost:8080"
    }

    @Test
    fun `should return all albums with status OK`() {
        val albums = listOf(
            Album(1,1, "Example album 1"),
            Album(2,2, "Example album 2")
        )

        whenever(photoAlbumsRepository.findAllAlbums()).thenReturn(albums)

        RestAssuredMockMvc.given()
            .`when`()
                .get("/albums")
            .then()
                .statusCode(HttpStatus.OK.value())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body("$.size()", equalTo(albums.size))
                .body("[0].userId", equalTo(albums[0].userId.toInt()))
                .body("[0].id", equalTo(albums[0].id.toInt()))
                .body("[0].title", equalTo(albums[0].title))
                .body("[1].userId", equalTo(albums[1].userId.toInt()))
                .body("[1].id", equalTo(albums[1].id.toInt()))
                .body("[1].title", equalTo(albums[1].title))
    }

    @Test
    fun `should return photos for a specific album with status OK`() {
        val albumId:Long = 1
        val photos = listOf(
            Photo(1, 1,"Example photo 1","http://example.com/photo1.jpg","http://example.com/photo1_thumb.jpg"),
            Photo(2,2,"Example photo 2","http://example.com/photo2.jpg","http://example.com/photo2_thumb.jpg")
        )

        whenever(photoAlbumsRepository.findPhotosByAlbumId(any())).thenReturn(photos)

        RestAssuredMockMvc.given()
            .`when`()
                .get("/albums/{albumId}/photos", albumId)
            .then()
                .statusCode(HttpStatus.OK.value())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body("$.size()", equalTo(photos.size))
                .body("[0].id", equalTo(photos[0].id.toInt()))
                .body("[0].title", equalTo(photos[0].title))
                .body("[0].url", equalTo(photos[0].url))
                .body("[0].thumbnailUrl", equalTo(photos[0].thumbnailUrl))
                .body("[1].id", equalTo(photos[1].id.toInt()))
                .body("[1].title", equalTo(photos[1].title))
                .body("[1].url", equalTo(photos[1].url))
                .body("[1].thumbnailUrl", equalTo(photos[1].thumbnailUrl))
    }

}
