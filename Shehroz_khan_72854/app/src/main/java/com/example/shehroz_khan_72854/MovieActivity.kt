package com.example.shehroz_khan_72854

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.shehroz_khan_72854.MainActivity.Companion.listOfMovieData
import com.example.shehroz_khan_72854.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {

    private var pos = 0

    private lateinit var binding: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pos = intent.extras?.getInt("pos") as Int

        initViews()
        initClickListeners()
    }

    private fun initViews() {
        binding.addSeats.isEnabled = listOfMovieData[pos].seats_remaining != 0
        binding.subSeats.isEnabled = listOfMovieData[pos].seats_selected != 0

        when (listOfMovieData[pos].certification) {
            "16" -> binding.certification.setImageResource(R.drawable.certificate_16)
            "15A" -> binding.certification.setImageResource(R.drawable.certificate_15a)
            "PG" -> binding.certification.setImageResource(R.drawable.certificate_pg)
        }

        binding.seatsSelected.text = listOfMovieData[pos].seats_selected.toString()

        binding.seatsLeft.text = "${listOfMovieData[pos].seats_remaining} seats remaining"

        binding.movieTitle.text = listOfMovieData[pos].name

        binding.description.text = listOfMovieData[pos].description

        binding.cast.text = listOfMovieData[pos].starring.toString()

        binding.movieRunningTime.text = "${listOfMovieData[pos].runnning_time_mins / 60}hrs ${listOfMovieData[pos].runnning_time_mins % 60}mins"

        Glide.with(this@MovieActivity).load(listOfMovieData[pos].image).into(binding.movieImg)
    }

    private fun initClickListeners() {
        binding.addSeats.setOnClickListener {
            if (listOfMovieData[pos].seats_remaining > 0) {
                binding.seatsLeft.text = "${--listOfMovieData[pos].seats_remaining} seats remaining"
                binding.seatsSelected.text = (++listOfMovieData[pos].seats_selected).toString()

                binding.subSeats.isEnabled = listOfMovieData[pos].seats_selected != 0
                binding.addSeats.isEnabled = listOfMovieData[pos].seats_remaining != 0
            }
        }

        binding.subSeats.setOnClickListener {
            if (listOfMovieData[pos].seats_selected > 0) {
                binding.seatsLeft.text = "${++listOfMovieData[pos].seats_remaining} seats remaining"
                binding.seatsSelected.text = (--listOfMovieData[pos].seats_selected).toString()

                binding.subSeats.isEnabled = listOfMovieData[pos].seats_selected != 0
                binding.addSeats.isEnabled = listOfMovieData[pos].seats_remaining != 0
            }
        }
    }
}