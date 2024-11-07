package org.ramt57.bhagwatgita.feature.gita.presentation.ui.home

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class Detail(val chapterName: String, val verseNumber: String)