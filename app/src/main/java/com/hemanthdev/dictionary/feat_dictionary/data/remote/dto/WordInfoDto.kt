package com.hemanthdev.dictionary.feat_dictionary.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.hemanthdev.dictionary.feat_dictionary.data.local.entites.WordInfoEntity

data class WordInfoDto(
    @SerializedName("word")
    var word: String,
    @SerializedName("phonetics")
    var phonetics: List<PhoneticDto>,
    @SerializedName("meanings")
    var meanings: List<MeaningDto>,
    @SerializedName("origin")
    val origin: String,
    @SerializedName("phonetic")
    val phonetic: String,
) {
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
            origin = origin,
            phonetic = phonetic,
            word = word
        )
    }
}