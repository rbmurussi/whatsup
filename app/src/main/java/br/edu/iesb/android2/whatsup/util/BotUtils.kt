package br.edu.iesb.android2.whatsup.util

import android.util.Log
import br.edu.iesb.android2.whatsup.domain.BasalData
import br.edu.iesb.android2.whatsup.domain.Response
import br.edu.iesb.android2.whatsup.domain.UserData


    fun verifyIntent(intent: String, userData: UserData, vararg responses: Response) {

        when(intent) {
            "GenderIntent" -> userData.gender = responses[0].queryResult.parameters.fields.GenderEntity.stringValue
            "AgeIntent" -> userData.age = responses[0].queryResult.parameters.fields.numberInteger.numberValue.filter{ it.isDigit()}.toInt()
            "HeightIntent" -> userData.height = responses[0].queryResult.parameters.fields.number.numberValue.filter{ it.isDigit() || it == '.'}.toFloat()
            "WeightIntent" -> userData.weight = responses[0].queryResult.parameters.fields.number.numberValue.filter{ it.isDigit() || it == '.'}.toFloat()
            "ExerciceYesIntent" -> userData.exerciceDo = 1
            "ExerciceNoIntent" -> userData.exerciceDo = 0
//            "ExerciceIntensityIntent" -> userData.exerciceStrenght = value
//            "ExerciceFrequencyIntent" -> userData.exerciceFrequency = value.filter{ it.isDigit()}.toInt()
        }
//        when(intent) {
//            "GenderIntent" -> Log.d("TESTE_WHATSUP", "variavel height: ${userData.gender}")
//        }
    }

    fun basalCalc(gender: String, age: Int, height: Float, weight: Float, basalData: BasalData): Float {

        val basalResult: Float

        when (gender) {
            "Homem" -> {
                basalData.gender = 66
                basalData.weight = 13.7f
                basalData.height = 5.0f
                basalData.age = 6.8f
            }
            "Mulher" -> {
                basalData.gender = 665
                basalData.weight = 9.6f
                basalData.height = 1.8f
                basalData.age = 4.7f
            }

        }

        Log.d("TESTE_WHATSUP", "genero: ${basalData.gender} * ${gender} / peso: ${basalData.weight} * ${weight} / altura: ${basalData.height} * ${height} / idade: ${basalData.age} * ${age})")

        basalResult =   basalData.gender +
                (basalData.weight * weight) +
                (basalData.height * height) -
                (basalData.age * age)
        return basalResult
    }