package com.example.mocktube

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeStandalonePlayer
import kotlinx.android.synthetic.main.activity_standalone.*

class StandaloneActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standalone)

        btnPlay.setOnClickListener(this)
        btnPlayList.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val intent = when (view.id) {

            R.id.btnPlay -> YouTubeStandalonePlayer.createVideoIntent(this, getString(R.string.YOUR_API_KEY), "")

            R.id.btnPlayList -> YouTubeStandalonePlayer.createPlaylistIntent(
                this,
                getString(R.string.YOUR_API_KEY),
                ""
            )
            else -> throw IllegalArgumentException("Undefined button clicked")
        }
        startActivity(intent)
    }
}