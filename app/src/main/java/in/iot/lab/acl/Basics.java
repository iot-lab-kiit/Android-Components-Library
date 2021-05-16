package in.iot.lab.acl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import in.iot.lab.acl.adapters.GroupRvAdapters;
import in.iot.lab.acl.data.UiComponetsGroups;
import in.iot.lab.acl.utils.RvClickHandler;

public class Basics extends AppCompatActivity implements RvClickHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basics);

        //Initialize and Assign variables
        BottomNavigationView bottomNavigationView=findViewById(R.id.nav_view);
        ArrayList<String> groups=new ArrayList<>();
        ArrayList<String>logo=new ArrayList<>();
        GroupRvAdapters groupRvAdapters;
        RecyclerView recyclerView=findViewById(R.id.basic_rv);

        //Set Basic Selected
        bottomNavigationView.setSelectedItemId(R.id.navigation_basic);

        //Item Select Listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_basic:
                        return true;
                    case R.id.navigation_advanced:
                        startActivity(new Intent(getApplicationContext(),Advanced.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_dashboard:
                        startActivity(new Intent(getApplicationContext(),DashBoard.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        //Set Adapter
        groups= UiComponetsGroups.INSTANCE.getGroups();
        logo=UiComponetsGroups.INSTANCE.getLogo();

        groupRvAdapters=new GroupRvAdapters(groups,logo,getBaseContext(),this);
        recyclerView.setAdapter(groupRvAdapters);
        RecyclerView.LayoutManager manager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);



    }

    @Override
    public void onItemClick(int position) {

    }
}
