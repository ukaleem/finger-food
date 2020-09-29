package com.example.aleemullah.fingerfood.userSection

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.aleemullah.fingerfood.R
import com.example.aleemullah.fingerfood.adapter.QuickOrderAdapter
import com.example.aleemullah.fingerfood.model.QuickOrderData
import org.json.JSONObject

class QuickHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quick_order)

        var my_intent = intent
           var tid =  my_intent.getStringExtra("tableId")
           var tName =  my_intent.getStringExtra("tableName")


        //find listView by id
        var listView: ListView?
        listView = findViewById(R.id.listViewId)

        val sides = ArrayList<QuickOrderData>()


        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this@QuickHome)

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, "http://192.168.115.2/updated_api/v1/?op=getOurPizza",
            Response.Listener<String> { response ->

                val obj = JSONObject(response)
                var productsArray = obj.getJSONArray("our_pizzas")
                for (i in 0 until productsArray.length()) {
                    val sideItems = productsArray.getJSONObject(i)
                    var id = sideItems.getString("op_id")
                    var name = sideItems.getString("op_name")
                    var desc = sideItems.getString("op_description")
                    var price = sideItems.getString("op_price")
                    var qunt = sideItems.getString("op_quantity")

                    when (name) {
                        "SEEKH KABAB OVERLOAD" -> {

                            val wb = QuickOrderData(
                                id.toInt(),
                                R.drawable.shekk1, name, desc, price
                                ,R.id.done_btn, qunt
                            )
                            sides.add(wb)
                        }
                        "BBQ BUZZ NEW" -> {
                            val bbq = QuickOrderData(
                                id.toInt(),
                                R.drawable.bbq_buzz, "$name", "$desc.", "$price"
                                , R.id.done_btn, "$qunt"
                            )
                            sides.add(bbq)
                        }
                        "SPICY RANCH NEW" -> {
                            val spicy = QuickOrderData(
                                id.toInt(),
                                R.drawable.spicy_ranch_new, "$name", "$desc.", "$price"
                                ,
                                R.id.done_btn, "$qunt"
                            )
                            sides.add(spicy)
                        }
                        "SUPER SICILIAN NEW" -> {
                            val chk = QuickOrderData(
                                id.toInt(),
                                R.drawable.super_sicilian_new, "$name", "$desc", "$price"
                                ,
                                R.id.done_btn, "$qunt"
                            )
                            sides.add(chk)
                        }
                        "BEHARI CHICKEN" -> {
                            val behari = QuickOrderData(
                                id.toInt(),
                                R.drawable.behari_chicken, "$name", "$desc.", "$price"
                                ,
                                R.id.done_btn, "$qunt"
                            )
                            sides.add(behari)
                        }
                        "AFGHANI TIKKA" -> {
                            val afgani = QuickOrderData(
                                id.toInt(),
                                R.drawable.afghani_tikka, "$name", "$desc", "$price"
                                ,
                                R.id.done_btn,"$qunt"
                            )
                            sides.add(afgani)
                        }
                        "CHICKEN SUPREME" -> {
                            val afgani = QuickOrderData(
                                id.toInt(),
                                R.drawable.chicken_supreme, "$name", "$desc", "$price"
                                ,
                                R.id.done_btn, "$qunt"
                            )
                            sides.add(afgani)
                        }
                        "CHICKEN ARABIA" -> {
                            val afgani = QuickOrderData(
                                id.toInt(),
                                R.drawable.chicken_arabia, "$name", "$desc", "$price"
                                ,
                                R.id.done_btn, "$qunt"
                            )
                            sides.add(afgani)
                        }
                        "FAJITA SICILIAN" -> {
                            val afgani = QuickOrderData(
                                id.toInt(),
                                R.drawable.fajita_sicilian, "$name", "$desc", "$price"
                                ,
                                R.id.done_btn, "$qunt"
                            )
                            sides.add(afgani)
                        }
                        "SUPER SUPREME" -> {
                            val afgani = QuickOrderData(
                                id.toInt(),
                                R.drawable.super_supreme, "$name", "$desc", "$price"
                                ,
                                R.id.done_btn, qunt
                            )
                            sides.add(afgani)
                        }
                        else -> {
                            val garlic_bread123 = QuickOrderData(
                                id.toInt(),
                                R.drawable.other_box, "$name", "$desc", "$price"
                                ,
                                R.id.done_btn, "$qunt"
                            )
                            sides.add(garlic_bread123)
                        }
                    }
                }
            }, Response.ErrorListener {
                Toast.makeText(
                    this@QuickHome,
                    "Something Wrong Please check internet Connection...",
                    Toast.LENGTH_LONG
                ).show()
            })


        //Custom Adapter

        var adapter = QuickOrderAdapter(this, sides)

        listView?.adapter = adapter
        adapter.notifyDataSetChanged()
}
}
