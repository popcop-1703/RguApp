package com.example.rguapp;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Scanner;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SecondActivity extends Activity {

    public double speed, point, Final_count = 0;
    public int Hour_int,Minute_int,Second_int, Millisecond_int = 0;
    public int gender, style, distance, point_int = 0;
    public static double a,b,c,d,x1,x2,x3,repeat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
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

        //if(distance == 1000 && gender == 1 && style == 1)

        TextView textView1 = findViewById(R.id.textView_speed);
        textView1.setText("Ваша скорость = " + speed + " М/C");
        TextView textView2 = findViewById(R.id.textView_point);
        textView2.setText("Ваше количество очков = " + point);

        //Toast.makeText(this, Hour_int, Toast.LENGTH_SHORT).show();
        System.out.println(Final_count);
        System.out.println(distance);
        System.out.println(gender);
        System.out.println(style);
        System.out.println(speed);
        System.out.println(point);
    }
    //Calculates the repeated bit of the equation and returns it
    public static double calcRepeat() {
        repeat = (((b * c)
                / (6 * Math.pow(a, 2)))
                - ((Math.pow(b, 3))
                / (27 * Math.pow(a, 3)))
                - (d
                / (2 * a)));
        return repeat;
    }
    //Calculates the first root
    public static double calcX1() {
        if (repeat != 0) {
            //Returns the result of the equation x1
            x1 = Math.cbrt(
                    (repeat + Math.sqrt(
                            Math.pow(repeat, 2)
                                    + Math.pow((c / (3 * a) - (Math.pow(b, 2) / (9 * Math.pow(a, 2)))), 3))))
                    + Math.cbrt(repeat - Math.sqrt(
                    Math.pow(repeat, 2)
                            + Math.pow((c / (3 * a) - (Math.pow(b, 2) / (9 * Math.pow(a, 2)))), 3)))
                    - (b / (3 * a));
        } else {
            //The cube roots cancel out because its zero so only need to return the last fraction
            x1 = -(b / (3 * a));
        }
        return x1;
    }
    //Calculates the second root
    public static String calcX2() {
        //Checks if the discriminant  is negative
        if ((Math.pow(b + (a * x1), 2)) + ((4 * a * d) / x1) < 0) {
            //It has complex roots so it calculates and returns them
            return String.valueOf(
                    (-(b + (a * x1))) / (2 * a)//The real part
                            + " + "
                            + String.valueOf(
                            Math.sqrt(
                                    (Math.pow(b + (a * x1), 2)) + ((4 * a * d) / x1) * -1)//The imaginary value
                                    / (2 * a))
                            + "i"//The imaginary label
            );
        } else {
            //Calculates the actual root and returns it
            x2 = (-(b + (a * x1)))//The numerator without the discriminant
                    + Math.sqrt((Math.pow(b + (a * x1), 2)) + ((4 * a * d) / x1))//The discriminant
                    / (2 * a);//The denominator
        }
        return String.valueOf(x2);//Returns the result
    }
    //Calculates the third root
    public static String calcX3() {
        //Checks if the discriminant  is negative
        if ((Math.pow(b + (a * x1), 2)) + ((4 * a * d) / x1) < 0) {
            //It has complex roots so it calculates and returns them
            return String.valueOf(
                    (-(b + (a * x1))) / (2 * a)//The real part
                            + " + "
                            + String.valueOf(
                            Math.sqrt((Math.pow(b + (a * x1), 2)) + ((4 * a * d) / x1) * -1)//The imaginary part
                                    / (2 * a))
                            + "i"//The imaginary label
            );
        } else {
            //Calculates the actual root and returns it
            x3 = (-(b + (a * x1)))//The numerator without the discriminant
                    - Math.sqrt((Math.pow(b + (a * x1), 2)) + ((4 * a * d) / x1))//The discriminant
                    / (2 * a);//The denominator
            return String.valueOf(x3);//Returns the result
        }
    }
    /*The "run" of the program
        In order:
        Get the equation from the user
        Calculate the repeated bit
        Calculates first root and outputs it
        Calculates second root and outputs it
        Calculate third root and outputs it
    */
    public static void main(String[] args) {
        getInputs();
        calcRepeat();
        System.out.println("X1= "+calcX1());
        System.out.println("X2= "+calcX2());
        System.out.println("X3= "+calcX3());
    }
}

/*
        1)Посчитать формулы
        2)Привести все в порядок
 */