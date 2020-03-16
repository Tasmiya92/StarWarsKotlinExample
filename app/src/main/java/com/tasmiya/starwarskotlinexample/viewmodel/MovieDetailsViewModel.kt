package com.tasmiya.starwarskotlinexample.viewmodel

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.tasmiya.starwarskotlinexample.api.MovieDetailsRepository
import com.tasmiya.starwarskotlinexample.model.MoviesDetailsDashboard

/**
 * Created by Tasmiya on 3/13/2020.
 */
//Movie details View Model class
class MovieDetailsViewModel(@NonNull application : Application) : AndroidViewModel(application) {
    private val movieDetailsRepository : MovieDetailsRepository

    fun startMoviesDetails(id:String):LiveData<MoviesDetailsDashboard>{
        return movieDetailsRepository.getStarWarsMovieDetails(id)
    }

    init{
        movieDetailsRepository = MovieDetailsRepository()
    }
}