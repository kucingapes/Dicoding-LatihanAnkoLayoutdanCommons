package com.kucingapes.latihanankolayoutdancommons

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                padding = dip(16)

                val name = editText { hint = "What's yur name" }

                button("Say Helo") {
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        alert("Happi coding, Hello ${name.text}") {
                            yesButton { toast("Oh") }
                            noButton { }
                        }.show()
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }

                button("Show selector") {
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        val club = listOf("Barcelona", "Madrid", "Munchen", "Liverpool")
                        selector("Hello ${name.text}! What's football club do you love?",
                                club) { _, i ->
                            toast("So you love ${club[i]}, right?")

                        }
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }

                button("Show Snackbar") {
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        snackbar("Hellow ${name.text}")
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }

                button("Show progressbar") {
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        indeterminateProgressDialog("Hello ${name.text}!, please wait").show()
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }

                button("Go to second activity") {
                    backgroundColor = ContextCompat.getColor(context, R.color.colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        startActivity<SecondActivity>("name" to "${name.text}")
                    }
                }.lparams(width = matchParent) {
                    topMargin = dip(5   )
                }
            }
        }
    }
}
