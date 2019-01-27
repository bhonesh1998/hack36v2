package com.example.bhonesh.hack36;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ConfirmationPage extends AppCompatActivity {

    TextView textadd,textdate,texttime,textstan,textsubject,textname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_page);

        textadd=(TextView)findViewById(R.id.textadd);
        textdate=(TextView)findViewById(R.id.textdate);
        texttime=(TextView)findViewById(R.id.texttime);
        textstan=(TextView)findViewById(R.id.textstan);
        textsubject=(TextView)findViewById(R.id.textsubject);
        textname=(TextView)findViewById(R.id.textname);

        textadd.setText(DataSaveClass.address);
        textdate.setText(DataSaveClass.date);
        texttime.setText(DataSaveClass.time);
        textstan.setText(DataSaveClass.standard);
        textsubject.setText(DataSaveClass.subject);
        textname.setText(DataSaveClass.name);

    }
}
