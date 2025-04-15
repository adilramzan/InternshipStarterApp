package com.example.internshipstarterapp.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.internshipstarterapp.R
import com.example.internshipstarterapp.databinding.ActivityHomeBinding
import com.example.internshipstarterapp.utils.Quotes
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeActivity : ComponentActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.motivationButton.setOnClickListener{
            val quote= Quotes.getQuote()
            MaterialAlertDialogBuilder(this)
                .setTitle(getString(R.string.motivation_box_title))
                .setMessage(quote)
                .setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

}