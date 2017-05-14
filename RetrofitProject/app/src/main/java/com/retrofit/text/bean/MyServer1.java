package com.retrofit.text.bean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by lenovo on 2017/5/10.
 */

public interface MyServer1 {
    //定义一个接口
     @GET ("/api/{category}/list")
     Call<Info> getServer(@Path("category")String category, @Query("id") int id, @Query("page") int page, @Query("rows") int rows);

    //post的请求的方法
    @POST("/api/{category}/list")
    @FormUrlEncoded//设置表单的编码，post的是以表单的形式上传的，设置表单的编码
     Call<Info>  load(@Path("category") String category, @Field("id") int id,@Field("page") int page,@Field("rows") int rows);


    //post进行请求
       @POST("login?")
       @FormUrlEncoded
        Call<LogBean>  login(@Query("name") String name,@Query("pwd") String pwd);


}
