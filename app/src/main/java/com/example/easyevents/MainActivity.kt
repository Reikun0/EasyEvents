package com.example.easyevents

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ScrollView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.widget.NestedScrollView
import com.google.android.material.appbar.MaterialToolbar


class MainActivity : AppCompatActivity() {

    private lateinit var topAppBar : MaterialToolbar
    private lateinit var contactButton : Button
    private lateinit var subscribeButton : Button
    private lateinit var emailField : EditText
    private lateinit var subscribeMessage : AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // NavBar
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

        // Buttons
        contactButton = findViewById(R.id.contactButton)
        contactButton.setOnClickListener {
            val intent = Intent(this, ContactActivity::class.java)
            startActivity(intent)
        }

        subscribeButton = findViewById(R.id.joinButton)
        emailField = findViewById(R.id.subscribeEmailField)
        subscribeMessage = findViewById(R.id.subscribeMessage)
        subscribeButton.setOnClickListener {
            val email = emailField.text.toString().trim()
            if (isValidEmail(email)) {
                subscribeMessage.text = "Thanks for subscribing!"
                subscribeMessage.visibility = View.VISIBLE
                emailField.error = null
                subscribeMessage.requestFocus()
                val scrollView = findViewById<NestedScrollView>(R.id.scrollView)
                scrollView.post {
                    scrollView.scrollTo(0, scrollView.bottom)
                }
            } else {
                subscribeMessage.visibility = View.GONE
                emailField.error = "Invalid Email"
            }
        }
    }

    private fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}