package com.example.jackpot

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class Juego : AppCompatActivity() {

    private lateinit var btnSpin: ImageView
    private lateinit var resultImage1: ImageView
    private lateinit var resultImage2: ImageView
    private lateinit var resultImage3: ImageView
    private lateinit var resultImage4: ImageView

    private val symbols = listOf(
        R.drawable.delicia,
        R.drawable.cinta_azul,
        R.drawable.kimby,
        R.drawable.pipasa,
        R.drawable.delicia,
        R.drawable.cinta_azul,
        R.drawable.kimby,
        R.drawable.pipasa
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)

        btnSpin = findViewById(R.id.btnSpin)
        resultImage1 = findViewById(R.id.resultImage1)
        resultImage2 = findViewById(R.id.resultImage2)
        resultImage3 = findViewById(R.id.resultImage3)
        resultImage4 = findViewById(R.id.resultImage4)

        btnSpin.setOnClickListener {
            spinReels()
        }
    }

    private fun spinReels() {

        btnSpin.isEnabled = false

        val delayMillis = 210L // Ajusta este valor según el tiempo de retraso deseado
        val handler = Handler()

        handler.postDelayed({
            resultImage1.setImageResource(R.drawable.oculto)
            resultImage1.visibility = View.INVISIBLE
        }, delayMillis)

        handler.postDelayed({
            resultImage1.setImageResource(R.drawable.cinta_azul)
            resultImage1.visibility = View.VISIBLE
        }, delayMillis * 2)

        handler.postDelayed({
            resultImage1.visibility = View.INVISIBLE
        }, delayMillis * 3)

        handler.postDelayed({
            resultImage1.setImageResource(R.drawable.pipasa)
            resultImage1.visibility = View.VISIBLE
        }, delayMillis * 4)

        handler.postDelayed({
            resultImage1.visibility = View.INVISIBLE
        }, delayMillis * 5)

        handler.postDelayed({
            resultImage1.setImageResource(R.drawable.delicia)
            resultImage1.visibility = View.VISIBLE
        }, delayMillis * 6)

        handler.postDelayed({
            resultImage1.visibility = View.INVISIBLE
        }, delayMillis * 7)

        handler.postDelayed({
            resultImage1.setImageResource(R.drawable.kimby)
            resultImage1.visibility = View.VISIBLE
        }, delayMillis * 8)

        //Cambio a la imagen 2
        handler.postDelayed({
            resultImage2.setImageResource(R.drawable.oculto)
            resultImage2.visibility = View.INVISIBLE
        }, delayMillis)

        handler.postDelayed({
            resultImage2.setImageResource(R.drawable.pipasa)
            resultImage2.visibility = View.VISIBLE
        }, delayMillis * 2)

        handler.postDelayed({
            resultImage2.visibility = View.INVISIBLE
        }, delayMillis * 3)

        handler.postDelayed({
            resultImage2.setImageResource(R.drawable.delicia)
            resultImage2.visibility = View.VISIBLE
        }, delayMillis * 4)

        handler.postDelayed({
            resultImage2.visibility = View.INVISIBLE
        }, delayMillis * 5)

        handler.postDelayed({
            resultImage2.setImageResource(R.drawable.kimby)
            resultImage2.visibility = View.VISIBLE
        }, delayMillis * 6)

        handler.postDelayed({
            resultImage2.visibility = View.INVISIBLE
        }, delayMillis * 7)

        handler.postDelayed({
            resultImage2.setImageResource(R.drawable.cinta_azul)
            resultImage2.visibility = View.VISIBLE
        }, delayMillis * 8)

        //Cambio de imagen3
        handler.postDelayed({
            resultImage3.setImageResource(R.drawable.oculto)
            resultImage3.visibility = View.INVISIBLE
        }, delayMillis)

        handler.postDelayed({
            resultImage3.setImageResource(R.drawable.delicia)
            resultImage3.visibility = View.VISIBLE
        }, delayMillis * 2)

        handler.postDelayed({
            resultImage3.visibility = View.INVISIBLE
        }, delayMillis * 3)

        handler.postDelayed({
            resultImage3.setImageResource(R.drawable.kimby)
            resultImage3.visibility = View.VISIBLE
        }, delayMillis * 4)

        handler.postDelayed({
            resultImage3.visibility = View.INVISIBLE
        }, delayMillis * 5)

        handler.postDelayed({
            resultImage3.setImageResource(R.drawable.cinta_azul)
            resultImage3.visibility = View.VISIBLE
        }, delayMillis * 6)

        handler.postDelayed({
            resultImage3.visibility = View.INVISIBLE
        }, delayMillis * 7)

        handler.postDelayed({
            resultImage3.setImageResource(R.drawable.pipasa)
            resultImage3.visibility = View.VISIBLE
        }, delayMillis * 8)

        //Cambio imagen4
        handler.postDelayed({
            resultImage4.setImageResource(R.drawable.oculto)
            resultImage4.visibility = View.INVISIBLE
        }, delayMillis)

        handler.postDelayed({
            resultImage4.setImageResource(R.drawable.kimby)
            resultImage4.visibility = View.VISIBLE
        }, delayMillis * 2)

        handler.postDelayed({
            resultImage4.visibility = View.INVISIBLE
        }, delayMillis * 3)

        handler.postDelayed({
            resultImage4.setImageResource(R.drawable.cinta_azul)
            resultImage4.visibility = View.VISIBLE
        }, delayMillis * 4)

        handler.postDelayed({
            resultImage4.visibility = View.INVISIBLE
        }, delayMillis * 5)

        handler.postDelayed({
            resultImage4.setImageResource(R.drawable.pipasa)
            resultImage4.visibility = View.VISIBLE
        }, delayMillis * 6)

        handler.postDelayed({
            resultImage4.visibility = View.INVISIBLE
        }, delayMillis * 7)

        handler.postDelayed({
            resultImage4.setImageResource(R.drawable.delicia)
            resultImage4.visibility = View.VISIBLE
        }, delayMillis * 8)

        val random = Random.Default

        handler.postDelayed({
            val result1 = symbols[random.nextInt(symbols.size)]
            val result2 = symbols[random.nextInt(symbols.size)]
            val result3 = symbols[random.nextInt(symbols.size)]
            val result4 = symbols[random.nextInt(symbols.size)]

            resultImage1.setImageResource(result1)
            resultImage2.setImageResource(result2)
            resultImage3.setImageResource(result3)
            resultImage4.setImageResource(result3)

            checkWin(result1, result2, result3, result4)

            btnSpin.isEnabled = true
        }, 2000)
    }

    private fun checkWin(result1: Int, result2: Int, result3: Int, result4: Int) {
        if (result1 == result2 && result2 == result3 && result3 == result4) {
            // Aquí puedes realizar acciones adicionales si es un Jackpot
            Handler().postDelayed({
                val intent = Intent(this, Victoria::class.java)
                startActivity(intent)
                finish()
            },1500)
        } else {
            Handler().postDelayed({
                val intent = Intent(this, Derrota::class.java)
                startActivity(intent)
                finish()
            },1500)
        }
    }
}