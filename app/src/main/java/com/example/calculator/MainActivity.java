package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int resault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void numberPress(View view){
        ((EditText)findViewById(R.id.editTextNumberDecimal)).getText().append(((Button) view).getText());
    }
    public  void DEL (View view){
        EditText text = findViewById(R.id.editTextNumberDecimal);
        if (text.getText().toString() != ""){
            text = 
            text.append(x);
        }

    }
}