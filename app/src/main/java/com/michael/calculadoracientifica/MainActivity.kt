package com.michael.calculadoracientifica

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Variáveis do visor do projeto
        val visorExpressao = findViewById<TextView>(R.id.visorExpressao)
        val visorPrincipal = findViewById<TextView>(R.id.visorPrincipal)

        //Variáveis do DEG e F-E
        val deg = findViewById<Button>(R.id.deg)
        val fe = findViewById<Button>(R.id.fe)

        //Variáveis da memória
        val mc = findViewById<Button>(R.id.mc)
        val mr = findViewById<Button>(R.id.mr)
        val mMais = findViewById<Button>(R.id.mMais)
        val mMenos = findViewById<Button>(R.id.mMenos)
        val ms = findViewById<Button>(R.id.ms)
        val mOpcoes = findViewById<Button>(R.id.mOpcoes)

        //Variáveis das funções avançadas
        val doisND = findViewById<Button>(R.id.doisND)
        val pi = findViewById<Button>(R.id.pi)
        val e = findViewById<Button>(R.id.e)
        val x2 = findViewById<Button>(R.id.x2)
        val dividirPorX = findViewById<Button>(R.id.dividirporx)
        val valorAbsoluto = findViewById<Button>(R.id.valorAbsoluto)
        val exp = findViewById<Button>(R.id.exp)
        val mod = findViewById<Button>(R.id.mod)
        val raizQuadrada = findViewById<Button>(R.id.raizQuadrada)
        val fatorial = findViewById<Button>(R.id.fatorial)
        val potencias = findViewById<Button>(R.id.potencias)
        val dezExpoenteX = findViewById<Button>(R.id.dezexpoentex)
        val log = findViewById<Button>(R.id.log)
        val inn = findViewById<Button>(R.id.inn)

        //Variáveis de comando
        val ce = findViewById<Button>(R.id.ce)
        val apagar = findViewById<Button>(R.id.apagar)

        //Variáveis do teclado numérico
        val btn0 = findViewById<Button>(R.id.zero)
        val btn1 = findViewById<Button>(R.id.um)
        val btn2 = findViewById<Button>(R.id.dois)
        val btn3 = findViewById<Button>(R.id.tres)
        val btn4 = findViewById<Button>(R.id.quatro)
        val btn5 = findViewById<Button>(R.id.cinco)
        val btn6 = findViewById<Button>(R.id.seis)
        val btn7 = findViewById<Button>(R.id.sete)
        val btn8 = findViewById<Button>(R.id.oito)
        val btn9 = findViewById<Button>(R.id.nove)
        val maisOuMenos = findViewById<Button>(R.id.maisoumenos)
        val virgula = findViewById<Button>(R.id.virgula)

        //Variáveis das operações básicas
        val divisao = findViewById<Button>(R.id.divisao)
        val multiplicacao = findViewById<Button>(R.id.multiplicacao)
        val subtracao = findViewById<Button>(R.id.subtracao)
        val soma = findViewById<Button>(R.id.soma)
        val igual = findViewById<Button>(R.id.igual)

        //Variáveis de controle
        var MR = 0.0
        var temp1 = 0.0
        var temp2 = 0.0
        var result = 0.0
        var isResult = false
        var operacao = 0

        //Implementação da digitação de números no visor
        btn0.setOnClickListener {
            if(isResult)
                visorPrincipal.setText("0")
            if(!visorPrincipal.text.toString().equals("0"))
                visorPrincipal.setText(visorPrincipal.text.toString().plus("0"))
            isResult = false
        }

        btn1.setOnClickListener {
            if (visorPrincipal.text.toString().equals("0") || isResult)
                visorPrincipal.setText("1")
            else
                visorPrincipal.setText(visorPrincipal.text.toString().plus("1"))
            isResult = false
        }

        btn2.setOnClickListener {
            if (visorPrincipal.text.toString().equals("0") || isResult)
                visorPrincipal.setText("2")
            else
                visorPrincipal.setText(visorPrincipal.text.toString().plus("2"))
            isResult = false
        }

        btn3.setOnClickListener {
            if (visorPrincipal.text.toString().equals("0") || isResult)
                visorPrincipal.setText("3")
            else
                visorPrincipal.setText(visorPrincipal.text.toString().plus("3"))
            isResult = false
        }

        btn4.setOnClickListener {
            if (visorPrincipal.text.toString().equals("0") || isResult)
                visorPrincipal.setText("4")
            else
                visorPrincipal.setText(visorPrincipal.text.toString().plus("4"))
            isResult = false
        }

        btn5.setOnClickListener {
            if (visorPrincipal.text.toString().equals("0") || isResult)
                visorPrincipal.setText("5")
            else
                visorPrincipal.setText(visorPrincipal.text.toString().plus("5"))
            isResult = false
        }

        btn6.setOnClickListener {
            if (visorPrincipal.text.toString().equals("0") || isResult)
                visorPrincipal.setText("6")
            else
                visorPrincipal.setText(visorPrincipal.text.toString().plus("6"))
            isResult = false
        }

        btn7.setOnClickListener {
            if (visorPrincipal.text.toString().equals("0") || isResult)
                visorPrincipal.setText("7")
            else
                visorPrincipal.setText(visorPrincipal.text.toString().plus("7"))
            isResult = false
        }

        btn8.setOnClickListener {
            if (visorPrincipal.text.toString().equals("0") || isResult)
                visorPrincipal.setText("8")
            else
                visorPrincipal.setText(visorPrincipal.text.toString().plus("8"))
            isResult = false
        }

        btn9.setOnClickListener {
            if (visorPrincipal.text.toString().equals("0") || isResult)
                visorPrincipal.setText("9")
            else
                visorPrincipal.setText(visorPrincipal.text.toString().plus("9"))
            isResult = false
        }

        //Implementaçãp das ações de operações simples

    }
}