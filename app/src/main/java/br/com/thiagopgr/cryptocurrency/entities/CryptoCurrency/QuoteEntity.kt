package br.com.thiagopgr.cryptocurrency.entities.CryptoCurrency

import com.google.gson.annotations.SerializedName

data class QuoteEntity (
    @SerializedName("BRL")
    val brl : CoinEntity
)