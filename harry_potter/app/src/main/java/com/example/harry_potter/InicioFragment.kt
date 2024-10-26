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
import com.example.harry_potter.databinding.InicioFragmentBinding

class InicioFragment : Fragment() {

    private var _binding: InicioFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = InicioFragmentBinding.inflate(inflater, container, false)

        // Botón de inicio del juego
        binding.startButton.setOnClickListener {
            (activity as MainActivity).replaceFragment(PreguntaFragment.newInstance(0))
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
