package com.example.bhonesh.hack36;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;
//package com.example.bhonesh.e_class;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    String seditpass,myid;
    EditText ipass,iid;
    Button create,signin;
    ProgressDialog pd;
    DatabaseReference ref1,ref2;
    boolean a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        signin=(Button)findViewById(R.id.signin);
        ipass=(EditText)findViewById(R.id.editpass);
        iid=(EditText)findViewById(R.id.editid);

        Firebase.setAndroidContext(this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=true;
                myid= iid.getText().toString(); // username`
                seditpass = ipass.getText().toString(); // password
                if(myid.equals("")){
                    iid.setHint("can't be empty");
                    iid.setBackgroundColor(Color.parseColor("#FFEF767C")); a=false;
                    // Toast.makeText(MainActivity.this,"You can't leave it empty",Toast.LENGTH_SHORT).show();
                }
                if(seditpass.equals("")){
                    ipass.setHint("can't be empty");
                    ipass.setBackgroundColor(Color.parseColor("#FFEF767C")); a=false;
                }
                if(a == true)
                {
                    System.out.println(myid + " <--> " + seditpass);

                    pd = new ProgressDialog(MainActivity.this);

                    // pd.setTitle("dashboard");
                    pd.setMessage("logging in");
                    pd.show();

                    ref1 = FirebaseDatabase.getInstance().getReference("users");
                    // ref1.keepSynced(true);
                    ref1.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(myid=="admin"){
                                ref2 = ref1.child(myid);
                                ref2.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        Map<String, String> m = (Map<String, String>) dataSnapshot.getValue();
                                        String oemail = m.get("email");

                                        String oimage = m.get("image");

                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {

                                    }
                                });
                            }

                            if (!dataSnapshot.hasChild(myid)) {
                                Toast.makeText(MainActivity.this, "No such user", Toast.LENGTH_SHORT).show();
                                pd.dismiss();
                            } else {

                                ref2 = ref1.child(myid);
                                // ref2.keepSynced(true);

                                ref2.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {

                                        Log.e("error", "data " + dataSnapshot.getValue());

                                        Map<String, String> m = (Map<String, String>) dataSnapshot.getValue();
                                        // dataSnapshot.getValue(Map.class);


                                        //String semail = m.get("email");
                                        String spass = m.get("password");

                                        String oname = m.get("name");

                                        String oemail = m.get("email");

                                        String oadd = m.get("add");

                                        String oage = m.get("age");

                                        String oedu = m.get("edu");

                                        String oocc = m.get("occ");

                                        String ocontact = m.get("contact");

                                        String otype = m.get("type");



//                                        String oimage = m.get("image");
//
//                                        String osubject = m.get("subject");
//
//                                        String oq = m.get("q");

                                        String profession = m.get("pro");

                                        //  String seditemail = iemail.getText().toString();

                                        System.out.println("===> " + spass);


                                        if (seditpass.equals(spass) && profession.equalsIgnoreCase("Volunteer"))
                                        {
                                            pd.dismiss();
                                            Intent i1 = new Intent("com.example.bhonesh.hack36.volunteer_dashboard");
                                            i1.putExtra("name_value", oname);
                                            i1.putExtra("email_value", oemail);
                                            i1.putExtra("add_value", oadd);
                                            i1.putExtra("age_value", oage);
                                            i1.putExtra("edu_value", oedu);
                                            i1.putExtra("occ_value", oocc);
                                            ipass.setText("");
                                            iid.setText("");
                                            startActivity(i1);
                                        }

                                        else if (seditpass.equals(spass) && profession.equalsIgnoreCase("NGO"))
                                        {
                                            pd.dismiss();
                                            Intent i2 = new Intent("com.example.bhonesh.hack36.ngo_dashboard");
                                            i2.putExtra("name_value", oname);
//                                            i2.putExtra("email_value", oemail);
//                                            i2.putExtra("add_value", oadd);
//                                            i2.putExtra("contact_value", ocontact);
//                                            i2.putExtra("type_value", otype);


                                            ipass.setText("");
                                            iid.setText("");

                                            startActivity(i2);

                                        } else {
                                            pd.dismiss();

                                            Toast.makeText(MainActivity.this, "Incorrect Combination", Toast.LENGTH_SHORT).show();
                                            ipass.setText("");
                                            iid.setText("");
                                            //Toast.makeText(this,"error",Toast.LENGTH_LONG).show();

                                        }
                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {

                                    }
                                });

                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


                }







            }
        });




        create=(Button)findViewById(R.id.create);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i1=new Intent("com.example.bhonesh.hack36.options");
                startActivity(i1);
            }
        });


    }





}