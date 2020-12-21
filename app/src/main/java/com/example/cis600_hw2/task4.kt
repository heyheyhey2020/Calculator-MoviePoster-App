package com.example.cis600_hw2

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_task4.*




private const val DEBUG_TAG = "Gestures"
class task4 : AppCompatActivity(),GestureDetector.OnGestureListener {



    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return true
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (mDetector.onTouchEvent(event)) {
            true
        } else {
            super.onTouchEvent(event)
        }
    }

    override fun onDown(event: MotionEvent): Boolean {
        Log.d(DEBUG_TAG, "onDown: $event")
        return true
    }

    override fun onFling(
        event1: MotionEvent,
        event2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        Log.d(DEBUG_TAG, "onFling: $event1 $event2")

        when (event1?.action) {
            MotionEvent.ACTION_UP -> {
                //downX = event.x // starting point

            }
            MotionEvent.ACTION_DOWN -> {
                val deltaX = event1.x - event2.x // calculate distance
// horizontal swipe action detection
                if (kotlin.math.abs(deltaX) > 20F) {
// left to right or right to next?
                    if ( deltaX > 0 ){
// right to left (move to next movie)
                        movieIndex++
                        if (movieIndex >= movieList.size){ // last movie, stay!!
                            movieIndex = movieList.size - 1
                        } else {
                            loadMovieInfo()
                        }
                    } else {
// left to right (move to previous movie)
                        movieIndex--
                        if (movieIndex < 0) { // first movie, stay!!
                            movieIndex = 0
                        } else {
                            loadMovieInfo()
                        }
                    }
                }
            }
        }
        return true
    }

    override fun onLongPress(event: MotionEvent) {
        Log.d(DEBUG_TAG, "onLongPress: $event")
    }

    override fun onScroll(
        event1: MotionEvent,
        event2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        Log.d(DEBUG_TAG, "onScroll: $event1 $event2")
        return true
    }

    override fun onShowPress(event: MotionEvent) {
        Log.d(DEBUG_TAG, "onShowPress: $event")
    }

    lateinit var movieList: List<MovieData>
    lateinit var posterTable:MutableMap<String, Int>
    private var movieIndex: Int = 0
    private lateinit var snack: Snackbar
    //private const val DEBUG_TAG = "Gestures"
    var downX:Float = 0.0f
    private lateinit var mDetector: GestureDetectorCompat

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task4)


        var imageHeight:Int= 0
        var imageWidth:Int = 0
        var image = findViewById(R.id.moviePicture) as ImageView
        imageHeight = image.drawable.intrinsicHeight
        imageWidth = image.drawable.intrinsicWidth

        mDetector = GestureDetectorCompat(this, this)

        this.movieList = Gson().fromJson(movies, Array<MovieData>::class.java).asList()
        posterTable = mutableMapOf()
        posterTable["Mulan"] = R.drawable.mulan
        posterTable["Rogue"] = R.drawable.rogue
        posterTable["Peninsula"] = R.drawable.peninsula
        posterTable["Project Power"] = R.drawable.project_power
        posterTable["After We Collided"] = R.drawable.after_we_collided
        posterTable["Ava"] = R.drawable.ava
        posterTable["Archive"] = R.drawable.archive
        posterTable["The Crimes That Bind"] = R.drawable.the_crimes_that_bind
        posterTable["Mortal"] = R.drawable.mortal
        posterTable["Scoob!"] = R.drawable.scoob
        loadMovieInfo()

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                               fromUser: Boolean) {
                var newHeight = imageHeight*progress/50F
                var newWidth = imageWidth*progress/50F

                changeImageViewSize(newHeight.toInt(), newWidth.toInt())

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

        moviePicture.setOnClickListener {
            Toast.makeText(this, "Short Click", Toast.LENGTH_SHORT).show()
            snack=Snackbar.make(seekBar, "Snack Message", Snackbar.LENGTH_LONG)
            snack.show()

        }
        moviePicture.setOnLongClickListener{
            seekBar.progress = 50
            moviePicture.setImageResource(posterTable.get(movieList[movieIndex].title)!!)
            Toast.makeText(this, "Long Click", Toast.LENGTH_SHORT).show()
            true
        }


        moviePicture.setOnTouchListener { v, event ->
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> {
                    downX = event.x // starting point
                }
                MotionEvent.ACTION_UP -> {
                    val deltaX = downX - event.x // calculate distance
// horizontal swipe action detection
                    if (kotlin.math.abs(deltaX) > 20F) {
// left to right or right to next?
                        if ( deltaX > 0 ){
// right to left (move to next movie)
                            movieIndex++
                            if (movieIndex >= movieList.size){ // last movie, stay!!
                                movieIndex = movieList.size - 1
                            } else {
                                loadMovieInfo()
                                Log.d("DEBUG", "onFling: $downX ${event.x}")
                            }
                        } else {
// left to right (move to previous movie)
                            movieIndex--
                            if (movieIndex < 0) { // first movie, stay!!
                                movieIndex = 0
                            } else {
                                loadMovieInfo()
                                Log.d("DEBUG", "onFling: $downX ${event.x}")
                            }
                        }
                    }
                }
            }
            v?.onTouchEvent(event) ?: true
        }
    }

    private fun changeImageViewSize(h: Int, w: Int) {
        var image = findViewById(R.id.moviePicture) as ImageView
        image.layoutParams.height=h
        image.layoutParams.width=w
        image.scaleType=ImageView.ScaleType.FIT_XY
        image.requestLayout()
    }



    private fun loadMovieInfo() {
// load image information with movieIndex
        moviePicture.setImageResource(posterTable.get(movieList[movieIndex].title)!!)
    }
}

