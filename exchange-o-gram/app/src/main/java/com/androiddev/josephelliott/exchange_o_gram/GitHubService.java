package com.androiddev.josephelliott.exchange_o_gram;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Joseph Elliott on 1/12/2016.
 */
public interface GitHubService {
    @GET("api/posts")
    Call<ArrayList<Post>> listPosts(@Path("post") Post post);
}
