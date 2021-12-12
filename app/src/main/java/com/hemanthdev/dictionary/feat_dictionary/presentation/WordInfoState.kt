package com.hemanthdev.dictionary.feat_dictionary.presentation

import com.hemanthdev.dictionary.feat_dictionary.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
