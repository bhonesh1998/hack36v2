package com.example.bhonesh.hack36;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by bhonesh on 26/1/19.
 */

public class SuggestPage extends AppCompatActivity {

    Button suggestSubmit;
    EditText classEdit, subjectEdit, topicEdit, urlEdit, nameEdit;

    private Firebase mref,t_ref;
    private StorageReference ms;
    private Uri filePath;
    private final int PICK_REQUEST=71;
    private static Firebase image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest_page);

        ms = FirebaseStorage.getInstance().getReference();

        suggestSubmit = (Button)findViewById(R.id.suggestSubmit);

        classEdit = (EditText)findViewById(R.id.classEdit);
        subjectEdit = (EditText)findViewById(R.id.subjectEdit);
        topicEdit = (EditText)findViewById(R.id.topicEdit);
        urlEdit = (EditText)findViewById(R.id.urlEdit);
        nameEdit = (EditText)findViewById(R.id.nameEdit);

        Firebase.setAndroidContext(this);
        mref=new Firebase("https://hack36-2a2b4.firebaseio.com/suggestTable");
        t_ref=new Firebase("https://hack36-2a2b4.firebaseio.com");

        suggestSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("submit clicked");

                String id = nameEdit.getText().toString();

                String classString = classEdit.getText().toString();
                String subjectString = subjectEdit.getText().toString();
                String topicString = topicEdit.getText().toString();
                String urlString = urlEdit.getText().toString();
                String nameString = nameEdit.getText().toString();

                final Firebase c_classes=mref.child(id).child("classes");
                final Firebase c_subject=mref.child(id).child("subject");
                final Firebase c_topic=mref.child(id).child("topic");
                final Firebase c_url=mref.child(id).child("url");
                final Firebase c_name=mref.child(id).child("name");

                c_classes.setValue(classString);
                c_subject.setValue(subjectString);
                c_topic.setValue(topicString);
                c_url.setValue(urlString);
                c_name.setValue(nameString);

                Intent i21 = new Intent("com.example.bhonesh.hack36.volunteer_dashboard");
                startActivity(i21);
            }
        });
    }
}
