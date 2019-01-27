package com.example.bhonesh.hack36;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ngo_dashboard extends AppCompatActivity {

    TextView disname;
    Button createevent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo_dashboard);

        disname=(TextView)findViewById(R.id.disname);
        createevent=(Button)findViewById(R.id.button2);

        Intent iin= getIntent();

        String name = iin.getExtras().get("name_value").toString();


        // String image=iin.getExtras().get("image_value").toString();

        disname.setText(name);

        createevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i21 = new Intent("com.example.bhonesh.hack36.CreateClass");
                startActivity(i21);
                Log.e("clicked", "clicked");

            }
        });

    }
}