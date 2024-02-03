package com.example.imagetopdf

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.imagetopdf.BaseObject.getMarginPosition
import com.example.imagetopdf.BaseObject.getPageMarginNameList
import com.example.imagetopdf.BaseObject.getPageSizeNameList
import com.example.imagetopdf.BaseObject.getPageSizePosition
import com.example.imagetopdf.BaseObject.setMarginPosition
import com.example.imagetopdf.BaseObject.setPageSizePosition


class SettingActivity : AppCompatActivity() {

    private lateinit var textPageSize: TextView
    private lateinit var textMargin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        supportActionBar?.title = "Settings"

        textPageSize = findViewById(R.id.textPageSize)
        textMargin = findViewById(R.id.textMargin)

        textPageSize.text =
            "Page size: ${getPageSizeNameList()[getPageSizePosition(this)]}"
        textMargin.text =
            "PDF Page Margin: ${getPageMarginNameList()[getMarginPosition(this)]}"

    }

    fun listenerMethod(view: View) {
        when (view.id) {
            R.id.pageSize -> {
                showPageSizeDialog()
            }
            R.id.pageMargin -> {
                showMarginDialog()
            }
        }
    }

    private fun showPageSizeDialog() {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        alertDialog.setTitle("PDF Page Size")

        alertDialog.setSingleChoiceItems(
            getPageSizeNameList(),
         getPageSizePosition(this@SettingActivity)
        ) { dialog, which ->
            dialog.dismiss()
            setPageSizePosition(this@SettingActivity, which)
            textPageSize.text = "Page size: ${getPageSizeNameList()[which]}"
//            Toast.makeText(this, itemsPageSize[which], Toast.LENGTH_LONG).show()
        }
        val alert: AlertDialog = alertDialog.create()
        alert.setCanceledOnTouchOutside(true)
        alert.show()
    }

    private fun showMarginDialog() {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        alertDialog.setTitle("PDF Page Size")

        alertDialog.setSingleChoiceItems(
            getPageMarginNameList(),
            getMarginPosition(this@SettingActivity)
        ) { dialog, which ->
            dialog.dismiss()
            setMarginPosition(this@SettingActivity, which)
            textMargin.text = "PDF Page Margin: ${getPageMarginNameList()[which]}"
//            Toast.makeText(this, itemsMargin[which], Toast.LENGTH_LONG).show()
        }
        val alert: AlertDialog = alertDialog.create()
        alert.setCanceledOnTouchOutside(true)
        alert.show()
    }
}