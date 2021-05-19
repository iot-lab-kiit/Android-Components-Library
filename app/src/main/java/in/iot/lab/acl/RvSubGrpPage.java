package in.iot.lab.acl;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import in.iot.lab.acl.adapters.GroupRvAdapters;
import in.iot.lab.acl.data.UiComponetsButton;
import in.iot.lab.acl.data.UiComponetsContainers;
import in.iot.lab.acl.data.UiComponetsDerived;
import in.iot.lab.acl.data.UiComponetsLayouts;
import in.iot.lab.acl.data.UiComponetsText;
import in.iot.lab.acl.data.UiComponetsWidgets;
import in.iot.lab.acl.utils.RvClickHandler;
import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.adapters.Options;
import io.github.kbiakov.codeview.highlight.ColorTheme;
import io.github.kbiakov.codeview.highlight.Font;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class RvSubGrpPage extends AppCompatActivity implements RvClickHandler {

    RecyclerView recyclerView;
    FrameLayout fragView;
    ArrayList<String> groups = new ArrayList<>();
    ArrayList<String> logo = new ArrayList<>();
    CodeView codeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_sub_grp_page);

        //Initialize and Assign variables
        recyclerView = findViewById(R.id.extended_rv_button);
        fragView = findViewById(R.id.fragment_view);
        codeView = (CodeView) findViewById(R.id.code_view);


        //Receiving extra from activity call
        Intent intent = getIntent();
        String grp = intent.getStringExtra("GRP");
        Log.d("intent", " " + grp);


        //Getting data
//        switch (grp) {
//            case "Text":
//                groups = UiComponetsText.INSTANCE.getText();
//                logo = UiComponetsText.INSTANCE.getLogo();
//                break;
//            case "Button":
//                groups = UiComponetsButton.INSTANCE.getButtonNames();
//                logo = UiComponetsButton.INSTANCE.getLogo();
//                break;
//            case "Widgets/Views":
//                groups = UiComponetsWidgets.INSTANCE.getWidgetsNames();
//                logo = UiComponetsWidgets.INSTANCE.getLogo();
//                break;
//            case "Layouts":
//                groups = UiComponetsLayouts.INSTANCE.getLayoutsNames();
//                logo = UiComponetsLayouts.INSTANCE.getLogo();
//                break;
//            case "Derived Components":
//                groups = UiComponetsDerived.INSTANCE.getComponents();
//                logo = UiComponetsDerived.INSTANCE.getLogo();
//                break;
//            case "Containers":
//                groups = UiComponetsContainers.INSTANCE.getContainers();
//                logo = UiComponetsContainers.INSTANCE.getLogo();
//                break;
//        }
//
//        //Set Adapter
//        groupRvAdapters = new GroupRvAdapters(groups, logo, getBaseContext(), this);
//        recyclerView.setAdapter(groupRvAdapters);
//        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 2);
//        recyclerView.setLayoutManager(manager);


    }

    @Override
    public void onItemClick(int position) {
        recyclerView.setVisibility(View.GONE);
        fragView.setVisibility(View.VISIBLE);
        codeView.setVisibility(View.VISIBLE);
        changeFragment(groups.get(position));

    }

    public void changeFragment(String str) {
        Fragment fragment;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();


        switch (str) {
            case "Text View":
                fragment = new textView();
                fragmentTransaction.replace(R.id.fragment_view, fragment);
                fragmentTransaction.addToBackStack("Text View Frag");
                fragmentTransaction.commit();
                codeView.setCode("" +
                        "<TextView/n" +
                        "android:layout_width=" + "match_parent/n" +
                        "android:layout_height=" + "wrap_content/n" +
                        "android:text=" + "Text View/n" +
                        "android:textSize=" + "40sp/n" +
                        "android:textAlignment=" + "center/n" +
                        "android:layout_marginTop=" + "10dp/n" +
                        "/>", "xml");
                codeView.updateOptions(new Function1<Options, Unit>() {
                    @Override
                    public Unit invoke(Options options) {
                        options.withFont(Font.Consolas)
                                .withTheme(ColorTheme.SOLARIZED_LIGHT)
                                .withShadows()
                                .setShortcut(false);
                        return null;
                    }
                });

                break;
            case "Edit Text":
                fragment = new EditText();
                fragmentTransaction.replace(R.id.fragment_view, fragment);
                fragmentTransaction.addToBackStack("Edit Text Frag");
                fragmentTransaction.commit();
                break;
        }


    }

    @Override
    public void onBackPressed() {
        if (fragView.getVisibility() == View.VISIBLE) {
            fragView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            codeView.setVisibility(View.GONE);
        }
        super.onBackPressed();
    }
}