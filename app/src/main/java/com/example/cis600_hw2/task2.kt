package com.example.cis600_hw2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_task2.*
import android.view.View.OnClickListener


//reference code: https://github.com/linwenbing/KotlinCounterDemo
class task2 : AppCompatActivity(), OnClickListener {

    private var firstNumber = ""
    private var nextNumber = ""
    private var operator = ""
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2)
        number0.setOnClickListener(this)
        number1.setOnClickListener(this)
        number2.setOnClickListener(this)
        number3.setOnClickListener(this)
        number4.setOnClickListener(this)
        number5.setOnClickListener(this)
        number6.setOnClickListener(this)
        number7.setOnClickListener(this)
        number8.setOnClickListener(this)
        number9.setOnClickListener(this)
        add.setOnClickListener(this)
        subtract.setOnClickListener(this)
        muliply.setOnClickListener(this)
        divide.setOnClickListener(this)
        clear.setOnClickListener(this)
        equal.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        doClick("" + (v as Button).text)
    }

    private fun  doClick(value:String){
        when(value){
            "+","-","*","/"->{
                if (firstNumber?.isNotEmpty() && nextNumber?.isEmpty()){
                    operator = value
                }else if(firstNumber?.isNotEmpty() && nextNumber?.isNotEmpty()){
                    operator = value
                    doCount()
                }

            }
            "=" ->{
                if(firstNumber?.isNotEmpty() && nextNumber?.isNotEmpty()){
                    doCount()
                    operator = ""
                }
            }
            "AC" ->{
                firstNumber = ""
                nextNumber = ""
                textView.text = ""
                operator = ""
            }
            else ->{
                if (operator?.isNotEmpty()){
                    if (nextNumber?.isEmpty() && value?.equals("0")){
                        Toast.makeText(this,"除数不能为0",Toast.LENGTH_SHORT).show()
                    }else{
                        nextNumber += value
                        textView.text = nextNumber
                    }
                }else{
                    firstNumber += value
                    textView.text = firstNumber
                }
            }
        }
    }

    private fun doCount(){
        var result = 0.0
        when(operator){
            "+" -> result = firstNumber.toDouble()+nextNumber.toDouble()
            "-" -> result =firstNumber.toDouble()-nextNumber.toDouble()
            "*" -> result =firstNumber.toDouble()*nextNumber.toDouble()
            "/" -> {
                result = firstNumber.toDouble()/nextNumber.toDouble()
            }
        }
        firstNumber = result.toString()
        nextNumber = ""
        textView.text = result.toString()
    }
}