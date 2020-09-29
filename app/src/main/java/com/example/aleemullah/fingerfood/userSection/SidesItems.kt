package com.example.aleemullah.fingerfood.userSection

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.aleemullah.fingerfood.R
import com.example.aleemullah.fingerfood.adapter.SidesAdapter
import com.example.aleemullah.fingerfood.model.SideItemsOrder
import com.example.aleemullah.fingerfood.model.SidesData
import org.json.JSONObject

class SidesItems : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sides_items)

        //find listView by id
        var listView: ListView? = null
        listView = findViewById(R.id.listViewId)

        val sides = ArrayList<SidesData>()

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this@SidesItems)

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET,"http://192.168.115.2/updated_api/v1/?op=get_Products",
            Response.Listener<String> { response ->
                //var obj = JSONObject(response)
                // Display the first 500 characters of the response string.
                // Toast.makeText(activity, obj.getString("massage"), Toast.LENGTH_LONG).show()
                // Toast.makeText(activity, response, Toast.LENGTH_LONG).show()
                val obj = JSONObject(response)
                var productsArray = obj.getJSONArray("products")
                for (i in 0 until productsArray.length()) {
                    val sideItems = productsArray.getJSONObject(i)
                    var id = sideItems.getString("product_id")
                    var name = sideItems.getString("product_name")
                    var price = sideItems.getString("product_price")
                    var qunt = sideItems.getString("product_quantity")

                    val fries = SidesData(id.toInt(),"$name","$price", "$qunt", R.id.done_btn)
                    sides.add(fries)

                  /*  when (name) {
                        "Water Bottle" -> {
                            val wb = SidesData (id.toInt(),R.drawable.water,"$name","RS.","$price", "$qunt.5 L", R.drawable.ic_plus, "", R.drawable.ic_minus)
                            sides.add(wb)
                        }
                        "Fries" -> {
                            val fries = SidesData(id.toInt(),R.drawable.fries,"$name","RS.", "$price", "$qunt Pack", R.drawable.ic_plus, "", R.drawable.ic_minus)
                            sides.add(fries)
                        }
                        "Coffee" -> {
                            val cofee = SidesData(id.toInt(),R.drawable.coffee,"$name","RS.", "$price", "$qunt Cup", R.drawable.ic_plus, "", R.drawable.ic_minus)
                            sides.add(cofee)
                        }
                        "Chicken Sandwich" -> {
                            val chk = SidesData(id.toInt(),R.drawable.garlicsupreme,"$name", "RS.", "$price", "$qunt piece",R.drawable.ic_plus, "", R.drawable.ic_minus)
                            sides.add(chk)
                        }
                        "Tea" -> {
                            val tea = SidesData(id.toInt(),R.drawable.tea,"$name", "RS.", "$price", "$qunt Cup", R.drawable.ic_plus, "", R.drawable.ic_minus)
                            sides.add(tea)
                        }
                        "Coca Cola" -> {
                            val coca = SidesData(id.toInt(),R.drawable.cocacola, "$name", "RS.", "$price", "$qunt.5 L", R.drawable.ic_plus, "", R.drawable.ic_minus)
                            sides.add(coca)
                        }
                        else -> {
                            val garlic_bread123 = SidesData(id.toInt(), R.drawable.other_box, "$name", "RS.", "$price", "Quantity:0$qunt", R.drawable.ic_plus, "", R.drawable.ic_minus)
                            sides.add(garlic_bread123)
                        }
                    }*/
                }
            }, Response.ErrorListener {
                Toast.makeText(
                    this@SidesItems,
                    "Something Wrong Please check internet Connection...",
                    Toast.LENGTH_LONG
                ).show()
            })
        queue.add(stringRequest)

        //Custom Adapter

        var adapter = SidesAdapter(this, sides)

        listView?.adapter = adapter
        adapter?.notifyDataSetChanged()
    }

    //Onclick Event for Order Button
    fun productOrder(view:View){
        var db  = SideItemsOrder()
        var abc = db.addProductIds()
        var id = abc["PID1"]
        var quna = abc["PID1Q"]
        Toast.makeText(this@SidesItems,"$id and $quna",Toast.LENGTH_LONG).show()

    }
}
