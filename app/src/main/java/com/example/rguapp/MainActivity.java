package com.example.rguapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupMenu;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    public int gender = 0;
    public int style = 0;
    public int distance = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //анимация для "Добро пожаловать"
        /*TextView textView = findViewById(R.id.HiText);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.hi_text_animation);
        textView.startAnimation(animation);*/
    }

    public void showMenu(View view){
        PopupMenu menu = new PopupMenu(this, view);
        menu.setOnMenuItemClickListener(this);
        MenuInflater inf = menu.getMenuInflater();
        inf.inflate(R.menu.main, menu.getMenu());
        menu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case (R.id.opt1):
                distance = 1000;
                break;
            case (R.id.opt2):
                distance = 2000;
                break;
            case (R.id.opt3):
                distance = 3000;
                break;
            case (R.id.opt4):
                distance = 5000;
                break;
            case (R.id.opt5):
                distance = 7500;
                break;
            case (R.id.opt6):
                distance = 10000;
                break;
            case (R.id.opt7):
                distance = 15000;
                break;
            case (R.id.opt8):
                distance = 20000;
                break;
            case (R.id.opt9):
                distance = 30000;
                break;
            case (R.id.opt10):
                distance = 50000;
                break;
            case (R.id.opt11):
                distance = 70000;
                break;
        }
        TextView btn1 = findViewById(R.id.btn1);
        btn1.setText(menuItem.getTitle());
        Toast.makeText(this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }

    public void SaveAll(View view){

        //присвоение данных для RadioGroup_gender
        RadioGroup radioGroup_gender = findViewById(R.id.radioGroup_gender);
        radioGroup_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton_female:
                        gender = 2;
                        break;
                    case R.id.radioButton_male:
                        gender = 1;
                        break;
                }
            }
        });

        //присвоение данных для RadioGroup_style
        RadioGroup radioGroup_style = findViewById(R.id.radioGroup_style);
        radioGroup_style.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId){
                    case R.id.StyleClassic:
                        style = 1;
                        break;
                    case R.id.StyleFree:
                        style = 2;
                        break;
                }
            }
        });
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("gender", gender);
        intent.putExtra("style", style);
        intent.putExtra("distance", distance);
        startActivity(intent);
    }
}