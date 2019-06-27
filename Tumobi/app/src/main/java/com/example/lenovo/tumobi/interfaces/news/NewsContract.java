package com.example.lenovo.tumobi.interfaces.news;

import com.example.lenovo.tumobi.interfaces.IBaseView;
import com.example.lenovo.tumobi.interfaces.IPersenter;
import com.example.lenovo.tumobi.model.bean.IndexBean;
import com.example.lenovo.tumobi.model.bean.home_bean.Frist_Bean;

import java.util.List;

public interface NewsContract {

    interface View extends IBaseView {
        void getIndexReturn(Frist_Bean indexBean);
    }

    interface Presenter extends IPersenter<View> {
        void getIndex();
    }
}