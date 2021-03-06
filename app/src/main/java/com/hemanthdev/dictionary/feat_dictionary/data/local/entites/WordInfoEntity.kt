package com.hemanthdev.dictionary.feat_dictionary.data.local.entites

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hemanthdev.dictionary.feat_dictionary.domain.model.Meaning
import com.hemanthdev.dictionary.feat_dictionary.domain.model.WordInfo

@Entity
data class WordInfoEntity constructor(
    @PrimaryKey val id: Int? = null,
    val word: String,
    val phonetic: String?,
    val origin: String,
    val meanings: List<Meaning>
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meanings = meanings,
            word = word,
            origin = origin,
            phonetic = phonetic
        )
    }
}
