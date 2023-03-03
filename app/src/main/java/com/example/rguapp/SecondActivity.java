package com.example.rguapp;

import java.text.DecimalFormat;
import java.util.Scanner;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends Activity {

    public double speed, speed_2, point, Final_count = 0;
    public int Hour_int,Minute_int,Second_int, Millisecond_int = 0;
    public int gender, style, distance = 0;
    public static double a,b,c,d,x1,x2,x3;
    public double scale = Math.pow(10, 2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView1 = findViewById(R.id.textView_speed);
        textView1.setText("");
        TextView textView2 = findViewById(R.id.textView_point);
        textView2.setText("");
    }

    public static void getInputs() {
        //Declares input function
        Scanner in = new Scanner(System.in);
        System.out.println("Solves cubics in the form Ax^3 + Bx^2 + Cx +D");

        //Gets actual values from user
        System.out.println("Enter tha value of A:");
        a = Double.parseDouble(in.nextLine());
        System.out.println("Enter tha value of B:");
        b = Double.parseDouble(in.nextLine());
        System.out.println("Enter tha value of C:");
        c = Double.parseDouble(in.nextLine());
        System.out.println("Enter tha value of D:");
        d = Double.parseDouble(in.nextLine());
        System.out.println("A=" + a + ", B=" + b + ", C=" + c + ", D=" + d);
    }
    public void CountButton(View view){
        DecimalFormat myFormat = new DecimalFormat("#.##");
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

        if(distance == 1000 && gender == 1 && style == 1){
            a = -3.800610269 * Math.pow(10,-10);
            b = 5.351939033 * Math.pow(10,-7);
            c = 0.002888134079;
            d = 4.166654127;
        } else if (distance == 1000 && gender == 1 && style == 2) {
            a = -3.446864478 * Math.pow(10,-10);
            b = 4.462887807 * Math.pow(10,-7);
            c = 0.002635557119;
            d = 4.61501587;
        } else if (distance == 1000 && gender == 2 && style == 1) {
            a = -3.114583333 * Math.pow(10,-10);
            b = 4.344426407 * Math.pow(10,-7);
            c = 0.00254557052;
            d = 3.71202381;
        } else if (distance == 1000 && gender == 2 && style == 2) {
            a = -2.767860199 * Math.pow(10,-10);
            b = 3.483833439 * Math.pow(10,-7);
            c = 0.0022779484;
            d = 3.6804441;
        }
        for( int i = 0; i < 2200; i++){
            speed_2 = a*Math.pow(i,3) + b*Math.pow(i,2) + c*i + d;
            if (Math.floor(speed_2) == Math.floor(speed)){
                for (double j=0; j<1; j+=0.1){
                    speed_2 = a*Math.pow(i,3) + b*Math.pow(i,2) + c*i + d;
                    if ((Math.ceil(speed_2 * 10) / 10) ==(Math.ceil(speed * 10) / 10)){
                        for (double k = 0; k < 0.1; k+=0.01 ){
                            speed_2 = a*Math.pow(i,3) + b*Math.pow(i,2) + c*i + d;
                            if ((Math.ceil(speed_2 * scale) / scale) ==(Math.ceil(speed * scale) / scale)){
                                point = i;
                                break;
                            }
                        }
                    }
                }
            }
        }


        TextView textView1 = findViewById(R.id.textView_speed);
        textView1.setText("Ваша скорость = " + myFormat.format(speed) + " М/C");
        TextView textView2 = findViewById(R.id.textView_point);
        textView2.setText("Ваше количество очков = " + point);

        //Toast.makeText(this, Hour_int, Toast.LENGTH_SHORT).show();
        System.out.println("Final_count " + Final_count);
        System.out.println("distance " + distance);
        System.out.println("gender " + gender);
        System.out.println("style " + style);
        System.out.println("speed " + speed);
        System.out.println("point " + point);
    }
}

/*
        1)Посчитать формулы
        2)Привести все в порядок
 */