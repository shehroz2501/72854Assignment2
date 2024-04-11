package com.example.shehroz_khan_72854

data class MovieData(
    val name: String,
    val image: String,
    val certification: String,
    val description: String,
    val starring: ArrayList<String>,
    val runnning_time_mins: Int,
    var seats_remaining: Int,
    var seats_selected: Int
)
