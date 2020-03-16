package com.tasmiya.starwarskotlinexample.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.tasmiya.starwarskotlinexample.model.MoviesDetailsDashboard
import retrofit2.Call
import retrofit2.Response

/**
 * Created by Tasmiya on 3/13/2020.
 */
// Gets Movie details
class MovieDetailsRepository {
    private val mutableLiveData = MutableLiveData<MoviesDetailsDashboard>()

    //Retrofit response to get movie details
    fun getStarWarsMovieDetails(id: String): MutableLiveData<MoviesDetailsDashboard> {
        val userDataService = RetrofitClient.getService()

        val call = userDataService.getMovieDetails(id)
        Log.d("URL", userDataService.getMovieDetails(id).toString())
        call.enqueue(object : retrofit2.Callback<MoviesDetailsDashboard> {
            override fun onResponse(
                call: Call<MoviesDetailsDashboard>,
                response: Response<MoviesDetailsDashboard>
            ) {
                val movieDBResponse = response.body()
                if (movieDBResponse != null) {
                    mutableLiveData.setValue(movieDBResponse)
                }
            }

            override fun onFailure(call: Call<MoviesDetailsDashboard>, t: Throwable) {}
        })
        return mutableLiveData
    }
}


