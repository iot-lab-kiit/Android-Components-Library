package in.iot.lab.acl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import in.iot.lab.acl.adapters.GroupRvAdapters;
import in.iot.lab.acl.data.UiComponetsButton;
import in.iot.lab.acl.data.UiComponetsContainers;
import in.iot.lab.acl.data.UiComponetsDerived;
import in.iot.lab.acl.data.UiComponetsGroups;
import in.iot.lab.acl.data.UiComponetsLayouts;
import in.iot.lab.acl.data.UiComponetsText;
import in.iot.lab.acl.data.UiComponetsWidgets;
import in.iot.lab.acl.utils.RvClickHandler;

public class RvSubGrpPage extends AppCompatActivity implements RvClickHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_sub_grp_page);

        //Initialize and Assign variables
        RecyclerView recyclerView=findViewById(R.id.extended_rv);
        GroupRvAdapters groupRvAdapters;
        ArrayList<String> groups=new ArrayList<>();
        ArrayList<String>logo=new ArrayList<>();

        //Receiving extra from activity call
        Intent intent = getIntent();
        String grp= intent.getStringExtra("GRP");
        Log.d("intent"," "+grp);



        //Getting data
        switch (grp){
            case "Text":
                groups= UiComponetsText.INSTANCE.getText();
                logo=UiComponetsText.INSTANCE.getLogo();
                break;
            case "Button":
                groups= UiComponetsButton.INSTANCE.getButtonNames();
                logo=UiComponetsButton.INSTANCE.getLogo();
                break;
            case "Widgets/Views":
                groups= UiComponetsWidgets.INSTANCE.getWidgetsNames();
                logo=UiComponetsWidgets.INSTANCE.getLogo();
                break;
            case "Layouts":
                groups= UiComponetsLayouts.INSTANCE.getLayoutsNames();
                logo=UiComponetsLayouts.INSTANCE.getLogo();
                break;
            case "Derived Components":
                groups= UiComponetsDerived.INSTANCE.getComponents();
                logo=UiComponetsDerived.INSTANCE.getLogo();
                break;
            case "Containers":
                groups= UiComponetsContainers.INSTANCE.getContainers();
                logo=UiComponetsContainers.INSTANCE.getLogo();
                break;
        }

//        groups= UiComponetsText.INSTANCE.getText();
//        logo=UiComponetsText.INSTANCE.getLogo();


        //Set Adapter
        groupRvAdapters=new GroupRvAdapters(groups,logo,getBaseContext(),this);
        recyclerView.setAdapter(groupRvAdapters);
        RecyclerView.LayoutManager manager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);


    }

    @Override
    public void onItemClick(int position) {

    }
}