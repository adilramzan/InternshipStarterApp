package com.example.internshipstarterapp.utils

object Quotes {
    private val quotes=listOf(
       "aaaaaaaaaaaaaaaa","bbbbbbbbbbbbbbbb","CCCCCCCCCCCCCCCCC"
    )

    fun getQuote(): String {
        val randomIndex = (quotes.indices).random()
        return quotes[randomIndex]
    }
}