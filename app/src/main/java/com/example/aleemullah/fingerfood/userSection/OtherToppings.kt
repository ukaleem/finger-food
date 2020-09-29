package com.example.aleemullah.fingerfood.userSection

import android.content.ClipData
import android.content.Intent
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.example.aleemullah.fingerfood.EndPointsApi
import com.example.aleemullah.fingerfood.R
import com.example.aleemullah.fingerfood.VolleySingleton
import com.irozon.alertview.AlertActionStyle
import com.irozon.alertview.AlertStyle
import com.irozon.alertview.AlertTheme
import com.irozon.alertview.AlertView
import com.irozon.alertview.objects.AlertAction
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_other_toppings.*
import org.json.JSONException
import org.json.JSONObject

class OtherToppings : AppCompatActivity() {

    private lateinit var mOnionImage: ImageView
    private lateinit var mMasroomImage: ImageView
    private lateinit var mGreenPeeperImage: ImageView
    private lateinit var target: ImageView

    var dbBreadDetails = ""
    var dbSaucesDetails = ""
    var dbOtherDetails = ""
    var dbTableID = ""
    var dbTableName = ""



    var totalDragCounter = 0
    var onionCheck = 0
    var masroomCheck = 0
    var greenpCheck = 0
    var countingValue = 0

    var breadId: String = ""
    var breadName: String = ""
    var breadPrice: String = ""
    var breadSize: String = ""
    var breadResourse: String = ""
    var tomatoValue: String = ""
    var cheeseValue: String = ""
    var sauceActiBill: String = ""

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

