package br.com.thiagopgr.cryptocurrency.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.thiagopgr.cryptocurrency.R
import br.com.thiagopgr.cryptocurrency.entities.CryptoCurrency.DataEntity
import br.com.thiagopgr.cryptocurrency.viewholders.CurrencyViewHolder


class CurrencyListAdapter  (currencyList: List<DataEntity>): RecyclerView.Adapter<CurrencyViewHolder>() {

    private val mListProdutoEntities: List<DataEntity> = currencyList
    //private val mListener: OnClienteListInteractionListener = listener

    override fun getItemCount(): Int {
        return mListProdutoEntities.size
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        // Obtém item da lista
        val data: DataEntity = mListProdutoEntities[position]
        holder.bindData(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val context = parent.context

        // Infla o layout da linha e faz uso na listagem
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.row_currency_list, parent, false)

        return CurrencyViewHolder(view, context)
    }
}