package com.example.aleemullah.fingerfood.adminSection

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.aleemullah.fingerfood.R
import com.example.aleemullah.fingerfood.adapter.AdminOrderAdapter
import com.example.aleemullah.fingerfood.model.AdminOrderData
import es.dmoral.toasty.Toasty
import org.json.JSONObject

class admin_pannel_order : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_pannel_order)
        var lblOrder = findViewById<TextView>(R.id.admin_panel_orderLbl)
        var face = Typeface.createFromAsset(assets,"fonts/FORTE.TTF")
        lblOrder.typeface = face



        //find listView by id
        var listView: ListView? = null
        listView = findViewById(R.id.order_list_view)

        val sides = ArrayList<AdminOrderData>()

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this@admin_pannel_order)

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET,"http://192.168.115.2/updated_api/v1/?op=getCustomizeOrder",
            Response.Listener<String> { response ->
                val obj = JSONObject(response)
                var productsArray = obj.getJSONArray("Receive_Orders")
                for (i in 0 until productsArray.length()) {
                    val sideItems = productsArray.getJSONObject(i)
                    var orderId = sideItems.getString("cOrderId")
                    var tableNo = sideItems.getString("cTableNo")
                    var mbreadDetails = sideItems.getString("cBreadDetails")
                    var sauceDetails = sideItems.getString("cSaucesDetails")
                    var toppingDetail = sideItems.getString("cOtherDetails")
                    var finalBill = sideItems.getString("cTotalBill")

                    sides.add(AdminOrderData(orderId.toInt(),"$tableNo",
                        "1",
                        "${mbreadDetails.toString()}",
                        "$sauceDetails",
                        "$toppingDetail",
                        "Italian Burger",
                        "2",
                        "$finalBill",
                        R.id.deleteBtn))

                }
            }, Response.ErrorListener {
                Toasty.error(
                    this@admin_pannel_order,
                    "Something Wrong Please check internet Connection...",
                    Toasty.LENGTH_LONG
                ).show()
            })
        queue.add(stringRequest)

        /*sides.add(AdminOrderData("Table No 1","1","Medium","Tomato 2x Rs. 40 Cheese 2x Rs. 40","Onion 2x Rs.40 Olive 2x Rs.40 Green Peeper 2x Rs.40","Italian Burger","2","1500",R.id.deleteBtn))
        sides.add(AdminOrderData("Table No 1","1","Medium","Tomato 2x Rs. 40 Cheese 2x Rs. 40","Onion 2x Rs.40 Olive 2x Rs.40 Green Peeper 2x Rs.40","Italian Burger","2","1500",R.id.deleteBtn))
        sides.add(AdminOrderData("Table No 1","1","Medium","Tomato 2x Rs. 40 Cheese 2x Rs. 40","Onion 2x Rs.40 Olive 2x Rs.40 Green Peeper 2x Rs.40","Italian Burger","2","1500",R.id.deleteBtn))*/
        //Custom Adapter

        var adapter = AdminOrderAdapter(this, sides)

        listView?.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}
