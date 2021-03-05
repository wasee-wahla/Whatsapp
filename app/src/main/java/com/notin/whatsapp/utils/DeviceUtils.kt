package com.notin.whatsapp.utils

import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.util.Log
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

object DeviceUtils {
    fun Context.isNetworkAvailable(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return if (netInfo != null && !netInfo.isConnected) {
            true
        } else {
            showErrorToast("Internet is not Available!")
            false
        }
    }

    fun Context.showErrorToast(message: String?) {

        val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
        val textView = toast.view?.findViewById(android.R.id.message) as? TextView
        textView?.setTextColor(Color.WHITE)
        textView?.gravity = Gravity.CENTER
        toast.view?.setBackgroundColor(Color.RED)
        toast.setGravity(Gravity.TOP or Gravity.FILL_HORIZONTAL, 0, 0)
        toast.show()
        Log.d("ERROR","ERRORRRRR")
    }
}