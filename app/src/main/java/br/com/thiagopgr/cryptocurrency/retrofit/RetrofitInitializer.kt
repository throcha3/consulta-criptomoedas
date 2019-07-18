package br.com.thiagopgr.cryptocurrency.retrofit

import br.com.thiagopgr.cryptocurrency.retrofit.services.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient

class RetrofitInitializer {

    private val okhttpClient = OkHttpClient()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pro-api.coinmarketcap.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okhttpClient)
        .build()

    fun currencyService   ()  = retrofit.create(CurrencyService   ::class.java)

}