package com.example.atanu.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button reminder;
    EditText time, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reminder = findViewById(R.id.btn_reminder);
        time = findViewById(R.id.et_time);
        message = findViewById(R.id.et_text);

        reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time_t = Integer.parseInt(time.getText().toString());
                String displayMessage = message.getText().toString();
                Intent intent = new Intent(MainActivity.this, secondActivity.class);
                intent.putExtra("key",displayMessage);

                PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 123, intent, 0);

                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                //alarmManager.set(AlarmManager.RTC_WAKEUP , System.currentTimeMillis()+(time_t*1000));

               alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +(time_t*1000),pi);
//                alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),
//                        AlarmManager.INTERVAL_HOUR/600,pi);




            }
        });
    }
}
