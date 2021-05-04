package br.edu.iesb.android2.whatsup.service

import br.edu.iesb.android2.whatsup.domain.ItemResult
import br.edu.iesb.android2.whatsup.domain.Message
import br.edu.iesb.android2.whatsup.domain.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface JsonPlaceholderService {

    @POST("message/text/send")
    @Headers("Content-Type: application/json")
    suspend fun sendMessageAsync(@Body message: Message): Array<Response>

//    @GET("posts")
//    suspend fun getPosts(): List<ItemResult>
}