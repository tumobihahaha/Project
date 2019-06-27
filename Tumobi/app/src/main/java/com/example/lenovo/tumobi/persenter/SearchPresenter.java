package com.example.lenovo.tumobi.persenter;

import com.example.lenovo.tumobi.base.BasePersenter;
import com.example.lenovo.tumobi.component.CommonSubscriber;
import com.example.lenovo.tumobi.interfaces.search.SearchContract;
import com.example.lenovo.tumobi.model.bean.SearchBean;
import com.example.lenovo.tumobi.model.http.HttpManager;
import com.example.lenovo.tumobi.utils.RxUtils;

/**
 * Created by 吕尚勇 on 2019/6/24.
 */

public class SearchPresenter extends BasePersenter<SearchContract.View> implements SearchContract.Presenter {
    @Override
    public void getSearch() {
        addSubscribe(HttpManager.getMyApi().getSearchData()
                .compose(RxUtils.<SearchBean> rxScheduler())
                .subscribeWith(new CommonSubscriber<SearchBean>(mView){
                    @Override
                    public void onNext(SearchBean searchBean) {
                        mView.getSearchReturn(searchBean);
                    }
                }));
    }
    }
