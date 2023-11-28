package com.alxgrbdev.a30days.model

import com.alxgrbdev.a30days.R
import com.alxgrbdev.a30days.data.Tip

object TipsRepository {
    val tips = listOf(
        Tip(
            day = R.string.day_1,
            title = R.string.tip_title_1,
            image = R.drawable.ph_500_400,
            description = R.string.tip_description_1
        ),
        Tip(
            day = R.string.day_2,
            title = R.string.tip_title_1,
            image = R.drawable.ph_500_400,
            description = R.string.tip_description_1
        ),
        Tip(
            day = R.string.day_3,
            title = R.string.tip_title_1,
            image = R.drawable.ph_500_400,
            description = R.string.tip_description_1
        ),
        Tip(
            day = R.string.day_4,
            title = R.string.tip_title_1,
            image = R.drawable.ph_500_400,
            description = R.string.tip_description_1
        )
    )
}