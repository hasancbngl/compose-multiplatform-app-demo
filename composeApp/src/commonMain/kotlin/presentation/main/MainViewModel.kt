package presentation.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.repository.AppRepository
import domain.model.Product
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: AppRepository
) : ViewModel() {

    private val _products : MutableState<List<Product>> = mutableStateOf(emptyList())
    val products = _products

    init {
        viewModelScope.launch {
            repository.getAllProducts().collectLatest {
                _products.value = it
            }
        }
    }
}