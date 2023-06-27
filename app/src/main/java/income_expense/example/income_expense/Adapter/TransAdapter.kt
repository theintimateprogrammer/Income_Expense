package income_expense.example.income_expense.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.income_expense.R
import com.example.income_expense.TransactionModel
import com.example.income_expense.databinding.ItemtransactionBinding

class TransAdapter    (update: (TransactionModel) -> Unit, delete:(Int) -> Unit) :RecyclerView.Adapter<TransAdapter.Transholder>(){

    var update = update
    var delete = delete

    var translist = ArrayList<TransactionModel>()
    lateinit var context: Context

    class Transholder(itemView: ItemtransactionBinding) : RecyclerView.ViewHolder(itemView.root)
    {
        var binding = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Transholder {
        context = parent.context
        var binding = ItemtransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Transholder(binding)
    }

    override fun getItemCount(): Int {

        return translist.size

    }


    override fun onBindViewHolder(holder: Transholder, @SuppressLint("RecyclerView")position: Int) {
        holder.binding.apply {
            translist.get(position).apply {
                txtcategory.text = category
                txtnotes.text = note
                txtamount.text = amount.toString()
                txtdate.text = date
                txtdate.text = month
                txtdate.text = year

                if (isExpence == 0) {
                    txtamount.setTextColor(Color.parseColor("#05C005"))
                    listbg.setImageResource(R.drawable.transactionbcground)
                    imgarrow.setImageResource(R.drawable.upward_24)
                    cardbg.setCardBackgroundColor(Color.parseColor("#F0FDF4"))
                } else {
                    txtamount.setTextColor(Color.RED)
                    listbg.setImageResource(R.drawable.transectionbacground2)
                    imgarrow.setImageResource(R.drawable.doun_24)
                    cardbg.setCardBackgroundColor(Color.parseColor("#FFF9F9"))
                }
            }
        }

    }

    fun updateData(transactionModels: ArrayList<TransactionModel>) {
        translist = transactionModels
        notifyDataSetChanged()
    }

    fun settrans(translist: java.util.ArrayList<TransactionModel>) {
        this.translist = translist
    }

}
