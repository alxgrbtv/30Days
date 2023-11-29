package com.alxgrbdev.a30days.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tip(
    @StringRes val day: Int,
    @StringRes val title: Int,
    @DrawableRes val image: Int,
    @StringRes val description: Int
)
