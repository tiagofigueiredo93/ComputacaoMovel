package pt.tiago.computacaomovel

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

const val PARAM1_NAME = "nome"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, R.string.welcome, Toast.LENGTH_SHORT).show()
        val sharedPref: SharedPreferences = getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE)

        val soundValue = sharedPref.getBoolean(getString(R.string.sound), false)
        Log.d("***SHAREDPREF", "Read $soundValue")

        if(soundValue){
            findViewById<CheckBox>(R.id.checkBox).isChecked = true
        }

    }

    fun checkBoxClicked(view: View){
        if (view is CheckBox){

            val sharedPref: SharedPreferences = getSharedPreferences(
                    getString(R.string.preference_file_key), Context.MODE_PRIVATE)
            with(sharedPref.edit()){
                putBoolean(getString(R.string.sound), view.isChecked)
                commit()
            }
            Log.d("***SHAREDPREF", "Change to ${view.isChecked}")
        }
    }

    fun button2(view: View) {
        var editTextHello = findViewById<EditText>(R.id.editTextTextPersonName)
        Toast.makeText(this, editTextHello.text, Toast.LENGTH_SHORT).show()
        findViewById<TextView>(R.id.textView1).setText(editTextHello.text)

    }

    fun button1(view: View) {
        var editTextHello = findViewById<EditText>(R.id.editTextTextPersonName)
        val intent = Intent(this, MainActivity2::class.java).apply {
            putExtra(PARAM1_NAME, editTextHello.text.toString())
        }
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.create_new -> {
                Toast.makeText(this, "create_new", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.open -> {
                Toast.makeText(this, "open", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.opcao2 -> {
                Toast.makeText(this, "opção2", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.opcao3 -> {
                Toast.makeText(this, "opção3", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.opcao4 -> {
                Toast.makeText(this, "opção4", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
