package br.edu.iesb.android2.whatsup.service

import br.edu.iesb.android2.whatsup.domain.ItemResult
import retrofit2.http.GET

interface JsonPlaceholderService {

    @GET("posts")
    suspend fun getPosts(): List<ItemResult>
}