package com.androidabhi.mvvm_di_kodein.data.repository

import androidx.lifecycle.LiveData
import com.androidabhi.mvvm_di_kodein.data.db.QuoteDao
import com.androidabhi.mvvm_di_kodein.data.model.Quote

class QuoteRepositoryImpl(private val quoteDao: QuoteDao)
    :QuoteRepository{
    override fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    override fun getQuotes() = quoteDao.getQuotes()


}