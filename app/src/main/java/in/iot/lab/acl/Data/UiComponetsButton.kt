package `in`.iot.lab.acl.data

import java.util.*
import kotlin.collections.ArrayList

object UiComponetsButton {
    var buttons = ArrayList<String>()
    var logo = ArrayList<String>()

    init {
        buttons.add("Toggle Button")
        buttons.add("Image Button")
        buttons.add("Radio Button")
        buttons.add("Switch")
        buttons.add("Checkbox")
        buttons.add("Floating Action Button")
    }

    fun getButtonNames():ArrayList<String>{
        return buttons;
    }
    @JvmName("getLogo1")
    fun getLogo(): ArrayList<String> {
        return UiComponetsGroups.logo;
    }
}