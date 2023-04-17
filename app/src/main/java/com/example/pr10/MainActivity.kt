package com.example.pr10

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText

const val TABLE="TABLE"
const val CHECKK = "KEY4"
class MainActivity : AppCompatActivity() {
    var preff: SharedPreferences?=null
    lateinit var mail: EditText
    lateinit var pass: EditText
    lateinit var check: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mail = findViewById(R.id.mail)
        pass = findViewById(R.id.pass)
        check = findViewById(R.id.checkBox)
        preff = getSharedPreferences("TABLEE", MODE_PRIVATE)
        check.isChecked=preff?.getBoolean("key3", false)?:false
        mail.setText(preff?.getString(CHECKK, ""))
        pass.setText(preff?.getString("key2", ""))
    }
    fun savestate(check:Boolean)
    {
        val editor = preff?.edit()
        editor?.putBoolean("key3", check)
        editor?.apply()
    }
    fun saveData(mail:String, pass:String){
        val editor=preff?.edit()
        editor?.putString(CHECKK, mail)
        editor?.putString("key2",pass)
        editor?.apply()
    }
    fun deleteAll()
    {
        val editor=preff?.edit()
        editor?.clear()
        editor?.apply()
    }
    fun save22(view: View){
        val value:String=mail.text.toString()
        val value2:String=pass.text.toString()
        val checkboxstate:Boolean=check.isChecked
        if(checkboxstate==true)
        {
            saveData(value, value2)
            savestate(checkboxstate)
        }
        else
        {
            deleteAll()
        }
        val intent = Intent(this@MainActivity, MainActivity2::class.java)
        startActivity(intent)
        finish()
    }
}