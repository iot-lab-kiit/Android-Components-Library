package `in`.iot.lab.acl.SubBackend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.iot.lab.acl.R
import `in`.iot.lab.acl.broadcastReceivers.AlarmReceiver
import `in`.iot.lab.acl.databinding.FragmentBackendSubAlarmManagerBinding
import android.app.*
import android.content.Context
import android.content.Context.ALARM_SERVICE
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import io.noties.markwon.Markwon
import java.util.*

open class fragment_backend__sub__AlarmManager : Fragment() {
    private lateinit var binding: FragmentBackendSubAlarmManagerBinding
    private lateinit var calendar: Calendar
    private lateinit var alarmManager: AlarmManager
    private lateinit var pendingIntent: PendingIntent

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBackendSubAlarmManagerBinding.inflate(layoutInflater)

        // Getting calendar instance
        calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, Calendar.MINUTE + 1)
        }

        // Create notification channel
        createNotificationChannel()

        val currentMinutePlusTwo: Int = calendar.get(Calendar.MINUTE + 2)

        binding.setAlarmBtn.setOnClickListener {
            if (binding.alarmStatusText.text == "Alarm is off") {
                setAlarm()
            } else {
                Toast.makeText(context as Activity, "Alarm is already on", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        if (calendar.get(Calendar.MINUTE) == currentMinutePlusTwo) {
            cancelAlarm()
        }

        val md = """
            #Basic Info
            ```text
            In this demo, alarm is set and invoked for the next minute and it is automatically cancelled after the next minute of being invoked.
            
            We need to achieve three basic things in order to successfully implement the Alarm functionality:
            a) Create an object of AlarmManager class and using ALARM_SERVICE invoke the desired alarm type.
            b) Create a notification channel to provide notification whenever the alarm is invoked.
            c) Create a Broadcast Receiver which will call the onReceive() method and execute the code.
            
            NOTE: Many changes can be done after the above tasks are fulfilled in order to improve the quality of the alarm(like adding a Time Picker). 
                  Please refer the documentation for more information.
            ```
            #XML
            ```xml
            <Button
                android:id="@+id/setAlarmBtn"
                android:layout_width="160dp"
                android:layout_height="wrap_content"
                android:text="Set Alarm"
                android:textSize="14sp"
                android:layout_marginTop="8dp"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/alarmStatusText" />
        
            <TextView
                android:id="@+id/alarmStatusText"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Alarm is off"
                android:textColor="@color/black"
                android:textSize="18sp"
                android:layout_marginTop="36dp"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toTopOf="parent" />
            ```
            #Kotlin: AlarmManager Fragment
            ```kotlin
            open class fragment_backend__sub__AlarmManager : Fragment() {
                private lateinit var binding: FragmentBackendSubAlarmManagerBinding
                private lateinit var calendar: Calendar
                private lateinit var alarmManager: AlarmManager
                private lateinit var pendingIntent: PendingIntent
            
                override fun onCreateView(
                    inflater: LayoutInflater, container: ViewGroup?,
                    savedInstanceState: Bundle?
                ): View? {
                    // Inflate the layout for this fragment
                    binding = FragmentBackendSubAlarmManagerBinding.inflate(layoutInflater)
            
                    // Getting calendar instance
                    calendar = Calendar.getInstance().apply {
                        timeInMillis = System.currentTimeMillis()
                        set(Calendar.HOUR_OF_DAY, Calendar.MINUTE + 1)
                    }
            
                    // Create notification channel
                    createNotificationChannel()
            
                    val currentMinutePlusTwo: Int = calendar.get(Calendar.MINUTE + 2)
            
                    binding.setAlarmBtn.setOnClickListener {
                        if (binding.alarmStatusText.text == "Alarm is off") {
                            setAlarm()
                        } else {
                            Toast.makeText(context as Activity, "Alarm is already on", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
            
                    if (calendar.get(Calendar.MINUTE) == currentMinutePlusTwo) {
                        cancelAlarm()
                    }
                    return binding.root
                }
                
                private fun createNotificationChannel() {
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        val name: CharSequence = "ACLReminderChannel"
                        val description = "Channel for Alarm Manager"
                        val importance = NotificationManager.IMPORTANCE_HIGH
                        val channel = NotificationChannel("acl", name, importance)
                        channel.description = description
            
                        val notificationManager = context?.getSystemService(NotificationManager::class.java)
            
                        notificationManager!!.createNotificationChannel(channel)
                    }
                }
            
                private fun setAlarm() {
                    alarmManager = context?.getSystemService(ALARM_SERVICE) as AlarmManager
                    val intent = Intent(context as Activity, AlarmReceiver::class.java)
            
                    pendingIntent = PendingIntent.getBroadcast(context as Activity, 0, intent, 0)
            
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        alarmManager.setExactAndAllowWhileIdle(
                            AlarmManager.RTC_WAKEUP,
                            calendar.timeInMillis,
                            pendingIntent
                        )
                    }
            
                    setAlarmStatus("Alarm is on")
                    Toast.makeText(context as Activity, "Alarm Set successfully", Toast.LENGTH_SHORT).show()
                }
            
                private fun cancelAlarm() {
                    alarmManager = context?.getSystemService(ALARM_SERVICE) as AlarmManager
                    val intent = Intent(context as Activity, AlarmReceiver::class.java)
            
                    pendingIntent = PendingIntent.getBroadcast(context as Activity, 0, intent, 0)
            
                    alarmManager.cancel(pendingIntent)
            
                    setAlarmStatus("Alarm is off")
                    Toast.makeText(context as Activity, "Alarm Cancelled", Toast.LENGTH_SHORT).show()
                }
            
                private fun setAlarmStatus(alarm_status: String) {
                    binding.alarmStatusText.text = alarm_status
                }
            }
            ```
            #Kotlin: AlarmReceiver
            ```kotlin
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
            ```
        """.trimIndent()

        val markwon = Markwon.builder(requireContext()).build()

        markwon.setMarkdown(binding.codeAlarmManager, md)


        return binding.root
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = "ACLReminderChannel"
            val description = "Channel for Alarm Manager"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("acl", name, importance)
            channel.description = description

            val notificationManager = context?.getSystemService(NotificationManager::class.java)

            notificationManager!!.createNotificationChannel(channel)
        }
    }

    private fun setAlarm() {
        alarmManager = context?.getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(context as Activity, AlarmReceiver::class.java)

        pendingIntent = PendingIntent.getBroadcast(context as Activity, 0, intent, 0)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                pendingIntent
            )
        }

        setAlarmStatus("Alarm is on")
        Toast.makeText(context as Activity, "Alarm Set successfully", Toast.LENGTH_SHORT).show()
    }

    private fun cancelAlarm() {
        alarmManager = context?.getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(context as Activity, AlarmReceiver::class.java)

        pendingIntent = PendingIntent.getBroadcast(context as Activity, 0, intent, 0)

        alarmManager.cancel(pendingIntent)

        setAlarmStatus("Alarm is off")
        Toast.makeText(context as Activity, "Alarm Cancelled", Toast.LENGTH_SHORT).show()
    }

    private fun setAlarmStatus(alarm_status: String) {
        binding.alarmStatusText.text = alarm_status
    }
}