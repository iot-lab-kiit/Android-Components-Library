package in.iot.lab.acl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Advanced extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);

        //Initialize and Assign variables
        BottomNavigationView bottomNavigationView=findViewById(R.id.nav_view);

        //Set Advanced Selected
        bottomNavigationView.setSelectedItemId(R.id.navigation_advanced);

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

                        return true;
                    case R.id.navigation_dashboard:
                        startActivity(new Intent(getApplicationContext(),DashBoard.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}