package com.example.prak4

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth


class Login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

//    public override fun onStart() {
//        super.onStart()
//        val currentUser = auth.currentUser
//        if (currentUser != null) {
//            startActivity(Intent(this, MainActivity::class.java))
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        val btnRegister: Button = findViewById(R.id.btnRegister)
        btnRegister.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }

        val btnLogin: Button = findViewById(R.id.btLogin)
        btnLogin.setOnClickListener {
            val email = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.email)
            val password = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.password)

            email.text.toString()
            password.text.toString()

            if (email == null || password == null) {
                Toast.makeText(baseContext, "email and password are required", Toast.LENGTH_LONG).show()
            } else {
                auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success")
                            val user = auth.currentUser
                            updateUI(user)
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.exception)
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
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            startActivity(Intent(this, MainActivity::class.java))
            showWelcomeMessage(user.displayName)
        } else {
           Toast.makeText(applicationContext, "Email belum terdaftar, silahkan melakukan registrasi",
               Toast.LENGTH_LONG).show()
        }
    }

    private fun showWelcomeMessage(username: String?) {
        Toast.makeText(
            applicationContext,
            "Welcome, $username!",
            Toast.LENGTH_SHORT
        ).show()
    }


}
