package com.bcnc.photoalbum.controller

import com.bcnc.photoalbum.entity.Album
import com.bcnc.photoalbum.entity.Photo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AlbumControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @LocalServerPort
    private val port: Int = 0

    @Test
    fun testGetAllAlbums() {
        val response = restTemplate.getForEntity("http://localhost:$port/albums", Array<Album>::class.java)
        assertEquals(HttpStatus.OK, response.statusCode)

        // JSONPlaceholder tiene 100 álbumes
        assertEquals(100, response.body?.size)
    }

    @Test
    fun testGetPhotosByAlbumId() {
        val response = restTemplate.getForEntity("http://localhost:$port/albums/1/photos", Array<Photo>::class.java)
        assertEquals(HttpStatus.OK, response.statusCode)

        // JSONPlaceholder tiene 50 fotos por álbum
        assertEquals(50, response.body?.size)
    }
}
