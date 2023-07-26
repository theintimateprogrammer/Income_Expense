package com.example.income_expense


class TransactionModel {

    var id = 0
    var amount = 0
    var  category: String

    var note: String
    var isExpence = 0
    var date: String
     var month: String
    var year: String

    constructor(id: Int, amount: Int, category: String, note: String, isExpence: Int, date: String, month: String, year: String) {
        this.id = id
        this.amount = amount
        this.category = category
        this.note = note
        this.isExpence = isExpence
        this.date = date
        this.month = month
        this.year = year
    }
}
