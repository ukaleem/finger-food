package com.example.aleemullah.fingerfood.model

import java.io.Serializable

class BreadsClass() :Serializable {

    private var BId:Int = 0
    private var BName:String = ""
    private var BSize:String = ""
    private var BPrice:Int = 0
    private val AllBreadsAtOnce = hashMapOf<String,String>()

    constructor(breadId: Int = 0, breadName: String = "", breadSize: String = "", breadPrice: Int = 0):this(){
        this.BId = breadId
        this.BName = breadName
        this.BSize = breadSize
        this.BPrice = breadPrice
    }
    public fun insertAllBreadsAtOncePlace(){
        AllBreadsAtOnce["id${this.BId}"] = this.BId.toString()
        AllBreadsAtOnce["name${this.BId}"] = this.BName
        AllBreadsAtOnce["size${this.BId}"] = this.BSize
        AllBreadsAtOnce["price${this.BId}"] = this.BPrice.toString()
    }

    public fun getBreadWithId(id:Int):Map<String,String>{

        val data= hashMapOf<String,String>()

        val newid = AllBreadsAtOnce["id$id"]?.toInt()
        val newname = AllBreadsAtOnce["name$id"]
        val newsize = AllBreadsAtOnce["size$id"]
        val newprice = AllBreadsAtOnce["price$id"]
        data["id"] = "$newid"
        data["name"] = "$newname"
        data["size"] = "$newsize"
        data["price"] = "$newprice"
        return data
    }
}