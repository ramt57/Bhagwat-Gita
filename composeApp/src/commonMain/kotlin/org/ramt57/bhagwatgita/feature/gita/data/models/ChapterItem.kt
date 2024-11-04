package org.ramt57.bhagwatgita.feature.gita.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChapterItem(
    @SerialName("chapter_number")
    val chapterNumber: Int,
    val meaning: Language,
    val name: String,
    val summary: Language?,
    val translation: String?,
    val transliteration: String?,
    @SerialName("verses_count")
    val versesCount: Int
)