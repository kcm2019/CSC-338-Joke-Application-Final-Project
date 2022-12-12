package com.example.jokes

import androidx.annotation.StringRes

data class Joke(@StringRes val textResId: Int, @StringRes val punchline: Int)