package `in`.iot.lab.acl.home

import `in`.iot.lab.acl.R
import `in`.iot.lab.acl.text.Toast
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast.makeText
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(this, R.id.nav_host_fragment)
        navView.setupWithNavController(navController)

    }
}