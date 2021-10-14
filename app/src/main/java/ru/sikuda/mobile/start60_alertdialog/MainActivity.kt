package ru.sikuda.mobile.start60_alertdialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.sikuda.mobile.start60_alertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var color: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        binding.AlertDialogButton.setOnClickListener {
            showAlertDialogFragment()
        }
        AlertDialogFragmentListener()
        color = -16777216
        binding.colorView.setBackgroundColor(color)
    }

//    override fun onResume() {
//        super.onResume()
//        binding.colorView.setBackgroundColor(0)
//    }

    private fun showAlertDialogFragment() {
        AlertDialogFragment.show(supportFragmentManager, this.color)
    }

    private fun AlertDialogFragmentListener(){
        AlertDialogFragment.setupListener(supportFragmentManager, this) {
            this.color = it
            binding.colorView.setBackgroundColor(color)
        }
    }


}