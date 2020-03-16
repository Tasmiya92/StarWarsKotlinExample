package com.tasmiya.starwarskotlinexample.viewmodel

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tasmiya.starwarskotlinexample.api.MovieRepository
import com.tasmiya.starwarskotlinexample.model.MoviesDetailsDashboard
import com.tasmiya.starwarskotlinexample.model.Search

/**
 * Created by Tasmiya on 3/13/2020.
 */
//To get movie Movies data view model
 class MoviesViewModel(@NonNull application: Application) : AndroidViewModel(application) {
   private val mMoviesRepository : MovieRepository

    val moviesRepo:LiveData<List<Search>>
        get() {
            return mMoviesRepository.getStarWarsMovies()
        }
    init{
        mMoviesRepository = MovieRepository()
    }


}