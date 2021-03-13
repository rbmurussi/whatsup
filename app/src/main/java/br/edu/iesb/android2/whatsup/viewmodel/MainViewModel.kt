package br.edu.iesb.android2.whatsup.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.iesb.android2.whatsup.domain.ItemResult
import br.edu.iesb.android2.whatsup.service.JsonPlaceholderService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
        private val service: JsonPlaceholderService
) : ViewModel() {

    val responseView = MutableLiveData<List<ItemResult>>();

    fun load() = viewModelScope.launch {
        responseView.value = service.getPosts()
    }
}