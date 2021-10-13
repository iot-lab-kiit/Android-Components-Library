package `in`.iot.lab.acl.SubAdvanced

import `in`.iot.lab.acl.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.noties.markwon.Markwon
import kotlinx.android.synthetic.main.fragment_adv__sub___circle_menu_view.*


class fragment_adv__sub__CircleMenuView : Fragment() {
    lateinit var code_circle_menu: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_adv__sub___circle_menu_view, container, false)

        code_circle_menu = view.findViewById(R.id.code_circle_menu)

        val md = """
            #XML
            ```xml
            <com.ramotion.circlemenu.CircleMenuView
                android:id="@+id/circleMenuView"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                app:button_colors="@array/colors"
                app:button_icons="@array/icons"
                android:layout_marginTop="16dp"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/textView" />
            ```
            #Gradle
            ```
            implementation 'com.ramotion.circlemenu:circle-menu:0.3.2'
            ```
            #Java
            ```java
            final CircleMenuView menu = (CircleMenuView) findViewById(R.id.circle_menu);
            menu.setEventListener(new CircleMenuView.EventListener() {
                @Override
                public void onMenuOpenAnimationStart(@NonNull CircleMenuView view) {
                    Log.d("D", "onMenuOpenAnimationStart");
                }

                @Override
                public void onMenuOpenAnimationEnd(@NonNull CircleMenuView view) {
                    Log.d("D", "onMenuOpenAnimationEnd");
                }

                @Override
                public void onMenuCloseAnimationStart(@NonNull CircleMenuView view) {
                    Log.d("D", "onMenuCloseAnimationStart");
                }

                @Override
                public void onMenuCloseAnimationEnd(@NonNull CircleMenuView view) {
                    Log.d("D", "onMenuCloseAnimationEnd");
                }

                @Override
                public void onButtonClickAnimationStart(@NonNull CircleMenuView view, int index) {
                    Log.d("D", "onButtonClickAnimationStart| index: " + index);
                }

                @Override
                public void onButtonClickAnimationEnd(@NonNull CircleMenuView view, int index) {
                    Log.d("D", "onButtonClickAnimationEnd| index: " + index);
                }
            });
            ```
            #Github Link
            ```text
            https://github.com/Ramotion/circle-menu-android
            ```
        """.trimIndent()

        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(code_circle_menu, md)

        return view
    }
}