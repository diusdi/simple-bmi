package com.example.bmi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmi.databinding.ActivityMainBinding

private lateinit var binding:ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn.setOnClickListener(){
            proses()
        }
    }

    @SuppressLint("SetTextI18n")
    fun proses(){
        val beratBadan : Float = binding.editBb.text.toString().toFloat()
        val tinggiBadan : Float = (binding.editTb.text.toString().toFloat())/100
        val index : Float = beratBadan/(tinggiBadan*tinggiBadan)
        binding.tvIndex.text = "Index : $index"
        var status : String = ""

        if(index < 18.5) {
            status = "Kurus"
        }else if(index in 18.5..24.9){
            status = "Normal"
        }else if(index in 25.0..29.9){
            status = "Gemuk"
        }else if(index in 30.0..34.9){
            status = "Obesitas 1"
        }else if(index in 35.0..39.9){
            status = "Obesitas 2"
        }else{
            status = "Obesitas 3"
        }
        binding.tvStatus.text = "Status : $status"
    }
}