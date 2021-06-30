package com.example.greenstems;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import org.tensorflow.lite.Interpreter;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Objects;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {

    Button button;
    LinearLayout classification, soil, health, diseases;
    private static final int PERMISSION_NEW_REQUEST_CODE = 200;
    String[] permissionsRequired = new String[]
            {
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
            };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.gardening);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,GardenResource.class);
                startActivity(intent);
            }
        });

        classification=findViewById(R.id.classification);
        soil=findViewById(R.id.soil);
        health=findViewById(R.id.leafhealth);
        diseases=findViewById(R.id.diseases);

        classification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checknewpermission())
                {
                    addImageFlower();
                }
                else
                {
                    requestnewpermission();
                }
            }
        });

        soil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checknewpermission())
                {
                    addImageSoil();
                }
                else
                {
                    requestnewpermission();
                }
            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checknewpermission())
                {
                    addImageHealth();
                }
                else
                {
                    requestnewpermission();
                }
            }
        });

        diseases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checknewpermission())
                {
                    addImageDisease();
                }
                else
                {
                    requestnewpermission();
                }
            }
        });


    }

    private boolean checknewpermission()
    {
        int result = ContextCompat.checkSelfPermission(Objects.requireNonNull(MainActivity.this), Manifest.permission.CAMERA);
        int result1 = ContextCompat.checkSelfPermission(MainActivity.this, WRITE_EXTERNAL_STORAGE);
        int result2 = ContextCompat.checkSelfPermission(MainActivity.this,READ_EXTERNAL_STORAGE );
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED
                && result2 == PackageManager.PERMISSION_GRANTED;
    }

    private void addImageFlower()
    {
        final CharSequence[] options = { "Take Photo", "Choose From Gallery" ,"Cancel" };
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.
                Builder(Objects.requireNonNull(MainActivity.this));
        builder.setTitle("Choose a picture");
        builder.setItems(options, (dialog, which) -> {
            if (options[which].equals("Take Photo"))
            {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 10);
            }
            else if (options[which].equals("Choose From Gallery"))
            {
                Intent pickphoto = new Intent();
                pickphoto.setAction(Intent.ACTION_GET_CONTENT);
                pickphoto.setType("image/*");
                startActivityForResult(pickphoto,14);
            }
            else if(options[which].equals("Cancel"))
            {

                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void addImageSoil()
    {
        final CharSequence[] options = { "Take Photo", "Choose From Gallery" ,"Cancel" };
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.
                Builder(Objects.requireNonNull(MainActivity.this));
        builder.setTitle("Choose a picture");
        builder.setItems(options, (dialog, which) -> {
            if (options[which].equals("Take Photo"))
            {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 11);
            }
            else if (options[which].equals("Choose From Gallery"))
            {
                Intent pickphoto = new Intent();
                pickphoto.setType("image/*");
                pickphoto.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(pickphoto,15);
            }
            else if(options[which].equals("Cancel"))
            {

                dialog.dismiss();
            }
        });
        builder.show();
    }
    private void addImageHealth()
    {
        final CharSequence[] options = { "Take Photo", "Choose From Gallery" ,"Cancel" };
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.
                Builder(Objects.requireNonNull(MainActivity.this));
        builder.setTitle("Choose a picture");
        builder.setItems(options, (dialog, which) -> {
            if (options[which].equals("Take Photo"))
            {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 12);
            }
            else if (options[which].equals("Choose From Gallery"))
            {
                Intent pickphoto = new Intent();
                pickphoto.setType("image/*");
                pickphoto.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(pickphoto,16);
            }
            else if(options[which].equals("Cancel"))
            {

                dialog.dismiss();
            }
        });
        builder.show();
    }
    private void addImageDisease()
    {
        final CharSequence[] options = { "Take Photo", "Choose From Gallery" ,"Cancel" };
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.
                Builder(Objects.requireNonNull(MainActivity.this));
        builder.setTitle("Choose a picture");
        builder.setItems(options, (dialog, which) -> {
            if (options[which].equals("Take Photo"))
            {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 13);
            }
            else if (options[which].equals("Choose From Gallery"))
            {
                Intent pickphoto = new Intent();
                pickphoto.setType("image/*");
                pickphoto.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(pickphoto,17);
            }
            else if(options[which].equals("Cancel"))
            {

                dialog.dismiss();
            }
        });
        builder.show();
    }
    private void requestnewpermission()
    {
        ActivityCompat.requestPermissions(Objects.requireNonNull(MainActivity.this),permissionsRequired,PERMISSION_NEW_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case 10:
                assert data != null;
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                //Starting activity (ImageViewActivity in my code) to preview image
                Intent intent=new Intent(MainActivity.this, ActivityResultFlower.class);
                intent.putExtra("sendImage", photo);
                startActivity(intent);
                break;
            case 11:
                assert data != null;
                Bitmap photo11 = (Bitmap) data.getExtras().get("data");
                //Starting activity (ImageViewActivity in my code) to preview image
                Intent intent11=new Intent(MainActivity.this, ActivityResultSoil.class);
                intent11.putExtra("sendImage", photo11);
                startActivity(intent11);
                break;
            case 12:
                assert data != null;
                Bitmap photo12 = (Bitmap) data.getExtras().get("data");
                //Starting activity (ImageViewActivity in my code) to preview image
                Intent intent12=new Intent(MainActivity.this, ActivityResultLeafHealth.class);
                intent12.putExtra("sendImage", photo12);
                startActivity(intent12);
                break;
            case 13:
                assert data != null;
                Bitmap photo13 = (Bitmap) data.getExtras().get("data");
                //Starting activity (ImageViewActivity in my code) to preview image
                Intent intent13=new Intent(MainActivity.this, ActivityResultDisease.class);
                intent13.putExtra("sendImage", photo13);
                startActivity(intent13);
                break;
            case 14:
                assert data != null;
                if (data.getData() != null) {
                    Uri imageUri14 = data.getData();

                    //Starting activity (ImageViewActivity in my code) to preview image
                    Intent intent14 = new Intent(MainActivity.this, ActivityResultFlower.class);
                    intent14.putExtra("selectedImage", imageUri14.toString());
                    startActivity(intent14);
                }
                break;
            case 15:
                assert data != null;
                if (data.getData() != null) {
                    Uri imageUri15 = data.getData();

                    //Starting activity (ImageViewActivity in my code) to preview image
                    Intent intent15 = new Intent(MainActivity.this, ActivityResultSoil.class);
                    intent15.putExtra("selectedImage", imageUri15.toString());
                    startActivity(intent15);
                }
                break;
            case 16:
                assert data != null;
                if (data.getData() != null) {
                    Uri imageUri16 = data.getData();

                    //Starting activity (ImageViewActivity in my code) to preview image
                    Intent intent16 = new Intent(MainActivity.this, ActivityResultLeafHealth.class);
                    intent16.putExtra("selectedImage", imageUri16.toString());
                    startActivity(intent16);
                }
                break;
            case 17:
                assert data != null;
                if (data.getData() != null) {
                    Uri imageUri17 = data.getData();

                    //Starting activity (ImageViewActivity in my code) to preview image
                    Intent intent17 = new Intent(MainActivity.this, ActivityResultDisease.class);
                    intent17.putExtra("selectedImage", imageUri17.toString());
                    startActivity(intent17);
                }
                break;
            default:
                break;
        }

    }
}