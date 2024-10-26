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
import com.example.harry_potter.databinding.FinalFragmentBinding

class FinalFragment : Fragment() {

    private var _binding: FinalFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FinalFragmentBinding.inflate(inflater, container, false)

        // Obtener la puntuación
        val finalScore = arguments?.getInt(ARG_SCORE) ?: 0
        val totalQuestions = Preguntas.getPreguntas().size

        // Mostrar la puntuación final
        binding.finalScoreText.text = "Puntuación final: $finalScore de $totalQuestions"

        // Botón para reiniciar el juego
        binding.restartButton.setOnClickListener {
            (activity as MainActivity).replaceFragment(InicioFragment())
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_SCORE = "arg_score"

        fun newInstance(score: Int) = FinalFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_SCORE, score)
            }
        }
    }
}
