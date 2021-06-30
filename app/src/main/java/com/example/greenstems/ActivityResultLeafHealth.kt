package com.example.greenstems

import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.greenstems.R.layout.activityresulthealth

class ActivityResultLeafHealth:AppCompatActivity()
{
    var result: TextView? = null
    var image: ImageView? = null

    var bitmapCamera: Bitmap? = null
    var bitmapGallery: Bitmap? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activityresulthealth)
        result = findViewById(R.id.resulttexthealth)
        image = findViewById<View>(R.id.imageresult) as ImageView

        val bundle = getIntent().getExtras();
        if (bundle != null) {

            //BITMAP FROM CAMERA
            bitmapCamera = intent.getParcelableExtra<Parcelable>("sendImage") as Bitmap?

            if(bitmapCamera==null)
            {
                var uri:String? = bundle.getString("selectedImage")
                var uriGallery: Uri? = Uri.parse(uri!!)
                //BITMAP FROM GALLERY
                bitmapGallery = MediaStore.Images.Media.getBitmap(this.contentResolver, uriGallery)
            }


            if (bitmapCamera != null)
                image!!.setImageBitmap(bitmapCamera)
            else
                image!!.setImageBitmap(bitmapGallery)
        }




    }


}
