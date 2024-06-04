package presentation.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.repository.AppRepository
import domain.model.Product
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: AppRepository
) : ViewModel() {

    private val _data : MutableState<List<Product>> = mutableStateOf(emptyList())
    val data = _data

    init {
        viewModelScope.launch {
            repository.readData().collectLatest {
                _data.value = it
            }
        }
    }
}