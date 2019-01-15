package com.example.tolonginapp.tolongin.utils

import android.content.Context
import android.content.DialogInterface
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.util.Base64
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.tolonginapp.tolongin.R
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.COUNTRY
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.EMPTY_STRING
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.LANGUANGE
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.joda.time.format.DateTimeFormat
import java.io.ByteArrayOutputStream
import java.text.NumberFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun Context.buildAlertDialog(
    title: String,
    message: String = EMPTY_STRING,
    yesButton: String = EMPTY_STRING,
    noButton: String = EMPTY_STRING,
    positiveAction: (DialogInterface) -> Unit = {},
    negativeAction: (DialogInterface) -> Unit = {}
): AlertDialog {
    val builder = AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .setCancelable(false)

    if (yesButton.isNotEmpty()) {
        builder.setPositiveButton(yesButton, { dialog, _ -> positiveAction.invoke(dialog) })
    }

    if (noButton.isNotEmpty()) {
        builder.setNegativeButton(noButton, { dialog, _ -> negativeAction.invoke(dialog) })
    }

    return builder.create()
}

fun Context.showSnackBar(
    view: View, text: String, actionText: Int = android.R.string.ok,
    duration: Int = Snackbar.LENGTH_INDEFINITE,
    textColor: Int = ContextCompat.getColor(this, R.color.Red),
    onActionClick: () -> Unit = {}, dismissEvent: () -> Unit = {}
) {
    val snackbar = Snackbar.make(view, text, duration)
    snackbar.setAction(actionText) {
        onActionClick.invoke()
        snackbar.dismiss()
    }
    snackbar.setActionTextColor(ContextCompat.getColor(this, R.color.grey))
    snackbar.duration = Constant.CommonString.SNACKBAR_DURATION
    snackbar.view.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
    snackbar.view.findViewById<TextView>(android.support.design.R.id.snackbar_text).setTextColor(textColor)
    snackbar.show()
    snackbar.addCallback(object : Snackbar.Callback() {
        override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
            super.onDismissed(transientBottomBar, event)
            dismissEvent.invoke()
        }
    })
}

fun Button.setEnable(boolean: Boolean) {
    with(this) {
        isEnabled = boolean
        when {
            boolean -> {
                this.setBackgroundResource(R.drawable.rounded_button)
            }
            else -> {
                this.setBackgroundResource(R.drawable.rounded_button_disable)
            }
        }
    }
}

fun setCurrency(double: Double): String {
    val localeID = Locale(LANGUANGE, COUNTRY)
    val formatRP = NumberFormat.getCurrencyInstance(localeID)

    return formatRP.format(double).toString()
}


fun String.changeDateFormat(oldPattern: String, newPattern: String): String {
    var res = ""
    try {
        val oldFormat = DateTimeFormat.forPattern(oldPattern)
        val oldDateTime = oldFormat.parseDateTime(this)
        val newFormat = DateTimeFormat.forPattern(newPattern)
        val newDateTime = DateTime.parse(newFormat.print(oldDateTime), newFormat)
        res = newDateTime.toString(newPattern)
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return res
}

fun getTimeStamp(): String {
    return SimpleDateFormat("yyyyMMdd_Hmmss", Locale.getDefault()).format(Date())
}

fun ImageView.encodeBase64(): String {
    val byteArrayOutputStream = ByteArrayOutputStream()
    (this.drawable as BitmapDrawable).bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream)
    return Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT)
}