package `in`.iot.lab.acl.data

import java.util.ArrayList

object UiComponetsDerived {
    var components = ArrayList<String>()
    var logo = ArrayList<String>()

    init{
        components.add("Auto Complete Textview")
        components.add("Image Switcher")
        components.add("Text Switcher")
        components.add("Alert Dialog")
        components.add("Fragment Container View")
    }

    @JvmName("getComponents1")
    fun getComponents():ArrayList<String>{
        return components;
    }
    @JvmName("getLogo1")
    fun getLogo(): ArrayList<String> {
        return logo;
    }
}