package br.com.thiagopgr.cryptocurrency.entities.CryptoCurrency

data class DataEntity (

    var id : Int?,

    var name : String,

    var symbol : String,

    var slug : String?,

    var quote : QuoteEntity,

    var info : String?
)