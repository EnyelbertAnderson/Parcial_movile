//Descripción: Parcial de preguntas de Harry Potter.
//Autor: Enyelbert Anderson Panta Huaracha.
//Fecha creación: 17/10/2024
//Última modificación: 19/10/2024
package com.example.harry_potter

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.harry_potter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Iniciar la música de fondo
        val musicIntent = Intent(this, MusicService::class.java)
        startService(musicIntent)

        // Cargar el fragmento de inicio
        if (savedInstanceState == null) {
            replaceFragment(InicioFragment())
        }
    }


    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        // Detener la música al salir
        val musicIntent = Intent(this, MusicService::class.java)
        stopService(musicIntent)
    }
}
