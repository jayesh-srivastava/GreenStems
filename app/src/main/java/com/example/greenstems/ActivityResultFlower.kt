package com.example.greenstems

import android.app.Activity
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.support.common.TensorProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import com.example.greenstems.ml.Flowermodel
import org.tensorflow.lite.DataType
import java.nio.ByteBuffer
import java.nio.FloatBuffer

class ActivityResultFlower : AppCompatActivity() {
    lateinit var result: TextView
    var image: ImageView? = null
    lateinit var show: Button

    var bitmapCamera: Bitmap? = null
    var bitmapGallery: Bitmap? = null

    var bitmapGallerycopy: Bitmap?=null

    @RequiresApi(Build.VERSION_CODES.N)
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activityresultflower)
        result = findViewById(R.id.resulttext)
        image = findViewById<View>(R.id.imageresult) as ImageView
        show=findViewById(R.id.showresultsflower)

        val bundle = getIntent().getExtras();
        if (bundle != null) {

            //BITMAP FROM CAMERA
            bitmapCamera = intent.getParcelableExtra<Parcelable>("sendImage") as Bitmap?

            if (bitmapCamera == null) {
                var uri: String? = bundle.getString("selectedImage")
                var uriGallery: Uri? = Uri.parse(uri!!)
                //BITMAP FROM GALLERY
                bitmapGallery = MediaStore.Images.Media.getBitmap(this.contentResolver, uriGallery)
                bitmapGallerycopy=bitmapGallery?.copy(bitmapGallery?.config,true)
            }

            if (bitmapCamera != null)
                image!!.setImageBitmap(bitmapCamera)
            else {
                image!!.setImageBitmap(bitmapGallerycopy)
            }

            val labels = application.assets.open("labels_flower.txt").bufferedReader().use { it.readText() }.split("\n")

            show.setOnClickListener(View.OnClickListener {
                var resized =
                    bitmapGallerycopy?.let { it1 -> Bitmap.createScaledBitmap(it1, 224, 224, true) }
                val model = Flowermodel.newInstance(this)


                val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)

                var tensorImage: TensorImage= TensorImage(DataType.FLOAT32)
                tensorImage.load(resized)

                var byteBuffer: ByteBuffer=tensorImage.buffer
                inputFeature0.loadBuffer(byteBuffer)

                val outputs = model.process(inputFeature0)
                val outputFeature0 = outputs.outputFeature0AsTensorBuffer

                var max = getMax(outputFeature0.floatArray)

                result.setText(labels[max])

                model.close()
            })

        }
    }

    fun getMax(arr:FloatArray) : Int{
        var ind = 0;
        var min = 0.0f;

        for(i in 0..4)
        {
            if(arr[i] > min)
            {
                min = arr[i]
                ind = i;
            }
        }
        return ind
    }

}






