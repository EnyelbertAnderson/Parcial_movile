//Descripción: Parcial de preguntas de Harry Potter.
//Autor: Enyelbert Anderson Panta Huaracha.
//Fecha creación: 17/10/2024
//Última modificación: 19/10/2024

package com.example.harry_potter

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MusicService : Service() {

    private lateinit var player: MediaPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player = MediaPlayer.create(this, R.raw.background_music) // Asegúrate de tener un archivo de música en res/raw
        player.isLooping = true
        player.start()
        return START_STICKY
    }

    override fun onDestroy() {
        player.stop()
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
