package com.example.mainapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.findmyip3.repository.IPFetcherRepository
import com.example.findmyip3.repository.IRepository
import com.example.findmyip3.view.DisplayIPDetails
import com.example.findmyip3.viewmodel.IPFetcherViewModel
import com.example.findmyip3.viewmodel.IPFetcherViewModelFactory

class MainActivity : ComponentActivity() {
    private val repository: IRepository by lazy {
        IPFetcherRepository()
    }
    private val viewmodel: IPFetcherViewModel by viewModels {
        IPFetcherViewModelFactory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            DisplayIPDetails(viewModel = viewmodel)
        }
    }
}