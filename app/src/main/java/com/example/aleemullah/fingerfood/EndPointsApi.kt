package com.example.aleemullah.fingerfood

/*
|---------------------------------------------
|
* This is a End Points API Url file that holds...
* -BASE_URL provides base http url for server.
* -LOGIN Complete API Call Avalible At php .../rest_api/dbOprations => fun#08 Admin Login Function
* -TABLE_LOGIN Complete API Call Avalible At php .../rest_api/dbOprations => fun#09 TABLE Login Function
* -Ethernet adapter VirtualBox Host-Only Network: 192.168.56.1
* -Ethernet adapter VirtualBox Host-Only Network #2: 192.168.63.2
* -Ethernet adapter VirtualBox Host-Only Network #3: 192.168.115.2
|----------------------------------------------
* */
object EndPointsApi{
    //https://liberal-bureaus.000webhostapp.com/foodapi/home.php/?op=
    //http://192.168.115.2/rest_api/v1/?op=
    private val BASE_URL = "http://192.168.115.2/rest_api/v1/?op="

    //Admin Login url
    val LOGIN = "http://192.168.115.2/rest_api/v1/?op=login"

    //Table login url
    val TABLE_LOGIN = BASE_URL+"tableLogin"

    //Get All Breads url
    val BREAD_URL = BASE_URL+"getBread"

    //Get All Side Items url
    val SIDE_ITEMS = BASE_URL+"Get_Side_Items"

    //Insert Side Items url
    val ADD_SIDE_ITEMS = BASE_URL+"addNewSideItems"

    //Insert New Pizza url
    val ADD_NEW_PIZZA = BASE_URL+"addCustomPizza"
}