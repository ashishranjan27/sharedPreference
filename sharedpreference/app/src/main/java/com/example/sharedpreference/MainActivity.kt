package com.example.sharedpreference

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var editText: EditText
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        editText = findViewById(R.id.editName)
        textView = findViewById(R.id.textView)
        button.setOnClickListener(View.OnClickListener {
            val msg = editText.getText().toString()
            val shared = getSharedPreferences("demo", MODE_PRIVATE)
            val editor = shared.edit()
            editor.putString("str1", msg)
            editor.apply();
            textView.setText(msg);
        })
        val getshared = getSharedPreferences("demo", MODE_PRIVATE)
        val `val` = getshared.getString("str1", "save a default value")
        textView.setText(`val`)
    }
}


