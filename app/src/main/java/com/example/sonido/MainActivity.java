package com.example.sonido;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referenciamos nuestro video y la vista del mismo
        VideoView vista = findViewById(R.id.video);
        Uri ruta = Uri.parse("android.resource://com.example.sonido/" + R.raw.intromono);

        MediaController mc = new MediaController(this);
        // Establecemos las propiedades de la vista
        vista.setMediaController(mc);
        vista.setVideoURI(ruta);
        // Comenzamos el video
//        vista.start();
    }

    public void pulsarBebe(View view) {
        if ((mp!= null) && (!mp.isPlaying())){
            mp.start();
            return;
        }
        if ((mp != null) && (mp.isPlaying())){ // Instancia creada y reproduciendose
            mp.pause();                      // parar
            return;
        }
        if (mp == null) {                 // Instancia no existe --> la creo y reproduzco
            mp = MediaPlayer.create(this, R.raw.bebe);
            mp.setLooping(true);
            mp.start();
            return;
        }

    }


    public void pulsarCoche(View view) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.coche);
        mp.start();
        //mp.stop();
    }
}