package com.example.aleemullah.fingerfood.model

class AdminOrderData {
    var order_id = ""
    var table_no_text: String = ""
    var pizza_quantity_text: String = ""
    var bread_detail_text: String = ""
    var sauce_detail_text: String = ""
    var topping_detail_text: String = ""
    var item_name_text : String = ""
    var item_quantity_text: String = ""
    var total_bill_text: String = ""
    var deleteButton: Int = 0

    constructor(
        Order_Id :Int,
        table_no_text: String,
        pizza_quantity_text: String,
        bread_detail_text: String,
        sauce_detail_text: String,
        topping_detail_text: String,
        item_name_text: String,
        item_quantity_text: String,
        total_bill_text: String,
        deleteButton: Int
    ) {
        this.order_id = Order_Id.toString()
        this.table_no_text = table_no_text
        this.pizza_quantity_text = pizza_quantity_text
        this.bread_detail_text = bread_detail_text
        this.sauce_detail_text = sauce_detail_text
        this.topping_detail_text = topping_detail_text
        this.item_name_text = item_name_text
        this.item_quantity_text = item_quantity_text
        this.total_bill_text = total_bill_text
        this.deleteButton = deleteButton
    }
}