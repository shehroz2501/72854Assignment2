package com.example.shehroz_khan_72854

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shehroz_khan_72854.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Adapter.ClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: Adapter

    companion object {
        var listOfMovieData = mutableListOf<MovieData>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        generateMovieList()

        adapter = Adapter(listOfMovieData, this)

        binding.rv.adapter = adapter
    }

    fun generateMovieList() {

        listOfMovieData.add(
            MovieData(
                "CIVIL WAR",
                "https://www.myvue.com/-/jssmedia/vuecinemas/film-and-events/mar-2024/civil-war-d.jpg?mw=768&rev=8d89c6e6d45f43ceaa39d208cddf0573",
                "15A",
                "In the near future, a team of journalists travel across the United States during a rapidly escalating civil war that has engulfed the entire nation.",
                arrayListOf("Wagner Moura", "Kirsten Dunst", "Cailee Spaeny", "Stephen McKinley Henderson"),
                109,
                randomNumberGenerator(0, 15),
                0
            )
        )

        listOfMovieData.add(
            MovieData(
                "KUNG FU PANDA 4",
                "https://www.myvue.com/-/media/vuecinemas/carousel-artwork/value-aw/kfp4/kungfupanda4valuebannerie5991584x540.jpg?h=540&iar=0&w=1584&rev=56b0d7420d374222b4423973cd58973d",
                "PG",
                "After Po is tapped to become the Spiritual Leader of the Valley of Peace, he needs to find and train a new Dragon Warrior, while a wicked sorceress plans to re-summon all the master villains whom Po has vanquished to the spirit realm.",
                arrayListOf("Jack Black", "Awkwafina", "Viola David", "Dustin Hoffman", "Bryan Cranston", "Mr. Beast"),
                94,
                (0..15).random(),
                0
            )
        )

        listOfMovieData.add(
            MovieData(
                "MONKEY MAN",
                "https://www.myvue.com/-/jssmedia/vuecinemas/carousel-artwork/april-24/mkm_vue_herohomepage_1584x540_aw-3_now.jpg?mw=1600&rev=a3b82d72b1584ba081927154672076b9",
                "16",
                "Oscar® nominee Dev Patel (Lion, Slumdog Millionaire) achieves an astonishing, tour-de-force feature directing debut with an action thriller about one man’s quest.",
                arrayListOf("Sharlto Copley", "Dev Patel", "Sobhita Dhulipala", "Ashwini Kalsekar", "Adithi Kalkunte", "Sikandar Kher", "Pitobash", "Vipin Sharma", "Makarand Deshpande"),
                121,
                randomNumberGenerator(0, 15),
                0
            )
        )

        listOfMovieData.add(
            MovieData(
                "THE FIRST OMEN",
                "https://www.myvue.com/-/jssmedia/vuecinemas/carousel-artwork/april-24/thefirstomen_vue_homepagehero_1584x540_now.jpg?mw=1600&rev=bbd231fb564d47f0b15eca5c8d4a1590",
                "16",
                "When a young American woman is sent to Rome to begin a life of service to the church, she encounters a darkness that causes her to question her own faith.",
                arrayListOf("Bill Nighy", "Ralph Ineson", "Sônia Braga", "Nell Tiger Free", "Tawfeek Barhom"),
                119,
                randomNumberGenerator(0, 15),
                0
            )
        )

    }

    private fun randomNumberGenerator(a: Int, b: Int): Int {
        return (a..b).random()
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, MovieActivity::class.java)
        intent.putExtra("pos", position)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()

        adapter.notifyDataSetChanged()
    }
}