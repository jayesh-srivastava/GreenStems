package com.example.greenstems

import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.greenstems.R.layout.activityresultdisease
import com.example.greenstems.ml.Flowermodel
import com.example.greenstems.ml.LeavesDisease
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.model.Model
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer

class ActivityResultDisease:AppCompatActivity()
{
    lateinit var result: TextView
    var image: ImageView? = null
    lateinit var show: Button

    var bitmapCamera: Bitmap? = null
    var bitmapGallery: Bitmap? = null
    var bitmapcopy: Bitmap?=null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activityresultdisease)
        result = findViewById(R.id.resulttextdisease)
        image = findViewById<View>(R.id.imageresult) as ImageView
        show=findViewById(R.id.showresultdisease)

        val bundle = getIntent().getExtras();
        if (bundle != null) {

            //BITMAP FROM CAMERA
            var bitmapCamera = intent.getParcelableExtra<Parcelable>("sendImage") as Bitmap?

            if (bitmapCamera == null) {
                var uri: String? = bundle.getString("selectedImage")
                var uriGallery: Uri? = Uri.parse(uri!!)
                //BITMAP FROM GALLERY
                bitmapGallery = MediaStore.Images.Media.getBitmap(this.contentResolver, uriGallery)
                bitmapcopy=bitmapGallery?.copy(bitmapGallery?.config,true)
            }
            else {
                bitmapcopy=bitmapCamera?.copy(bitmapCamera?.config, true)
            }

            image!!.setImageBitmap(bitmapcopy)

            val labels = application.assets.open("leaves_disease.txt").bufferedReader().use { it.readText()}
            val labelfile=labels.split("\n")

            show.setOnClickListener(View.OnClickListener {
                var resized =
                    bitmapcopy?.let { it1 -> Bitmap.createScaledBitmap(it1, 224, 224, true) }

                val options= Model.Options.Builder().setDevice(Model.Device.GPU).build()
                val model = LeavesDisease.newInstance(this)


                val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)

                var tBuffer = TensorImage.fromBitmap(resized)
                //var byteBuffer =tBuffer.buffer
                val byteBuffer = ByteBuffer.allocateDirect(1*224*224*3*4)
                byteBuffer.put(tBuffer.buffer)
                inputFeature0.loadBuffer(byteBuffer)

                val outputs = model.process(inputFeature0)
                val outputFeature0 = outputs.outputFeature0AsTensorBuffer

                var max = getMax(outputFeature0.floatArray)

                result.setText(labelfile[max])

                model.close()
            })
        }
    }

    fun getMax(arr:FloatArray) : Int{
        var ind = 0;
        var min = 0.0f;

        for(i in 0..35)
        {
            if(arr[i] > min) {
                min = arr[i]
                ind = i;
            }
        }
        return ind
    }
}