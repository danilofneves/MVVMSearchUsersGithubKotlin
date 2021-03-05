package com.github.repositories.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result (
    val total_count: String,
    val incomplete_results: String,
    val items: List<User>
) : Parcelable