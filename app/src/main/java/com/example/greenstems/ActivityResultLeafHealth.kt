package com.example.greenstems

import android.graphics.Bitmap
import android.os.Bundle
import android.os.Parcelable
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

    private var bitmap: Bitmap? = null
    private var uri: String? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityresulthealth)
        result = findViewById(R.id.resulttexthealth)
        image = findViewById<View>(R.id.imageresult) as ImageView


        val bundle = getIntent().getExtras();
        if (bundle != null) {
            val intent = intent
            val bitmap = intent.getParcelableExtra<Parcelable>("sendImage") as Bitmap?
            uri = bundle.getString("selectedImage")

            if (bitmap != null)
                image!!.setImageBitmap(bitmap)
            else
                Glide.with(this).load(uri).into(image!!)
        }

    }
}