package com.example.rguapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements PopupMenu.OnMenuItemClickListener {
    public int gender = 1;
    public int style = 2;
    public int distance = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    public void onRadioButtonClicked_gender(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.radioButton_male:
                if (checked)
                    gender = 1;
                break;

            case R.id.radioButton_female:
                if(checked)
                    gender = 2;
                break;
        }
    }
    public void onRadioButtonClicked_style(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.StyleFree:
                if (checked)
                    style = 1;
                break;

            case R.id.StyleClassic:
                if (checked)
                    style = 2;
                break;
        }
    }
    public void scoring(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("gender", gender);
        intent.putExtra("style", style);
        intent.putExtra("distance", distance);
        startActivity(intent);
        System.out.println(gender);
        System.out.println(style);
    }

    public void speedCalculation(View view){
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("gender", gender);
        intent.putExtra("style", style);
        intent.putExtra("distance", distance);
        startActivity(intent);
    }
}