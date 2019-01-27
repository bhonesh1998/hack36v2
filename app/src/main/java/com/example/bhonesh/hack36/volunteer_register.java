package com.example.bhonesh.hack36;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class volunteer_register extends AppCompatActivity {
    private Firebase mref,t_ref,mref2;
    EditText editname,editemail,editpass,editcpass,editocc,editedu,editage,editadd,editcontact;
    //EditText editname,editemail,editpass,editcpass,editbatch,editid,editdepart,edityear;
    TextView editpro;

    // Intent i;
    private static final  int GALLERY_INTENT=2;

    private StorageReference ms;
    private Button saveb;
    private ImageView iv;
    private Uri filePath;
    private final int PICK_REQUEST=71;
    private static  Firebase image;
    boolean ima=false,a;

    private String id,sname,sbatch,syear,sdepart,spro,x,y,z,scontact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_register);


        ms = FirebaseStorage.getInstance().getReference();


        editname=(EditText)findViewById(R.id.editname);
        editemail=(EditText)findViewById(R.id.code);
        editpass=(EditText)findViewById(R.id.editpass);
        editcpass=(EditText)findViewById(R.id.editcpass);
        editocc=(EditText)findViewById(R.id.editbatch);
        editedu=(EditText)findViewById(R.id.edityear);
        editage=(EditText)findViewById(R.id.editcontact);
        editadd=(EditText)findViewById(R.id.editid);
        editpro=(TextView) findViewById(R.id.editpro);
        editcontact=(EditText)findViewById(R.id.contactid);
        saveb=(Button)findViewById(R.id.signin);

        Firebase.setAndroidContext(this);


        mref=new Firebase("https://hack36-2a2b4.firebaseio.com/users");

        mref2=new Firebase("https://hack36-2a2b4.firebaseio.com/volunteers");

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
                final Firebase c_batch=mref.child(id).child("occ");
                final Firebase c_year=mref.child(id).child("edu");
                final Firebase c_department=mref.child(id).child("age");
                final Firebase c_id=mref.child(id).child("add");
                final Firebase c_pro=mref.child(id).child("pro");
                final Firebase c_contact=mref.child(id).child("contact");
                final Firebase c_name2=mref2.child("name");
                //	id,sname,sbatch,sdepart,,spro
                sname=editname.getText().toString();
                sbatch=editocc.getText().toString();
                sdepart=editage.getText().toString();
                syear=editedu.getText().toString();
                spro=editpro.getText().toString();
                x=editemail.getText().toString();
                y=editpass.getText().toString();
                z=editcpass.getText().toString();
                scontact=editcontact.getText().toString();
                check();

                c_name.setValue(sname);
                c_name2.setValue(sname);
                c_email.setValue(editemail.getText().toString());
                c_password.setValue(editpass.getText().toString());
                c_cpassword.setValue(editcpass.getText().toString());
                c_id.setValue(editadd.getText().toString());
                c_batch.setValue(sbatch);
                c_department.setValue(sdepart);
                c_year.setValue(syear);
                c_pro.setValue(spro);
                c_contact.setValue(scontact);

                Toast toast=Toast.makeText(getApplicationContext(),"Submitted",Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();

//                final Firebase c_t=t_ref.child(spro).child(sdepart).child(syear).child(sbatch).child("Student");
//
//                c_t.child(id).setValue("true");

            }
        });
    }


//    private void chooseImage(){
//        a=true;
//        check();
//        if(a) {
//            Intent i = new Intent();
//            i.setType("image/*");
//            i.setAction(Intent.ACTION_GET_CONTENT);
//            startActivityForResult(Intent.createChooser(i, "select picture"), PICK_REQUEST);
//        }
//    }



    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data)

    {
        super.onActivityResult(requestCode,resultCode,data);

        if(resultCode==RESULT_OK && requestCode==PICK_REQUEST && data!=null && data.getData()!=null)
        {

            filePath = data.getData();
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),filePath);
                iv.setImageBitmap(bitmap);
            }catch(IOException e){
                e.printStackTrace();
            }

            if(filePath!=null){


                String  picid = editadd.getText().toString();
                StorageReference ref= ms.child("id_images").child(picid);


                ref.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        image=mref.child(editadd.getText().toString()).child("image");
                        //Toast.makeText(this,"Upload done",Toast.LENGTH_LONG).show();
                        Log.e("image","uploaded");
                        Uri downloaduri=taskSnapshot.getDownloadUrl();
                        ima=true;
                        image.setValue(downloaduri.toString());


                    }
                }).addOnFailureListener(new OnFailureListener(){
                    @Override
                    public void onFailure(@NonNull Exception e){
                        Log.e("image","failed");
                    }
                });


            }

        }



    }
    private void check() {

        if(sname.isEmpty()){
            editname.setHint("can't be empty");
            editname.setBackgroundColor(Color.parseColor("#FFEF767C"));a=false;
        }
        if(sbatch.isEmpty()){
            editocc.setHint("can't be empty");
            editocc.setBackgroundColor(Color.parseColor("#FFEF767C"));a=false;
        }
        if(sdepart.isEmpty()){
            editage.setHint("can't be empty");
            editage.setBackgroundColor(Color.parseColor("#FFEF767C"));a=false;
        }
        if(syear.isEmpty()){
            editedu.setHint("can't be empty");
            editedu.setBackgroundColor(Color.parseColor("#FFEF767C"));a=false;
        }
        if(spro.isEmpty()){
            editpro.setHint("can't be empty");
            editpro.setBackgroundColor(Color.parseColor("#FFEF767C"));a=false;
        }
        if(x.isEmpty()){
            editemail.setHint("can't be empty");
            editemail.setBackgroundColor(Color.parseColor("#FFEF767C"));a=false;
        }if(y.isEmpty()){
            editpass.setHint("can't be empty");
            editpass.setBackgroundColor(Color.parseColor("#FFEF767C"));a=false;
        }
        if(z.isEmpty()){
            editcpass.setHint("can't be empty");
            editcpass.setBackgroundColor(Color.parseColor("#FFEF767C"));a=false;
        }
        if(!y.equals(z)){
            editpass.setHint("Password should equal");
            editpass.setBackgroundColor(Color.parseColor("#FFEF767C"));a=false;
        }
    }


}