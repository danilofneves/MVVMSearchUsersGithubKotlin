package com.github.repositories.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    val login: String,
    val avatar_url: String
) : Parcelable