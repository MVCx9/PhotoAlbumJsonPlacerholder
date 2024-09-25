package com.bcnc.photoalbum.service


import com.bcnc.photoalbum.application.service.PhotoAlbumsService
import com.bcnc.photoalbum.domain.entity.Album
import com.bcnc.photoalbum.domain.entity.Photo
import com.bcnc.photoalbum.domain.exceptions.ApiCallException
import com.bcnc.photoalbum.domain.exceptions.ResourceNotFoundException
import com.bcnc.photoalbum.domain.repository.PhotoAlbumsRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.web.client.HttpClientErrorException

@SpringBootTest
class PhotoAlbumsServiceTest {

    @MockBean
    private lateinit var photoAlbumsRepository: PhotoAlbumsRepository

    private lateinit var photoAlbumsService: PhotoAlbumsService

    @BeforeEach
    fun setUp() {
        photoAlbumsService = PhotoAlbumsService(photoAlbumsRepository)
    }

    @Test
    fun `should return all albums`() {
        val expectedAlbums = listOf(
            Album(1,1,"Example album 1"),
            Album(2,2,"Example album 2")
        )

        whenever(photoAlbumsRepository.findAllAlbums()).thenReturn(expectedAlbums)
        val actualAlbums = photoAlbumsService.getAlbums()

        assertEquals(expectedAlbums, actualAlbums)
    }

    @Test
    fun `should return photos by album ID`() {
        val albumId:Long = 1
        val expectedPhotos = listOf(
            Photo(1,1,"Beach","http://example.com/photo1.jpg","http://example.com/photo1_thumb.jpg"),
            Photo(2,2,"Mountains","http://example.com/photo2.jpg","http://example.com/photo2_thumb.jpg")
        )

        whenever(photoAlbumsRepository.findPhotosByAlbumId(any())).thenReturn(expectedPhotos)
        val actualPhotos = photoAlbumsService.getPhotosFromAlbum(albumId)

        assertEquals(expectedPhotos, actualPhotos)
    }

    @Test
    fun `should return 404 error because albums does not exist`() {
        whenever(photoAlbumsRepository.findAllAlbums()).thenReturn(emptyList())

        assertThrows<ResourceNotFoundException> {
            photoAlbumsService.getAlbums()
        }
    }

    @Test
    fun `should return 404 error because photos does not exist in album ID`() {
        val albumId:Long = 1

        whenever(photoAlbumsRepository.findPhotosByAlbumId(any())).thenReturn(emptyList())

        assertThrows<ResourceNotFoundException> {
            photoAlbumsService.getPhotosFromAlbum(albumId)
        }
    }

    @Test
    fun `should return 500 because error fetching albums`() {
        whenever(photoAlbumsRepository.findAllAlbums()).thenThrow(HttpClientErrorException::class.java)

        assertThrows<ApiCallException> {
            photoAlbumsService.getAlbums()
        }
    }

    @Test
    fun `should return 500 because error fetching photos from album ID`() {
        val albumId:Long = 1

        whenever(photoAlbumsRepository.findPhotosByAlbumId(any())).thenThrow(HttpClientErrorException::class.java)

        assertThrows<ApiCallException> {
            photoAlbumsService.getPhotosFromAlbum(albumId)
        }
    }
}
