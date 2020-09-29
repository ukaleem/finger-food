package com.example.aleemullah.fingerfood.userSection

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.aleemullah.fingerfood.R
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_get_started.*
import java.io.IOException

class GetStarted : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)
        try {
            //pre_Activ mean's Previous_Activity(LoginTable)
            // that's Hold the previous Activity Extra data Like .MyTableId and .MyTableName
            val pre_Activ = intent

            //To check that data from pre_Activ Came or not
            if (pre_Activ.hasExtra("com.example.aleemullah.fingerfood.userSection.MyTableId") &&
                pre_Activ.hasExtra("com.example.aleemullah.fingerfood.userSection.MyTableName")
            ) {
                val TableId = pre_Activ.getStringExtra("com.example.aleemullah.fingerfood.userSection.MyTableId")
                val TableName = pre_Activ.getStringExtra("com.example.aleemullah.fingerfood.userSection.MyTableName")

                //GET Started OnClickListener
                getBtn.setOnClickListener(View.OnClickListener {
                    //Move to new activity (TableHome) + PutExtras Variables MyTableId and MyTableName
                    val newintent = Intent(this, TableHome::class.java)
                    newintent.putExtra("MyTableId", TableId)
                    newintent.putExtra("MyTableName", TableName)
                    startActivity(newintent)
                })
            } else {
                Toasty.error(this, "Error: Please Check ThisTableId And ThisTableNaem not Set..", Toast.LENGTH_LONG)
                    .show()
            }
        } catch (ex: Exception) {
            Toasty.info(this, "Somting Went Worng Please Check Connection...", Toast.LENGTH_LONG)
                .show()
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }
}
