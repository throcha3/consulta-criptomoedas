package br.com.thiagopgr.cryptocurrency.retrofit.services



import br.com.thiagopgr.cryptocurrency.constants.API_CONST_KEY
import br.com.thiagopgr.cryptocurrency.entities.CryptoCurrency.CurrencyEntity
import br.com.thiagopgr.cryptocurrency.entities.CryptoInfo.CryptoInfoMainEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CurrencyService {
    @GET("cryptocurrency/listings/latest?convert=BRL")
    fun list(@Header (API_CONST_KEY.API_KEY_NAME) key:String) : Call<CurrencyEntity>

    @GET("cryptocurrency/info")
    fun info(@Header (API_CONST_KEY.API_KEY_NAME) key:String, @Query("id") id:String) : Call<CryptoInfoMainEntity>
}