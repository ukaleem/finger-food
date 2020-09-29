package com.example.aleemullah.fingerfood.model

class SidesData {
    var id :Int = 0
    var item_text : String = ""
    var price_text : String = ""
    var quantity_edit_text : String = ""
    var done_Btn : Int = 0

    constructor(Id:Int,Item_Text:String,Price:String,Quantity_edit_txt:String,Done_Btn:Int){
        this.id = Id
        this.item_text = Item_Text
        this.price_text = Price
        this.quantity_edit_text = Quantity_edit_txt
        this.done_Btn = Done_Btn

    }

    }

