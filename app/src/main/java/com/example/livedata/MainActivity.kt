package com.example.livedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.example.livedata.databinding.ActivityMainBinding
import java.util.Observer

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("LIFECYCLE", "onCreate() Called")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.emitValue().observe(this, androidx.lifecycle.Observer { response ->
            if (response.status == "error"){
                val dialog = AlertDialog.Builder(baseContext)
                    .setTitle("Error")
                    .setMessage("Please try again")
                    .create()
                dialog.show()

            } else{

                val description = response.news.get(0).description
                binding.tvMessage.text = description
            }

        })
}


    override fun onStart() {
        Log.d("LIFECYCLE", "onStart() Called")
        super.onStart()
    }

    override fun onResume() {
        Log.d("LIFECYCLE", "onResume() Called")
        super.onResume()
    }

    override fun onPause() {
        Log.d("LIFECYCLE", "onPause() Called")
        super.onPause()
    }

    override fun onStop() {
        Log.d("LIFECYCLE", "onStop() Called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("LIFECYCLE", "onDestroy() Called")
        super.onDestroy()
    }

    override fun onRestart() {
        Log.d("LIFECYCLE", "onRestart( Called")
        super.onRestart()
    }




}






