package presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.repository.AppRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: AppRepository
) : ViewModel() {

    fun addDummyData(){

    }
}