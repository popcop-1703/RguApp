package com.example.rguapp;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class ThirdActivity extends Activity {

    public int point,gender,style,distance;
    public double speed, time = 0;
    public double a,b,c,d = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }
    public void buttonRecommendSpeed(View view){
        DecimalFormat myFormat = new DecimalFormat("#.##");
        TextView textView_speed = findViewById(R.id.recommendSpeed);
        TextView textView_time = findViewById(R.id.recommendTime);
        Bundle arguments = getIntent().getExtras();
        gender = arguments.getInt("gender");
        style = arguments.getInt("style");
        distance = arguments.getInt("distance");
        EditText editText1 = findViewById(R.id.editTextRecommendSpeed);
        String point_string = editText1.getText().toString();
        if (point_string.equals("")) {
            point = 0;
        } else {
            point = Integer.parseInt(point_string);
        }
        //1 км
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
            d = 3.71202381 ;
        } else if (distance == 1000 && gender == 2 && style == 2) {
            a = -2.767860199 * Math.pow(10,-10);
            b = 3.483833439 * Math.pow(10,-7);
            c = 0.0022779484;
            d = 3.6804441 ;
        } //2 км
        else if (distance == 2000 && gender == 1 && style == 1){
            a = -3.879734848 * Math.pow(10,-10);
            b = 5.567613636 * Math.pow(10,-7);
            c = 0.0028709545;
            d = 4.1155;
        } else if (distance == 2000 && gender == 1 && style == 2) {
            a = -3.452335859 * Math.pow(10,-10);
            b = 4.504626623 * Math.pow(10,-7);
            c = 0.002626759019;
            d = 4.0375976;
        } else if (distance == 2000 && gender == 2 && style == 1) {
            a = -3.10290404 * Math.pow(10,-10);
            b = 4.340205628 * Math.pow(10,-7);
            c = 0.0025429538;
            d = 3.66107619 ;
        } else if (distance == 2000 && gender == 2 && style == 2) {
            a = -2.791877104 * Math.pow(10,-10);
            b = 3.588915945 * Math.pow(10,-7);
            c = 0.002265981542;
            d = 3.616415873 ;
        }//3 км
        else if (distance == 3000 && gender == 1 && style == 1){
            a = -3.867529461 * Math.pow(10,-10);
            b = 5.512599206 * Math.pow(10,-7);
            c = 0.0028771030;
            d = 4.06270094;
        } else if (distance == 3000 && gender == 1 && style == 2) {
            a = -3.45223064 * Math.pow(10,-10);
            b = 4.502444084 * Math.pow(10,-7);
            c = 0.0026274173;
            d = 4.026130159;
        } else if (distance == 3000 && gender == 2 && style == 1) {
            a = -3.101536195 * Math.pow(10,-10);
            b = 4.324062049 * Math.pow(10,-7);
            c = 0.0025448159;
            d = 3.612701587 ;
        } else if (distance == 3000 && gender == 2 && style == 2) {
            a = -2.754945286 * Math.pow(10, -10);
            b = 3.464619408 * Math.pow(10, -7);
            c = 0.0022771097;
            d = 3.552539683;
        }// 5 км
        else if (distance == 5000 && gender == 1 && style == 1){
            a = -3.857954545 * Math.pow(10,-10);
            b = 5.492234848 * Math.pow(10,-7);
            c = 0.002878109848;
            d = 3.972316667;
        } else if (distance == 5000 && gender == 1 && style == 2) {
            a = -3.428240741 * Math.pow(10,-10);
            b = 4.5428309885 * Math.pow(10,-7);
            c = 0.002632981542;
            d = 3.927349206;
        } else if (distance == 5000 && gender == 2 && style == 1) {
            a = -3.543034512 * Math.pow(10,-10);
            b = 5.582160895 * Math.pow(10,-7);
            c = 0.0024516010;
            d = 3.544426984 ;
        } else if (distance == 5000 && gender == 2 && style == 2) {
            a = -2.763888889 * Math.pow(10, -10);
            b = 3.499972944 * Math.pow(10, -7);
            c = 0.0022732693;
            d = 3.444945238;
        } //7.5 км
        else if (distance == 7500 && gender == 1 && style == 1){
            a = -3.83733165 * Math.pow(10,-10);
            b = 5.432720058 * Math.pow(10,-7);
            c = 0.002882444204;
            d = 3.876275397;
        } else if (distance == 7500 && gender == 1 && style == 2) {
            a = -3.420664983 * Math.pow(10,-10);
            b = 4.405068543 * Math.pow(10,-7);
            c = 0.0026347245;
            d = 3.81270873;
        } else if (distance == 7500 && gender == 2 && style == 1) {
            a = -3.101430976 * Math.pow(10,-10);
            b = 4.324693362 * Math.pow(10,-7);
            c = 0.002544411496;
            d = 3.437629365 ;
        } else if (distance == 7500 && gender == 2 && style == 2) {
            a = -2.759259259 * Math.pow(10, -10);
            b = 3.486138167 * Math.pow(10, -7);
            c = 0.0022743788;
            d = 3.329843651;
        } // 10 км
        else if (distance == 10000 && gender == 1 && style == 1){
            a = -3.835963805 * Math.pow(10,-10);
            b = 5.430510462 * Math.pow(10,-7);
            c = 0.0028823112;
            d = 3.795586508;
        } else if (distance == 10000 && gender == 1 && style == 2) {
            a = -3.424031987 * Math.pow(10,-10);
            b = 4.418524531 * Math.pow(10,-7);
            c = 0.002633435666;
            d = 3.71653651;
        } else if (distance == 10000 && gender == 2 && style == 1) {
            a = -3.11668771 * Math.pow(10,-10);
            b = 4.367649711 * Math.pow(10,-7);
            c = 0.002541034031;
            d = 3.361956349 ;
        } else if (distance == 10000 && gender == 2 && style == 2) {
            a = -2.759364478 * Math.pow(10, -10);
            b = 3.485615079 * Math.pow(10, -7);
            c = 0.002274428331;
            d = 3.233268254;
        }//15 км
        else if (distance == 15000 && gender == 1 && style == 1){
            a = -3.834069865 * Math.pow(10,-10);
            b = 5.430266955 * Math.pow(10,-7);
            c = 0.002881810666;
            d = 3.666643651;
        } else if (distance == 15000 && gender == 1 && style == 2) {
            a = -3.430029461 * Math.pow(10,-10);
            b = 4.433757215 * Math.pow(10,-7);
            c = 0.002632288119;
            d = 3.563074603;
        } else if (distance == 15000 && gender == 2 && style == 1) {
            a = -3.111742424 * Math.pow(10,-10);
            b = 4.4354220779 * Math.pow(10,-7);
            c = 0.002542019481;
            d = 3.423982619 ;
        } else if (distance == 15000 && gender == 2 && style == 2) {
            a = -2.767150673 * Math.pow(10, -10);
            b = 3.507323232 * Math.pow(10, -7);
            c = 0.002272715067;
            d = 3.080122222;
        }//20 км
        else if (distance == 20000 && gender == 1 && style == 1){
            a = -3.834806397 * Math.pow(10,-10);
            b = 5.430122655 * Math.pow(10,-7);
            c = 0.00288212025;
            d = 3.567584921;
        } else if (distance == 20000 && gender == 1 && style == 2) {
            a = -3.426346801 * Math.pow(10,-10);
            b = 4.423439755 * Math.pow(10,-7);
            c = 0.002633114658;
            d = 3.44575873;
        } else if (distance == 20000 && gender == 2 && style == 1) {
            a = -3.115214646 * Math.pow(10,-10);
            b = 4.36482684 * Math.pow(10,-7);
            c = 0.0025411621;
            d = 3.14677619 ;
        } else if (distance == 20000 && gender == 2 && style == 2) {
            a = -2.764941077 * Math.pow(10, -10);
            b = 3.501208514 * Math.pow(10, -7);
            c = 0.002273179173;
            d = 2.963479365;
        }//30 км
        else if (distance == 30000 && gender == 1 && style == 1){
            a = -3.837647306 * Math.pow(10,-10);
            b = 5.435560967 * Math.pow(10,-7);
            c = 0.002881918951;
            d = 3.426342063;
        } else if (distance == 30000 && gender == 1 && style == 2) {
            a = -3.423295455 * Math.pow(10,-10);
            b = 4.414772727 * Math.pow(10,-7);
            c = 0.0026337386;
            d = 3.27905;
        } else if (distance == 30000 && gender == 2 && style == 1) {
            a = -3.118160774 * Math.pow(10,-10);
            b = 4.37252886 * Math.pow(10,-7);
            c = 0.002540577982;
            d = 3.013815079 ;
        } else if (distance == 30000 && gender == 2 && style == 2) {
            a = -2.739162458 * Math.pow(10, -10);
            b = 3.417243867 * Math.pow(10, -7);
            c = 0.002280146765;
            d = 2.796818254;
        }//50 км
        else if (distance == 50000 && gender == 1 && style == 1){
            a = -3.838594276 * Math.pow(10,-10);
            b = 5.438753608 * Math.pow(10,-7);
            c = 0.002881617544;
            d = 3.260687302;
        } else if (distance == 50000 && gender == 1 && style == 2) {
            a = -3.425505051 * Math.pow(10,-10);
            b = 4.420887446 * Math.pow(10,-7);
            c = 0.002633274531;
            d = 3.084792857;
        } else if (distance == 50000 && gender == 2 && style == 1) {
            a = -3.116898148 * Math.pow(10,-10);
            b = 4.36976912 * Math.pow(10,-7);
            c = 0.0025407082;
            d = 2.857896032 ;
        } else if (distance == 50000 && gender == 2 && style == 2) {
            a = -2.765677609 * Math.pow(10, -10);
            b = 3.503607504 * Math.pow(10, -7);
            c = 0.002272980099;
            d = 2.606218254;
        } // 70 км
        else if (distance == 70000 && gender == 1 && style == 1){
            a = -3.831123737 * Math.pow(10,-10);
            b = 5.41880952 * Math.pow(10,-7);
            c = 0.002883598304;
            d = 3.166219048;
        } else if (distance == 70000 && gender == 1 && style == 2) {
            a = -3.42645202 * Math.pow(10,-10);
            b = 4.424188312 * Math.pow(10,-7);
            c = 0.002632951479;
            d = 2.975057143;
        } else if (distance == 70000 && gender == 2 && style == 1) {
            a = -3.114832114 * Math.pow(10,-10);
            b = 4.35728123 * Math.pow(10,-7);
            c = 0.0025408408;
            d = 2.70420184 ;
        } else if (distance == 70000 && gender == 2 && style == 2) {
            a = -2.757154801 * Math.pow(10, -10);
            b = 3.419801873 * Math.pow(10, -7);
            c = 0.002265503937;
            d = 2.4524292077;
        }

        speed = a * Math.pow(point,3) + b * Math.pow(point,2) + c * point + d;
        time = distance / speed;
        textView_speed.setText("Рекомендованная скорость = " + myFormat.format(speed) + "М/C");
        textView_time.setText("Рекомедованное время = " + time);
    }
    //Сделать расчет скорости
    //довести до ума обратную задачу
}