package hoods.com.jetpetrescue.core.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast


fun openUrl(
    context: Context,
    url: String?,
) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    try {
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
    }
}