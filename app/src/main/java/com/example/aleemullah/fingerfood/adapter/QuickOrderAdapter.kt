package com.example.aleemullah.fingerfood.adapter

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.aleemullah.fingerfood.R
import com.example.aleemullah.fingerfood.model.QuickOrderData
import com.example.aleemullah.fingerfood.userSection.QuickHome
import kotlin.collections.ArrayList

class QuickOrderAdapter(private var activity: QuickHome, private var items: ArrayList<QuickOrderData>) :
    BaseAdapter() {

//    //Create Variables Here
//
//    var counter = 0
//
//    //Counter Variables declaration
//    var friesCounter = 0
//    var wBottleCounter = 0
//    var coffeeCounter = 0
//    var teaCounter = 0
//    var cknSandCounter = 0
//    var colaCounter = 0
//
//    var OrderCart = ArrayList<String>()
//
//    var cartCounter = 0
//
//    //============ 01 Fries Counter + Function ===============
//    private fun FriesPlusCounter(): Int {
//        friesCounter++
//        cartCounter++
//        return friesCounter
//    }
//
//    //Fries Counter - function
//    private fun FriesMinusCounter(): Int {
//        return if (friesCounter == 0) {
//            friesCounter
//        } else {
//            friesCounter--
//            cartCounter--
//            friesCounter
//        }
//    }
//
//    //============== 02 Water Bottle Counter + Function =============
//    private fun wBottlePlusCounter(): Int {
//        wBottleCounter++
//        cartCounter++
//        return wBottleCounter
//    }
//
//    // Water Bottle Counter - function
//    private fun wBottleMinusCounter(): Int {
//        return if (wBottleCounter == 0) {
//            wBottleCounter
//        } else {
//            wBottleCounter--
//            cartCounter--
//            wBottleCounter
//        }
//    }
//
//
//    //============ 03 Coffee Counter + Function ===================
//    private fun coffeePlusCounter(): Int {
//        coffeeCounter++
//        cartCounter++
//        return coffeeCounter
//    }
//
//    //Coffee Counter - function
//    private fun coffeeMinusCounter(): Int {
//        return if (coffeeCounter == 0) {
//            coffeeCounter
//        } else {
//            coffeeCounter--
//            cartCounter--
//            coffeeCounter
//        }
//    }
//
//
//    //============ 04 Tea Counter + Function ===================
//    private fun teaPlusCounter(): Int {
//        teaCounter++
//        cartCounter++
//        return teaCounter
//    }
//
//    //Tea Counter - function
//    private fun teaMinusCounter(): Int {
//        return if (teaCounter == 0) {
//            teaCounter
//        } else {
//            teaCounter--
//            cartCounter--
//            teaCounter
//        }
//    }
//
//    //============ 05 Chicken Sandwich Counter + Function ===================
//    private fun cknSandPlusCounter(): Int {
//        cknSandCounter++
//        cartCounter++
//        return cknSandCounter
//    }
//
//    //Chicken Sandwich Counter - function
//    private fun cknSandMinusCounter(): Int {
//        return if (cknSandCounter == 0) {
//            cknSandCounter
//        } else {
//            cknSandCounter--
//            cartCounter--
//            cknSandCounter
//        }
//    }
//
//
//    //============ 06 CocaCola  Counter + Function ===================
//    private fun cocaColaPlusCounter(): Int {
//        colaCounter++
//        cartCounter++
//        return colaCounter
//    }
//
//    //CocaCola Counter - function
//    private fun cocaColaMinusCounter(): Int {
//        return if (colaCounter == 0) {
//            colaCounter
//        } else {
//            colaCounter--
//            cartCounter--
//            colaCounter
//        }
//    }
//
//
//    //===================== Default function for plus counter ================
//    private fun defultPlusCounter(): Int {
//        counter++
//        cartCounter++
//        return counter
//    }
//
//    //Default function for MinusCounter
//    private fun defultMinusCounter(): Int {
//        return if (counter == 0) {
//            counter = 0
//            counter
//        } else {
//            counter--
//            cartCounter--
//            counter
//        }
//
//    }

    //Create View Holder Class
    private class ViewHolder(row: View?) {

        var product_image: ImageView? = null
        var item_text: TextView? = null
        var description_text: TextView? = null
        var price_text: TextView? = null
        var done_Btn: Button? = null
        var quantity_text: EditText? = null

        init {
            this.product_image = row?.findViewById(R.id.listImage)
            this.item_text = row?.findViewById(R.id.item_Text)
            this.description_text = row?.findViewById(R.id.description_Text)
            this.price_text = row?.findViewById(R.id.priceText)
            this.done_Btn = row?.findViewById(R.id.done_btn)!!
            this.quantity_text = row?.findViewById(R.id.quantityText)
        }
    }

    @SuppressLint("SetTextI18n", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater = this.activity.layoutInflater
            view = inflater.inflate(R.layout.list_view_item, parent, false)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var StartersData = items[position]

        viewHolder.product_image?.setImageResource(R.drawable.fajita_sicilian)
        viewHolder.item_text?.text = StartersData.item_text
        viewHolder.description_text?.text = StartersData.description_text
        viewHolder.price_text?.text = StartersData.price_text
        viewHolder.done_Btn?.setOnClickListener {

        }
        viewHolder.quantity_text?.setText(StartersData.quantity_text)


//        viewHolder.myimg?.setImageResource(StartersData.myimage)
//        viewHolder.titletxt?.text = StartersData.titletext
//        viewHolder.pricetag?.text = StartersData.pricetag
//        viewHolder.pricetxt?.text = StartersData.pricetext
//        viewHolder.qtytxt?.text = StartersData.qtytext
//        viewHolder.counttxt?.text = StartersData.counttext
//
//        viewHolder.plusbutton?.setOnClickListener {
//            when (viewHolder.titletxt?.text) {
//                "Fries" -> {
//                    viewHolder.counttxt?.text = "" + FriesPlusCounter()
//                    Toast.makeText(activity!!.applicationContext,"${StartersData.id}",Toast.LENGTH_LONG).show()
//                    val order = SideItemsOrder(StartersData.id,friesCounter)
//
//                }
//                "Water Bottle" -> {
//                    viewHolder.counttxt?.text = "" + wBottlePlusCounter()
//                    Toast.makeText(activity!!.applicationContext,"${StartersData.id}",Toast.LENGTH_LONG).show()
//                    val order = SideItemsOrder(StartersData.id,wBottleCounter)
//                }
//                "Coffee" ->{
//                    viewHolder.counttxt?.text = "" + coffeePlusCounter()
//                    Toast.makeText(activity!!.applicationContext,"${StartersData.id}",Toast.LENGTH_LONG).show()
//                }
//                "Tea" -> {
//                    viewHolder.counttxt?.text = "" + teaPlusCounter()
//                    Toast.makeText(activity!!.applicationContext,"${StartersData.id}",Toast.LENGTH_LONG).show()
//                }
//                "Chicken Sandwich" -> {
//                    viewHolder.counttxt?.text = "" + cknSandPlusCounter()
//                    Toast.makeText(activity!!.applicationContext,"${StartersData.id}",Toast.LENGTH_LONG).show()
//                }
//                "Coca Cola" -> {
//                    viewHolder.counttxt?.text = "" + cocaColaPlusCounter()
//                    Toast.makeText(activity!!.applicationContext,"${StartersData.id}",Toast.LENGTH_LONG).show()
//                }
//                else -> {
//                    viewHolder.counttxt?.text = "" + defultPlusCounter()
//                    Toast.makeText(activity!!.applicationContext,"${StartersData.id}",Toast.LENGTH_LONG).show()
//                }
//            }
//        }
//        viewHolder.minusbutton?.setOnClickListener {
//
//            when (viewHolder.titletxt?.text) {
//                "Fries" -> {
//                    viewHolder.counttxt?.text = "" + FriesMinusCounter()
//                }
//                "Water Bottle" -> {
//                    viewHolder.counttxt?.text = "" + wBottleMinusCounter()
//                }
//                "Coffee" -> viewHolder.counttxt?.text = "" + coffeeMinusCounter()
//                "Tea" -> viewHolder.counttxt?.text = "" + teaMinusCounter()
//                "Chicken Sandwich" -> viewHolder.counttxt?.text = "" + cknSandMinusCounter()
//                "Coca Cola" -> viewHolder.counttxt?.text = "" + cocaColaMinusCounter()
//                else -> viewHolder.counttxt?.text = "" + defultMinusCounter()
//            }
//        }

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