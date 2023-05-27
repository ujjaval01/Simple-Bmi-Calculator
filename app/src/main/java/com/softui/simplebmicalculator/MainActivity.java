package com.softui.simplebmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightFt, edtHeightIn;
        Button cclBtn;
        TextView resultTv1,resultTv;
        LinearLayout llMain;



        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn =  findViewById(R.id.edtHeightIn);
        cclBtn = findViewById(R.id.cclBtn);
        resultTv = findViewById(R.id.resultTv);
      //  resultTv1 = findViewById(R.id.resultTv1);
        llMain = findViewById(R.id.llMain);

        cclBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              int wht =   Integer.parseInt(edtWeight.getText().toString());
              int ft = Integer.parseInt(edtHeightFt.getText().toString());
              int in =  Integer.parseInt(edtHeightIn.getText().toString());

              int totalIn = ft*12 + in;
              double totalCm = totalIn * 2.53;
              double totalM = totalCm/100;
              double bmi = wht/(totalM*totalM);

              if (bmi<25){
                  resultTv.setText("You Are OverWeight");
                  //resultTv1.setText((int) bmi);
                  llMain.setBackgroundColor(getResources().getColor(R.color.red));

              } else if (bmi<18) {
                  resultTv.setText("You Are underWeight");
                  llMain.setBackgroundColor(getResources().getColor(R.color.yello));
              }
              else {
                  resultTv.setText("You Are Healthy");
                  llMain.setBackgroundColor(getResources().getColor(R.color.green));
              }

            }
        });




    }
}