package br.com.thiagopgr.cryptocurrency.entities.CryptoCurrency



data class CoinEntity (
    val price : Float,
    val volume_24h : Float?,
    val percent_change_1h : Float?,
    val percent_change_24h : Float?,
    val percent_change_7d : Float?,
    val market_cap : Float?,
    val last_updated : String?
)

