package com.example.musicapp
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var imageButtonTelefono: ImageButton

    private var isImageOriginal = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageButtonTelefono = findViewById(R.id.imageButtonPausar)
        imageButtonTelefono.setOnClickListener {
            if (isImageOriginal) {
                imageButtonTelefono.setImageResource(android.R.drawable.ic_media_play)
            } else {
                imageButtonTelefono.setImageResource(android.R.drawable.ic_media_pause)
            }
            isImageOriginal = !isImageOriginal
        }
    }
}
