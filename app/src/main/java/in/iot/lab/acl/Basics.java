package in.iot.lab.acl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import in.iot.lab.acl.adapters.GroupRvAdapters;

public class Basics extends AppCompatActivity {

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
        groups.add("TextView");
        logo.add("https://www.bing.com/images/search?view=detailV2&ccid=%2fWZC4Yuv&id=AD16AE2BAA99F7208EC757A71F35C072610EE6E8&thid=OIP._WZC4YuvUa0WB4Ac177KnQHaNK&mediaurl=https%3a%2f%2fth.bing.com%2fth%2fid%2fRfd6642e18baf51ad1607801cd7beca9d%3frik%3d6OYOYXLANR%252bnVw%26riu%3dhttp%253a%252f%252fmedia.idownloadblog.com%252fwp-content%252fuploads%252f2014%252f10%252fiOS-8-Messages-Text-Message-Forwarding-002.png%26ehk%3dh604Yiibz4FbXWZVhEyKQ6%252f34kIUui0y%252fBbZIfm2tIY%253d%26risl%3d%26pid%3dImgRaw&exph=2208&expw=1242&q=text&simid=607999547639361465&ck=EBC520BF8F3788D66CF3AD51A698E243&selectedIndex=16&FORM=IRPRST");
        groups.add("Image");
        logo.add("https://www.bing.com/images/search?view=detailV2&ccid=%2fWZC4Yuv&id=AD16AE2BAA99F7208EC757A71F35C072610EE6E8&thid=OIP._WZC4YuvUa0WB4Ac177KnQHaNK&mediaurl=https%3a%2f%2fth.bing.com%2fth%2fid%2fRfd6642e18baf51ad1607801cd7beca9d%3frik%3d6OYOYXLANR%252bnVw%26riu%3dhttp%253a%252f%252fmedia.idownloadblog.com%252fwp-content%252fuploads%252f2014%252f10%252fiOS-8-Messages-Text-Message-Forwarding-002.png%26ehk%3dh604Yiibz4FbXWZVhEyKQ6%252f34kIUui0y%252fBbZIfm2tIY%253d%26risl%3d%26pid%3dImgRaw&exph=2208&expw=1242&q=text&simid=607999547639361465&ck=EBC520BF8F3788D66CF3AD51A698E243&selectedIndex=16&FORM=IRPRST");
        groups.add("View");
        logo.add("https://www.bing.com/images/search?view=detailV2&ccid=%2fWZC4Yuv&id=AD16AE2BAA99F7208EC757A71F35C072610EE6E8&thid=OIP._WZC4YuvUa0WB4Ac177KnQHaNK&mediaurl=https%3a%2f%2fth.bing.com%2fth%2fid%2fRfd6642e18baf51ad1607801cd7beca9d%3frik%3d6OYOYXLANR%252bnVw%26riu%3dhttp%253a%252f%252fmedia.idownloadblog.com%252fwp-content%252fuploads%252f2014%252f10%252fiOS-8-Messages-Text-Message-Forwarding-002.png%26ehk%3dh604Yiibz4FbXWZVhEyKQ6%252f34kIUui0y%252fBbZIfm2tIY%253d%26risl%3d%26pid%3dImgRaw&exph=2208&expw=1242&q=text&simid=607999547639361465&ck=EBC520BF8F3788D66CF3AD51A698E243&selectedIndex=16&FORM=IRPRST");
        groups.add("Icons");
        logo.add("https://www.bing.com/images/search?view=detailV2&ccid=%2fWZC4Yuv&id=AD16AE2BAA99F7208EC757A71F35C072610EE6E8&thid=OIP._WZC4YuvUa0WB4Ac177KnQHaNK&mediaurl=https%3a%2f%2fth.bing.com%2fth%2fid%2fRfd6642e18baf51ad1607801cd7beca9d%3frik%3d6OYOYXLANR%252bnVw%26riu%3dhttp%253a%252f%252fmedia.idownloadblog.com%252fwp-content%252fuploads%252f2014%252f10%252fiOS-8-Messages-Text-Message-Forwarding-002.png%26ehk%3dh604Yiibz4FbXWZVhEyKQ6%252f34kIUui0y%252fBbZIfm2tIY%253d%26risl%3d%26pid%3dImgRaw&exph=2208&expw=1242&q=text&simid=607999547639361465&ck=EBC520BF8F3788D66CF3AD51A698E243&selectedIndex=16&FORM=IRPRST");

        groupRvAdapters=new GroupRvAdapters(groups,logo);
        recyclerView.setAdapter(groupRvAdapters);
        RecyclerView.LayoutManager manager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);



    }
}
