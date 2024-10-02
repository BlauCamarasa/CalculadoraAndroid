package com.example.calculadoraandroid

import android.os.Bundle
import android.view.View
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//Calculadora Android feta per Maria Blau Camarasa Linde
class MainActivity : AppCompatActivity() {
    var resultado: Double = 0.0
    private val numeromarcado = StringBuilder()
    var operacionpen: Int = 0;
    var operacionpentri: Int = 0;
    lateinit var SW_rad: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        SW_rad = findViewById(R.id.switch_rad)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun operation()
    {
        var valor: Double = 0.0;
        when (operacionpentri){
            1 -> {
                if (SW_rad.isChecked) {
                    valor = Math.sin(numeromarcado.toString().toDouble())
                    numeromarcado.clear()
                    numeromarcado.append(valor.toString())
                } else{
                    valor = Math.sin(Math.toRadians(numeromarcado.toString().toDouble()))
                    numeromarcado.clear()
                    numeromarcado.append(valor.toString())
                }
            }

            2 -> {
                if (SW_rad.isChecked) {
                    valor = Math.cos(numeromarcado.toString().toDouble())
                    numeromarcado.clear()
                    numeromarcado.append(valor.toString())
                } else{
                    valor = Math.cos(Math.toRadians(numeromarcado.toString().toDouble()))
                    numeromarcado.clear()
                    numeromarcado.append(valor.toString())
                }
            }
            3 -> {
                if (SW_rad.isChecked) {
                    valor = Math.tan(numeromarcado.toString().toDouble())
                    numeromarcado.clear()
                    numeromarcado.append(valor.toString())
                } else{
                    valor = Math.tan(Math.toRadians(numeromarcado.toString().toDouble()))
                    numeromarcado.clear()
                    numeromarcado.append(valor.toString())
                }
            }
        }
        operacionpentri=0;
        when (operacionpen) {
            0 -> {
                resultado = numeromarcado.toString().toDouble();
            }
            1 -> {
                resultado = resultado - numeromarcado.toString().toDouble()
            }
            2 -> {
                resultado = resultado + numeromarcado.toString().toDouble()
            }
            3 -> {
                resultado = resultado * numeromarcado.toString().toDouble()
            }
            4 -> {
                resultado = resultado / numeromarcado.toString().toDouble()
            }
        }
        numeromarcado.clear()
    }

    fun onClick(view: View) {
        val screen_calcu = findViewById<TextView>(R.id.textView)

        when (view.id) {
            R.id.button_point -> {
                screen_calcu.text = screen_calcu.text.toString() + ".";
                numeromarcado.append(".")
            }

            R.id.button_0 -> {
                screen_calcu.text = screen_calcu.text.toString() + "0";
                numeromarcado.append("0")
            }

            R.id.button_1 -> {
                screen_calcu.text = screen_calcu.text.toString() + "1";
                numeromarcado.append("1")
            }

            R.id.button_2 -> {
                screen_calcu.text = screen_calcu.text.toString() + "2";
                numeromarcado.append("2")
            }

            R.id.button_3 -> {
                screen_calcu.text = screen_calcu.text.toString() + "3";
                numeromarcado.append("3")
            }

            R.id.button_4 -> {
                screen_calcu.text = screen_calcu.text.toString() + "4";
                numeromarcado.append("4")
            }

            R.id.button_5 -> {
                screen_calcu.text = screen_calcu.text.toString() + "5";
                numeromarcado.append("5")
            }

            R.id.button_6 -> {
                screen_calcu.text = screen_calcu.text.toString() + "6";
                numeromarcado.append("6")
            }

            R.id.button_7 -> {
                screen_calcu.text = screen_calcu.text.toString() + "7";
                numeromarcado.append("7")
            }

            R.id.button_8 -> {
                screen_calcu.text = screen_calcu.text.toString() + "8";
                numeromarcado.append("8")
            }

            R.id.button_9 -> {
                screen_calcu.text = screen_calcu.text.toString() + "9";
                numeromarcado.append("9")
            }

            R.id.button_substraction -> {
                screen_calcu.text = screen_calcu.text.toString() + " - "
                operation()
                operacionpen = 1

            }

            R.id.button_plus -> {
                screen_calcu.text = screen_calcu.text.toString() + " + "
                operation()
                operacionpen = 2

            }
            R.id.button_multiply -> {
                screen_calcu.text = screen_calcu.text.toString() + " * "
                operation()
                operacionpen = 3;
            }
            R.id.button_division-> {
                screen_calcu.text = screen_calcu.text.toString() + " / "
                operation()
                operacionpen = 4
            }
            R.id.button_equals -> {
                operation()
                screen_calcu.text = resultado.toString();

            }
            R.id.button_clear -> {
                screen_calcu.text = "";
                numeromarcado.clear()
                operacionpen = 0
                resultado = 0.0
                operacionpentri = 0
            }
            R.id.button_sin -> {
                screen_calcu.text = screen_calcu.text.toString() + "sin "
                operacionpentri = 1
            }
            R.id.button_cos -> {
                screen_calcu.text = screen_calcu.text.toString() + "cos "
                operacionpentri = 2
            }
            R.id.button_tan -> {
                screen_calcu.text = screen_calcu.text.toString() + "tan "
                operacionpentri = 3
            }
        }
    }
}