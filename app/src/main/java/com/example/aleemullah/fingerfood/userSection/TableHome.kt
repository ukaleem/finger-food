package com.example.aleemullah.fingerfood.userSection

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.aleemullah.fingerfood.R
import kotlinx.android.synthetic.main.activity_table_home.*

class TableHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_home)

        //Get Extra Data passed by activitys

        val mintent = intent

        //get tableId and Table name from the database
        val thisTableId = mintent.getStringExtra("MyTableId")
        val thisTableName = mintent.getStringExtra("MyTableName")


        if (thisTableId != "" || thisTableName!= "") {
            holdTblIdTxt.text = "$thisTableName"
        }

        //set click listener to move the activity to the quick order

        quickorder.setOnClickListener {
            val intent = Intent(this,QuickHome::class.java)
            intent.putExtra("tableId",thisTableId)
            intent.putExtra("tableName",thisTableName)
            startActivity(intent)
        }

        //set click listener to move the activity to the Customize Pizza

        customizePizza.setOnClickListener {
            val intent = Intent(this,CustomizePizza::class.java)
            intent.putExtra("TABLE_ID",mintent.getStringExtra("MyTableId"))
            intent.putExtra("TABLE_NAME",mintent.getStringExtra("MyTableName"))
            startActivity(intent)
        }
    }
}
