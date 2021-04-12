package `in`.iot.lab.acl.splash

import `in`.iot.lab.acl.MainActivity
import `in`.iot.lab.acl.R
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class Splash_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_1)
        Handler().postDelayed({ // This method will be executed once the timer is over
            // Start your app main activity
            val i = Intent(this@Splash_1, MainActivity::class.java)
            startActivity(i)

            // close this activity
            finish()
        }, SPLASH_TIME_OUT.toLong())
    }

    companion object {
        private const val SPLASH_TIME_OUT = 3000
    }
}