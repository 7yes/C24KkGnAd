package com.jesse.c24kkgnad.g2.perritos

import com.google.gson.annotations.SerializedName

data class ResponseDogs(
    @SerializedName("message") val images: List<String>,
    @SerializedName("status") val status: String
)