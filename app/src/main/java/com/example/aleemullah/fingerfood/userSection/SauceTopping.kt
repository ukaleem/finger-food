package com.example.aleemullah.fingerfood.userSection

import android.content.ClipData
import android.content.Intent
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.aleemullah.fingerfood.R
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_sauce_topping.*

class SauceTopping : AppCompatActivity() {

    private lateinit var chiliSauceImg: ImageView
    private lateinit var cheezImg: ImageView
    lateinit var target: ImageView

    lateinit var breadId: String
    lateinit var breadName: String
    lateinit var breadSize: String
    lateinit var breadPrice: String
    var BreadResource: String = ""

    var TID: String = ""
    var TNAME: String = ""

    var totalDragCounter = 0
    var tomatoCheck = 0
    var cheezCheck = 0
    var value = 0
    // var Length = tomatoCheck


    /* ---------- Long Click Listener for Drag and Drop ---------- */

    private var longClickListener: View.OnLongClickListener = View.OnLongClickListener { v ->
        val data = ClipData.newPlainText("", "")
        val myShadow = View.DragShadowBuilder(v)
        v.startDrag(data, myShadow, v, 0)
        true
    }

    /* ---------- Drag Click Listener for Drag and Drop ---------- */

    private var dragListener: View.OnDragListener = View.OnDragListener { v, event ->

        val myanim = AnimationUtils.loadAnimation(this, R.anim.bounce)


        val dragEvent = event.action
        val view = event.localState as View
        when (dragEvent) {

            DragEvent.ACTION_DROP ->
                /* ---------- Tomato Sauce Topping here ---------- */
                if (view.id == R.id.tomatoSauseImg) {

                    if (tomatoCheck == 0 && cheezCheck == 0) {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.finaltomatopicture)
                        BreadResource = "R.drawable.finaltomatopicture"
                        tomatoCheck++
                        totalDragCounter++
                        value += 50
                        totallBillShowtxt.startAnimation(myanim)
                        tomatoSauceQuantity.startAnimation(myanim)
                        totallBillShowtxt.text = "Total Amount: Rs." + value
                        tomatoSauceQuantity.text = "Tomato Sauces -> " + tomatoCheck
                        val toast = Toasty.success(this, "Total Tomato Quantity:$tomatoCheck", Toast.LENGTH_SHORT)
                        toast.show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT)
                        t.show()
                    } else if (cheezCheck == 1 && tomatoCheck == 0) {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.finalcheeztomato)
                        BreadResource = "R.drawable.finalcheeztomato"
                        tomatoCheck++
                        totalDragCounter++
                        value += 50
                        totallBillShowtxt.startAnimation(myanim)
                        tomatoSauceQuantity.startAnimation(myanim)
                        totallBillShowtxt.text = "Total Amount: Rs." + value
                        tomatoSauceQuantity.text = "Tomato Sauces -> " + tomatoCheck
                        val toast = Toasty.success(this, "Total Tomato Quantity:$tomatoCheck", Toast.LENGTH_SHORT)
                        toast.show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT)
                        t.show()
                    } else if (cheezCheck == 1 && tomatoCheck == 1) {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.finalcheeztomato)
                        BreadResource = "R.drawable.finalcheeztomato"
                        tomatoCheck++
                        totalDragCounter++
                        value += 50
                        totallBillShowtxt.text = "Total Amount: Rs." + value
                        tomatoSauceQuantity.text = "Tomato Sauces -> " + tomatoCheck + "X"
                        val toast = Toasty.success(this, "Total Tomato Quantity:$tomatoCheck", Toast.LENGTH_SHORT)
                        toast.show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT)
                        t.show()

                    } else if (cheezCheck == 2 && tomatoCheck == 0) {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.finalcheeztomato)
                        BreadResource = "R.drawable.finalcheeztomato"
                        tomatoCheck++
                        totalDragCounter++
                        value += 50
                        totallBillShowtxt.text = "Total Amount: Rs." + value
                        tomatoSauceQuantity.text = "Tomato Sauces -> " + tomatoCheck
                        val toast = Toasty.success(this, "Total Tomato Quantity:$tomatoCheck", Toast.LENGTH_SHORT)
                        toast.show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT)
                        t.show()
                    } else if (cheezCheck == 2 && tomatoCheck == 1) {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.finalcheeztomato)
                        BreadResource = "R.drawable.finalcheeztomato"
                        tomatoCheck++
                        totalDragCounter++
                        value += 50
                        totallBillShowtxt.text = "Total Amount: Rs." + value
                        tomatoSauceQuantity.text = "Tomato Sauces -> " + tomatoCheck + "X"
                        val toast = Toasty.success(this, "Total Tomato Quantity:$tomatoCheck", Toast.LENGTH_SHORT)
                        toast.show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT)
                        t.show()
                    } else if (cheezCheck == 2 && tomatoCheck == 2) {
                        Toasty.warning(
                            this@SauceTopping,
                            "Dear! You Have Reached Max limits To Choose Sause on pizza!",
                            Toasty.LENGTH_LONG
                        ).show()
                    } else if (tomatoCheck == 1) {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.finaltomatopicture)
                        BreadResource = "R.drawable.finaltomatopicture"
                        tomatoCheck++
                        totalDragCounter++
                        value += 50
                        totallBillShowtxt.text = "Total Amount: Rs." + value
                        tomatoSauceQuantity.text = "Tomato Sauces -> " + tomatoCheck + "X"
                        val toast = Toasty.success(this, "Total Chilli Quantity:$tomatoCheck", Toast.LENGTH_SHORT)
                        toast.show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT)
                        t.show()
                    } else if (tomatoCheck == 2) {
                        Toasty.warning(
                            this@SauceTopping,
                            "Notice Dear!, To get A tasty Pizza max limit is Reached...",
                            Toasty.LENGTH_LONG
                        ).show()
                    }
                }

                /* ---------- Cheez Topping here ---------- */
                else if (view.id == R.id.cheezImg) {

                    if (cheezCheck == 0 && tomatoCheck == 0) {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.finalcheezpicture)
                        BreadResource = "R.drawable.finalcheezpicture"
                        cheezCheck++
                        totalDragCounter++
                        value += 80
                        totallBillShowtxt.startAnimation(myanim)
                        tomatoSauceQuantity.startAnimation(myanim)
                        totallBillShowtxt.text = "Total Amount: Rs." + value
                        cheezQunatity.text = "Cheez -> " + cheezCheck
                        val toast = Toasty.success(this, "Total Cheez Quantity:$cheezCheck", Toast.LENGTH_SHORT)
                        toast.show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT)
                        t.show()
                    } else if (tomatoCheck == 1 && cheezCheck == 0) {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.finalcheeztomato)
                        BreadResource = "R.drawable.finalcheeztomato"
                        cheezCheck++
                        totalDragCounter++
                        value += 80
                        totallBillShowtxt.text = "Total Amount: Rs." + value
                        cheezQunatity.text = "Cheez -> " + cheezCheck
                        val toast = Toasty.success(this, "Total Cheez Quantity:$cheezCheck", Toast.LENGTH_SHORT)
                        toast.show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT)
                        t.show()

                    } else if (tomatoCheck == 1 && cheezCheck == 1) {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.finalcheeztomato)
                        BreadResource = "R.drawable.finalcheeztomato"
                        cheezCheck++
                        totalDragCounter++
                        value += 80
                        totallBillShowtxt.startAnimation(myanim)
                        tomatoSauceQuantity.startAnimation(myanim)
                        totallBillShowtxt.text = "Total Amount: Rs." + value
                        cheezQunatity.text = "Cheez -> " + cheezCheck + "X"
                        val toast = Toasty.success(this, "Total Cheez Quantity:$cheezCheck", Toast.LENGTH_SHORT)
                        toast.show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT)
                        t.show()
                    } else if (tomatoCheck == 2 && cheezCheck == 0) {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.finalcheeztomato)
                        BreadResource = "R.drawable.finalcheeztomato"
                        cheezCheck++
                        totalDragCounter++
                        value += 80
                        totallBillShowtxt.text = "Total Amount: Rs." + value
                        cheezQunatity.text = "Cheez -> " + cheezCheck
                        val toast = Toasty.success(this, "Total Cheez Quantity:$cheezCheck", Toast.LENGTH_SHORT)
                        toast.show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT)
                        t.show()

                    } else if (tomatoCheck == 2 && cheezCheck == 1) {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.finalcheeztomato)
                        BreadResource = "R.drawable.finalcheeztomato"
                        cheezCheck++
                        totalDragCounter++
                        value += 80
                        totallBillShowtxt.text = "Total Amount: Rs." + value
                        cheezQunatity.text = "Cheez -> " + cheezCheck + "X"
                        val toast = Toasty.success(this, "Total Cheez Quantity:$cheezCheck", Toast.LENGTH_SHORT)
                        toast.show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT)
                        t.show()

                    } else if (tomatoCheck == 2 && cheezCheck == 2) {
                        Toasty.warning(
                            this@SauceTopping,
                            "Dear! You Have Reached Max limits To Choose Sause on pizza!",
                            Toasty.LENGTH_LONG
                        ).show()

                    } else if (cheezCheck == 1) {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.finalcheezpicture)
                        BreadResource = "R.drawable.finalcheezpicture"
                        cheezCheck++
                        totalDragCounter++
                        value += 80
                        totallBillShowtxt.text = "Total Amount: Rs." + value
                        cheezQunatity.text = "Cheez -> " + cheezCheck + "X"
                        val toast = Toasty.success(this, "Total Cheez Quantity:$cheezCheck", Toast.LENGTH_SHORT)
                        toast.show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT)
                        t.show()
                    } else {
                        Toasty.warning(
                            this@SauceTopping,
                            "Notice Dear!, To get A tasty Pizza Your max limit is Reached...",
                            Toasty.LENGTH_LONG
                        ).show()
                    }
                }
        }
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sauce_topping)

        //Font FORTE.TTF initialize
        var face = Typeface.createFromAsset(assets, "fonts/FORTE.TTF")

        //TextView Labels Initializes
        var sauceHeadingLbl = findViewById<TextView>(R.id.thankYouTbl)
        sauceHeadingLbl.typeface = face

        var selItemLbl = findViewById<TextView>(R.id.selectedItemsLbl)
        selItemLbl.typeface = face

        //Font style on sauces Labels
        /* var potatoLbl = findViewById<TextView>(R.id.potatoTxt)
         potatoLbl.typeface = face

         var chiliLbl = findViewById<TextView>(R.id.chiliTxt)
         chiliLbl.typeface = face

         var cheezLbl = findViewById<TextView>(R.id.cheezTxt)
         cheezLbl.typeface = face*/


        //get Extra data send from the First bread screen.

        if (intent.extras != null) {
            breadId = intent.getStringExtra("breadId")
            breadName = intent.getStringExtra("breadName")
            breadPrice = intent.getStringExtra("breadPrice")
            breadSize = intent.getStringExtra("breadSize")

            TID = intent.getStringExtra("tId")
            TNAME = intent.getStringExtra("tName")

            value += Integer.parseInt(breadPrice).toInt()
            breadNameLbl.text = breadName
            breadPriceLbl.text = "Rs. " + breadPrice
            breadSizeLbl.text = "Size: " + breadSize
        }

        /* ---------- Create the Instances here ---------- */

        chiliSauceImg = findViewById(R.id.tomatoSauseImg)
        cheezImg = findViewById(R.id.cheezImg)

        /* ---------- Target Instance here ---------- */
        target = findViewById(R.id.imagedough)


        /* ---------- Action Long Click Listener to our ImageView ---------- */

        chiliSauceImg.setOnLongClickListener(longClickListener)
        cheezImg.setOnLongClickListener(longClickListener)

        /* ---------- Action Drag Listener to our Target ---------- */

        target.setOnDragListener(dragListener)

        totallBillShowtxt.text = "Total Amount: Rs." + value

        saucesNextOrderBtn.setOnClickListener {
            val i = Intent(this, OtherToppings::class.java)

            //Breads Details to other activity
            i.putExtra("breadId", breadId)
            i.putExtra("breadName", breadName)
            i.putExtra("breadPrice", breadPrice)
            i.putExtra("breadSize", breadSize)
            i.putExtra("breadResource", BreadResource)
            //Sauces Details send to other activity

            i.putExtra("sauseTomatoValue", tomatoCheck.toString())
            i.putExtra("sauseCheeseValue", cheezCheck.toString())
            i.putExtra("sauseFinalBill", value.toString())

            i.putExtra("tId",TID)
            i.putExtra("tName",TNAME)
            startActivity(i)

        }

    }
}
