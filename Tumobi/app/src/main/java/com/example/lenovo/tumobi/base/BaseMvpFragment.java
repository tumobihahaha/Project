package com.example.lenovo.tumobi.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.tumobi.interfaces.IBaseView;
import com.example.lenovo.tumobi.interfaces.IPersenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Lenovo on 2019/6/6.
 */

public abstract class BaseMvpFragment<V extends IBaseView,P extends IPersenter> extends Fragment implements IBaseView{
    protected P mPresenter;
    protected Context mContext;
    private Unbinder mBind;

    @Nullable
    @Override



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayout(), null);
        mBind = ButterKnife.bind(this, inflate);

        mContext = getActivity();
        mPresenter = initMvpPresenter();

        mPresenter.attchView(this);
        initView();
        initData();
        initListener();
        return inflate;
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initMvpPresenter();

    protected abstract int getLayout();


}
