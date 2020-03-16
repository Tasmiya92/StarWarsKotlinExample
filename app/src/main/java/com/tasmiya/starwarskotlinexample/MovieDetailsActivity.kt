package com.tasmiya.starwarskotlinexample

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tasmiya.starwarskotlinexample.databinding.ActivityMovieDetailsBinding
import com.tasmiya.starwarskotlinexample.model.MoviesDetailsDashboard
import com.tasmiya.starwarskotlinexample.viewmodel.MovieDetailsViewModel

/**
 * Created by Tasmiya on 3/13/2020.
 */
//Movies details data
class MovieDetailsActivity : AppCompatActivity() {
    var movieDetailsViewModel : MovieDetailsViewModel? = null
    var imdbId : String? = null

    var activityMainBinding : ActivityMovieDetailsBinding? = null
    lateinit var progressBar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_movie_details)
        movieDetailsViewModel = ViewModelProviders.of(this).get(MovieDetailsViewModel::class.java)
        progressBar = activityMainBinding!!.progressBar
        progressBar.visibility = View.VISIBLE
        val extras = intent.extras
        if (extras != null) {
            imdbId = extras.getString("iMDBId")
        }
        imdbId?.let { getDetails(it) }

    }

    private fun getDetails(id: String) {
        movieDetailsViewModel!!.startMoviesDetails(id)
            .observe(this, object : Observer<MoviesDetailsDashboard> {
                override fun onChanged(t: MoviesDetailsDashboard?) {
                    activityMainBinding!!.movieDetails = t
                    progressBar.visibility = View.GONE
                }
            })
    }

    }

