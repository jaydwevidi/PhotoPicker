package com.example.photopicker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    companion object {
        val image_request_code =  100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button =  findViewById(R.id.imagepicker)
        button.setOnClickListener {
            pickImage()
        }
    }


    fun pickImage(){
        val getImage = Intent(Intent.ACTION_PICK)
        getImage.type = "image/*"
        startActivityForResult(getImage , image_request_code)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 100 && resultCode == RESULT_OK) {
            val image = findViewById<ImageView>(R.id.image1)
            image.setImageURI(data?.data)
        }
    }
}