package org.ramt57.bhagwatgita.feature.gita.data.models

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.int
import kotlinx.serialization.json.jsonPrimitive

@Serializable(with = GitaVerseSerializer::class)
data class VerseItem(
    @SerialName("_id") val id: String,
    val chapter: Int?,
    @SerialName("verse")
    val verseNumber: Int?,
    @SerialName("slok")
    val verse: String?,
    val transliteration: String?,
    val authors: Map<String, Author>?
)

@Serializable
data class Author(
    val author: String?,
    @SerialName("ht")
    val hindiTranslation: String?,  // Hindi translation
    @SerialName("hc")
    val hindiCommentary: String?,  // Hindi commentary
    @SerialName("et")
    val englishTranslation: String?,  // English translation
    @SerialName("ec")
    val englishCommentary: String?,  // English commentary
    @SerialName("st")
    val sanskritTranslation: String?,  // Sanskrit translation
    @SerialName("sc")
    val sanskritCommentary: String?  // Sanskrit commentary
)

private object GitaVerseSerializer : KSerializer<VerseItem> {
    private val knownProperties = setOf("_id", "chapter", "verse", "slok", "transliteration")

    override val descriptor = buildClassSerialDescriptor("VerseItem") {
        element("_id", PrimitiveSerialDescriptor("_id", PrimitiveKind.STRING))
        element("chapter", PrimitiveSerialDescriptor("chapter", PrimitiveKind.INT))
        element("verse", PrimitiveSerialDescriptor("verse", PrimitiveKind.INT))
        element("slok", PrimitiveSerialDescriptor("slok", PrimitiveKind.STRING))
        element("transliteration", PrimitiveSerialDescriptor("transliteration", PrimitiveKind.STRING))
        element("authors", MapSerializer(String.serializer(), Author.serializer()).descriptor)
    }

    override fun deserialize(decoder: Decoder): VerseItem {
        val jsonObject = decoder.decodeSerializableValue(JsonElement.serializer()) as JsonObject

        // Extract known properties
        val id = jsonObject["_id"]?.jsonPrimitive?.content ?: ""
        val chapter = jsonObject["chapter"]?.jsonPrimitive?.int ?: 0
        val verse = jsonObject["verse"]?.jsonPrimitive?.int ?: 0
        val slok = jsonObject["slok"]?.jsonPrimitive?.content ?: ""
        val transliteration = jsonObject["transliteration"]?.jsonPrimitive?.content ?: ""

        // Extract commentaries from remaining properties
        val commentaries = mutableMapOf<String, Author>()
        jsonObject.forEach { (key, value) ->
            if (key !in knownProperties && value is JsonObject) {
                try {
                    val commentary = Author(
                        author = value["author"]?.jsonPrimitive?.content ?: "",
                        hindiTranslation = value["ht"]?.jsonPrimitive?.contentOrNull,
                        englishTranslation = value["et"]?.jsonPrimitive?.contentOrNull,
                        englishCommentary = value["ec"]?.jsonPrimitive?.contentOrNull,
                        hindiCommentary = value["hc"]?.jsonPrimitive?.contentOrNull,
                        sanskritCommentary = value["sc"]?.jsonPrimitive?.contentOrNull,
                        sanskritTranslation = value["st"]?.jsonPrimitive?.contentOrNull,
                    )
                    commentaries[key] = commentary
                } catch (e: Exception) {
                    println("Failed to parse commentary for key: $key")
                    e.printStackTrace()
                }
            }
        }

        return VerseItem(id, chapter, verse, slok, transliteration, commentaries)
    }

    override fun serialize(encoder: Encoder, value: VerseItem) {
        val jsonObject = buildJsonObject {
            put("_id", JsonPrimitive(value.id))
            put("chapter", JsonPrimitive(value.chapter))
            put("verse", JsonPrimitive(value.verseNumber))
            put("slok", JsonPrimitive(value.verse))
            put("transliteration", JsonPrimitive(value.transliteration))

            // Add commentaries as top-level properties
            value.authors?.forEach { (key, commentary) ->
                put(key, Json.encodeToJsonElement(commentary))
            }
        }

        encoder.encodeSerializableValue(JsonObject.serializer(), jsonObject)
    }
}