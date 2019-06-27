package com.example.lenovo.tumobi.model.apis;

import com.example.lenovo.tumobi.model.bean.IndexBean;

import com.example.lenovo.tumobi.model.bean.SearchBean;
import com.example.lenovo.tumobi.model.bean.home_bean.Frist_Bean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface MyApi {

    @GET("index/index")
    Flowable<Frist_Bean> getIndexData();

    @GET("search/index")
    Flowable<SearchBean> getSearchData();

}
