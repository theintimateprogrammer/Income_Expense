package income_expense.example.income_expense.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.example.income_expense.R
import com.example.income_expense.TransactionModel
import com.example.income_expense.databinding.ItemtransactionBinding
import java.util.Objects

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


        holder.itemView.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(p0: View?): Boolean {

                var popupMenu = PopupMenu(context, holder.itemView)
                popupMenu.menuInflater.inflate(R.menu.option_menu, popupMenu.menu)

                popupMenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener{
                    override fun onMenuItemClick(p0: MenuItem?): Boolean {

                        if (p0?.itemId == R.id.edit) {
                            update.invoke(translist.get(position))
                        }

                        if (p0?.itemId == R.id.delete) {
                            delete.invoke(translist.get(position).id)
                        }
                        return true
                    }
                })
                popupMenu.show()
                return true
            }
        })
    }

    fun  settrans(translist:ArrayList<TransactionModel>) {
        this.translist = translist
    }
fun  updateData(translist: ArrayList<TransactionModel>) {
    this.translist = translist
    notifyDataSetChanged()
}

}
