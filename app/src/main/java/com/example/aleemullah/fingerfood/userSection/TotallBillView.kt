package com.example.aleemullah.fingerfood.userSection

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.aleemullah.fingerfood.R
import kotlinx.android.synthetic.main.activity_totall_bill_view.*

class TotallBillView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_totall_bill_view)

        if (intent.extras != null) {
            //Get All Customize pizza ingridiets
            var breadId = intent.getStringExtra("breadId")
            var breadName = intent.getStringExtra("breadName")
            var breadPrice = intent.getStringExtra("breadPrice")
            var breadSize = intent.getStringExtra("breadSize")

            var tomatoValue = intent.getStringExtra("TomatoValue")
            var cheeseValue = intent.getStringExtra("CheeseValue")

            var onionValue = intent.getStringExtra("onionValue")
            var masroomValue = intent.getStringExtra("masroomValue")
            var greenpValue = intent.getStringExtra("greenpValue")

            var totalBill = intent.getStringExtra("FinalBill")

            breadNameLbl.text = ""+breadName
            breadSizeLbl.text = ""+breadSize
            breadPriceLbl.text = ""+breadPrice

            T_quantity.text = "Tomato Sauce $tomatoValue x"
            C_quantity.text = "Cheez $cheeseValue x"

            other_onio_quantity.text = "Onion $onionValue X"
            other_masroom_qunatity.text = "Mushrooms $masroomValue x"
            other_greenP_quantity.text = "Green Pepper $greenpValue x"

            final_bill_Txt.text = "Total Bill: Rs.$totalBill"

        }
    }
}
