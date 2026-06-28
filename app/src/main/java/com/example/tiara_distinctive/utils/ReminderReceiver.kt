package com.example.tiara_distinctive.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class ReminderReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val title = intent.getStringExtra("title") ?: "Agenda Desa"
        val message = intent.getStringExtra("message") ?: "Jangan lupa kegiatan"
        val target = intent.getStringExtra("target_activity")

        // Menggunakan refleksi Class.forName agar target Activity dinamis
        val targetIntent = if (target != null) {
            Intent(context, Class.forName(target)).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
        } else {
            // Fallback default jika target null, mengarah ke MainActivity bawaan package Anda
            Intent(context, Class.forName("com.example.tiara_distinctive.MainActivity"))
        }

        NotificationHelper.showNotification(
            context,
            title,
            message,
            targetIntent
        )
    }
}