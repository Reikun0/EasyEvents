package com.example.easyevents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.widget.NestedScrollView
import com.google.android.material.appbar.MaterialToolbar

class ContactActivity : AppCompatActivity() {
    private lateinit var submitButton : Button
    private lateinit var nameField : EditText
    private lateinit var emailField : EditText
    private lateinit var subjectField : EditText
    private lateinit var messageField : EditText
    private lateinit var submitMessage : AppCompatTextView
    private lateinit var topAppBar : MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

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

        submitButton = findViewById(R.id.submitButton)
        nameField = findViewById(R.id.nameField)
        emailField = findViewById(R.id.emailField)
        subjectField = findViewById(R.id.subjectField)
        messageField = findViewById(R.id.messageField)
        submitMessage = findViewById(R.id.submitMessage)
        submitButton.setOnClickListener {
            val name = nameField.text.toString().trim()
            val email = emailField.text.toString().trim()
            val subject = subjectField.text.toString().trim()
            val message = messageField.text.toString().trim()
            var isOk = false
            if (!TextUtils.isEmpty(name)) {
                isOk = true
                nameField.error = null
            } else {
                isOk = false
                nameField.error = "Name is required"
            }

            if (isValidEmail(email)) {
                isOk = true
                emailField.error = null
            } else {
                isOk = false
                emailField.error = "Invalid Email"
            }

            if (!TextUtils.isEmpty(subject)) {
                isOk = true
                subjectField.error = null
            } else {
                isOk = false
                subjectField.error = "Name is required"
            }

            if (!TextUtils.isEmpty(message)) {
                isOk = true
                messageField.error = null
            } else {
                isOk = false
                messageField.error = "Name is required"
            }

            if (isOk) {
                submitMessage.text = "Thanks for contacting us! We'll get back to you soon!"
                submitMessage.visibility = View.VISIBLE
                submitMessage.requestFocus()
                val scrollView = findViewById<NestedScrollView>(R.id.scrollView)
                scrollView.post {
                    scrollView.scrollTo(0, scrollView.bottom)
                }
                nameField.text.clear()
                emailField.text.clear()
                subjectField.text.clear()
                messageField.text.clear()
            } else
                submitMessage.visibility = View.GONE
        }
    }

    private fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}