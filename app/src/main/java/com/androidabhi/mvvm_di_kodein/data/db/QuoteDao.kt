package com.androidabhi.mvvm_di_kodein.data.db

import androidx.lifecycle.LiveData
import com.androidabhi.mvvm_di_kodein.data.model.Quote

// DAO is an interface through which we add stuff and get stuff from local database

interface QuoteDao {
    fun addQuote(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>
}