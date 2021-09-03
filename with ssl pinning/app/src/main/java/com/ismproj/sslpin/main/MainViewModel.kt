package com.ismproj.sslpin.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ismproj.sslpin.network.GithubApi
import com.ismproj.sslpin.network.VitaccessData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private var _userData = MutableLiveData<VitaccessData>()
    val userData: LiveData<VitaccessData>
        get() = _userData

    init {
        _userData.value = null
    }

    fun getUserData(profile: String) {
        val api = GithubApi.retrofitService.getUserData(profile)

        api.enqueue(object : Callback<VitaccessData> {
            override fun onFailure(call: Call<VitaccessData>, t: Throwable) {
                Log.d("TAG_TAG", "Failed :" + t.message)
            }

            override fun onResponse(call: Call<VitaccessData>, response: Response<VitaccessData>) {
                _userData.value = response.body()
            }
        })
    }
}