package com.hemanthdev.dictionary.feat_dictionary.domain.model


data class WordInfo(
    val meanings: List<Meaning>,
    val origin: String,
    val phonetic: String?,
    val word: String
)
