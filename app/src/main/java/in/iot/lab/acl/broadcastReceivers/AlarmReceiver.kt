package `in`.iot.lab.acl.broadcastReceivers

import `in`.iot.lab.acl.R
import `in`.iot.lab.acl.SubBackend.fragment_backend__sub__AlarmManager
import `in`.iot.lab.acl.home.MainActivity
import android.app.Activity
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val i = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        val pendingIntent = PendingIntent.getActivity(context, 0, i,0)

        val builder = NotificationCompat.Builder(context, "acl")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Android Components Library")
            .setContentText("Sample alarm notification")
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_SOUND)
            .setContentIntent(pendingIntent)

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(101, builder.build())
    }
}