package com.example.bhonesh.hack36;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class volunteer_dashboard extends AppCompatActivity {

    Button start_quiz,mark_a,download,chatroom;
    Button suggestButton;
    TextView disname,disadd,disage,disedu,disocc,disemail;

    ImageView vi;
    String id,year,department,batch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_dashboard);

        disname=(TextView)findViewById(R.id.disname);
        disemail=(TextView)findViewById(R.id.disemail);

        disadd=(TextView)findViewById(R.id.disadd);

        disage=(TextView)findViewById(R.id.disage);

        disedu=(TextView)findViewById(R.id.disedu);

        disocc=(TextView)findViewById(R.id.disocc);

        suggestButton = (Button)findViewById(R.id.suggestButton);

        //disname=(TextView)findViewById(R.id.disname);




        //vi=(ImageView)findViewById(R.id.image);



        Intent iin= getIntent();

        String pname = iin.getExtras().get("name_value").toString();
        String pemail= iin.getExtras().get("email_value").toString();
        String padd = iin.getExtras().get("add_value").toString();
        String page = iin.getExtras().get("age_value").toString();
        String pedu = iin.getExtras().get("edu_value").toString();
        String pocc = iin.getExtras().get("occ_value").toString();

        // String image=iin.getExtras().get("image_value").toString();


        disname.setText(pname);
        disemail.setText(pemail);
        disadd.setText(padd);
        disage.setText(page);
        disedu.setText(pedu);
        disocc.setText(pocc);


        suggestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i21 = new Intent("com.example.bhonesh.hack36.SuggestPage");
                startActivity(i21);
            }
        });
    }
}