package com.example.prak4

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth

class Register : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth

        val email = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.email)
        val username = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.username)
        val password = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.password)

        val btnSignUp: Button = findViewById(R.id.btnSignUp)
        btnSignUp.setOnClickListener {
            auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                        updateUI(null)
                    }
                }
        }
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            startActivity(Intent(this, MainActivity::class.java))
            showWelcomeMessage(user.displayName)
        } else {
            // User is signed out
            // Update UI elements for a signed-out user
            showSignInOptions()
        }
    }

    private fun showWelcomeMessage(username: String?) {
        Toast.makeText(
            applicationContext,
            "Welcome, $username!",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun showSignInOptions() {
        // Display sign-in options on the UI
        // For example, show/hide certain buttons or views
        // signInButton.visibility = View.VISIBLE
        // signOutButton.visibility = View.GONE
    }
}