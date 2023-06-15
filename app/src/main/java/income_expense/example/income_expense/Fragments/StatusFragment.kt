package income_expense.example.income_expense.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.income_expense.R
import com.example.income_expense.databinding.FragmentStatusBinding

class StatusFragment : Fragment() {

    lateinit var binding: FragmentStatusBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatusBinding.inflate(layoutInflater)

        val list : kotlin.collections.ArrayList<PieEntry> = java.util.ArrayList()
        list.add(PieEntry(30f,"Expence"))
        list.add(PieEntry(80f,"Income"))

        val pieDataSet = PieDataSet(list,"")
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS,255)
        pieDataSet.valueTextSize=15f
        pieDataSet.valueTextColor= Color.BLACK

        var pieData = PieData(pieDataSet)
        binding.piechart.data = pieData
        binding.piechart.description.text = "Pie Chart Of Transaction"
        binding.piechart.centerText = "Transaction List"
        binding.piechart.animateY(1300)

        return binding.root
    }
}

}
