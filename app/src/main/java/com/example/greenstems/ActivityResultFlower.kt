package com.example.greenstems

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Matrix
import android.icu.util.ULocale
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.provider.MediaStore
import android.speech.RecognitionListener
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.bumptech.glide.Glide
import org.tensorflow.lite.Interpreter
import kotlin.random.Random

import org.tensorflow.lite.support.image.TensorImage
import java.util.*


class ActivityResultFlower : AppCompatActivity() {
    var result: TextView? = null
    var image: ImageView? = null

    private var bitmap: Bitmap? = null
    private var uri: String? = null
    public var bitmapCamera: Bitmap? = null
    public var bitmapGallery: Bitmap? = null

    protected var tflite: Interpreter
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activityresultflower)
        result = findViewById(R.id.resulttext)
        image = findViewById<View>(R.id.imageresult) as ImageView


        val bundle = getIntent().getExtras();
        if (bundle != null) {
            val intent = intent

            //BITMAP FROM CAMERA
            bitmapCamera = intent.getParcelableExtra<Parcelable>("sendImage") as Bitmap?
            uri = bundle.getString("selectedImage")
            val uriGallery: Uri = Uri.parse(uri)

            //BITMAP FROM GALLERY
            bitmapGallery = MediaStore.Images.Media.getBitmap(this.contentResolver, uriGallery)

            if (bitmap != null)
                image!!.setImageBitmap(bitmap)
            else
                Glide.with(this).load(uri).into(image!!)
        }


        try {
            tflite=Interpreter()
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

