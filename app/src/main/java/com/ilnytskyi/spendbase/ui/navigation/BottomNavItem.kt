package com.ilnytskyi.spendbase.ui.navigation

import com.ilnytskyi.spendbase.R

sealed class BottomNavItem(var title:String, var icon:Int, var route:String){

    object Home : BottomNavItem("Home", R.drawable.ic_home,"home")
    object Transactions: BottomNavItem("Transactions",R.drawable.ic_transactions,"transactions")
    object MyCards: BottomNavItem("My Cards",R.drawable.ic_my_cards,"my_cards")
    object Account: BottomNavItem("Account",R.drawable.ic_account,"account")
}