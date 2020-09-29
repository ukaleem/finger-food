package com.example.aleemullah.fingerfood.userSection

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.aleemullah.fingerfood.EndPointsApi
import com.example.aleemullah.fingerfood.R
import com.example.aleemullah.fingerfood.model.Tabels
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login_table.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class LoginTable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_table)

        //Login button onclick listener
        try {
            loginBtn.setOnClickListener {

                // Create ProgressBar And Set Message and show while loading...
                val progressBar = ProgressDialog(this@LoginTable)
                progressBar.setMessage("Please wait...")
                progressBar.show()

                val myQue = Volley.newRequestQueue(this@LoginTable)

                val sr = object : StringRequest(Request.Method.POST, EndPointsApi.TABLE_LOGIN,
                    Response.Listener<String> { response ->
                        try {

                            //Text Box values assign to Variables
                            val tblNo = tableNo.text.toString()
                            val tblPw = Password.text.toString()

                            val obj = JSONObject(response)

                            //API ERROR AND MESSAGE

                            val error = obj.getBoolean("error")
                            val msg = obj.getString("message")

                            if (tblNo == "") {
                                progressBar.dismiss()
                                Toasty.error(applicationContext, "Table Name Field can't be empty!", Toast.LENGTH_LONG)
                                    .show()
                            }
                            if (tblPw == "") {
                                progressBar.dismiss()
                                Toasty.error(applicationContext, "Password Field can't be empty!", Toast.LENGTH_LONG)
                                    .show()
                            }
                            if (error == true) {
                                progressBar.dismiss()
                                Toasty.error(applicationContext, "*Opps! Error=$error ->$msg ", Toast.LENGTH_LONG)
                                    .show()

                            } else if (error == false) {

                                progressBar.dismiss()
                                val ThisTableId = obj.getString("tableid")
                                val ThisTableName = obj.getString("tablename")

                                var tableClassObj = Tabels(ThisTableId.toString(), ThisTableName.toString())

                                Toasty.success(applicationContext, "Wellcome! $msg", Toast.LENGTH_LONG).show()
                                //Toast.makeText(applicationContext, "Name = $ThisTableName", Toast.LENGTH_LONG).show()

                                //Move to new activity (GetStarted) + putExtra variables ThisTableId and ThisTableName
                                val intent = Intent(this, GetStarted::class.java)
                                intent.putExtra("com.example.aleemullah.fingerfood.userSection.MyTableId", ThisTableId)
                                intent.putExtra(
                                    "com.example.aleemullah.fingerfood.userSection.MyTableName",
                                    ThisTableName
                                )

                                startActivity(intent)
                            }
                        } catch (Ex: JSONException) {
                            Toasty.error(
                                applicationContext,
                                "Please Check Internet Connection" + Ex.message,
                                Toast.LENGTH_LONG
                            )
                                .show()
                        } catch (ex: Exception) {
                            Toasty.error(applicationContext, "Exception " + ex.message, Toast.LENGTH_LONG).show()
                        }

                    }, object : Response.ErrorListener {
                        override fun onErrorResponse(volleyError: VolleyError) {
                            Toasty.error(applicationContext, "" + volleyError.message, Toast.LENGTH_LONG).show()
                            Toasty.error(applicationContext, "failed something wrong", Toast.LENGTH_LONG).show()
                        }
                    }) {
                    @Throws(AuthFailureError::class)
                    override fun getParams(): Map<String, String> {
                        val params = HashMap<String, String>()
                        params.put("tbl_name", tableNo.text.toString())
                        params.put("tbl_password", Password.text.toString())
                        return params
                    }
                }
                myQue.add(sr)
            }
        } catch (ex: Exception) {
            Toasty.info(this@LoginTable, "Please Check Your Connection and Try Again..", Toasty.LENGTH_LONG).show()
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }
}
