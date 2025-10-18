package com.example.hellotoastapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var mCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mShowCount = findViewById<TextView>(R.id.show_count)
        val buttonCountUp = findViewById<Button>(R.id.button_count)
        val buttonToast = findViewById<Button>(R.id.button_toast)
        val buttonSwitchPage = findViewById<Button>(R.id.button_switchpage)
        val buttonBrowser = findViewById<Button>(R.id.button_browser)
        val buttonContact = findViewById<Button>(R.id.button_contact)
        val buttonMap = findViewById<Button>(R.id.button_map)
        val buttonSms = findViewById<Button>(R.id.button_sms)

        // COUNT BUTTON
        buttonCountUp.setOnClickListener {
            mCount++
            Log.d("mCount", mCount.toString())
            mShowCount.text = mCount.toString()
        }

        // TOAST BUTTON
        buttonToast.setOnClickListener {
            val tulisan = mShowCount.text.toString()
            Toast.makeText(this, "Angka yang dimunculkan: $tulisan", Toast.LENGTH_LONG).show()
        }

        // EXPLICIT INTENT
        buttonSwitchPage.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        // IMPLICIT INTENTS
        // 1️⃣ Buka Browser
        buttonBrowser.setOnClickListener {
            val intentBrowse = Intent(Intent.ACTION_VIEW)
            intentBrowse.data = Uri.parse("https://www.google.com/")
            startActivity(intentBrowse)
        }

        // 2️⃣ Buka Kontak
        buttonContact.setOnClickListener {
            val intentContact = Intent(Intent.ACTION_VIEW)
            intentContact.data = Uri.parse("content://contacts/people/")
            startActivity(intentContact)
        }

        // 3️⃣ Buka Lokasi di Maps
        buttonMap.setOnClickListener {
            val location = Uri.parse("geo:-6.914744,107.609810?q=Bandung")
            val intentMap = Intent(Intent.ACTION_VIEW, location)
            startActivity(intentMap)
        }

        // 4️⃣ Kirim SMS
        buttonSms.setOnClickListener {
            val smsIntent = Intent(Intent.ACTION_VIEW)
            smsIntent.data = Uri.parse("sms:08123456789")
            smsIntent.putExtra("sms_body", "Halo! Ini pesan otomatis dari HelloToastApp 😄")
            startActivity(smsIntent)
        }
    }
}
