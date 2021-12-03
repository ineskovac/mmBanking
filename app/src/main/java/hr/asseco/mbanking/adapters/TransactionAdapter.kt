package hr.asseco.mbanking.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.asseco.mbanking.R
import hr.asseco.mbanking.models.Transactions

class TransactionAdapter(val context: Context, val items: List<Transactions>) :
    RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_transaction_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        /*
        val accounts = item.acounts.size

        for (i in 0..accounts){

        }*/
        val item = items.get(position)

        holder.transactionID.text = item.id.toString()
        holder.transactionDate.text = item.date
        holder.transactionDescrition.text = item.description
        holder.transactionAmount.text = item.amount
        holder.transactionType.text = item.type.toString()



    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        var transactionID: TextView
        var transactionDate : TextView
        var transactionDescrition :TextView
        var transactionAmount : TextView
        var transactionType : TextView

        init {
            transactionID = view.findViewById(R.id.transactionIDField)
            transactionDate = view.findViewById(R.id.transactionDateField)
            transactionDescrition = view.findViewById(R.id.transactionDescriptionField)
            transactionAmount = view.findViewById(R.id.transactionAmountField)
            transactionType = view.findViewById(R.id.transactionTypeField)
        }


        //var transactionDate = view.transactionDateField
        //var transactionDescrition = view.transactionDescriptionField
        //var transactionAmount = view.transactionAmountField
        //var transactionType = view.transactionTypeField

    }

}
