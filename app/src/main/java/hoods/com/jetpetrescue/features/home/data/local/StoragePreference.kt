package hoods.com.jetpetrescue.features.home.data.local

import android.content.Context
import hoods.com.jetpetrescue.R
import hoods.com.jetpetrescue.features.home.data.local.LocalConstants.USER_TOKEN

class StoragePreference(context: Context) {
    private val preference = context.getSharedPreferences(
        context.getString(R.string.app_name),
        Context.MODE_PRIVATE,
    )

    fun getToken(): String = preference.getString(USER_TOKEN, null) ?: ""

    fun saveToken(token: String?) {
        preference.edit().apply {
            putString(USER_TOKEN, token)
            apply()
        }
    }

}