package com.app.comics.marvels.data.network;

import com.app.comics.marvels.data.network.model.Characters;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface MarvelApi {

    @GET("/v1/public/characters")
    Call<Characters> getCharacters(@Query("ts") String timestamp, @Query("apikey") String apiKey, @Query("hash") String hash, @Query("limit") String limit);
}
