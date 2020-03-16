package com.tasmiya.starwarskotlinexample.api

import com.tasmiya.starwarskotlinexample.model.Movies
import com.tasmiya.starwarskotlinexample.model.MoviesDetailsDashboard
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Tasmiya on 3/13/2020.
 */
interface MyEndPointInterface {
    // To get the Movies
    @GET("?apikey=ae37d79a&s=star+wars")
     fun getMovies(): Call<Movies>

    // To get movie details
    @GET("?apikey=ae37d79a&")
    fun getMovieDetails(@Query("i") id: String): Call<MoviesDetailsDashboard>

}