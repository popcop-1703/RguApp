package com.example.rguapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    public double speed, point, Final_count = 0;
    public int Hour_int,Minute_int,Second_int, Millisecond_int = 0;
    public int gender, style, distance, point_int = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void CountButton(View view){
        Bundle arguments = getIntent().getExtras();
        gender = arguments.getInt("gender");
        style = arguments.getInt("style");
        distance = arguments.getInt("distance");

        EditText editText1 = findViewById(R.id.editTextTime1);
        String hour = editText1.getText().toString();
        if (hour.equals(""))
            Hour_int = 0;
        else
            Hour_int = Integer.parseInt(hour);

        EditText editText2 = findViewById(R.id.editTextTime2);
        String minute = editText2.getText().toString();
        if (minute.equals(""))
            Minute_int = 0;
        else
            Minute_int = Integer.parseInt(minute);

        EditText editText3 = findViewById(R.id.editTextTime3);
        String second = editText3.getText().toString();
        if (second.equals(""))
            Second_int = 0;
        else
            Second_int = Integer.parseInt(second);

        EditText editText4 = findViewById(R.id.editTextTime4);
        String millisecond = editText4.getText().toString();
        if (millisecond.equals(""))
            Millisecond_int = 0;
        else
            Millisecond_int = Integer.parseInt(millisecond);


        Final_count = (Millisecond_int + (Second_int * 1000) + (Minute_int * 60 * 1000) + (Hour_int * 60 * 60 * 1000))/1000;
        speed = distance / Final_count;

        switch (style){
            case distance = 1000 & gender = 1 & style = 1:
                point = 1;
                break;
        }

        //Toast.makeText(this, Hour_int, Toast.LENGTH_SHORT).show();
        System.out.println(Final_count);
        System.out.println(distance);
        System.out.println(gender);
        System.out.println(style);
        System.out.println(speed);
        System.out.println(point);
    }
}

/*
        1)Посчитать формулы
        2)Привести все в порядок
 */