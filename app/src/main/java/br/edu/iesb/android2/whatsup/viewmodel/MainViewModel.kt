package br.edu.iesb.android2.whatsup.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.edu.iesb.android2.whatsup.domain.ItemResult
import br.edu.iesb.android2.whatsup.util.Endpoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MainViewModel(val app: Application) : AndroidViewModel(app), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main
    val responseView = MutableLiveData<List<ItemResult>>();

    @Inject
    private lateinit var service : Endpoint

    fun load() {
        launch {
            responseView.value = service.posts.execute().body()
        }
    }
}