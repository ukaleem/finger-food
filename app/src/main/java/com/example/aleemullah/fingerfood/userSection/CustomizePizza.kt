package com.example.aleemullah.fingerfood.userSection

import android.content.Intent
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.NonNull
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.aleemullah.fingerfood.R
import com.example.aleemullah.fingerfood.model.BreadsClass
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_customize_pizza.*
import org.json.JSONObject

class CustomizePizza : AppCompatActivity() {

    var tid = ""
    var tName = ""

    var collectAllBreadsAtOnce = hashMapOf<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customize_pizza)

        if (intent.extras != null) {
            val my_intent = intent
            tid = my_intent.getStringExtra("TABLE_ID")
            tName = my_intent.getStringExtra("TABLE_NAME")
        }

        //geting Id of Customize Screen Top Label And Change its font to TypeFace
        var customizeHeadText = findViewById<TextView>(R.id.headText)
        var face = Typeface.createFromAsset(assets, "fonts/FORTE.TTF")
        customizeHeadText.typeface = face

        var smallId = 0
        var largeId = 0
        var mediumId = 0

        /* ---------- Declare  Animation ---------- */

        val myanim = AnimationUtils.loadAnimation(this, R.anim.myanim)

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this@CustomizePizza)

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, "http://192.168.115.2/updated_api/v1/?op=getBread",
            Response.Listener<String> { response ->
                val obj = JSONObject(response)
                var BreadsArray = obj.getJSONArray("Breads")

                for (i in 0 until BreadsArray.length()) {
                    val bread = BreadsArray.getJSONObject(i)
                    var id = bread.getString("bread_id")
                    var name = bread.getString("bread_name")
                    var size = bread.getString("bread_size")
                    var price = bread.getString("bread_price")

                    if (size == "Small") {
                        smallId = id.toInt()
                    }
                    if (size == "Medium") {
                        mediumId = id.toInt()
                    }
                    if (size == "Large") {
                        largeId = id.toInt()
                    }
                    collectAllBreadsAtOnce.put("id$id", "" + id.toString())
                    collectAllBreadsAtOnce.put("name$id", "" + name.toString())
                    collectAllBreadsAtOnce.put("size$id", "" + size.toString())
                    collectAllBreadsAtOnce.put("price$id", "" + price.toString())

                    Toasty.Config.getInstance().apply()

                    var eachBreadWithId = getBreadWithId(id.toInt())
                    Toasty.success(
                        this@CustomizePizza, "Res; ${eachBreadWithId["id"]} " +
                                "${eachBreadWithId["name"]}" +
                                "${eachBreadWithId["size"]}" +
                                "${eachBreadWithId["price"]}", Toast.LENGTH_SHORT
                    ).show()
                }
            }, Response.ErrorListener {
                Toast.makeText(
                    this@CustomizePizza, "Something Wrong Please check internet Connection...",
                    Toast.LENGTH_LONG
                ).show()
            })
        queue.add(stringRequest)


        /* ---------- Small Text Animation ---------- */

        smallText.startAnimation(myanim)

        /* ---------- Small Text ClickListener ---------- */

        smallText.setOnClickListener {
            val intent1 = Intent(this, SauceTopping::class.java)
            var small_bread = getBreadWithId(smallId.toInt())
            intent1.putExtra("tId", tid.toString())
            intent1.putExtra("tName", tName.toString())
            intent1.putExtra("breadId", small_bread["id"])
            intent1.putExtra("breadName", small_bread["name"])
            intent1.putExtra("breadPrice", small_bread["price"])
            intent1.putExtra("breadSize", small_bread["size"])
            intent1.putExtra("imgId", R.drawable.twodough)
            startActivity(intent1)
        }
        /* ---------- Medium Text Animation ---------- */

        mediumText.startAnimation(myanim)

        /* ---------- Medium Text ClickListener ---------- */

        mediumText.setOnClickListener {
            val intent1 = Intent(this, SauceTopping::class.java)
            var small_bread = getBreadWithId(mediumId.toInt())
            intent1.putExtra("tId", tid.toString())
            intent1.putExtra("tName", tName.toString())
            intent1.putExtra("breadId", small_bread["id"])
            intent1.putExtra("breadName", small_bread["name"])
            intent1.putExtra("breadPrice", small_bread["price"])
            intent1.putExtra("breadSize", small_bread["size"])
            intent1.putExtra("imgId", R.drawable.twodough)
            startActivity(intent1)
        }

        /* ---------- Large Text Animation ---------- */

        largeText.startAnimation(myanim)

        /* ---------- Large Text ClickListener ---------- */

        largeText.setOnClickListener {
            val intent1 = Intent(this, SauceTopping::class.java)
            var small_bread = getBreadWithId(largeId.toInt())
            intent1.putExtra("tId", tid.toString())
            intent1.putExtra("tName", tName.toString())

            intent1.putExtra("breadId", small_bread["id"])
            intent1.putExtra("breadName", small_bread["name"])
            intent1.putExtra("breadPrice", small_bread["price"])
            intent1.putExtra("breadSize", small_bread["size"])
            intent1.putExtra("imgId", R.drawable.twodough)
            startActivity(intent1)
        }
    }

    fun getBreadWithId(id: Int): Map<String, String> {

        val data = hashMapOf<String, String>()

        val newid = collectAllBreadsAtOnce["id$id"]?.toInt()
        val newname = collectAllBreadsAtOnce["name$id"]
        val newsize = collectAllBreadsAtOnce["size$id"]
        val newprice = collectAllBreadsAtOnce["price$id"]
        data["id"] = "$newid"
        data["name"] = "$newname"
        data["size"] = "$newsize"
        data["price"] = "$newprice"
        return data
    }
}
