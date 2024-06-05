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


}