package com.example.itd_stu.project_dicoding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by ITD-STU on 6/10/19.
 */

public class Display extends AppCompatActivity {
    private static final String TAG="Display";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        Log.d(TAG,"onCreate: started.");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG,"getIncomingIntent: Checking for incoming intents.");

        //if(getIntent().hasExtra("image_url")&& getIntent().hasExtra("image_name")){
          //  Log.d(TAG,"getIncomingIntent: found intent extras.");

            String imageurl=getIntent().getStringExtra("image_url");
            String imageName=getIntent().getStringExtra("image_name");
            String price=getIntent().getStringExtra("price");
            String deskripsi=getIntent().getStringExtra("deskripsi");
            String display=getIntent().getStringExtra("display");
            String size=getIntent().getStringExtra("size");
            String feature=getIntent().getStringExtra("feature");
            String camera=getIntent().getStringExtra("camera");
            String toko=getIntent().getStringExtra("toko");
            String pemilik=getIntent().getStringExtra("pemilik");

            setImage(imageurl,imageName,price,deskripsi,display,size,feature,camera,toko,pemilik);
        //}
    }

    private void setImage(String imageUrl,String imageName,String price,String deskripsi,String display,String size,String feature,String camera,String toko,String pemilik){
        Log.d(TAG,"setImage: setting te image and name to widgets.");

        TextView name=findViewById(R.id.price);
        name.setText(imageName);

        TextView pemil=findViewById(R.id.penjual);
        pemil.setText(pemilik);

        TextView displa=findViewById(R.id.display);
        displa.setText(display);



        TextView size1=findViewById(R.id.size);
        size1.setText(size);

        TextView featur=findViewById(R.id.feature);
        featur.setText(feature);

        TextView camer=findViewById(R.id.camera);
        camer.setText(camera);

        TextView namePrice=findViewById(R.id.stock);
        namePrice.setText(price);

        TextView namedes=findViewById(R.id.deskripsi);
        namedes.setText(deskripsi);

        ImageView image=findViewById(R.id.tv_item_image);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);

        ImageView profile=findViewById(R.id.profile_image);
        Glide.with(this)
                .asBitmap()
                .load(toko)
                .into(profile);
    }
}
