package com.example.aleemullah.fingerfood.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.example.aleemullah.fingerfood.EndPointsApi
import com.example.aleemullah.fingerfood.R
import com.example.aleemullah.fingerfood.VolleySingleton
import com.example.aleemullah.fingerfood.adminSection.admin_pannel_order
import com.example.aleemullah.fingerfood.model.AdminOrderData
import es.dmoral.toasty.Toasty
import org.json.JSONException
import org.json.JSONObject

class AdminOrderAdapter
    (private var activity: admin_pannel_order, private var items: ArrayList<AdminOrderData>) :
    BaseAdapter() {

        //Create View Holder Class
        private class ViewHolder(row: View?) {

            var table_no_text: TextView? = null
            var pizza_quantity_text: TextView? = null
            var bread_detail_text: TextView? = null
            var sauce_detail_text: TextView? = null
            var topping_detail_text: TextView? = null
            var item_name_text: TextView? = null
            var item_quantity_text : TextView? = null
            var total_bill_text: TextView? = null
            var deleteButton: Button? = null

            init {

                this.table_no_text = row?.findViewById<TextView>(R.id.table_no_Text)
                this.pizza_quantity_text = row?.findViewById<TextView>(R.id.pizza_quantity_Text)
                this.bread_detail_text = row?.findViewById<TextView>(R.id.bread_detail_Text)
                this.sauce_detail_text = row?.findViewById<TextView>(R.id.sauce_detail_Text)
                this.topping_detail_text = row?.findViewById<TextView>(R.id.topping_detail_Text)
                this.item_name_text = row?.findViewById(R.id.item_name_Text)
                this.item_quantity_text = row?.findViewById(R.id.item_quantity_Text)
                this.total_bill_text = row?.findViewById<TextView>(R.id.total_bill_Text)
                this.deleteButton = row?.findViewById(R.id.deleteBtn)

            }
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view: View?
            val viewHolder: ViewHolder
            if (convertView == null) {
                val inflater = this.activity.layoutInflater
                view = inflater.inflate(R.layout.order_view_list_items, parent, false)
                viewHolder = ViewHolder(view)
                view?.tag = viewHolder
            } else {
                view = convertView
                viewHolder = view.tag as ViewHolder
            }
            var StartersData = items[position]
            viewHolder.table_no_text?.text = StartersData.table_no_text
            viewHolder.pizza_quantity_text?.text = StartersData.pizza_quantity_text
            viewHolder.bread_detail_text?.text = StartersData.bread_detail_text
            viewHolder.sauce_detail_text?.text = StartersData.sauce_detail_text
            viewHolder.topping_detail_text?.text = StartersData.topping_detail_text
            viewHolder.item_name_text?.text = StartersData.item_name_text
            viewHolder.item_quantity_text?.text = StartersData.item_quantity_text
            viewHolder.total_bill_text?.text = StartersData.total_bill_text


            viewHolder.deleteButton?.setOnClickListener {
                items.removeAt(position)
                notifyDataSetChanged()

                //Volley Method to insert data
                val stringRequest = object : StringRequest(
                    Method.POST, "http://192.168.115.2/updated_api/v1/?op=deleteReceiveCustomizeOrder",
                    Response.Listener<String> { response ->
                        try {
                            val obj = JSONObject(response)
                            Toasty.success(
                                this.activity.applicationContext,
                                obj.getString("message"),
                                Toast.LENGTH_LONG
                            ).show()
                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    },
                    Response.ErrorListener { volleyError ->
                        android.widget.Toast.makeText(
                            this.activity.applicationContext,
                            volleyError.message,
                            Toast.LENGTH_LONG
                        ).show()
                        android.widget.Toast.makeText(
                            this.activity.applicationContext,
                            "failed something wrong...",
                            Toast.LENGTH_LONG
                        ).show()
                    }) {
                    @Throws(AuthFailureError::class)
                    override fun getParams(): Map<String, String> {
                        var map = HashMap<String, String>()
                        map.put("deleteId", StartersData.order_id)
                        return map
                    }
                }
                VolleySingleton.instance?.addToRequestQueue(stringRequest)
            }

            return view as View
        }

        override fun getItem(position: Int): Any {
            return items[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return items.size
        }
    }