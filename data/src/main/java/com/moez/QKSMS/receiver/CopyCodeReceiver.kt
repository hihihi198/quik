package dev.octoshrimpy.quik.receiver

import android.content.BroadcastReceiver
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import dagger.android.AndroidInjection
import javax.inject.Inject

class CopyCodeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        AndroidInjection.inject(this, context)
        val code = intent.getStringExtra("code") ?: return
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipboard.setPrimaryClip(ClipData.newPlainText("Verification code", code))
    }
}
