package in.iot.lab.acl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Initialize and Assign variables
        BottomNavigationView bottomNavigationView=findViewById(R.id.nav_view);

        //Set Dashboard Selected
        bottomNavigationView.setSelectedItemId(R.id.navigation_dashboard);

        //Item Select Listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_basic:
                        startActivity(new Intent(getApplicationContext(),Basics.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_advanced:
                        startActivity(new Intent(getApplicationContext(),Advanced.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_dashboard:

                        return true;
                }
                return false;
            }
        });


    }
}