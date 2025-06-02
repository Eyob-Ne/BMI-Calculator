package com.example.eyb;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

TextView textone,texttwo,textthree;
Button btn;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textone=findViewById(R.id.t1);
        texttwo=findViewById(R.id.t2);
        textthree=findViewById(R.id.r1);
        btn=findViewById(R.id.b1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first=textone.getText().toString();
                String second=String.valueOf(texttwo.getText());
               if(!first.isEmpty() && !second.isEmpty()){
                    float weight=Float.parseFloat(first);
                   float height=Float.parseFloat(second);
                   if(height>0){
                  float calc= weight/(height * height);
                       String description = BmiDescription(calc);
                  textthree.setText(String.valueOf(calc+" "+description));
                       textthree.setTextColor(Color.BLUE);
                   }
                   else {
                      textthree.setText("Height must be > 0");
                      textthree.setTextColor(Color.RED);
                   }
               }
               else {
                   textthree.setText("Please enter weight and height");
                   textthree.setTextColor(Color.RED);
               }
            }
        });

    }

public String BmiDescription(float calc){
    if(calc<16) return  "Sever thinness";
    else if (calc <17) return  "Moderate thinness";
    else if (calc<18.5)  return "Mild Thiness";
    else return "Obesty";
}
}