package `in`.iot.lab.acl.data

import java.util.ArrayList

object UiComponetsLayouts {

    var layouts = ArrayList<String>()
    var logo = ArrayList<String>()

    init{
        layouts.add("Constraint Layout")
        layouts.add("Linear Layout(Horizontal)")
        layouts.add("Constraint Layout(Vertical)")
        layouts.add("Frame Layout")
        layouts.add("Table Layout")
    }

    fun getLayoutsNames():ArrayList<String>{
        return layouts;
    }
    @JvmName("getLogo1")
    fun getLogo(): ArrayList<String> {
        return logo;
    }
}