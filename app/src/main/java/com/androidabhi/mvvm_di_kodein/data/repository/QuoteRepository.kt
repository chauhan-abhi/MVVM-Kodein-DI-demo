package com.androidabhi.mvvm_di_kodein.data.repository

import androidx.lifecycle.LiveData
import com.androidabhi.mvvm_di_kodein.data.model.Quote

//single source of truth for the data that view models request
interface QuoteRepository {
    fun addQuote(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>
}