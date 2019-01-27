package com.example.bhonesh.hack36;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class CreateClass extends AppCompatActivity {
    private Firebase mref,t_ref;
    ///EditText editname,editemail,editpass,editcpass,editsubject,editid,editdepart,editq;
    //EditText editname,editadd,editemail,editpass,editcpass,edittype,editq,editcontact;
    TextView editpro;
    Button mybutton;

    EditText editadd,editdate,edittime,editsub,editstan;

   // EditText editname,editemail,editpass,editcpass,edittype,editadd,editcontact;
    // Intent i;
    private static final  int GALLERY_INTENT=2;

    private StorageReference ms;
    private Button saveb;
    private Uri filePath;
    private final int PICK_REQUEST=71;
    private static  Firebase image;

    private String sadd,sdate,stime,ssub,sstan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_class);

        ms = FirebaseStorage.getInstance().getReference();

        editadd=(EditText)findViewById(R.id.editadd);
        editdate=(EditText)findViewById(R.id.editdate);
        edittime=(EditText)findViewById(R.id.edittime);
        editsub=(EditText)findViewById(R.id.editsub);
        editstan=(EditText)findViewById(R.id.editstan);
        mybutton=(Button)findViewById(R.id.choosebutton);
        Firebase.setAndroidContext(this);
        mref=new Firebase("https://hack36-2a2b4.firebaseio.com/classes");
        t_ref=new Firebase("https://hack36-2a2b4.firebaseio.com");

        //end of making child
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Firebase c_add=mref.child("address");
                final Firebase c_date=mref.child("date");
                final Firebase c_time=mref.child("time");
                final Firebase c_sub=mref.child("subject");
                final Firebase c_stan=mref.child("standard");

                sadd=editadd.getText().toString();
                sdate=editdate.getText().toString();
                stime=edittime.getText().toString();
                ssub=editsub.getText().toString();
                sstan=editstan.getText().toString();

                DataSaveClass.address = sadd;
                DataSaveClass.date = sdate;
                DataSaveClass.time = stime;
                DataSaveClass.subject = ssub;
                DataSaveClass.standard = sstan;

                c_add.setValue(sadd);
                c_date.setValue(sdate);
                c_time.setValue(stime);
                c_sub.setValue(ssub);
                c_stan.setValue(sadd);

                //final Firebase c_t = t_ref.child(spro).child(sdepart).child(sq).child(ssubject).child("NGO");

                //c_t.child(id).setValue("true");


                Intent i21 = new Intent("com.example.bhonesh.hack36.VolunteerSelection");
                startActivity(i21);
                //Log.e("clicked", "clicked")


            }
        });
    }



}