package `in`.iot.lab.acl.data

import java.util.ArrayList

object UiComponetsWidgets {
    var views = ArrayList<String>()
    var logo = ArrayList<String>()

    init{
        views.add("Image View")
        views.add("Web View")
        views.add("Video View")
        views.add("Calendar View")
        views.add("Progress Bar(Spiral)")
        views.add("Progress Bar(Horizontal)")
        views.add("Seek Bar")
        views.add("Seek Bar(Discrete)")
        views.add("Star Rating")
        views.add("Search View")
        views.add("Texture View")
        views.add("Surface View")
    }

    fun getWidgetsNames():ArrayList<String>{
        return views;
    }
    @JvmName("getLogo1")
    fun getLogo(): ArrayList<String> {
        return logo;
    }

}