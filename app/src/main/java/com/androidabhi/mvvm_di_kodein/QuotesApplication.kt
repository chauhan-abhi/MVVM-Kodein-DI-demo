package com.androidabhi.mvvm_di_kodein

import android.app.Application
import com.androidabhi.mvvm_di_kodein.data.db.Database
import com.androidabhi.mvvm_di_kodein.data.db.DatabaseFakeImpl
import com.androidabhi.mvvm_di_kodein.data.db.QuoteDao
import com.androidabhi.mvvm_di_kodein.data.repository.QuoteRepository
import com.androidabhi.mvvm_di_kodein.data.repository.QuoteRepositoryImpl
import com.androidabhi.mvvm_di_kodein.ui.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

// This class is accessible from all componsnts of the app-> activites, fragments
class QuotesApplication : Application(), KodeinAware  {
    override val kodein = Kodein.lazy {
        bind<Database>() with singleton { DatabaseFakeImpl() }
        // DO not do this because every Dao is centered around a database
        //bind<QuoteDao>() with singleton { QuoteDaoFakeImpl() }

        // so we can get it from DatabaseImpl
        // instance<Database> will return the Database bound above
        bind<QuoteDao>() with singleton { instance<Database>().quoteDao }

        // need QuoteDao to be passed while instantiating QuoteRepositoryImpl
        // instance() method will do so for us
        bind<QuoteRepository>() with singleton { QuoteRepositoryImpl(instance()) }

        // binding QuoteRepository with a concrete class
        // provider is opposite of singleton --> get new instance every time
        // a request is made to QuotesViewModelFactory

        // bind<QuotesViewModelFactory>() with provider { QuotesViewModelFactory(instance()) }

        // shorten code
        bind() from provider { QuotesViewModelFactory(instance()) }
    }


}