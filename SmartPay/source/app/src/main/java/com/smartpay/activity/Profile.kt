package com.smartpay.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.smartpay.R
import com.smartpay.databinding.ActivityProfileBinding
import com.smartpay.model.ModalProfile

class Profile : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Wrap text in the TextView
        val textView = binding.upi
        val originalText = getString(R.string.upi)
        val wrappedText = originalText.replace("(.{26})".toRegex(), "$1\n")
        textView.text = wrappedText


        binding.backButton.setOnClickListener{
            val Intent = Intent(this ,SmartPayScreen::class.java)
            startActivity(Intent)
        }
//        binding.backbutton.setOnClickListener{
//            val Intent = Intent(this,Profile::class.java)
//            startActivity(Intent)
//        }


    }
}
