package com.example.atanu.alarm;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class secondActivity extends AppCompatActivity  implements TextToSpeech.OnInitListener {

    //MediaPlayer mp;

    TextView messageDisplay ;
    TextToSpeech tts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        messageDisplay = findViewById(R.id.tv_displayMessege);

        Intent i = getIntent();
        String diplayMessage = i.getStringExtra("key");

        messageDisplay.setText(diplayMessage);
        tts = new TextToSpeech(secondActivity.this, this);
       // tts.speak(messageDisplay,)
        //tts.speak(diplayMessage,TextToSpeech.QUEUE_FLUSH, null);
        tts.setLanguage(Locale.US);
        tts.speak(diplayMessage,TextToSpeech.QUEUE_ADD,null);



    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            }


        }
        else{
            Toast.makeText(secondActivity.this, "failed",Toast.LENGTH_SHORT).show();
        }
    }
}
