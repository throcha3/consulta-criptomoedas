package br.com.thiagopgr.cryptocurrency.entities.CryptoInfo

import com.google.gson.annotations.SerializedName

data  class CryptoInfoMainEntity (
    //val data : CryptoInfoEntity

    @SerializedName("data")
    var data: Map<String, DataInfoEntity>
)