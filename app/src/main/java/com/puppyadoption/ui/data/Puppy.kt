package com.puppyadoption.ui.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Puppy(
    val id: Int=0,
    val image: String="",
    val name: String="",
    val nickName: String="",
    val gender: String="",
    val ageInMonth: Int=0,
    val color: String="",
    val description: String="",
    val weight: String="",
):Parcelable
