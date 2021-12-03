package hr.asseco.mbanking.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.asseco.mbanking.R
import hr.asseco.mbanking.models.Accounts

class AccountAdapter(val context: Context, val items: List<Accounts>) :
    RecyclerView.Adapter<AccountAdapter.ViewHolder>() {

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


        val item = items.get(position)

        holder.accountID.text = item.id.toString()
        holder.accountIBAN.text = item.iBAN.toString()

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        var accountID : TextView
        var accountIBAN : TextView

        init {
            accountID = view.findViewById(R.id.accountIDField)
            accountIBAN = view.findViewById(R.id.accountIDField)

            //ovdje se odabire racun za koji ce se prikazati transakcije
            view.setOnClickListener{
                val position: Int = adapterPosition

                //treba prikazati transakcije racuna koji je ovdje odabran

            }
        }


    }

}