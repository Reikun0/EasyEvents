package com.example.easyevents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.appbar.MaterialToolbar

class FaqActivity : AppCompatActivity() {
    private lateinit var contactButton : Button
    private lateinit var topAppBar : MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faq)

        contactButton = findViewById(R.id.contactButton)
        contactButton.setOnClickListener {
            val intent = Intent(this, ContactActivity::class.java)
            startActivity(intent)
        }

        topAppBar = findViewById(R.id.topAppBar)

        topAppBar.setNavigationOnClickListener {
            Toast.makeText(this, "Navigation Icon Clicked", Toast.LENGTH_SHORT).show()
        }

        topAppBar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId) {
                R.id.Home -> {
                    Toast.makeText(this, "Home overflow menu Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.About -> {
                    Toast.makeText(this, "About overflow menu Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, AboutActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.Contact -> {
                    Toast.makeText(this, "Contact overflow menu Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, ContactActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.Faq -> {
                    Toast.makeText(this, "Faq overflow menu Clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, FaqActivity::class.java)
                    startActivity(intent)
                    true
                }

                else -> {
                    false
                }
            }
        }
    }
}