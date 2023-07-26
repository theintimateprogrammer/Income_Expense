package income_expense.example.income_expense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.income_expense.R
import income_expense.example.income_expense.Fragments.HomeFragments
import com.example.income_expense.databinding.ActivityMainBinding
import income_expense.example.income_expense.Fragments.AddDataFragments
import income_expense.example.income_expense.Fragments.StatusFragment

class MainActivity : AppCompatActivity() {
    lateinit var  binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragments())
        binding.bottom.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home -> replaceFragment(HomeFragments())
                R.id.status -> replaceFragment(StatusFragment())
                R.id.add -> replaceFragment(AddDataFragments())

                else -> {


            }
            }
            true
        }
    }
    private fun replaceFragment(fragments: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragpageview,fragments).commit()

    }
}
