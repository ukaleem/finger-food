package com.example.aleemullah.fingerfood.model

class QuickOrderData {
    var id :Int = 0
    var product_image : Int = 0
    var item_text : String = ""
    var description_text : String = ""
    var price_text : String = ""
    var done_Btn : Int = 0
    var quantity_text : String = ""

    constructor(
        id: Int,
        product_image: Int,
        item_text: String,
        description_text: String,
        price_text: String,
        done_Btn: Int,
        quantity_text: String
    ) {
        this.id = id
        this.product_image = product_image
        this.item_text = item_text
        this.description_text = description_text
        this.price_text = price_text
        this.done_Btn = done_Btn
        this.quantity_text = quantity_text
    }
}

