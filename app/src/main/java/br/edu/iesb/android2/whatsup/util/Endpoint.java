package br.edu.iesb.android2.whatsup.util;

import java.util.List;

import br.edu.iesb.android2.whatsup.domain.ItemResult;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Endpoint {
    @GET("posts")
    Call<List<ItemResult>> getPosts();
}
