package com.bcnc.photoalbum.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Album (

    val userId: Long,
    val id: Long,
    val title: String
)