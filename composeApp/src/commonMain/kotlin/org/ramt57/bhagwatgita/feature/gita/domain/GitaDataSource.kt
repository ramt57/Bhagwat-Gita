package org.ramt57.bhagwatgita.feature.gita.domain

import org.ramt57.bhagwatgita.core.domain.util.NetworkError
import org.ramt57.bhagwatgita.core.domain.util.Result
import org.ramt57.bhagwatgita.feature.gita.data.models.ChapterItem
import org.ramt57.bhagwatgita.feature.gita.data.models.SlokItem

interface GitaDataSource {
    suspend fun getAllChapters(): Result<List<ChapterItem>, NetworkError>
    suspend fun getChapterByNumber(number: Int): Result<ChapterItem, NetworkError>
    suspend fun getSlok(chapterNumber: Int, slokNumber: Int): Result<SlokItem, NetworkError>
    suspend fun getRandomSlok(): Result<SlokItem, NetworkError>
    suspend fun getRandomSlokByChapter(chapterNumber: Int): Result<SlokItem, NetworkError>
}