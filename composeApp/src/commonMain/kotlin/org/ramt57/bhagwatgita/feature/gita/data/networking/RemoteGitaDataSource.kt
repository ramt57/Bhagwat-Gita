package org.ramt57.bhagwatgita.feature.gita.data.networking

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import org.ramt57.bhagwatgita.core.data.networking.constructUrl
import org.ramt57.bhagwatgita.core.data.networking.safeCall
import org.ramt57.bhagwatgita.core.domain.util.NetworkError
import org.ramt57.bhagwatgita.core.domain.util.Result
import org.ramt57.bhagwatgita.feature.gita.domain.GitaDataSource
import org.ramt57.bhagwatgita.feature.gita.data.models.ChapterItem
import org.ramt57.bhagwatgita.feature.gita.data.models.VerseItem

internal class RemoteGitaDataSource(val httpClient: HttpClient): GitaDataSource {
    override suspend fun getAllChapters(): Result<List<ChapterItem>, NetworkError> {
        return safeCall { httpClient.get(urlString = constructUrl(ApiRoutes.AllChapters)) }
    }

    override suspend fun getChapterByNumber(number: Int): Result<ChapterItem, NetworkError> {
        return safeCall { httpClient.get(urlString = constructUrl("${ApiRoutes.Chapter}/$number")) }
    }

    override suspend fun getSlok(
        chapterNumber: Int,
        slokNumber: Int
    ): Result<VerseItem, NetworkError> {
        return safeCall { httpClient.get(urlString = constructUrl("${ApiRoutes.Verse}/$chapterNumber/$slokNumber")) }
    }

    override suspend fun getRandomSlok(): Result<VerseItem, NetworkError> {
        return safeCall { httpClient.get(urlString = constructUrl(ApiRoutes.Verse)) }
    }

    override suspend fun getRandomSlokByChapter(chapterNumber: Int): Result<VerseItem, NetworkError> {
        return safeCall { httpClient.get(urlString = constructUrl("${ApiRoutes.Verse}/${chapterNumber}/1")) }
    }
}