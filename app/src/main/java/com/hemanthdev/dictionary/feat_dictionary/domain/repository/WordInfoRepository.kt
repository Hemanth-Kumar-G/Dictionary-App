package com.hemanthdev.dictionary.feat_dictionary.domain.repository

import com.hemanthdev.dictionary.core.util.Resource
import com.hemanthdev.dictionary.feat_dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>

}