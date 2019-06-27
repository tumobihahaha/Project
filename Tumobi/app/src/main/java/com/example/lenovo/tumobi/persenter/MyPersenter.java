package com.example.lenovo.tumobi.persenter;


import com.example.lenovo.tumobi.base.BasePersenter;
import com.example.lenovo.tumobi.component.CommonSubscriber;
import com.example.lenovo.tumobi.interfaces.news.NewsContract;
import com.example.lenovo.tumobi.model.bean.IndexBean;
import com.example.lenovo.tumobi.model.bean.home_bean.Frist_Bean;
import com.example.lenovo.tumobi.model.http.HttpManager;
import com.example.lenovo.tumobi.utils.RxUtils;

public class MyPersenter extends BasePersenter<NewsContract.View> implements NewsContract.Presenter {


    @Override
    public void getIndex() {
        addSubscribe(HttpManager.getMyApi().getIndexData()
        .compose(RxUtils.<Frist_Bean> rxScheduler())
        .subscribeWith(new CommonSubscriber<Frist_Bean>(mView){
            @Override
            public void onNext(Frist_Bean indexBean) {
                mView.getIndexReturn(indexBean);
            }
        }));
    }
}