//Descripción: Parcial de preguntas de Harry Potter.
//Autor: Enyelbert Anderson Panta Huaracha.
//Fecha creación: 17/10/2024
//Última modificación: 19/10/2024
package com.example.harry_potter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.os.CountDownTimer
import com.example.harry_potter.databinding.PreguntaFragmentBinding

class PreguntaFragment : Fragment() {

    private var _binding: PreguntaFragmentBinding? = null
    private val binding get() = _binding!!
    private var currentQuestion: Int = 0
    private var score: Int = 0
    private var preguntas: List<Preguntas> = Preguntas.getPreguntas()
    private lateinit var countdownTimer: CountDownTimer
    private var timeLeftInMillis: Long = 15000 // 15 segundos en milisegundos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            currentQuestion = it.getInt("ARG_CURRENT_QUESTION", 0)
            score = it.getInt("ARG_SCORE", 0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PreguntaFragmentBinding.inflate(inflater, container, false)


        setupQuestion()
        startTimer()

        binding.option1.setOnClickListener { checkAnswer(0) }
        binding.option2.setOnClickListener { checkAnswer(1) }
        binding.option3.setOnClickListener { checkAnswer(2) }
        binding.option4.setOnClickListener { checkAnswer(3) }

        return binding.root
    }

    private fun startTimer() {
        countdownTimer = object : CountDownTimer(timeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                binding.timerText.text = (timeLeftInMillis / 1000).toString() // Muestra el tiempo restante en segundos
            }

            override fun onFinish() {
                binding.timerText.text = "0"
                // Si el tiempo se agota, mostrar respuesta incorrecta y avanzar
                checkAnswer(-1) //
            }
        }.start()
    }

    private fun checkAnswer(selectedOption: Int) {
        // Detener el temporizador
        countdownTimer.cancel()

        // Incrementar el puntaje si la respuesta es correcta
        if (selectedOption == preguntas[currentQuestion].respuestaCorrecta) {
            score++
        }

        // Navegar a RespuestaFragment
        val respuestaFragment = RespuestaFragment.newInstance(currentQuestion, selectedOption, score)
        (activity as MainActivity).replaceFragment(respuestaFragment)
    }

    private fun setupQuestion() {
        // Configura la pregunta y las opciones
        val pregunta = preguntas[currentQuestion]
        binding.questionText.text = pregunta.pregunta
        binding.option1.text = pregunta.opciones[0]
        binding.option2.text = pregunta.opciones[1]
        binding.option3.text = pregunta.opciones[2]
        binding.option4.text = pregunta.opciones[3]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        countdownTimer.cancel() // Detenie el temporizador
    }

    companion object {
        fun newInstance(currentQuestion: Int = 0, score: Int = 0): PreguntaFragment {
            return PreguntaFragment().apply {
                arguments = Bundle().apply {
                    putInt("ARG_CURRENT_QUESTION", currentQuestion)
                    putInt("ARG_SCORE", score)
                }
            }
        }
    }
}
