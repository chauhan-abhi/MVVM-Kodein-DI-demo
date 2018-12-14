package com.androidabhi.mvvm_di_kodein.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.androidabhi.mvvm_di_kodein.data.model.Quote

class QuoteDaoFakeImpl : QuoteDao {

    private val quoteList = mutableListOf<Quote>()
    // made private to prevent it being changed directly from outside this class
    // Moreover , QuoteDao exposes LiveData in getQuotes which is not a mutable function
    // This can be observed from ouside --> MutableLiveData
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
    }


    override fun addQuote(quote: Quote) {
        quoteList.add(quote)
        quotes.value = quoteList
    }

    override fun getQuotes() = quotes as LiveData<List<Quote>>
}