package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String op = "";
    Double a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void numberPress(View view){
        EditText textbox = findViewById(R.id.editTextNumberDecimal);
        textbox.getText().append(((Button) view).getText());
    }
    public void minuspress(View view){
        EditText textbox = findViewById(R.id.editTextNumberDecimal);
        if(!textbox.getText().toString().matches("")){
            Double number = Double.parseDouble(textbox.getText().toString());
            number *= -1;
            textbox.getText().clear();
            textbox.append(number.toString());
        }
    }
    public void DOT (View view){
        EditText textbox = findViewById(R.id.editTextNumberDecimal);
          if(!textbox.getText().toString().contains("."))
              textbox.append(".");
    }
    public  void DEL (View view){
        EditText textbox = findViewById(R.id.editTextNumberDecimal);
        if(!textbox.getText().toString().matches("")){
            String text = textbox.getText().toString();
            textbox.getText().clear();
            textbox.getText().append(text.substring(0,text.length()-1));
        }
    }
    public void operation(View view){
        EditText textbox = findViewById(R.id.editTextNumberDecimal);
        if(!textbox.getText().toString().matches("")) {
             a =  Double.parseDouble(textbox.getText().toString());
            op = ((Button) view).getText().toString();
            textbox.getText().clear();
        }
    }
    public void factorial(View view){
        EditText textbox = findViewById(R.id.editTextNumberDecimal);
        if(!textbox.getText().toString().matches("") || Double.parseDouble(textbox.getText().toString())>0.0) {
            int resault = 1;
            for (int i=1; i<=Double.parseDouble(textbox.getText().toString()); i++)  resault *= i;
            textbox.getText().clear();
            textbox.getText().append(Integer.toString(resault));
        }
    }
    public void equal(View view){
        Double resault;
        EditText textbox = findViewById(R.id.editTextNumberDecimal);
        if(!textbox.getText().toString().matches("") || op.equals("") || !a.equals(0.0)){
            switch (op){
                case "+":
                    resault = a + Double.parseDouble(textbox.getText().toString());
                    textbox.getText().clear();
                    textbox.append(resault.toString());
                    break;
                case "-":
                    resault = a - Double.parseDouble(textbox.getText().toString());
                    textbox.getText().clear();
                    textbox.append(resault.toString());
                    break;
                case "*":
                    resault = a * Double.parseDouble(textbox.getText().toString());
                    textbox.getText().clear();
                    textbox.append(resault.toString());
                    break;
                case "/":
                    if(textbox.getText().toString().equals("0")){
                        Toast toast = Toast.makeText(getApplicationContext(), "Don't devide by 0!", Toast.LENGTH_LONG);
                        toast.show();
                    }
                    else{
                        resault = a / Double.parseDouble(textbox.getText().toString());
                        textbox.getText().clear();
                        textbox.append(resault.toString());
                    }
                    break;
                case "bⁿ":
                    resault = Math.pow(a, Double.parseDouble(textbox.getText().toString()));
                    textbox.getText().clear();
                    textbox.append(resault.toString());
                    break;

            }
        }
    }
}