package com.github.marcelobenedito.dailyfitness.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class FitnessTip(
    val day: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)
