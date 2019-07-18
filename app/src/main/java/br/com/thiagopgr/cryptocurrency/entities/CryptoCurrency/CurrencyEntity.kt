package br.com.thiagopgr.cryptocurrency.entities.CryptoCurrency


data class CurrencyEntity (

    var data : Array<DataEntity>,

    var status : StatusEntity

)


//"id": 1,
//"name": "Bitcoin",
//"symbol": "BTC",
//"slug": "bitcoin",
//"circulating_supply": 17800150,
//"total_supply": 17800150,
//"max_supply": 21000000,
//"date_added": "2013-04-28T00:00:00.000Z",
//"num_market_pairs": 7654,
//"tags": [
//"mineable"
//],
//"platform": null,
//"cmc_rank": 1,
//"last_updated": "2019-07-05T17:57:26.000Z",
//"quote": {
//    "USD": {
//        "price": 11249.2240943,
//        "volume_24h": 24514623597.4118,
//        "percent_change_1h": 0.340933,
//        "percent_change_24h": -4.94446,
//        "percent_change_7d": -6.60069,
//        "market_cap": 200237876262.15414,
//        "last_updated": "2019-07-05T17:57:26.000Z"
//    }
//}
//},