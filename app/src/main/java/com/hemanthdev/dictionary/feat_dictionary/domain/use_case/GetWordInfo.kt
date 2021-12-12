package com.hemanthdev.dictionary.feat_dictionary.domain.use_case

import com.hemanthdev.dictionary.core.util.Resource
import com.hemanthdev.dictionary.feat_dictionary.domain.model.WordInfo
import com.hemanthdev.dictionary.feat_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    private val repository: WordInfoRepository
) {
    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if (word.isBlank()) {
            return flow { }
        }
        return repository.getWordInfo(word)
    }
}