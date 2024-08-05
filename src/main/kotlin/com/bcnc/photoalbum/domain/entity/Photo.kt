package com.bcnc.photoalbum.domain.entity

data class Photo (

    val albumId: Long,
    val id: Long,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)