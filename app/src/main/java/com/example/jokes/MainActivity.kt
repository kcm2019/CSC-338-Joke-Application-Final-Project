package com.example.jokes

import JokeViewModel
import android.app.Activity
import android.content.ClipData.newIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.jokes.ComediansActivity

private const val TAG = "MainActivity"
private const val KEY_INDEX = "index"

class MainActivity : AppCompatActivity() {

    private val jokeViewModel: JokeViewModel by lazy {
        ViewModelProviders.of(this).get(JokeViewModel::class.java)
    }

    private lateinit var newButton: Button
    private lateinit var punchlineButton: Button
    private lateinit var moreButton: Button
    private lateinit var JokeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentIndex = savedInstanceState?.getInt(KEY_INDEX, 0) ?: 0
        jokeViewModel.currentIndex = currentIndex

        newButton = findViewById(R.id.new_button)
        punchlineButton = findViewById(R.id.punchline_button)
        moreButton = findViewById(R.id.more_button)
        JokeTextView = findViewById(R.id.textView)

        newButton.setOnClickListener { view: View? ->
            jokeViewModel.moveToNext()
            updateJoke()
        }

        punchlineButton.setOnClickListener { view: View? ->
            viewPunchline()
        }

        moreButton.setOnClickListener {
            val Intent = Intent(this,ComediansActivity::class.java)
            startActivity(Intent)
        }
    }

    private fun viewPunchline() {
        val punchline = jokeViewModel.currentPunchline
        Toast.makeText(this, punchline, Toast.LENGTH_SHORT)
            .show()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        Log.i(TAG, "onSaveInstanceState")
        savedInstanceState.putInt(KEY_INDEX, jokeViewModel.currentIndex)
    }


    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    private fun updateJoke() {
        val questionTextResId = jokeViewModel.currentJoke
        JokeTextView.setText(questionTextResId)
    }
}