                /*==================Onion All If else conditions Her=========================*/
                if (view.id == R.id.OnionImg) {
                    if (onionCheck == 0) {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_onion)
                        onionCheck++
                        totalDragCounter++
                        countingValue += 50
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oOnionQuantity.text = "Onion $onionCheck"
                        Toasty.success(this, "Total Onion Quantity:$onionCheck", Toast.LENGTH_SHORT).show()
                        Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    } else if (greenpCheck == 1 && onionCheck == 0){
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_green_onion)
                        onionCheck++
                        totalDragCounter++
                        countingValue += 50
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oOnionQuantity.text = "Onion $onionCheck"
                        Toasty.success(this, "Total Onion Quantity:$onionCheck", Toast.LENGTH_SHORT).show()
                        Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    } else if(greenpCheck == 2 && onionCheck == 0){
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_green_onion)
                        onionCheck++
                        totalDragCounter++
                        countingValue += 50
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oOnionQuantity.text = "Onion $onionCheck"
                        Toasty.success(this, "Total Onion Quantity:$onionCheck", Toast.LENGTH_SHORT).show()
                        Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    } else if (greenpCheck == 1 && onionCheck == 1){
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_green_onion)
                        onionCheck++
                        totalDragCounter++
                        countingValue += 50
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oOnionQuantity.text = "Onion $onionCheck"
                        Toasty.success(this, "Total Onion Quantity:$onionCheck", Toast.LENGTH_SHORT).show()
                        Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    } else if (greenpCheck == 1 && onionCheck == 2){
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_green_onion)
                        onionCheck++
                        totalDragCounter++
                        countingValue += 50
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oOnionQuantity.text = "Onion $onionCheck"
                        Toasty.success(this, "Total Onion Quantity:$onionCheck", Toast.LENGTH_SHORT).show()
                        Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    } else if (greenpCheck == 2 && masroomCheck == 1 && onionCheck == 1){
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_onion_masroom_greenp)
                        onionCheck++
                        totalDragCounter++
                        countingValue += 50
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oOnionQuantity.text = "Onion $onionCheck"
                        Toasty.success(this, "Total Onion Quantity:$onionCheck", Toast.LENGTH_SHORT).show()
                    } else if (onionCheck == 1) {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_onion)
                        onionCheck++
                        totalDragCounter++
                        countingValue += 50
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oOnionQuantity.text = "Onion $onionCheck"
                        val Q = Toasty.success(this, "Total Onion Quantity:$onionCheck", Toast.LENGTH_SHORT).show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    } else if (onionCheck == 2) {
                        Toasty.info(this, "You have reached max limit to choose Onion", Toast.LENGTH_SHORT).show()


                    } else {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_onion)
                        onionCheck++
                        totalDragCounter++
                        countingValue += 50
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oOnionQuantity.text = "Onion $onionCheck"
                        val Q = Toasty.success(this, "Total Onion Quantity:$onionCheck", Toast.LENGTH_SHORT).show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    }
                }

                /*==================Masrooms All If else conditions Her=========================*/
                else if (view.id == R.id.masroomsImg) {

                    if (masroomCheck == 0 && onionCheck == 0 && greenpCheck == 0) {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_masroom)
                        masroomCheck++
                        totalDragCounter++
                        countingValue += 70
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oMasroomQuantity.text = "Masrooms $masroomCheck"
                        val Q = Toasty.success(this, "Total Masroom Quantity:$masroomCheck", Toast.LENGTH_SHORT).show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    } else if (masroomCheck == 1 && onionCheck ==0 ) {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_masroom)
                        masroomCheck++
                        totalDragCounter++
                        countingValue += 70
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oMasroomQuantity.text = "Masrooms $masroomCheck"
                        val Q = Toasty.success(this, "Total Masroom Quantity:$masroomCheck", Toast.LENGTH_SHORT).show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    } else if (masroomCheck == 2) {
                        Toasty.info(this, "You have reached max limit to choose Onion", Toast.LENGTH_SHORT).show()
                    } else if (onionCheck == 1 && masroomCheck == 0) {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_onion_massroom)
                        masroomCheck++
                        totalDragCounter++
                        countingValue += 70
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oMasroomQuantity.text = "Masrooms $masroomCheck"
                        val Q = Toasty.success(this, "Total Masroom Quantity:$masroomCheck", Toast.LENGTH_SHORT).show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    } else if (onionCheck == 2 && masroomCheck == 0){
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_onion_massroom)
                        masroomCheck++
                        totalDragCounter++
                        countingValue += 70
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oMasroomQuantity.text = "Masrooms $masroomCheck"
                        val Q = Toasty.success(this, "Total Masroom Quantity:$masroomCheck", Toast.LENGTH_SHORT).show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    } else if (onionCheck == 1 && masroomCheck == 0){
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_onion_massroom)
                        masroomCheck++
                        totalDragCounter++
                        countingValue += 70
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oMasroomQuantity.text = "Masrooms $masroomCheck"
                        val Q = Toasty.success(this, "Total Masroom Quantity:$masroomCheck", Toast.LENGTH_SHORT).show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    } else if (greenpCheck == 1 && masroomCheck == 0){
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_masroom_greenp)
                        masroomCheck++
                        totalDragCounter++
                        countingValue += 70
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oMasroomQuantity.text = "Masrooms $masroomCheck"
                        val Q = Toasty.success(this, "Total Masroom Quantity:$masroomCheck", Toast.LENGTH_SHORT).show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    } else if (greenpCheck ==2 && masroomCheck == 0){
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_onion_massroom)
                        masroomCheck++
                        totalDragCounter++
                        countingValue += 70
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oMasroomQuantity.text = "Masrooms $masroomCheck"
                        val Q = Toasty.success(this, "Total Masroom Quantity:$masroomCheck", Toast.LENGTH_SHORT).show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    } else if (greenpCheck == 2 && masroomCheck == 0) {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_masroom_greenp)
                        masroomCheck++
                        totalDragCounter++
                        countingValue += 70
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oMasroomQuantity.text = "Masrooms $masroomCheck"
                        val Q = Toasty.success(this, "Total Masroom Quantity:$masroomCheck", Toast.LENGTH_SHORT).show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    } else if (onionCheck == 2 && masroomCheck == 1){
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_onion_massroom)
                        masroomCheck++
                        totalDragCounter++
                        countingValue += 70
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oMasroomQuantity.text = "Masrooms $masroomCheck"
                        val Q = Toasty.success(this, "Total Masroom Quantity:$masroomCheck", Toast.LENGTH_SHORT).show()
                        val t = Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    }

                }

                /*==================Greeen peepers All If else conditions Her=========================*/
                else if (view.id == R.id.greenPeperImg) {
                    if (greenpCheck == 0 && onionCheck == 0 && masroomCheck == 0) {

                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_greenp)
                        greenpCheck++
                        totalDragCounter++
                        countingValue += 40
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oGreenPepperQuantity.text = "Green Pepers $greenpCheck"
                        Toasty.success(this, "Total Green Pepers Quantity:$greenpCheck", Toast.LENGTH_SHORT).show()
                        Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()

                    } else if(greenpCheck == 0 && onionCheck == 1 && masroomCheck == 1){
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_onion_masroom_greenp)
                        greenpCheck++
                        totalDragCounter++
                        countingValue += 40
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oGreenPepperQuantity.text = "Green Pepers $greenpCheck"
                        Toasty.success(this, "Total Green Pepers Quantity:$greenpCheck", Toast.LENGTH_SHORT).show()
                        Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    } else if(onionCheck == 1 && greenpCheck == 0){
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_green_onion)
                        greenpCheck++
                        totalDragCounter++
                        countingValue += 40
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oGreenPepperQuantity.text = "Green Pepers $greenpCheck"
                        Toasty.success(this, "Total Green Pepers Quantity:$greenpCheck", Toast.LENGTH_SHORT).show()
                        Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    } else if (onionCheck == 2 && greenpCheck == 0){
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_green_onion)
                        greenpCheck++
                        totalDragCounter++
                        countingValue += 40
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oGreenPepperQuantity.text = "Green Pepers $greenpCheck"
                        Toasty.success(this, "Total Green Pepers Quantity:$greenpCheck", Toast.LENGTH_SHORT).show()
                        Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    }  else if (onionCheck == 2 && masroomCheck == 2 && greenpCheck == 0){
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_onion_masroom_greenp)
                        greenpCheck++
                        totalDragCounter++
                        countingValue += 40
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oGreenPepperQuantity.text = "Green Pepers $greenpCheck"
                        Toasty.success(this, "Total Green Pepers Quantity:$greenpCheck", Toast.LENGTH_SHORT).show()
                        Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    } else if(onionCheck == 2 && masroomCheck == 2 && greenpCheck == 1){
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_onion_masroom_greenp)
                        greenpCheck++
                        totalDragCounter++
                        countingValue += 40
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oGreenPepperQuantity.text = "Green Pepers $greenpCheck"
                        Toasty.success(this, "Total Green Pepers Quantity:$greenpCheck", Toast.LENGTH_SHORT).show()
                        Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()

                    } else if(onionCheck == 1 && masroomCheck == 1 && greenpCheck == 0){
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_onion_masroom_greenp)
                        greenpCheck++
                        totalDragCounter++
                        countingValue += 40
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oGreenPepperQuantity.text = "Green Pepers $greenpCheck"
                        Toasty.success(this, "Total Green Pepers Quantity:$greenpCheck", Toast.LENGTH_SHORT).show()
                        Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()

                    } else if(onionCheck == 1 && masroomCheck == 1 && greenpCheck == 1){
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_onion_masroom_greenp)
                        greenpCheck++
                        totalDragCounter++
                        countingValue += 40
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oGreenPepperQuantity.text = "Green Pepers $greenpCheck"
                        Toasty.success(this, "Total Green Pepers Quantity:$greenpCheck", Toast.LENGTH_SHORT).show()
                        Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    } else if (greenpCheck == 1) {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_greenp)
                        greenpCheck++
                        totalDragCounter++
                        countingValue += 40
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oGreenPepperQuantity.text = "Green Pepers $greenpCheck" + "X"
                        Toasty.success(this, "Total Green Pepers Quantity:$greenpCheck", Toast.LENGTH_SHORT).show()
                        Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    } else if (greenpCheck == 2) {
                        Toasty.info(this, "You have reached max limit to choose Onion", Toast.LENGTH_SHORT).show()
                    } else if (masroomCheck == 1 && greenpCheck == 0) {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_masroom_greenp)
                        greenpCheck++
                        totalDragCounter++
                        countingValue += 40
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oGreenPepperQuantity.text = "Green Pepers $greenpCheck"
                        Toasty.success(this, "Total Green Pepers Quantity:$greenpCheck", Toast.LENGTH_SHORT).show()
                        Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()
                    } else {
                        target.startAnimation(myanim)
                        target.setImageResource(R.drawable.final_greenp)
                        greenpCheck++
                        totalDragCounter++
                        countingValue += 40
                        oTotallBill.startAnimation(myanim)
                        oTotallBill.text = "Total Bill: Rs.$countingValue"
                        oGreenPepperQuantity.text = "Green Pepers $greenpCheck"
                        Toasty.success(this, "Total Green Pepers Quantity:$greenpCheck", Toast.LENGTH_SHORT).show()
                        Toasty.success(this, "Total Drag:$totalDragCounter", Toast.LENGTH_SHORT).show()

                    }
                }
        }
        true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_toppings)
        //Font FORTE.TTF initialize
        var face = Typeface.createFromAsset(assets, "fonts/FORTE.TTF")
        toppingActivityHeadingLbl.typeface = face

        //get Extra data send from the First bread screen.

        if (intent.extras != null) {
            breadId = intent.getStringExtra("breadId")
            breadName = intent.getStringExtra("breadName")
            breadPrice = intent.getStringExtra("breadPrice")
            breadSize = intent.getStringExtra("breadSize")

            //Put Bread Size to database
            dbBreadDetails += "$breadSize"
            dbTableID = intent.getStringExtra("tId")
            dbTableName = intent.getStringExtra("tName")

            var breadResourse = intent.getStringExtra("breadResource")

            var sauceActiBill = intent.getStringExtra("sauseFinalBill")
            cheeseValue = intent.getStringExtra("sauseCheeseValue")
            tomatoValue = intent.getStringExtra("sauseTomatoValue")






            countingValue += Integer.parseInt(sauceActiBill.toString())

            oBreadNameTxt.text = breadName
            oBreadPriceTxt.text = "Rs. " + breadPrice
            oBreadSizeTxt.text = breadSize

            oTomatoQuantity.text = "Tomato Sauce $tomatoValue X"
            oCheezeQuantity.text = "Cheese $cheeseValue X"
            oTotallBill.text = "Total Bill: Rs.$sauceActiBill"

            /* ---------- Create the Instances here ---------- */
            mOnionImage = findViewById(R.id.OnionImg)
            mMasroomImage = findViewById(R.id.masroomsImg)
            mGreenPeeperImage = findViewById(R.id.greenPeperImg)

            target = findViewById(R.id.myDough)
            //Set Previous selected dough
            if (tomatoValue == "1") {
                target.setImageResource(R.drawable.finaltomatopicture)
            } else if (tomatoValue == "2") {
                target.setImageResource(R.drawable.finaltomatopicture)
            } else if (cheeseValue == "1") {
                target.setImageResource(R.drawable.finalcheezpicture)
            } else if (cheeseValue == "2") {
                target.setImageResource(R.drawable.finalcheezpicture)
            } else if (tomatoValue == "2" && cheeseValue == "1") {
                target.setImageResource(R.drawable.finalcheeztomato)
            } else if (tomatoValue == "1" && cheeseValue == "1") {
                target.setImageResource(R.drawable.finalcheeztomato)
            } else if (tomatoValue == "0" && cheeseValue == "0") {
                target.setImageResource(R.drawable.twodough)
            } else {
                target.setImageResource(R.drawable.finalcheeztomato)
            }

            /* ---------- Action Long Click Listener to our ImageView ---------- */
            mOnionImage.setOnLongClickListener(longClickListener)
            mMasroomImage.setOnLongClickListener(longClickListener)
            mGreenPeeperImage.setOnLongClickListener(longClickListener)

            /* ---------- Action Drag Listener to our Target ---------- */
            target.setOnDragListener(dragListener)
        }

        finalOrderNowBtn.setOnClickListener {

            dbSaucesDetails = ""+oCheezeQuantity.text +" " +oTomatoQuantity.text
            dbOtherDetails = ""+oOnionQuantity.text + " " +oMasroomQuantity.text + " " + oGreenPepperQuantity.text
            // Declared in our activity_shapes_view.xml file.
            val alert = AlertView("Conform Order", "Are you Sure you want to Order..", AlertStyle.IOS)
            alert.addAction(AlertAction("Yes", AlertActionStyle.DEFAULT) { action ->
                SendOrder()

                val act = Intent(this, TotallBillView::class.java)

                //Breads Details to other activity
                act.putExtra("breadId", breadId)
                act.putExtra("breadName", breadName)
                act.putExtra("breadPrice", breadPrice)
                act.putExtra("breadSize", breadSize)

                //Sauces Details send to other activity

                act.putExtra("TomatoValue", tomatoValue.toString())
                act.putExtra("CheeseValue", cheeseValue.toString())

                //topping Details send to other activity
                act.putExtra("onionValue", onionCheck.toString())
                act.putExtra("masroomValue", masroomCheck.toString())
                act.putExtra("greenpValue", greenpCheck.toString())
                //final bill move to other activity
                act.putExtra("FinalBill", countingValue.toString())
                startActivity(act)
            })
            alert.addAction(AlertAction("No", AlertActionStyle.NEGATIVE) { action ->
                Toasty.warning(this,"Your Order Is Canceled...",Toast.LENGTH_LONG).show()
            })
            alert.setTheme(AlertTheme.DARK)
            alert.show(this@OtherToppings)

        }

    }

    fun SendOrder() {
        //Volley Method to insert data
        val stringRequest = object : StringRequest(
            Method.POST, "http://192.168.115.2/updated_api/v1/?op=customizeOrder",
            Response.Listener<String> { response ->
                try {
                    val obj = JSONObject(response)
                    Toasty.success(this@OtherToppings,
                        obj.getString("message"),
                        Toast.LENGTH_LONG
                    ).show()
                    //Toast.makeText(this@OtherToppings, obj.getString("name") + " Is Inserted", Toast.LENGTH_LONG).show()
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { volleyError ->
                android.widget.Toast.makeText(
                    applicationContext,
                    volleyError.message,
                    Toast.LENGTH_LONG
                ).show()
                android.widget.Toast.makeText(
                    applicationContext,
                    "Failed something wrong...",
                    Toast.LENGTH_LONG
                ).show()
            }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String> {
                var map = HashMap<String, String>()
                map.put("cTableNo", dbTableName.toString())
                map.put("cBreadDetails", dbBreadDetails.toString())
                map.put("cSaucesDetails", dbSaucesDetails.toString())
                map.put("cOtherDetails", dbOtherDetails.toString())
                map.put("cTotalBill", countingValue.toString())
                return map
            }
        }
        VolleySingleton.instance?.addToRequestQueue(stringRequest)

    }

}
