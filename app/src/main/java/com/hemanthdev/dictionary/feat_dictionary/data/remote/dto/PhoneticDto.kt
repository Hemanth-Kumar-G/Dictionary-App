package com.hemanthdev.dictionary.feat_dictionary.data.remote.dto


import com.google.gson.annotations.SerializedName

data class PhoneticDto(
    @SerializedName("text")
    var text: String?,
    @SerializedName("audio")
    var audio: String?
)