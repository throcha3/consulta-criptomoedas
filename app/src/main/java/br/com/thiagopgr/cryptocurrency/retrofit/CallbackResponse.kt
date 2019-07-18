package br.com.thiagopgr.cryptocurrency.retrofit

interface CallbackResponse<T> {
    fun success(response: T)
}