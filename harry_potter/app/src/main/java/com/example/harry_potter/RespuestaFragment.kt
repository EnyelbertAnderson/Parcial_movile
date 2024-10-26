//Descripción: Parcial de preguntas de Harry Potter.
//Autor: Enyelbert Anderson Panta Huaracha.
//Fecha creación: 17/10/2024
//Última modificación: 19/10/2024

package com.example.harry_potter

import androidx.appcompat.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.harry_potter.databinding.RespuestaFragmentBinding

class RespuestaFragment : Fragment() {

    private var _binding: RespuestaFragmentBinding? = null
    private val binding get() = _binding!!

    private var questionIndex: Int = 0
    private var selectedOption: Int = 0
    private var score: Int = 0
    private val totalQuestions: Int = Preguntas.getPreguntas().size // Total de preguntas

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RespuestaFragmentBinding.inflate(inflater, container, false)

        // Obtener argumentos
        questionIndex = arguments?.getInt(ARG_QUESTION) ?: 0
        selectedOption = arguments?.getInt(ARG_SELECTED_OPTION) ?: 0
        score = arguments?.getInt(ARG_SCORE) ?: 0

        showFeedback()

        return binding.root
    }

    private fun showFeedback() {
        val pregunta = Preguntas.getPreguntas()[questionIndex]

        if (selectedOption == -1) {
            binding.feedbackText.text = "Tiempo agotado. La respuesta correcta era: ${pregunta.opciones[pregunta.respuestaCorrecta]}"
        } else if (selectedOption == pregunta.respuestaCorrecta) {
            binding.feedbackText.text = "¡Correcto!"
        } else {
            binding.feedbackText.text = "Incorrecto. La respuesta correcta era: ${pregunta.opciones[pregunta.respuestaCorrecta]}"
        }

        // Botón para continuar
        binding.nextButton.setOnClickListener {
            // Aquí incrementamos el índice de la pregunta
            val nextQuestionIndex = questionIndex + 1

            if (nextQuestionIndex < Preguntas.getPreguntas().size) {
                // Si hay más preguntas, ir a la siguiente
                (activity as MainActivity).replaceFragment(PreguntaFragment.newInstance(nextQuestionIndex, score))
            } else {

                mostrarDialogoPuntuacionFinal(score)
            }
        }
    }

    private fun mostrarDialogoPuntuacionFinal(puntuacion: Int) {
        val dialogBuilder = AlertDialog.Builder(requireContext())
        dialogBuilder.setTitle("Fin del Juego")
        dialogBuilder.setMessage("Tu puntuación final es: $puntuacion/${Preguntas.getPreguntas().size}")

        dialogBuilder.setPositiveButton("Aceptar") { dialog, _ ->
            dialog.dismiss()

            (activity as MainActivity).replaceFragment(InicioFragment())
        }

        val alertDialog = dialogBuilder.create()
        alertDialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_QUESTION = "arg_question"
        private const val ARG_SELECTED_OPTION = "arg_selected_option"
        private const val ARG_SCORE = "arg_score"

        fun newInstance(questionIndex: Int, selectedOption: Int, score: Int) = RespuestaFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_QUESTION, questionIndex)
                putInt(ARG_SELECTED_OPTION, selectedOption)
                putInt(ARG_SCORE, score)
            }
        }
    }
}
