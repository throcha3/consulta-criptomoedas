package br.com.thiagopgr.cryptocurrency.viewholders

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.thiagopgr.cryptocurrency.R
import br.com.thiagopgr.cryptocurrency.entities.CryptoCurrency.DataEntity
import com.bumptech.glide.Glide


class CurrencyViewHolder(itemView: View, val context: Context) : RecyclerView.ViewHolder(itemView) {

    private val mName:  TextView = itemView.findViewById(R.id.tv_name)
    private val mPrice: TextView = itemView.findViewById(R.id.tv_price)
    private val mLogo:  ImageView = itemView.findViewById(R.id.img_logo)

    fun bindData(currency: DataEntity) {
        val name    = currency.symbol + " | " + currency.name
        val price   = currency.quote.brl.price.toString() + " R$"
        mName.text  = name
        mPrice.text = price

        if (currency.info != null) {
            Glide.with(context)
                .load(currency.info)
                .into(mLogo)
        }
    }

}