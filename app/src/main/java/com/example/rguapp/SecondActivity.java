package com.example.rguapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    public double speed = 0;
    public double point = 0;
    public int to_switch = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    public void CountButton(View view){
        Bundle arguments = getIntent().getExtras();
        int gender = arguments.getInt("gender");
        int style = arguments.getInt("style");
        int distance = arguments.getInt("distance");

        EditText editText1 = findViewById(R.id.editTextTime1);
        String hour = editText1.getText().toString();
        int Hour_int = Integer.parseInt(hour);

        EditText editText2 = findViewById(R.id.editTextTime2);
        String minute = editText2.getText().toString();
        int Minute_int = Integer.parseInt(minute);

        EditText editText3 = findViewById(R.id.editTextTime3);
        String second = editText3.getText().toString();
        int Second_int = Integer.parseInt(second);

        EditText editText4 = findViewById(R.id.editTextTime4);
        String millisecond = editText4.getText().toString();
        int Millisecond_int = Integer.parseInt(millisecond);


        double Final_count = (Millisecond_int + (Second_int * 1000) + (Minute_int * 60 * 1000) + (Hour_int * 60 * 60 * 1000))/1000;
        speed = distance / Final_count;

        if (distance == 1000 & gender == 1 & style == 2)
            point = 1;

        //Toast.makeText(this, Hour_int, Toast.LENGTH_SHORT).show();
        System.out.println(Final_count);
        System.out.println(distance);
        System.out.println(speed);
        System.out.println(point);
    }
}

/*      1)Добавить для второй страницы если отсутвует то 0
        2)Посчитать формулы
        3)Добавить вывод на экран скорости и очков
        4)Привести все в порядок
 */