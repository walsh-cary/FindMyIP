package com.example.mainapp

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.findmyip3.repository.IPFetcherRepository
import com.example.findmyip3.view.DisplayIPDetails
import com.example.findmyip3.viewmodel.IPFetcherViewModel
import com.example.findmyip3.viewmodel.IPFetcherViewModelFactory
import com.example.mainapp.ui.theme.MainAppTheme

class MainActivity : ComponentActivity() {
    private val viewModel: IPFetcherViewModel by viewModels {
        IPFetcherViewModelFactory(IPFetcherRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            MainAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayIPDetails(viewModel)
                }
            }
        }
    }
}