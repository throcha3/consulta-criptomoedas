package br.com.thiagopgr.cryptocurrency.retrofit.clients

class CurrencyWebClient(val apiToken : String){

//    fun list(callbackResponse: CallbackResponse<List<CurrencyEntity>>): List<CurrencyEntity> {
//        val list: List<CurrencyEntity> = mutableListOf()
//
//        val call = RetrofitInitializer().currencyService().list(apiToken)
//        call.enqueue(object : Callback<List<CurrencyEntity>> {
//            override fun onResponse(call: Call<List<CurrencyEntity>?>?,
//                                    response: Response<List<CurrencyEntity>?>?) {
//                response?.body()?.let {
//
//                    val formas: List<CurrencyEntity> = it
//                    callbackResponse.success(formas)
//                }
//            }
//
//            override fun onFailure(call: Call<List<CurrencyEntity>?>?, t: Throwable?) {
//                Log.e("onFailure error", t?.message)
//            }
//        })
//        return list
//    }
}