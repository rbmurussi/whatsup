package br.edu.iesb.android2.whatsup.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.iesb.android2.whatsup.domain.*
import br.edu.iesb.android2.whatsup.service.JsonPlaceholderService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import br.edu.iesb.android2.whatsup.util.*

@HiltViewModel
class MainViewModel @Inject constructor(
        private val service: JsonPlaceholderService
) : ViewModel() {

    lateinit private var retorno: Retorno
    var responseView = MutableLiveData<List<Retorno>>()


    fun load(message: Message, userData: UserData, basalData: BasalData, resp: ArrayList<Retorno>) = viewModelScope.launch {

        val response = service.sendMessageAsync(message)
        val intent = response[0].queryResult.intent.displayName
        var textResp = ""

        verifyIntent(intent, userData, response[0])

        if (intent == "WorkIntent") {
            val metabolismoBasal = basalCalc(userData.gender, userData.age, userData.height, userData.weight, basalData)
            textResp += "Seu metabolismo basal é de ${metabolismoBasal} calorias!"
//            Log.d("TESTE_WHATSUP", "genero: ${userData.gender} / peso: ${userData.weight} / altura: ${userData.height} / idade: ${userData.age}")
        }
        else {

            if (response.isNotEmpty()) {

                for (fulfillmentMessage in response[0].queryResult.fulfillmentMessages) {
                    textResp += fulfillmentMessage.text.text[0] + "\n"
                }
            }
        }
        retorno = Retorno(message.text, textResp)
        resp.add(retorno)

        responseView.value = resp
    }
}