package gencana.com.android.githubsearch.data.entity

import com.squareup.moshi.Json
import gencana.com.android.githubsearch.common.model.UserModel
import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class UserData(
        @Json(name = "login") val username: String,
        @Json(name = "avatar_url") val avatarUrl: String,
        val score: Double
)

fun UserData.mapToPresentation(): UserModel
        = UserModel(username, avatarUrl, score)