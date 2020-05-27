package com.example.calculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {

    Button buttonZero,buttonOne,buttonTwo,buttonThree,buttonFour,buttonFive,buttonSix,buttonSeven,buttonEight,buttonNine;
    Button buttonSub,buttonAdd,buttonMultiply,buttonDivide,buttonEqual,buttonPoint,buttonPercent,buttonClear,buttonBracket;
    TextView textViewInput,textViewResult;
    String process;
    boolean checkBracket;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.btnPlus);
        buttonBracket = findViewById(R.id.btnBracket);
        buttonClear = findViewById(R.id.clear);
        buttonDivide = findViewById(R.id.btnDivide);
        buttonEqual = findViewById(R.id.btnEqual);
        buttonMultiply= findViewById(R.id.btnTimes);
        buttonSub = findViewById(R.id.btnMinus);
        buttonPercent = findViewById(R.id.btnPercent);
        buttonPoint = findViewById(R.id.btnDecimal);

        buttonZero=findViewById(R.id.btnZero);
        buttonOne = findViewById(R.id.btnOne);
        buttonTwo = findViewById(R.id.btnTwo);
        buttonThree = findViewById(R.id.btnThree);
        buttonFour = findViewById(R.id.btnFour);
        buttonFive = findViewById(R.id.btnFive);
        buttonSix = findViewById(R.id.btnSix);
        buttonSeven = findViewById(R.id.btnSeven);
        buttonEight = findViewById(R.id.btnEight);
        buttonNine = findViewById(R.id.btnNine);

        textViewInput = findViewById(R.id.text_viewInput);
        textViewResult = findViewById(R.id.text_ViewResult);

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewInput.setText("");
                textViewResult.setText("");
            }
        });

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewInput.getText().toString();
                textViewInput.setText(process+ "0");
            }

        });


        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewInput.getText().toString();
                textViewInput.setText(process+ "1");
            }

        });


        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewInput.getText().toString();
                textViewInput.setText( process+ "2");
            }

        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewInput.getText().toString();
                textViewInput.setText(process+ "3");
            }

        });
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewInput.getText().toString();
                textViewInput.setText(process+ "4");
            }

        });
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewInput.getText().toString();
                textViewInput.setText(process+ "5");
            }

        });
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewInput.getText().toString();
                textViewInput.setText(process+ "6");
            }

        });
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewInput.getText().toString();
                textViewInput.setText(process+ "7");
            }

        });
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewInput.getText().toString();
                textViewInput.setText(process+ "8");
            }

        });

        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewInput.getText().toString();
                textViewInput.setText(process+ "9");
            }

        });
        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewInput.getText().toString();
                textViewInput.setText(process+ "%");
            }

        });
        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewInput.getText().toString();
                textViewInput.setText(process+ ".");
            }

        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewInput.getText().toString();
                textViewInput.setText(process+ "+");

            }

        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewInput.getText().toString();
                textViewInput.setText(process+ "-");
            }

        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewInput.getText().toString();
                textViewInput.setText(process+ "*");
            }

        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = textViewInput.getText().toString();
                textViewInput.setText(process+ "/");
            }

        });

        buttonBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBracket){
                    process = textViewInput.getText().toString();
                    textViewInput.setText(process+ ")");
                    checkBracket = false;
                }else {
                    process = textViewInput.getText().toString();
                    textViewInput.setText(process+ "(");
                    checkBracket = true;
                }

            }

        });


        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                process = textViewInput.getText().toString();

                process = process.replaceAll("%","/100");

                Context rhino = Context.enter();

                rhino.setOptimizationLevel(-1);

                String finalResult = "";

                try{
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,process,"javascript",1,null).toString();


                }catch (Exception e){
                    finalResult = "0";
                }

       textViewResult.setText(finalResult);
            }
        });



    }
}