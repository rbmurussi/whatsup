package br.edu.iesb.android2.whatsup.domain

import com.google.gson.annotations.SerializedName


data class UserData (
    var gender: String = "",
    var age: Int = 0,
    var height: Float = 0.0f,
    var weight: Float = 0.0f ,
    var exerciceDo: Int = 0,
    var exerciceStrenght: String = "",
    var exerciceFrequency: Int = 1,
    var workDo: Int = 0,
    var workStrenght: Int = 1,
    //var userData: UserData?
)

data class Message (
    val text: String,
    val email: String,
    val sessionId: String
)

data class Intent (
    val displayName: String
)

data class  BooleanString (
    val stringValue: String
)

data class  Number (
    val numberValue: String
)

data class  NumberValue (
    val numberValue: String
)

data class GenderEntity (
    val stringValue: String
)

data class Fields (
    val GenderEntity: GenderEntity,
    @SerializedName("number-integer") val numberInteger: NumberValue,
    val number: Number,
    val Boolean: BooleanString
)

data class Parameters (
    val fields: Fields
)

data class TextFulfillment (
    val text: List<String>
)

data class FulfillmentMessages (
    val text: TextFulfillment
)

data class QueryResult (
    val fulfillmentText: String,
    val fulfillmentMessages: List<FulfillmentMessages>,
    val parameters: Parameters,
    val intent: Intent
)

data class Response (
    val queryResult: QueryResult
)