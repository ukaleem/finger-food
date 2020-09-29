package com.example.aleemullah.fingerfood.model

class ToppingClass(toppingId: Int = 0, toppingName: String = "", toppingPrice: Int = 0, toppingQunty: Int = 0) {
    private var TId:Int = toppingId
    private var TName:String = toppingName
    private var TPrice:Int = toppingPrice
    private var TQunty:Int = toppingQunty

    private val AllToppingAtOnce = hashMapOf<String,String>()

    //Get All Records with ID
    public fun getToppingWithId(id:Int):Map<String,String>{

        val data= hashMapOf<String,String>()

        val newid = AllToppingAtOnce["id${id}"]?.toInt()
        val newname = AllToppingAtOnce["name${id}"]
        val newprice = AllToppingAtOnce["price${id}"]
        val newqunty = AllToppingAtOnce["qunty${id}"]
        data.put("id","$newid")
        data.put("name","$newname")
        data.put("price","$newprice")
        data.put("qunty","$newqunty")
        return data
    }

    init {
        AllToppingAtOnce.put("id${this.TId}","${this.TId}")
        AllToppingAtOnce.put("name${this.TId}",""+this.TName)
        AllToppingAtOnce.put("price${this.TId}","${this.TPrice}")
        AllToppingAtOnce.put("qunty${this.TId}","${this.TQunty}")
    }
}