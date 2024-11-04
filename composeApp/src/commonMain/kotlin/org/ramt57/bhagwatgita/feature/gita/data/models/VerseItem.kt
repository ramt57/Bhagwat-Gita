package org.ramt57.bhagwatgita.feature.gita.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VerseItem(
    @SerialName("_id") val id: String,
    val chapter: Int,
    @SerialName("verse")
    val verseNumber: Int,
    @SerialName("slok")
    val verse: String,
    val transliteration: String,
    val authors: Map<String, Author>
)

@Serializable
data class Author(
    val author: String,
    val ht: String?,  // Hindi translation
    val hc: String?,  // Hindi commentary
    val et: String?,  // English translation
    val ec: String?,  // English commentary
    val st: String?,  // Sanskrit translation
    val sc: String?   // Sanskrit commentary
)
