package com.github.marcelobenedito.dailyfitness.data.repository

import com.github.marcelobenedito.dailyfitness.R
import com.github.marcelobenedito.dailyfitness.model.FitnessTip

object DailyFitnessTipsRepository {

    val fitnessTips = listOf(
        FitnessTip(
            day = 1,
            title = R.string.title_1,
            description = R.string.description_1,
            image = R.drawable.image_1
        ),
        FitnessTip(
            day = 2,
            title = R.string.title_2,
            description = R.string.description_2,
            image = R.drawable.image_2
        ),
        FitnessTip(
            day = 3,
            title = R.string.title_3,
            description = R.string.description_3,
            image = R.drawable.image_3
        ),
        FitnessTip(
            day = 4,
            title = R.string.title_4,
            description = R.string.description_4,
            image = R.drawable.image_4
        ),
        FitnessTip(
            day = 5,
            title = R.string.title_5,
            description = R.string.description_5,
            image = R.drawable.image_5
        )
    )
}