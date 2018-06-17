package com.example.sport0102.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

class LoginActivity : AppCompatActivity() {
    val loginBtn by lazy{findViewById<Button>(R.id.login_btn_login)}
    val signUpBtn by lazy{findViewById<Button>(R.id.login_btn_signup)}
    var mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var splashBackground = mFirebaseRemoteConfig.getString(getString(R.string.rc_color))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(Color.parseColor(splashBackground))
        }
        loginBtn.setBackgroundColor(Color.parseColor(splashBackground))
        signUpBtn.setBackgroundColor(Color.parseColor(splashBackground))
        signUpBtn.setOnClickListener { startActivity(Intent(this@LoginActivity,SignUpActivity::class.java)) }
    }
}
