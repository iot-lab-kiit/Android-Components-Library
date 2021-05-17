package `in`.iot.lab.acl.data

import java.util.ArrayList

object UiComponetsText {
    var text = ArrayList<String>()
    var logo = ArrayList<String>()

    init{
        text.add("Text View")
        text.add("Edit Text")
        text.add("Toast")
    }
    @JvmName("getText1")
    fun getText():ArrayList<String>{
        return text;
    }
    @JvmName("getLogo1")
    fun getLogo(): ArrayList<String> {
        return logo;
    }
}