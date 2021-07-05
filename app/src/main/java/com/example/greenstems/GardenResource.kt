package com.example.greenstems

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GardenResource : AppCompatActivity() {
    lateinit var sunandwater: TextView
    lateinit var soil: TextView
    lateinit var zone: TextView
    lateinit var grow: TextView
    lateinit var location: TextView
    lateinit var water: TextView
    lateinit var protect: TextView
    lateinit var link: TextView
    lateinit var hiddensunandwater: RelativeLayout
    lateinit var hiddensoil: RelativeLayout
    lateinit var hiddenzone: RelativeLayout
    lateinit var hiddengrow: RelativeLayout
    lateinit var hiddenlocation: RelativeLayout
    lateinit var hiddenwater: RelativeLayout
    lateinit var hiddenprotect: RelativeLayout
    lateinit var sunandwatercard: LinearLayout
    lateinit var soilcard: LinearLayout
    lateinit var zonecard: LinearLayout
    lateinit var growcard: LinearLayout
    lateinit var locationcard: LinearLayout
    lateinit var watercard: LinearLayout
    lateinit var protectcard: LinearLayout
    lateinit var minussun: Button
    lateinit var minussoil: Button
    lateinit var minuszone: Button
    lateinit var minusgrow: Button
    lateinit var minuslocation: Button
    lateinit var minuswater: Button
    lateinit var minusprotect: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_garden_resource)
        sunandwater = findViewById(R.id.sunandwaterbutton)
        hiddensunandwater = findViewById(R.id.hiddensunandwater)
        sunandwatercard = findViewById(R.id.sunandwatercard)
        minussun = findViewById(R.id.sunandwater_minus_button)
        sunandwater.setOnClickListener(View.OnClickListener {
            if (hiddensunandwater.getVisibility() == View.GONE) {
                TransitionManager.beginDelayedTransition(
                    sunandwatercard as ViewGroup?,
                    AutoTransition()
                )
                hiddensunandwater.setVisibility(View.VISIBLE)
            }
        })
        minussun.setOnClickListener(View.OnClickListener {
            TransitionManager.beginDelayedTransition(
                sunandwatercard as ViewGroup?,
                AutoTransition()
            )
            hiddensunandwater.setVisibility(View.GONE)
        })
        soil = findViewById(R.id.soilbutton)
        hiddensoil = findViewById(R.id.hiddensoil)
        soilcard = findViewById(R.id.soilcard)
        minussoil = findViewById(R.id.soil_minus_button)
        soil.setOnClickListener(View.OnClickListener {
            if (hiddensoil.getVisibility() == View.GONE) {
                TransitionManager.beginDelayedTransition(soilcard as ViewGroup?, AutoTransition())
                hiddensoil.setVisibility(View.VISIBLE)
            }
        })
        minussoil.setOnClickListener(View.OnClickListener {
            TransitionManager.beginDelayedTransition(soilcard as ViewGroup?, AutoTransition())
            hiddensoil.setVisibility(View.GONE)
        })
        zone = findViewById(R.id.zonebutton)
        hiddenzone = findViewById(R.id.hiddenzone)
        zonecard = findViewById(R.id.zonecard)
        minuszone = findViewById(R.id.zone_minus_button)
        zone.setOnClickListener(View.OnClickListener {
            if (hiddenzone.getVisibility() == View.GONE) {
                TransitionManager.beginDelayedTransition(zonecard as ViewGroup?, AutoTransition())
                hiddenzone.setVisibility(View.VISIBLE)
            }
        })
        minuszone.setOnClickListener(View.OnClickListener {
            TransitionManager.beginDelayedTransition(zonecard as ViewGroup?, AutoTransition())
            hiddenzone.setVisibility(View.GONE)
        })
        grow = findViewById(R.id.growbutton)
        hiddengrow = findViewById(R.id.hiddengrow)
        growcard = findViewById(R.id.growcard)
        minusgrow = findViewById(R.id.grow_minus_button)
        grow.setOnClickListener(View.OnClickListener {
            if (hiddengrow.getVisibility() == View.GONE) {
                TransitionManager.beginDelayedTransition(growcard as ViewGroup?, AutoTransition())
                hiddengrow.setVisibility(View.VISIBLE)
            }
        })
        minusgrow.setOnClickListener(View.OnClickListener {
            TransitionManager.beginDelayedTransition(growcard as ViewGroup?, AutoTransition())
            hiddengrow.setVisibility(View.GONE)
        })
        location = findViewById(R.id.locationbutton)
        hiddenlocation = findViewById(R.id.hiddenlocation)
        locationcard = findViewById(R.id.locationcard)
        minuslocation = findViewById(R.id.location_minus_button)
        location.setOnClickListener(View.OnClickListener {
            if (hiddenlocation.getVisibility() == View.GONE) {
                TransitionManager.beginDelayedTransition(
                    locationcard as ViewGroup?,
                    AutoTransition()
                )
                hiddenlocation.setVisibility(View.VISIBLE)
            }
        })
        minuslocation.setOnClickListener(View.OnClickListener {
            TransitionManager.beginDelayedTransition(locationcard as ViewGroup?, AutoTransition())
            hiddenlocation.setVisibility(View.GONE)
        })
        water = findViewById(R.id.waterbutton)
        hiddenwater = findViewById(R.id.hiddenwater)
        watercard = findViewById(R.id.watercard)
        minuswater = findViewById(R.id.water_minus_button)
        water.setOnClickListener(View.OnClickListener {
            if (hiddenwater.getVisibility() == View.GONE) {
                TransitionManager.beginDelayedTransition(watercard as ViewGroup?, AutoTransition())
                hiddenwater.setVisibility(View.VISIBLE)
            }
        })
        minuswater.setOnClickListener(View.OnClickListener {
            TransitionManager.beginDelayedTransition(watercard as ViewGroup?, AutoTransition())
            hiddenwater.setVisibility(View.GONE)
        })
        protect = findViewById(R.id.protectbutton)
        hiddenprotect = findViewById(R.id.hiddenprotect)
        protectcard = findViewById(R.id.protectcard)
        minusprotect = findViewById(R.id.protect_minus_button)
        protect.setOnClickListener(View.OnClickListener {
            if (hiddenprotect.getVisibility() == View.GONE) {
                TransitionManager.beginDelayedTransition(
                    protectcard as ViewGroup?,
                    AutoTransition()
                )
                hiddenprotect.setVisibility(View.VISIBLE)
            }
        })
        minusprotect.setOnClickListener(View.OnClickListener {
            TransitionManager.beginDelayedTransition(protectcard as ViewGroup?, AutoTransition())
            hiddenprotect.setVisibility(View.GONE)
        })
        link = findViewById(R.id.link_button)
        link.setOnClickListener(View.OnClickListener {
            val url = "https://www.bigblogofgardening.com/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        })
    }
}