package com.tasmiya.starwarskotlinexample.api

import androidx.lifecycle.MutableLiveData
import com.tasmiya.starwarskotlinexample.model.Movies
import com.tasmiya.starwarskotlinexample.model.Search
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

/**
 * Created by Tasmiya on 3/13/2020.
 */
// To get Movie names and relevant brief data
class MovieRepository {
    private var moviesArrayList = java.util.ArrayList<Search>()
    private val mutableLiveData = MutableLiveData<List<Search>>()

    //Retrofit call to get star war movies
    fun getStarWarsMovies():MutableLiveData<List<Search>> {
        val userDataService = RetrofitClient.getService()
        val call = userDataService.getMovies()
        call.enqueue(object:Callback<Movies> {
            override fun onResponse(call:Call<Movies>, response:Response<Movies>) {
                val movieDBResponse = response?.body()
                if (movieDBResponse != null && movieDBResponse?.search != null)
                {
                    moviesArrayList = movieDBResponse?.search as ArrayList<Search>
                    mutableLiveData.setValue(moviesArrayList)
                }
            }
            override fun onFailure(call:Call<Movies>, t:Throwable) {}
        })
        return mutableLiveData
    }

}