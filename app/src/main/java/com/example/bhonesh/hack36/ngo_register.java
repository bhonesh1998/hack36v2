package com.example.bhonesh.hack36;

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

public class ngo_register extends AppCompatActivity {
    private Firebase mref,t_ref;
    ///EditText editname,editemail,editpass,editcpass,editsubject,editid,editdepart,editq;
    //EditText editname,editadd,editemail,editpass,editcpass,edittype,editq,editcontact;
    TextView editpro;

    EditText editname,editemail,editpass,editcpass,edittype,editadd,editcontact;
    // Intent i;
    private static final  int GALLERY_INTENT=2;

    private StorageReference ms;
    private Button saveb;
    private Uri filePath;
    private final int PICK_REQUEST=71;
    private static  Firebase image;

    private String id,sname,semail,spass,scpass,stype,sadd,scontact,spro;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo_register);


        ms = FirebaseStorage.getInstance().getReference();


        editname=(EditText)findViewById(R.id.editname);
        editemail=(EditText)findViewById(R.id.editemail);
        editpass=(EditText)findViewById(R.id.editpass);
        editcpass=(EditText)findViewById(R.id.editcpass);
        edittype=(EditText)findViewById(R.id.edittype);
        editadd=(EditText)findViewById(R.id.editadd);
        editcontact=(EditText)findViewById(R.id.editcontact);
        //editq=(EditText)findViewById(R.id.editq);
        editpro=(TextView)findViewById(R.id.editpro);



        saveb=(Button)findViewById(R.id.signin);



        Firebase.setAndroidContext(this);


        mref=new Firebase("https://hack36-2a2b4.firebaseio.com/users");

        t_ref=new Firebase("https://hack36-2a2b4.firebaseio.com");








        //end of making child



        saveb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                id=editname.getText().toString();
                final Firebase c_name=mref.child(id).child("name");
                final Firebase c_email=mref.child(id).child("email");
                final Firebase c_password=mref.child(id).child("password");
                final Firebase c_cpassword=mref.child(id).child("confirm password");
                final Firebase c_type=mref.child(id).child("type");
                final Firebase c_add=mref.child(id).child("address");
                final Firebase c_contact=mref.child(id).child("contact");
                //final Firebase c_id=mref.child(id).child("add");
                final Firebase c_pro=mref.child(id).child("pro");


                //	id,sname,ssubject,sdepart,,spro
                sname=editname.getText().toString();
                semail=editemail.getText().toString();
                spass=editpass.getText().toString();
                scpass=editcpass.getText().toString();
                stype=edittype.getText().toString();
                sadd=editadd.getText().toString();
                scontact=editcontact.getText().toString();

                spro=editpro.getText().toString();

                Log.e(sname,"hi");
                Log.e(semail,"hi");
                Log.e(spass,"hi");
                Log.e(scpass,"hi");
                Log.e(stype,"hi");
                Log.e(sadd,"hi");
                Log.e(scontact,"hi");







                check();
                

                    c_name.setValue(sname);
                    c_email.setValue(semail);
                    c_password.setValue(spass);
                    c_cpassword.setValue(scpass);
                    c_type.setValue(stype);
                    c_add.setValue(sadd);
                    c_contact.setValue(scontact);
                    c_pro.setValue(spro);

                Toast toast=Toast.makeText(getApplicationContext(),"Submitted",Toast.LENGTH_LONG);
                //toast.setMargin(50,50);
                toast.show();
                    //final Firebase c_t = t_ref.child(spro).child(sdepart).child(sq).child(ssubject).child("NGO");

                    //c_t.child(id).setValue("true");
              


            }
        });
    }

    private void check() {

        if(sname.isEmpty()){
            editname.setHint("can't be empty");
            editname.setBackgroundColor(Color.parseColor("#FFEF767C"));
        }
        if(semail.isEmpty()){
            editemail.setHint("can't be empty");
            editemail.setBackgroundColor(Color.parseColor("#FFEF767C"));
        }
        if(spass.isEmpty()){
            editpass.setHint("can't be empty");
            editpass.setBackgroundColor(Color.parseColor("#FFEF767C"));
        }
        if(scpass.isEmpty()){
            editcpass.setHint("can't be empty");
            editcpass.setBackgroundColor(Color.parseColor("#FFEF767C"));
        }
        if(stype.isEmpty()){
            edittype.setHint("can't be empty");
            edittype.setBackgroundColor(Color.parseColor("#FFEF767C"));
        }
        if(sadd.isEmpty()){
            editadd.setHint("can't be empty");
            editadd.setBackgroundColor(Color.parseColor("#FFEF767C"));
        }if(scontact.isEmpty()){
            editcontact.setHint("can't be empty");
            editcontact.setBackgroundColor(Color.parseColor("#FFEF767C"));
        }

        if(!spass.equals(scpass)){
            editpass.setHint("Password should equal");
            editpass.setBackgroundColor(Color.parseColor("#FFEF767C"));
        }
    }


//    private void chooseImage(){
//        a=true;
//        check();
//        if(a) {
//            ima=true;
//            Intent i = new Intent();
//            i.setType("image/*");
//            i.setAction(Intent.ACTION_GET_CONTENT);
//            startActivityForResult(Intent.createChooser(i, "select picture"), PICK_REQUEST);
//        }
//    }



//    @Override
//    protected void onActivityResult(int requestCode,int resultCode,Intent data)
//
//    {
//        super.onActivityResult(requestCode,resultCode,data);
//
//        if(resultCode==RESULT_OK && requestCode==PICK_REQUEST && data!=null && data.getData()!=null)
//        {
//
//            filePath = data.getData();
//            try{
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),filePath);
//                iv.setImageBitmap(bitmap);
//            }catch(IOException e){
//                e.printStackTrace();
//            }
//
//            if(filePath!=null){
//
//
//                String  picid = editid.getText().toString();
//                StorageReference ref= ms.child("id_images").child(picid);
//
//
//                ref.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//
//                        image=mref.child(editid.getText().toString()).child("image");
//                        //Toast.makeText(this,"Upload done",Toast.LENGTH_LONG).show();
//                        Log.e("image","uploaded");
//                        Uri downloaduri=taskSnapshot.getDownloadUrl();
//                        ima=true;
//                        image.setValue(downloaduri.toString());
//
//
//                    }
//                }).addOnFailureListener(new OnFailureListener(){
//                    @Override
//                    public void onFailure(@NonNull Exception e){
//                        Log.e("image","failed");
//                    }
//                });
//
//
//            }
//
//        }
//
//
//    }

}