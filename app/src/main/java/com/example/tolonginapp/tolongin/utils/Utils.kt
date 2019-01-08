package com.example.tolonginapp.tolongin.utils

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import com.example.tolonginapp.tolongin.utils.Constant.CommonString.Companion.EMPTY_STRING

fun Context.buildAlertDialog(title: String, message: String = EMPTY_STRING, yesButton: String = EMPTY_STRING, noButton: String = EMPTY_STRING, positiveAction: (DialogInterface) -> Unit = {}, negativeAction: (DialogInterface) -> Unit = {}): AlertDialog {
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
