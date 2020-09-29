package com.example.aleemullah.fingerfood.model

class SaucesClass(saucesId: Int = 0, saucesName: String = "", saucesPrice: Int = 0, saucesQunty: Int = 0) {

    private var SId:Int = saucesId
    private var SName:String = saucesName
    private var SPrice:Int = saucesPrice
    private var SQunty:Int = saucesQunty

    private val AllSaucesAtOnce = hashMapOf<String,String>()

    public fun getSauceWithId(id:Int):Map<String,String>{

        val data= hashMapOf<String,String>()

        val newid = AllSaucesAtOnce["id${id}"]?.toInt()
        val newname = AllSaucesAtOnce["name${id}"]
        val newprice = AllSaucesAtOnce["price${id}"]
        val newqunty = AllSaucesAtOnce["qunty${id}"]
        data.put("id","$newid")
        data.put("name","$newname")
        data.put("price","$newprice")
        data.put("qunty","$newqunty")
        return data
    }

    init {
        AllSaucesAtOnce.put("id${this.SId}","${this.SId}")
        AllSaucesAtOnce.put("name${this.SId}",""+this.SName)
        AllSaucesAtOnce.put("price${this.SId}","${this.SPrice}")
        AllSaucesAtOnce.put("qunty${this.SId}","${this.SQunty}")
    }
}