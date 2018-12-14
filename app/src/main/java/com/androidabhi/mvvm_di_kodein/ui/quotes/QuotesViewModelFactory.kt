package com.androidabhi.mvvm_di_kodein.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androidabhi.mvvm_di_kodein.data.repository.QuoteRepository

class QuotesViewModelFactory(private val quotesRepository: QuoteRepository)
    :ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quotesRepository) as T
    }


}