package com.androidabhi.mvvm_di_kodein.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.androidabhi.mvvm_di_kodein.R
import com.androidabhi.mvvm_di_kodein.data.model.Quote
import kotlinx.android.synthetic.main.activity_quotes.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class QuotesActivity : AppCompatActivity(), KodeinAware {

    // using by means its lazily initialized
    // closestKodein() -> gets Kodein defined in QuotesApplication
    override val kodein by closestKodein()

    // get insatnce of QuotesViewModelFactory from kodein
    private val viewModelFactory : QuotesViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUi()
    }

    private fun initializeUi() {
        // Use ViewModelProviders class to create / get already created QuotesViewModel
        // for this view (activity)
        // preserver their state if already exists
        val viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(QuotesViewModel::class.java)

        // Observing LiveData from the QuotesViewModel which in turn observes
        // LiveData from the repository, which observes LiveData from the DAO
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })

        // When button is clicked, instantiate a Quote and add it to DB through the ViewModel
        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}
