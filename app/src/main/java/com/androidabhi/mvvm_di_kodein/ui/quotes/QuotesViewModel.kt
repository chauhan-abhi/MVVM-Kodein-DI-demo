package com.androidabhi.mvvm_di_kodein.ui.quotes

import androidx.lifecycle.ViewModel
import com.androidabhi.mvvm_di_kodein.data.model.Quote
import com.androidabhi.mvvm_di_kodein.data.repository.QuoteRepository

class QuotesViewModel(private val quotesRepository: QuoteRepository)
    : ViewModel(){

    fun addQuotes(quote: Quote) = quotesRepository.addQuote(quote)

    fun getQuotes() = quotesRepository.getQuotes()

}
