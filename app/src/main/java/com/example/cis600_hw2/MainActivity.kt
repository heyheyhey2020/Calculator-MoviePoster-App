package com.example.cis600_hw2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(myToolbar)
        val appBar = supportActionBar
        appBar!!.title = "Tasks"
        appBar.setDisplayHomeAsUpEnabled(true)
        appBar.setDisplayUseLogoEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.mainmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId){
            R.id.action_task1 -> {
                Toast.makeText(this, "task1 item has been clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_task2 -> {
                val intent : Intent = Intent(this,task2::class.java).apply {
                }
                startActivity(intent)
            }
            R.id.action_task3 -> {
                Toast.makeText(this, "task3 item has been clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_task4 -> {
                val intent : Intent = Intent(this,task4::class.java).apply {
                }
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}