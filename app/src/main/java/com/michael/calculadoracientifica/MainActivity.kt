package com.michael.calculadoracientifica

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.mariuszgromada.math.mxparser.Argument
import org.mariuszgromada.math.mxparser.Expression


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
        val apagar = findViewById<ImageButton>(R.id.apagar)

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
        val abreParenteses = findViewById<Button>(R.id.abreParenteses)
        val fechaParenteses = findViewById<Button>(R.id.fechaParenteses)

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
        var result: Double? = 0.0
        var isResult = true
        var expressaoGeral = ""
        var limparHistorico = false

        //Implementação da digitação de números no visor
        btn0.setOnClickListener {
            if(isResult)
                visorPrincipal.setText("0")
            if(!visorPrincipal.text.toString().equals("0"))
                visorPrincipal.setText(visorPrincipal.text.toString().plus("0"))
            isResult = false

            if (limparHistorico) visorExpressao.setText("")
        }

        btn1.setOnClickListener {
            if (visorPrincipal.text.toString().equals("0") || isResult){
                visorPrincipal.setText("1")
            }
            else
                visorPrincipal.setText(visorPrincipal.text.toString().plus("1"))
            isResult = false

            if (limparHistorico) visorExpressao.setText("")
        }

        btn2.setOnClickListener {
            if (visorPrincipal.text.toString().equals("0") || isResult)
                visorPrincipal.setText("2")
            else
                visorPrincipal.setText(visorPrincipal.text.toString().plus("2"))
            isResult = false

            if (limparHistorico) visorExpressao.setText("")
        }

        btn3.setOnClickListener {
            if (visorPrincipal.text.toString().equals("0") || isResult)
                visorPrincipal.setText("3")
            else
                visorPrincipal.setText(visorPrincipal.text.toString().plus("3"))
            isResult = false

            if (limparHistorico) visorExpressao.setText("")
        }

        btn4.setOnClickListener {
            if (visorPrincipal.text.toString().equals("0") || isResult)
                visorPrincipal.setText("4")
            else
                visorPrincipal.setText(visorPrincipal.text.toString().plus("4"))
            isResult = false

            if (limparHistorico) visorExpressao.setText("")
        }

        btn5.setOnClickListener {
            if (visorPrincipal.text.toString().equals("0") || isResult)
                visorPrincipal.setText("5")
            else
                visorPrincipal.setText(visorPrincipal.text.toString().plus("5"))
            isResult = false

            if (limparHistorico) visorExpressao.setText("")
        }

        btn6.setOnClickListener {
            if (visorPrincipal.text.toString().equals("0") || isResult)
                visorPrincipal.setText("6")
            else
                visorPrincipal.setText(visorPrincipal.text.toString().plus("6"))
            isResult = false

            if (limparHistorico) visorExpressao.setText("")
        }

        btn7.setOnClickListener {
            if (visorPrincipal.text.toString().equals("0") || isResult)
                visorPrincipal.setText("7")
            else
                visorPrincipal.setText(visorPrincipal.text.toString().plus("7"))
            isResult = false

            if (limparHistorico) visorExpressao.setText("")
        }

        btn8.setOnClickListener {
            if (visorPrincipal.text.toString().equals("0") || isResult)
                visorPrincipal.setText("8")
            else
                visorPrincipal.setText(visorPrincipal.text.toString().plus("8"))
            isResult = false

            if (limparHistorico) visorExpressao.setText("")
        }

        btn9.setOnClickListener {
            if (visorPrincipal.text.toString().equals("0") || isResult)
                visorPrincipal.setText("9")
            else
                visorPrincipal.setText(visorPrincipal.text.toString().plus("9"))
            isResult = false

            if (limparHistorico) visorExpressao.setText("")
        }

        virgula.setOnClickListener {
            if (!visorPrincipal.text.toString().contains("."))
                visorPrincipal.setText(visorPrincipal.text.toString().plus("."))
        }

        //Implementação das condições de memória
        mc.setOnClickListener{
            visorPrincipal.setText(MR.toString())
        }

        mMais.setOnClickListener{
            MR += visorPrincipal.text.toString().toDouble()
            visorPrincipal.setText("0")
        }

        mMenos.setOnClickListener{
            MR -= visorPrincipal.text.toString().toDouble()
            visorPrincipal.setText("0")
        }

        pi.setOnClickListener {
            if (visorPrincipal.text.toString().equals("0") || isResult)
                visorPrincipal.setText("3.1415926535897932384626433832795")
            else
                visorPrincipal.setText(visorPrincipal.text.toString().plus("3.1415926535897932384626433832795"))
            isResult = false

            if (limparHistorico) visorExpressao.setText("")
        }

        e.setOnClickListener {
            if (visorPrincipal.text.toString().equals("0") || isResult)
                visorPrincipal.setText("2.7182818284590452353602874713527")
            else
                visorPrincipal.setText(visorPrincipal.text.toString().plus("2.7182818284590452353602874713527"))
            isResult = false

            if (limparHistorico) visorExpressao.setText("")

        }

        // Implementação de operadores aritméticos
        divisao.setOnClickListener {
            temp1 = visorPrincipal.text.toString().toDouble()
            expressaoGeral = "x/y"
            visorExpressao.setText("${visorPrincipal.text.toString()} ÷")
            isResult = true
            limparHistorico = false
        }

        multiplicacao.setOnClickListener {
            temp1 = visorPrincipal.text.toString().toDouble()
            expressaoGeral = "x*y"
            visorExpressao.setText("${visorPrincipal.text.toString()} x")
            isResult = true
            limparHistorico = false
        }

        subtracao.setOnClickListener {
            temp1 = visorPrincipal.text.toString().toDouble()
            expressaoGeral = "x-y"
            visorExpressao.setText("${visorPrincipal.text.toString()} -")
            isResult = true
            limparHistorico = false
        }

        soma.setOnClickListener {
            temp1 = visorPrincipal.text.toString().toDouble()
            expressaoGeral = "x+y"
            visorExpressao.setText("${visorPrincipal.text.toString()} +")
            isResult = true
            limparHistorico = false
        }

        mod.setOnClickListener {
            temp1 = visorPrincipal.text.toString().toDouble()
            expressaoGeral = "mod(x, y)"
            visorExpressao.setText("${visorPrincipal.text.toString()} Mod")
            isResult = true
            limparHistorico = false
        }

        //Implementação das funções avançadas
        x2.setOnClickListener {
            result = calculaExpressao("x^2", visorPrincipal.text.toString().toDouble())
            visorExpressao.setText("sqr(${visorPrincipal.text.toString()})")

            //formatação da remoção do zero depois do ponto
            if (result?.rem(1) == 0.0)
                visorPrincipal.setText(result!!.toInt().toString())
            else
                visorPrincipal.setText(result.toString())

            isResult = true
            limparHistorico = true
        }

        dividirPorX.setOnClickListener {

            if (visorPrincipal.text.toString().toDouble() != 0.0){
                result = calculaExpressao("1/x", visorPrincipal.text.toString().toDouble())
                visorExpressao.setText("1/(${visorPrincipal.text.toString()})")

                //formatação da remoção do zero depois do ponto
                if (result?.rem(1) == 0.0)
                    visorPrincipal.setText(result!!.toInt().toString())
                else
                    visorPrincipal.setText(result.toString())
            }else{
                visorPrincipal.setText("Não é possível dividir por zero")
            }


            isResult = true
            limparHistorico = true
        }

        valorAbsoluto.setOnClickListener {
            result = calculaExpressao("abs(x)", visorPrincipal.text.toString().toDouble())
            visorExpressao.setText("abs(${visorPrincipal.text.toString()})")

            //formatação da remoção do zero depois do ponto
            if (result?.rem(1) == 0.0)
                visorPrincipal.setText(result!!.toInt().toString())
            else
                visorPrincipal.setText(result.toString())

            isResult = true
            limparHistorico = true
        }

        raizQuadrada.setOnClickListener {
            result = calculaExpressao("sqrt(x)", visorPrincipal.text.toString().toDouble())
            visorExpressao.setText("√(${visorPrincipal.text.toString()})")

            //formatação da remoção do zero depois do ponto
            if (result?.rem(1) == 0.0)
                visorPrincipal.setText(result!!.toInt().toString())
            else
                visorPrincipal.setText(result.toString())

            isResult = true
            limparHistorico = true
        }

        fatorial.setOnClickListener {
            result = calculaExpressao("x!", visorPrincipal.text.toString().toDouble())
            visorExpressao.setText("fact(${visorPrincipal.text.toString()})")

            //formatação da remoção do zero depois do ponto
            if (result?.rem(1) == 0.0)
                visorPrincipal.setText(result!!.toInt().toString())
            else
                visorPrincipal.setText(result.toString())

            isResult = true
            limparHistorico = true
        }

        dezExpoenteX.setOnClickListener {
            result = calculaExpressao("10^x", visorPrincipal.text.toString().toDouble())
            visorExpressao.setText("10^(${visorPrincipal.text.toString()})")

            //formatação da remoção do zero depois do ponto
            if (result?.rem(1) == 0.0)
                visorPrincipal.setText(result!!.toInt().toString())
            else
                visorPrincipal.setText(result.toString())

            isResult = true
            limparHistorico = true
        }

        potencias.setOnClickListener {
            temp1 = visorPrincipal.text.toString().toDouble()
            expressaoGeral = "x^y"
            visorExpressao.setText("${visorPrincipal.text.toString()} ^")

            isResult = true
            limparHistorico = false
        }

        log.setOnClickListener {
            result = calculaExpressao("log(x, 10)", visorPrincipal.text.toString().toDouble())
            visorExpressao.setText("log(${visorPrincipal.text.toString()})")

            //formatação da remoção do zero depois do ponto
            if (result?.rem(1) == 0.0)
                visorPrincipal.setText(result!!.toInt().toString())
            else
                visorPrincipal.setText(result.toString())

            isResult = true
            limparHistorico = true
        }

        inn.setOnClickListener {
            result = calculaExpressao("ln(x)", visorPrincipal.text.toString().toDouble())
            visorExpressao.setText("ln(${visorPrincipal.text.toString()})")

            //formatação da remoção do zero depois do ponto
            if (result?.rem(1) == 0.0)
                visorPrincipal.setText(result!!.toInt().toString())
            else
                visorPrincipal.setText(result.toString())

            isResult = true
            limparHistorico = true
        }

        //Funções adicionais
        maisOuMenos.setOnClickListener {
            if (visorPrincipal.text.toString().toDouble() != 0.0 ){
                val temp = visorPrincipal.text.toString().toDouble() * -1

                //formatação da remoção do zero depois do ponto
                if (temp?.rem(1) == 0.0)
                    visorPrincipal.setText(temp!!.toInt().toString())
                else
                    visorPrincipal.setText(result.toString())

            }
        }

        //Implementação do botão Igual
        igual.setOnClickListener {
            temp2 = visorPrincipal.text.toString().toDouble()

            //Tratamento de divisão por zero
            if (expressaoGeral == "x/y" && temp2 == 0.0){
                visorPrincipal.setText("Não é possível dividir por zero")
            }else{
                visorExpressao.setText("${visorExpressao.text.toString()} ${visorPrincipal.text.toString()} =")
                result = calculaExpressao2(expressaoGeral, temp1, temp2)

                //formatação da remoção do zero depois do ponto
                if (result?.rem(1) == 0.0)
                    visorPrincipal.setText(result!!.toInt().toString())
                else
                    visorPrincipal.setText(result.toString())
            }

            isResult = true
            limparHistorico = true
        }

        ce.setOnClickListener {
            visorPrincipal.setText("0")
            visorExpressao.setText("")
            temp1 = 0.0
            temp2 = 0.0
            isResult = false
            limparHistorico = false
            result = 0.0
            expressaoGeral = ""
        }
    }
}

//Calcula uma expressão (String) considerando 1 argumento.
fun calculaExpressao (expressao: String, valor: Double): Double? {
    val x = Argument("x = ${valor.toString()}")
    val exp = Expression(expressao, x)

    return if(exp.checkSyntax()){
        //faz o calculo caso a sintaze seja válida
        exp.calculate()
    }else{
        //Se a sintxe não for válida retorna Null
        null
    }
}

//Calcula uma expressão (String) considerando 2 argumentos.
fun calculaExpressao2 (expressao: String, valorX: Double, valorY: Double): Double? {
    val x = Argument("x = ${valorX.toString()}")
    val y = Argument("y = ${valorY.toString()}")
    val exp = Expression(expressao, x, y)

    return if(exp.checkSyntax()){
        //faz o calculo caso a sintaze seja válida
        exp.calculate()
    }else{
        //Se a sintxe não for válida retorna Null
        null
    }
}