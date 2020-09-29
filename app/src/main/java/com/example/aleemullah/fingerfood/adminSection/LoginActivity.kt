package com.example.aleemullah.fingerfood.adminSection

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.aleemullah.fingerfood.EndPointsApi
import com.example.aleemullah.fingerfood.R
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {

    //Define Variables
    private lateinit var adminName: EditText
    private lateinit var PW: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //initialization variables

        adminName = findViewById(R.id.adminNameTxt)
        PW = findViewById(R.id.passwordTxt)

        //login button onclick listener

        val buttonLogin = findViewById<Button>(R.id.LoginButton)
        buttonLogin.setOnClickListener(View.OnClickListener { v ->

            val myQue = Volley.newRequestQueue(this@LoginActivity)
            //http://192.168.115.2/rest_api/v1/?op=login
            val sr = object : StringRequest(Request.Method.POST, "http://localhost/updated_api/v1/?op=LOGIN",
                Response.Listener<String> { response ->

                    val name = adminNameTxt.text.toString()
                    val pw = passwordTxt.text.toString()

                    val obj = JSONObject(response)

                    //API ERROR AND MESSAGE
                    val error = obj.getBoolean("error")
                    val msg = obj.getString("message")

                    if (name == "") {
                        Toasty.error(applicationContext, "Name Field can't be empty!", Toast.LENGTH_LONG).show()
                    }
                    if (pw == "") {
                        Toasty.error(applicationContext, "Password Field can't be empty!", Toast.LENGTH_LONG).show()
                    }
                    //if api returns some error=True
                    if (error) {
                        Toasty.error(applicationContext, "*Opps! Error=$error ->$msg ", Toast.LENGTH_LONG).show()
                    } else if (!error) {
                        val AdminHome = Intent(applicationContext, admin_panel_home::class.java)
                        AdminHome.putExtra("LogedInAdminName",name)
                        startActivity(AdminHome)
                        Toasty.success(applicationContext, "Wellcome! -> $msg", Toast.LENGTH_LONG).show()
                    }

                    //Other Choice of login with URL http://192.168.115.2/rest_api/v1/login.php
                    /* if (response.trim().equals("Success")) {
                         var AdminHome = Intent(applicationContext, AdminHomeActivity::class.java)
                         startActivity(AdminHome)
                     } else if (response.trim().equals("Failed")) {
                         Toast.makeText(applicationContext, "Invalid! Data LOGIN Failed...", Toast.LENGTH_LONG).show()
                     }*/

                },
                object : Response.ErrorListener {
                    override fun onErrorResponse(volleyError: VolleyError) {
                        Toasty.error(applicationContext, ""+volleyError.message, Toast.LENGTH_LONG).show()
                        Toasty.error(applicationContext, "failed something wrong", Toast.LENGTH_LONG).show()
                    }
                }) {
                @Throws(AuthFailureError::class)
                override fun getParams(): Map<String, String> {
                    val params = HashMap<String, String>()
                    params.put("email", adminNameTxt.text.toString())
                    params.put("password", passwordTxt.text.toString())
                    return params
                }
            }
            myQue.add(sr)
        })

    }
    /*fun login(view: View){
        var email = adminNameTxt.text.toString()
        var password = passwordTxt.text.toString()

        val urlLogin = "http://192.168.56.1/rest_api/v1/?op=login";

        val mstringRequest = object : StringRequest(Request.Method.POST, urlLogin,
            Response.Listener<String> { response ->
                try {
                var obj = JSONObject(response)

                if (obj.getBoolean("error") == false)
                {
                    var AdminHome = Intent(applicationContext,AdminHomeActivity::class.java)
                    startActivity(AdminHome)
                } else {
                    Toast.makeText(applicationContext,"LOGIN Failed!", Toast.LENGTH_LONG).show()
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            }, object : Response.ErrorListener {
                override fun onErrorResponse(volleyError: VolleyError) {
                    Toast.makeText(applicationContext, volleyError.message, Toast.LENGTH_LONG).show()
                    Toast.makeText(applicationContext, "failed something wrong", Toast.LENGTH_LONG).show()
                }
            }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String> {
                var map = HashMap<String,String>()
                map.put("email",email)
                map.put("password",password)
                return  map
            }
        }
        VolleySingleton.instance?.addToRequestQueue(mstringRequest)
    }*/


/*    @SuppressLint("WrongViewCast")
    fun login(view: View){

        //set email and password here

        var email: EditText? = findViewById<EditText>(R.id.adminNameTxt)
        var password: EditText? = findViewById<EditText>(R.id.passwordTxt)

        var loginURL:String = "http://192.168.56.1/rest_api/v1/?op=login"

        var que = Volley.newRequestQueue(this@LoginActivity)

        val stringRequest = object : StringRequest(
            Request.Method.POST, loginURL,
            Response.Listener<String> { response ->
                try {
                    var obj = JSONObject(response)

                    if (obj.getBoolean("error") == false)
                    {
                        var AdminHome = Intent(applicationContext,AdminHomeActivity::class.java)
                        startActivity(AdminHome)
                    } else {
                        Toast.makeText(applicationContext,"LOGIN Failed!", Toast.LENGTH_LONG).show()
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            object : Response.ErrorListener {
                override fun onErrorResponse(volleyError: VolleyError) {
                    Toast.makeText(applicationContext, volleyError.message, Toast.LENGTH_LONG).show()
                    Toast.makeText(applicationContext, "failed something wrong", Toast.LENGTH_LONG).show()

                }
            }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params.put("email", email.toString())
                params.put("password", password.toString())
                return params
            }
        }
        que.add(stringRequest)

    }*/
}
