package com.softwarica.formurlheroesapi;

import java.util.HashMap;
import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Employee_Interface {
    @GET("heroes")
    Call<List<Employee>> getAllData();

    @FormUrlEncoded
    @POST("heroes")
    Call<Void> putData(@Field("name") String name, @Field("desc") String password);

    @FormUrlEncoded
    @POST("heroes")
    Call<Void> putAllData(@FieldMap HashMap<String, String> item);


    @Multipart
    @POST("upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);

}
