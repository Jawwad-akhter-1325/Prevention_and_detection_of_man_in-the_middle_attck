package com.ismproj.sslpin.network

import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


private const val BASE_URL = "https://vitaccess.tech"

private val  certPinner = CertificatePinner.Builder()
    .add("vitaccess.tech","sha256/7LMcqrbPRaJaYI+q2FgK8MKFLUr3bc+smzHia7uvbzw=")
    .build()

private val okHttpClient = OkHttpClient.Builder()
    .certificatePinner(certPinner)
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .client(okHttpClient)
    .build()

interface GithubApiService {
    @GET("/{profile}")
    fun getUserData(@Path("profile") profile: String):
            Call<VitaccessData>
}

object GithubApi {
    val retrofitService: GithubApiService by lazy {
        retrofit.create(GithubApiService::class.java)
    }
}