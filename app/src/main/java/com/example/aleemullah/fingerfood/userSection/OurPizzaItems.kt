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
import com.example.aleemullah.fingerfood.model.SidesData
import org.json.JSONObject

class OurPizzaItems : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_our_pizza_items)

//        //find listView by id
//        var listView: ListView? = null
//        listView = findViewById(R.id.listViewId)
//
//        val sides = ArrayList<OurPizzaData>()
//
//        // Instantiate the RequestQueue.
//        val queue = Volley.newRequestQueue(this@OurPizzaItems)
//
//        // Request a string response from the provided URL.
//        val stringRequest = StringRequest(
//            Request.Method.GET, "http://192.168.115.2/updated_api/v1/?op=getOurPizza",
//            Response.Listener<String> { response ->
//
//                val obj = JSONObject(response)
//                var productsArray = obj.getJSONArray("our_pizzas")
//                for (i in 0 until productsArray.length()) {
//                    val sideItems = productsArray.getJSONObject(i)
//                    var id = sideItems.getString("op_id")
//                    var name = sideItems.getString("op_name")
//                    var desc = sideItems.getString("op_description")
//                    var price = sideItems.getString("op_price")
//                    var qunt = sideItems.getString("op_quantity")
//
//                    when (name) {
//                        "SEEKH KABAB OVERLOAD" -> {
//
//                            val wb = OurPizzaData(
//                                id.toInt(),
//                                R.drawable.shekk1, "$name", "RS.", "$price"
//                                ,
//                                "$desc", R.drawable.ic_plus, "0", R.drawable.ic_minus
//                            )
//                            sides.add(wb)
//                        }
//                        "BBQ BUZZ NEW" -> {
//                            val bbq = OurPizzaData(
//                                id.toInt(),
//                                R.drawable.bbq_buzz, "$name", "RS.", "$price"
//                                ,
//                                "$desc", R.drawable.ic_plus, "0", R.drawable.ic_minus
//                            )
//                            sides.add(bbq)
//                        }
//                        "SPICY RANCH NEW" -> {
//                            val spicy = OurPizzaData(
//                                id.toInt(),
//                                R.drawable.spicy_ranch_new, "$name", "RS.", "$price"
//                                ,
//                                "$desc", R.drawable.ic_plus, "0", R.drawable.ic_minus
//                            )
//                            sides.add(spicy)
//                        }
//                        "SUPER SICILIAN NEW" -> {
//                            val chk = OurPizzaData(
//                                id.toInt(),
//                                R.drawable.super_sicilian_new, "$name", "RS.", "$price"
//                                ,
//                                "$desc", R.drawable.ic_plus, "0", R.drawable.ic_minus
//                            )
//                            sides.add(chk)
//                        }
//                        "BEHARI CHICKEN" -> {
//                            val behari = OurPizzaData(
//                                id.toInt(),
//                                R.drawable.behari_chicken, "$name", "RS.", "$price"
//                                ,
//                                "$desc", R.drawable.ic_plus, "0", R.drawable.ic_minus
//                            )
//                            sides.add(behari)
//                        }
//                        "AFGHANI TIKKA" -> {
//                            val afgani = OurPizzaData(
//                                id.toInt(),
//                                R.drawable.afghani_tikka, "$name", "RS.", "$price"
//                                ,
//                                "$desc", R.drawable.ic_plus, "0", R.drawable.ic_minus
//                            )
//                            sides.add(afgani)
//                        }
//                        "CHICKEN SUPREME" -> {
//                            val afgani = OurPizzaData(
//                                id.toInt(),
//                                R.drawable.chicken_supreme, "$name", "RS.", "$price"
//                                ,
//                                "$desc", R.drawable.ic_plus, "0", R.drawable.ic_minus
//                            )
//                            sides.add(afgani)
//                        }
//                        "CHICKEN ARABIA" -> {
//                            val afgani = OurPizzaData(
//                                id.toInt(),
//                                R.drawable.chicken_arabia, "$name", "RS.", "$price"
//                                ,
//                                "$desc", R.drawable.ic_plus, "0", R.drawable.ic_minus
//                            )
//                            sides.add(afgani)
//                        }
//                        "FAJITA SICILIAN" -> {
//                            val afgani = OurPizzaData(
//                                id.toInt(),
//                                R.drawable.fajita_sicilian, "$name", "RS.", "$price"
//                                ,
//                                "$desc", R.drawable.ic_plus, "0", R.drawable.ic_minus
//                            )
//                            sides.add(afgani)
//                        }
//                        "SUPER SUPREME" -> {
//                            val afgani = OurPizzaData(
//                                id.toInt(),
//                                R.drawable.super_supreme, "$name", "RS.", "$price"
//                                ,
//                                "$desc", R.drawable.ic_plus, "0", R.drawable.ic_minus
//                            )
//                            sides.add(afgani)
//                        }
//                        else -> {
//                            val garlic_bread123 = OurPizzaData(
//                                id.toInt(),
//                                R.drawable.other_box, "$name", "RS.", "$price"
//                                ,
//                                "$desc", R.drawable.ic_plus, "0", R.drawable.ic_minus
//                            )
//                            sides.add(garlic_bread123)
//                        }
//                    }
//                }
//            }, Response.ErrorListener {
//                Toast.makeText(
//                    this@OurPizzaItems,
//                    "Something Wrong Please check internet Connection...",
//                    Toast.LENGTH_LONG
//                ).show()
//            })
//        queue.add(stringRequest)
//
//        //Custom Adapter
//
//        var adapter = OurPizzaAdapter(this, sides)
//
//        listView?.adapter = adapter
//        adapter?.notifyDataSetChanged()
//    }
    }
}