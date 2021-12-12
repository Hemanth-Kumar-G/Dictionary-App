package com.hemanthdev.dictionary.feat_dictionary.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.hemanthdev.dictionary.feat_dictionary.domain.model.Definition

data class DefinitionDto(
    @SerializedName("antonyms")
    val antonyms: List<String>,
    @SerializedName("definition")
    var definition: String,
    @SerializedName("example")
    var example: String?,
    @SerializedName("synonyms")
    var synonyms: List<String>
) {
    fun toDefinition(): Definition {
        return Definition(
            antonyms = antonyms,
            definition = definition,
            example = example,
            synonyms = synonyms
        )
    }
}