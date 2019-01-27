package com.example.bhonesh.hack36;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class VolunteerSelection extends AppCompatActivity {
    ListView usersList;
   // ArrayList<String> al = new ArrayList<>();
    DatabaseReference ref1,ref2;
    String myid="admin";

    private ArrayList<NameClass> nameClassArrayList = new ArrayList<NameClass>();
    private NameAdapter nameAdapter;
    private ArrayList<String> ar=new ArrayList<>();
    private ArrayList<String> al=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_selection);
        usersList = (ListView)findViewById(R.id.usersList);

        final VolunteerSelection volunteerSelection = this;
        nameAdapter = new NameAdapter(volunteerSelection, nameClassArrayList);
        usersList.setAdapter(nameAdapter);

        Firebase.setAndroidContext(this);
        ref1 = FirebaseDatabase.getInstance().getReference("users");
        ref1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                Map< String,Map<String ,String> > m = (Map< String,Map<String ,String> >) dataSnapshot.getValue();
//                System.out.println(" mein yha hu ");
//                System.out.println(m+" ");

              //  System.out.println("size of the array : " + m.entrySet().size());
//                for(int i = 0; i < m.entrySet().size(); i++)
                for( Map.Entry<String,Map<String,String> > x : m.entrySet() )
                {
                   // System.out.println("checking");
                    Map<String,String> user1=x.getValue();
                  //  System.out.println(user1.get("pro"));
                    if(user1.get("pro").equals("Volunteer"))
                    {System.out.println("adding "+user1.get("name"));
                        String pp=user1.get("name");
                        nameClassArrayList.add(new NameClass(pp));
                        //ar.add(pp);
                    }
                    else
                    {
                        Log.e("hi","hi else m hu ");
                    }

                  //  System.out.println("new line");
                }
                nameAdapter.notifyDataSetChanged();

//                System.out.print("hi m yha aa rha hu");
//                System.out.print(ar);
                usersList.setOnItemClickListener(new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {
                        //String xp = al.get(position);

                        NameClass c = nameClassArrayList.get(position);
                        DataSaveClass.name = c.getName();

                        Intent i21 = new Intent("com.example.bhonesh.hack36.ConfirmationPage");
                        startActivity(i21);
                        //Log.e("clicked", "clicked")
//                        DataSaveClass.printClass();

                        //Log.e(xp,"hi");
                        //startActivity(new Intent(users.this,chat.class));


                    }
                });
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.print("got the error");
            }
        });



//        for(String namex : ar) {
//            nameClassArrayList.add(new NameClass(namex));
//            Log.e(namex, " -> pushed in the list");
//        }



//        ref1.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot)
//            {
//                //if(myid=="admin")
//                //{
//
//                    ref2 = ref1.child(myid);
//                    ref2.addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//                            Map<String, String> m = (Map<String, String>) dataSnapshot.getValue();
////                            String oemail = m.get("email");
////                            String oimage = m.get("image");
//                        }
//                        @Override
//                        public void onCancelled(DatabaseError databaseError) {
//                        }
//                    });
//                //}
//                if (!dataSnapshot.hasChild(myid)) {
//                    //Toast.makeText(MainActivity.this, "No such user", Toast.LENGTH_SHORT).show();
//                    //pd.dismiss();
//                }
//                else
//                    {
//
//                    ref2 = ref1.child(myid);
//                    // ref2.keepSynced(true);
//
//                    ref2.addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//
//                            Log.e("error", "data " + dataSnapshot.getValue());
//
//                            Map<String, String> m = (Map<String, String>) dataSnapshot.getValue();
//                            // dataSnapshot.getValue(Map.class);
//
//
////                            //String semail = m.get("email");
////                            String spass = m.get("password");
////
////                            String oname = m.get("name");
////
////                            String oemail = m.get("email");
////
////                            String oadd = m.get("add");
////
////                            String oage = m.get("age");
////
////                            String oedu = m.get("edu");
////
////                            String oocc = m.get("occ");
////
////                            String ocontact = m.get("contact");
////
////                            String otype = m.get("type");
//                            int c=0;
//                            for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                                c++;
//                            }
//                            while(c-->0) {
//
//                                String profession = m.get("pro");
//                                String name = m.get("name");
//                                if (profession.equals("Volunteer")) {
//                                    ar.add(name);
//                                }
//                            }
//
//                           // Log.e(profession,"hi");
//
//
//
//                            //ArrayAdapter<String> nameap=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ar);
//
//
//
//
//                        }
//
//                        @Override
//                        public void onCancelled(DatabaseError databaseError) {
//
//                        }
//                    });
//
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
    }

}
