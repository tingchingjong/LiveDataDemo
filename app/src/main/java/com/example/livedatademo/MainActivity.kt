package com.example.livedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.livedatademo.databinding.ActivityMainBinding
import com.example.livedatademo.models.AccountModel

class MainActivity : AppCompatActivity() {
    private val myAccout = AccountModel("A1234566","John", 500.00)
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myAccount = myAccout
        binding.lifecycleOwner = this
        //lifecycleowner is use in fragment
//        display()

        //use self view then put different sample in 5.2 pratical document
//        myAccout.balance.observe(this, { newBalance -> binding.tvBalance.text = newBalance.toString() })




        binding.btnDeposit.setOnClickListener(){
            val amount:Double  = binding.tfAmount.text.toString().toDouble()

            myAccout.deposit(amount)
           // binding.tvBalance.text = myAccout.balance.toString()
        }

        binding.btnWitdraw.setOnClickListener(){
            val amount:Double  = binding.tfAmount.text.toString().toDouble()
            myAccout.withdraw(amount)
          //  binding.tvBalance.text = myAccout.balance.toString()
        }
    }

//    fun display(){
//
//        binding.tvAccNo.text = myAccout.accNo
//        binding.tvName.text = myAccout.owner
//        binding.tvBalance.text = myAccout.balance.value.toString()
//
//    }
}