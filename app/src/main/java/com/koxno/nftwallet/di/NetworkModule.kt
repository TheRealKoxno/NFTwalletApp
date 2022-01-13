package com.koxno.nftwallet.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.koxno.nftwallet.data.network.NFTApi
import com.koxno.nftwallet.data.network.NFTApi.Companion.api_key
import com.koxno.nftwallet.data.network.NFTRepositoryImpl
import com.koxno.nftwallet.domain.NFTRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideNFTApi(): NFTApi = Retrofit.Builder()
        .baseUrl("https://stoplight.io")
        .client(
            OkHttpClient.Builder()
                .addInterceptor { chain: Interceptor.Chain ->
                    val request = chain.request()
                        .newBuilder()
                        .header("api_key", api_key)
                        .build()

                    chain.proceed(request)
                }
                .addInterceptor(
                    HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)
                )
                .connectTimeout(30, TimeUnit.SECONDS)
                .callTimeout(   30, TimeUnit.SECONDS)
                .readTimeout(   30, TimeUnit.SECONDS)
                .writeTimeout(  30, TimeUnit.SECONDS)
                .build()
        )
        .addConverterFactory(
            Json(builderAction = {
                isLenient = true
                ignoreUnknownKeys = true
            }).asConverterFactory("application/json".toMediaType())
        )
        .build()
        .create()

    @Provides
    fun getRepository(nftApi: NFTApi): NFTRepository = NFTRepositoryImpl(nftApi)

}