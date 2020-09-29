package com.example.aleemullah.fingerfood.adminSection

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.example.aleemullah.fingerfood.EndPointsApi
import com.example.aleemullah.fingerfood.R
import com.example.aleemullah.fingerfood.VolleySingleton
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.content_admin_panel_home.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class admin_panel_home : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_panel_home)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.title = "Menu"
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "You Have Received New Order", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)


        /*
        * Set LogedIn Admin name to header_admin_panel textView
        * get Data from loginActivity
        * to check that this activity hasExtra or not
        * */
        val pre_activity_value = intent
        if (pre_activity_value.hasExtra("LogedInAdminName")) {
            var adminName = pre_activity_value.getStringExtra("LogedInAdminName")

            val headerView: View = navView.getHeaderView(0)

            val loginInAdmin = headerView.findViewById<TextView>(R.id.logedInAdminNameTxt)
            loginInAdmin.text = adminName

        }
    }

    // Onclick listener For insertSIdeItemsBtn Button From content_admin_panel_home.xml
    fun insertNewSideItems(view: View) {
        Toast.makeText(this@admin_panel_home, "Insert is Called...", Toast.LENGTH_LONG).show()
        //Get Data from Ui Screen to and assgin values to variables
        var name = nametxt.text.toString()
        var price = pricetxt.text.toString()
        var quanti = quntytxt.text.toString()

        when {
            name == "" -> Toasty.error(this@admin_panel_home,"Name Can't Be Empty...",Toast.LENGTH_LONG).show()
            price == "" -> Toasty.error(this@admin_panel_home,"Price Can't Be Empty...",Toast.LENGTH_LONG).show()
            quanti == "" -> Toasty.error(this@admin_panel_home,"Quantity Can't Be Empty...",Toast.LENGTH_LONG).show()
        }

        if(name!="" && price!="" && quanti!="") {
            //Volley Method to insert data
            val stringRequest = object : StringRequest(
                Method.POST, EndPointsApi.ADD_SIDE_ITEMS,
                Response.Listener<String> { response ->
                    try {
                        val obj = JSONObject(response)
                        android.widget.Toast.makeText(
                            this@admin_panel_home,
                            obj.getString("message"),
                            Toast.LENGTH_LONG
                        ).show()
                        Toasty.success(this@admin_panel_home,obj.getString("name")+" Is Inserted",Toast.LENGTH_LONG).show()
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
                        "failed something wrong...",
                        Toast.LENGTH_LONG
                    ).show()
                }) {
                @Throws(AuthFailureError::class)
                override fun getParams(): Map<String, String> {
                    var map = HashMap<String, String>()
                    map.put("name", name)
                    map.put("price", price)
                    map.put("quant", quanti)
                    return map
                }
            }
            VolleySingleton.instance?.addToRequestQueue(stringRequest)
        }
    }

    fun insertNewPizza(view: View) {
        try {
            //Get Data from Ui Screen and assign values to variables
            var name = pNametxt.text.toString()
            var price = pPricetxt.text.toString()
            var quanti = pQuntytxt.text.toString()
            var desc = pDesctxt.text.toString()
            when {
                name == "" -> Toast.makeText(this@admin_panel_home,"Name Can't Be Empty...",Toast.LENGTH_LONG).show()
                price == "" -> Toast.makeText(this@admin_panel_home,"Price Can't Be Empty...",Toast.LENGTH_LONG).show()
                quanti == "" -> Toast.makeText(this@admin_panel_home,"Quantity Can't Be Empty...",Toast.LENGTH_LONG).show()
                desc == "" -> Toast.makeText(this@admin_panel_home,"Description Can't Be Empty...",Toast.LENGTH_LONG).show()
            }

            if(name!="" && price!="" && quanti!="" && desc!="") {
                //Volley Method to insert data
                val stringRequest = object : StringRequest(
                    Method.POST, EndPointsApi.ADD_NEW_PIZZA,
                    Response.Listener<String> { response ->
                        try {
                            val obj = JSONObject(response)
                            android.widget.Toast.makeText(
                                this@admin_panel_home,
                                obj.getString("message"),
                                Toast.LENGTH_LONG
                            ).show()
                            Toast.makeText(this@admin_panel_home,obj.getString("name")+" Is Inserted",Toast.LENGTH_LONG).show()
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
                            "failed something wrong...",
                            Toast.LENGTH_LONG
                        ).show()
                    }) {
                    @Throws(AuthFailureError::class)
                    override fun getParams(): Map<String, String> {
                        var map = HashMap<String, String>()
                        map.put("cp_name", name)
                        map.put("cp_price", price)
                        map.put("cp_quantity", quanti)
                        map.put("cp_desc", desc)
                        return map
                    }
                }
                VolleySingleton.instance?.addToRequestQueue(stringRequest)
            }
        } catch (ex:Exception){
            Toast.makeText(this@admin_panel_home,"Please Check your Internet Connection...",Toast.LENGTH_LONG).show()
            ex.printStackTrace()
        } catch (ex:IOException){
            ex.printStackTrace()
        }

    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.admin_panel_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_order ->{
                val intent = Intent(this@admin_panel_home,admin_pannel_order::class.java)
                startActivity(intent)
            }
            R.id.nav_share -> {
                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.putExtra(Intent.EXTRA_TEXT,"This is paid App You can Contact us to Buy it @ukaleem540@gmail.com")
                shareIntent.setType("text/plan")
                startActivity(Intent.createChooser(shareIntent,"share via"))
            }
            /*        R.id.nav_home -> {
                        // Handle the camera action
                    }
                    R.id.nav_gallery -> {

                    }
                    R.id.nav_slideshow -> {

                    }
                    R.id.nav_tools -> {

                    }

                    R.id.nav_send -> {

                    }*/
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
