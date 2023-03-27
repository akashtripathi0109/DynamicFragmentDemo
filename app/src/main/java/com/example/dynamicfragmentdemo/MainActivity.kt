package com.example.dynamicfragmentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    val fm: FragmentManager =supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickFirst(v: View){
        val ft=fm.beginTransaction()
        ft.add(R.id.frameLayout, BlankDynamicFragment())
        ft.addToBackStack(null)
        ft.commit()
    }

    fun onClickSecond(v: View){
        val ft=fm.beginTransaction()
        ft.add(R.id.frameLayout, BlankDynamicFragment2())
        ft.addToBackStack(null)
        ft.commit()
    }
}