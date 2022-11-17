package com.example.calculator1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.Math.pow
import kotlin.math.log

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var temp = ""
    var current = ""
    var infoText = ""
    var state = ""
    lateinit var button0 : Button
    lateinit var button1 : Button
    lateinit var button2 : Button
    lateinit var button3 : Button
    lateinit var button4 : Button
    lateinit var button5 : Button
    lateinit var button6 : Button
    lateinit var button7 : Button
    lateinit var button8 : Button
    lateinit var button9 : Button
    lateinit var buttonAdd : Button
    lateinit var buttonEqual : Button
    lateinit var buttonMinus : Button
    lateinit var buttonMult : Button
    lateinit var buttonAC : Button
    lateinit var buttonDelete : Button
    lateinit var buttonReverse : Button
    lateinit var buttonPower : Button
    lateinit var buttonProcent : Button
    lateinit var buttonLog : Button
    lateinit var buttonDivide: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        buttonAC = findViewById(R.id.buttonAC)
        buttonDelete = findViewById(R.id.buttonDelete)
        buttonMinus = findViewById(R.id.buttonMinus)
        buttonEqual = findViewById(R.id.buttonEqual)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonMult = findViewById(R.id.buttonMult)
        buttonLog = findViewById(R.id.buttonLog)
        buttonReverse = findViewById(R.id.buttonReverse)
        buttonProcent = findViewById(R.id.buttonProcent)
        buttonPower = findViewById(R.id.buttonPower)
        buttonDivide = findViewById(R.id.buttonDivide)

        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        buttonAC.setOnClickListener(this)
        buttonDelete.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonEqual.setOnClickListener(this)
        buttonAdd.setOnClickListener(this)
        buttonMult.setOnClickListener(this)
        buttonLog.setOnClickListener(this)
        buttonReverse.setOnClickListener(this)
        buttonProcent.setOnClickListener(this)
        buttonPower.setOnClickListener(this)
        buttonDivide.setOnClickListener(this)

    }

    override fun onClick(v: View?){
        var resultText : TextView = findViewById(R.id.textResult)
        var tempText: TextView = findViewById(R.id.textInfo)
//        resultText.text = current
        println("ONCLICK")
        when (v?.id) {
            R.id.button0 -> {
                current += ((getText( findViewById(R.id.button0) )))
            }
            R.id.button1 -> {
                current += ((getText( findViewById(R.id.button1) )))
            }
            R.id.button2 -> {
                current += getText( findViewById(R.id.button2) )
            }
            R.id.button3 -> {
                current += getText( findViewById(R.id.button3) )
            }
            R.id.button4 -> {
                current += getText( findViewById(R.id.button4) )
            }
            R.id.button5 -> {
                current += getText( findViewById(R.id.button5) )
            }
            R.id.button6 -> {
                current += getText( findViewById(R.id.button6) )
            }
            R.id.button7 -> {
                current += getText( findViewById(R.id.button7) )
            }
            R.id.button8 -> {
                current += getText( findViewById(R.id.button8) )
            }
            R.id.button9 -> {
                current += getText( findViewById(R.id.button9) )
            }
            R.id.buttonAC -> {
                current = ""
                temp = ""
                state = ""
            }
            R.id.buttonAdd -> {
                changeState("+")
            }
            R.id.buttonDelete -> {
                if( current.equals("") == false ) {
                    current = current.substring(0, current.length - 1)
                }
            }
            R.id.buttonLog -> {
                changeState("L")
            }
            R.id.buttonMinus -> {
                changeState("-")
            }
            R.id.buttonMult -> {
                changeState("*")
            }
            R.id.buttonDivide -> {
                changeState("/")
            }
            R.id.buttonPower -> {
                changeState("^")
            }
            R.id.buttonReverse -> {
                if (current.equals("") == false){
                    current = ( current.toInt() * (-1) ).toString()
                }
                temp =  current
                current = ""
            }
            R.id.buttonProcent -> {
                if( current.equals("") || temp.equals("") ){
                    current = ""
                    temp = ""
                } else {
                    current = (temp.toDouble() * current.toDouble() / 100.00).toInt().toString()
                }
            }
            R.id.buttonEqual-> {
                if( current.equals("") || temp.equals("")){
                    state = ""
                }

                when( state ){
                    "+" -> {
                        current = ( temp.toInt() + current.toInt() ).toString()
                        temp = ""
                    }
                    "*" -> {
                        temp = ( temp.toInt() * current.toInt() ).toString()
                        current = temp
                        temp = ""
                    }
                    "-" -> {
                        temp = ( temp.toInt() - current.toInt() ).toString()
                        current = temp
                        temp = ""
                    }
                    "/" -> {
                        if( current.toInt() == 0 ){
                            temp = ""
                            current = ""
                        }
                        else {
                            temp = (temp.toInt() / current.toInt()).toString()
                            current = temp
                            temp = ""
                        }
                    }
                    "^" -> {
                        temp = ( pow(temp.toInt().toDouble(), current.toInt().toDouble() ) ).toInt().toString()
                        current = temp
                        temp = ""
                    }
                    "L" -> {
                        temp = ( log(temp.toDouble(), current.toDouble() ) ).toInt().toString()
                        current = temp
                        temp = ""
                    }
                    else -> {
                        temp = ""
                        current = ""
                    }
                }
                state = ""
            }
        }
        println(current)
        tempText.text = temp + state
        resultText.text = current
    }

    fun getText(button: Button ): String? {
        return button.text.toString()
    }

    fun changeState(symbol: String) {
        if( current.equals("") == false ) {
            temp = current
            current = ""
        }
            state = symbol
    }
}