package com.hemanthdev.dictionary.feat_dictionary.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.hemanthdev.dictionary.feat_dictionary.domain.model.Meaning

data class MeaningDto(
    @SerializedName("partOfSpeech")
    var partOfSpeech: String,
    @SerializedName("definitions")
    var definitions: List<DefinitionDto>
) {
    fun toMeaning(): Meaning {
        return Meaning(
            definitions = definitions.map { it.toDefinition() },
            partOfSpeech = partOfSpeech
        )
    }
}