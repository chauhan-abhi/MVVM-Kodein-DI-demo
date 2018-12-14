package com.androidabhi.mvvm_di_kodein.data.db

class DatabaseFakeImpl: Database {
    override val quoteDao: QuoteDao = QuoteDaoFakeImpl()
}