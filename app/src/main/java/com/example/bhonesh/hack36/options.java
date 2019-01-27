package com.example.bhonesh.hack36;

//package com.example.bhonesh.e_class;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class options extends AppCompatActivity {

    Button stu,tea;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        stu=(Button)findViewById(R.id.stu);
        tea=(Button)findViewById(R.id.tea);


        stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i1=new Intent("com.example.bhonesh.hack36.volunteer_register");
                startActivity(i1);


            }
        });


        tea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i1=new Intent("com.example.bhonesh.hack36.ngo_register");
                startActivity(i1);


            }
        });


    }
}

