package com.example.greenstems;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class GardenResource extends AppCompatActivity
{
    TextView sunandwater,soil,zone,grow,location,water,protect,link;
    RelativeLayout hiddensunandwater,hiddensoil,hiddenzone,hiddengrow,hiddenlocation,hiddenwater,hiddenprotect;
    LinearLayout sunandwatercard,soilcard,zonecard,growcard,locationcard,watercard,protectcard;
    Button minussun,minussoil,minuszone,minusgrow,minuslocation,minuswater,minusprotect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garden_resource);

        sunandwater=findViewById(R.id.sunandwaterbutton);
        hiddensunandwater=findViewById(R.id.hiddensunandwater);
        sunandwatercard=findViewById(R.id.sunandwatercard);
        minussun=findViewById(R.id.sunandwater_minus_button);

        sunandwater.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onClick(View v) {
                if (hiddensunandwater.getVisibility()== View.GONE){
                    TransitionManager.beginDelayedTransition((ViewGroup) sunandwatercard, new AutoTransition());
                    hiddensunandwater.setVisibility(View.VISIBLE);
                }
            }
        });

        minussun.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition((ViewGroup) sunandwatercard, new AutoTransition());
                hiddensunandwater.setVisibility(View.GONE);
            }
        });


        soil=findViewById(R.id.soilbutton);
        hiddensoil=findViewById(R.id.hiddensoil);
        soilcard=findViewById(R.id.soilcard);
        minussoil=findViewById(R.id.soil_minus_button);

        soil.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onClick(View v) {
                if (hiddensoil.getVisibility()== View.GONE){
                    TransitionManager.beginDelayedTransition((ViewGroup) soilcard, new AutoTransition());
                    hiddensoil.setVisibility(View.VISIBLE);
                }
            }
        });

        minussoil.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition((ViewGroup) soilcard, new AutoTransition());
                hiddensoil.setVisibility(View.GONE);
            }
        });

        zone=findViewById(R.id.zonebutton);
        hiddenzone=findViewById(R.id.hiddenzone);
        zonecard=findViewById(R.id.zonecard);
        minuszone=findViewById(R.id.zone_minus_button);

        zone.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onClick(View v) {
                if (hiddenzone.getVisibility()== View.GONE){
                    TransitionManager.beginDelayedTransition((ViewGroup) zonecard, new AutoTransition());
                    hiddenzone.setVisibility(View.VISIBLE);
                }
            }
        });

        minuszone.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition((ViewGroup) zonecard, new AutoTransition());
                hiddenzone.setVisibility(View.GONE);
            }
        });

        grow=findViewById(R.id.growbutton);
        hiddengrow=findViewById(R.id.hiddengrow);
        growcard=findViewById(R.id.growcard);
        minusgrow=findViewById(R.id.grow_minus_button);

        grow.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onClick(View v) {
                if (hiddengrow.getVisibility()== View.GONE){
                    TransitionManager.beginDelayedTransition((ViewGroup) growcard, new AutoTransition());
                    hiddengrow.setVisibility(View.VISIBLE);
                }
            }
        });

        minusgrow.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition((ViewGroup) growcard, new AutoTransition());
                hiddengrow.setVisibility(View.GONE);
            }
        });

        location=findViewById(R.id.locationbutton);
        hiddenlocation=findViewById(R.id.hiddenlocation);
        locationcard=findViewById(R.id.locationcard);
        minuslocation=findViewById(R.id.location_minus_button);

        location.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onClick(View v) {
                if (hiddenlocation.getVisibility()== View.GONE){
                    TransitionManager.beginDelayedTransition((ViewGroup) locationcard, new AutoTransition());
                    hiddenlocation.setVisibility(View.VISIBLE);
                }
            }
        });

        minuslocation.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition((ViewGroup) locationcard, new AutoTransition());
                hiddenlocation.setVisibility(View.GONE);
            }
        });

        water=findViewById(R.id.waterbutton);
        hiddenwater=findViewById(R.id.hiddenwater);
        watercard=findViewById(R.id.watercard);
        minuswater=findViewById(R.id.water_minus_button);

        water.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onClick(View v) {
                if (hiddenwater.getVisibility()== View.GONE){
                    TransitionManager.beginDelayedTransition((ViewGroup) watercard, new AutoTransition());
                    hiddenwater.setVisibility(View.VISIBLE);
                }
            }
        });

        minuswater.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition((ViewGroup) watercard, new AutoTransition());
                hiddenwater.setVisibility(View.GONE);
            }
        });

        protect=findViewById(R.id.protectbutton);
        hiddenprotect=findViewById(R.id.hiddenprotect);
        protectcard=findViewById(R.id.protectcard);
        minusprotect=findViewById(R.id.protect_minus_button);

        protect.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onClick(View v) {
                if (hiddenprotect.getVisibility()== View.GONE){
                    TransitionManager.beginDelayedTransition((ViewGroup) protectcard, new AutoTransition());
                    hiddenprotect.setVisibility(View.VISIBLE);
                }
            }
        });

        minusprotect.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition((ViewGroup) protectcard, new AutoTransition());
                hiddenprotect.setVisibility(View.GONE);
            }
        });

        link=findViewById(R.id.link_button);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.bigblogofgardening.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}
