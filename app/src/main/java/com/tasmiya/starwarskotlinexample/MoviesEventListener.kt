package com.tasmiya.starwarskotlinexample

import com.tasmiya.starwarskotlinexample.model.Search

/**
 * Created by Tasmiya on 3/13/2020.
 */
//To get listener on click of movie cardview item
interface MoviesEventListener {
    fun onMovieClicked(s : Search)
}