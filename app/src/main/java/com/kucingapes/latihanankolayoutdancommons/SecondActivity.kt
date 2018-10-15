/*
 * SecondActivity.kt on LatihanAnkoLayoutdanCommons
 * Developed by Muhammad Utsman on 10/15/18 9:30 PM
 * Last modified 10/15/18 9:30 PM
 * Copyright (c) 2018 kucingapes
 */

package com.kucingapes.latihanankolayoutdancommons

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import org.jetbrains.anko.dip
import org.jetbrains.anko.padding
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

class SecondActivity : AppCompatActivity() {
    private var name: String = ""
    private lateinit var nameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            padding = dip(16)
            nameTextView = textView()
        }

        name = intent.getStringExtra("name")
        nameTextView.text = name
    }
}