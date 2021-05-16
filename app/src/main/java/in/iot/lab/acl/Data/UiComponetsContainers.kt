package `in`.iot.lab.acl.data

import java.util.ArrayList

object UiComponetsContainers {
    var containers = ArrayList<String>()
    var logo = ArrayList<String>()

    init{
        containers.add("Spinner")
        containers.add("Recycler View")
        containers.add("Scroll View")
        containers.add("Horizontal Scroll View")
        containers.add("Nested Scroll View")
        containers.add("Card View")
    }

    @JvmName("getContainers1")
    fun getContainers():ArrayList<String>{
        return containers;
    }
    @JvmName("getLogo1")
    fun getLogo(): ArrayList<String> {
        return logo;
    }
}