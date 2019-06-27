package com.example.lenovo.tumobi.interfaces.search;

import com.example.lenovo.tumobi.interfaces.IBaseView;
import com.example.lenovo.tumobi.interfaces.IPersenter;
import com.example.lenovo.tumobi.model.bean.SearchBean;

/**
 * Created by 吕尚勇 on 2019/6/24.
 */

public interface SearchContract {
    interface View extends IBaseView {
        void getSearchReturn(SearchBean searchBean);
    }

    interface Presenter extends IPersenter<View> {
        void getSearch();
    }
}
