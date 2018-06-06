package com.altice_crt_a.android__avanzado_4.interfaces;

import com.altice_crt_a.android__avanzado_4.classes.Photo;
import com.altice_crt_a.android__avanzado_4.classes.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by jaime on 6/2/2018.
 */

public interface JSONPlaceholderService {
    @GET("users")
    Call<List<User>> listUsers();

    @GET("photos")
    Call<List<Photo>> listPhotos();

}
