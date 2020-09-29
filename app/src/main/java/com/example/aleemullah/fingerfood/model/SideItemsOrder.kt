package com.example.aleemullah.fingerfood.model

import java.io.Serializable

class SideItemsOrder() : Serializable {
    public var id = 0
    public var quantity = 0
    var productIds = hashMapOf<String, String>()

    constructor(Id: Int, Quantity: Int) : this() {
        this.id = Id
        this.quantity = Quantity
    }

    fun addProductIds(): HashMap<String, String> {
        this.productIds.put("PID${this.id}", "${this.id}")
        this.productIds.put("PID${this.id}Q", "${this.quantity}")
        return this.productIds
    }

    fun getProductsIds(): HashMap<String,String>{
        return productIds
    }

    fun removeProductIds(): HashMap<String, String> {
        this.productIds.remove("PID${this.id}")
        this.productIds.remove("PID${this.id}Q")
        return this.productIds
    }


}