package com.example.savedsharedpreference

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var saveButton: Button
    lateinit var applyTextButton: Button
    private var switch1: Switch? = null
    private var text: String? = null
    private var switchstatus = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textview)
        editText = findViewById(R.id.edittext)
        saveButton = findViewById(R.id.save_button)
        applyTextButton = findViewById(R.id.apply_text_button)
        switch1 = findViewById(R.id.switch1)
        applyTextButton.setOnClickListener(View.OnClickListener {
            textView.setText(editText.getText().toString())
        })
        saveButton.setOnClickListener(View.OnClickListener { saveData() })
        loadData()
        updateData()
    }

    fun saveData() {
        val sharedPreferences = getSharedPreferences("saved", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("Value", textView!!.text.toString())
        editor.putString("SWITCH1", switch1!!.isChecked.toString())
        editor.apply()
        Toast.makeText(this, "Data is saved", Toast.LENGTH_SHORT).show()
    }

    fun loadData() {
        val sharedPreferences = getSharedPreferences("saved", MODE_PRIVATE)
        text = sharedPreferences.getString("Value", "")
        switchstatus = sharedPreferences.getBoolean(switch1.toString(), false)
    }

    fun updateData() {
        textView!!.text = text
        switch1!!.isChecked = switchstatus
    }
}