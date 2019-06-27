package com.example.lenovo.tumobi.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.tumobi.R;
import com.example.lenovo.tumobi.adapter.SearchAdapter;
import com.example.lenovo.tumobi.base.BaseMvpFragment;
import com.example.lenovo.tumobi.interfaces.IPersenter;
import com.example.lenovo.tumobi.interfaces.search.SearchContract;
import com.example.lenovo.tumobi.model.bean.Bean;
import com.example.lenovo.tumobi.model.bean.SearchBean;
import com.example.lenovo.tumobi.persenter.SearchPresenter;
import com.example.lenovo.tumobi.ui.FlowLayout;
import com.example.lenovo.tumobi.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 吕尚勇 on 2019/6/24.
 */

public class Search extends BaseMvpFragment implements SearchContract.View {

    @BindView(R.id.rv_search)
    RecyclerView mRvSearch;
    @BindView(R.id.huan)
    TextView mHuan;
    @BindView(R.id.flow)
    FlowLayout mFlow;
    @BindView(R.id.clear)
    TextView mClear;
    Unbinder unbinder2;
    private SearchAdapter mSearchAdapter;
    private ArrayList<Bean> mList;

    @Override
    public void showError(String err) {

    }

    @Override
    protected void initListener() {
        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils utils = new Utils();
                utils.delete();
                mList.clear();
                mSearchAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void initData() {
        ((SearchPresenter) mPresenter).getSearch();
        List<Bean> beans = Utils.getUtils().queryAll();
        mList.addAll(beans);
        mSearchAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initView() {
        mRvSearch.setLayoutManager(new LinearLayoutManager(getActivity()));
        mList = new ArrayList<Bean>();
        mSearchAdapter = new SearchAdapter(mList, getActivity());
        mRvSearch.setAdapter(mSearchAdapter);
    }


    @Override
    protected IPersenter initMvpPresenter() {
        return new SearchPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_search;
    }


    @Override
    public void getSearchReturn(SearchBean searchBean) {
        List<SearchBean.DataBean.HotKeywordListBean> hotKeywordList = searchBean.getData().getHotKeywordList();

        for (int i = 0; i < hotKeywordList.size(); i++) {
            //获取视图,视图可以自定义,可以添加自己想要的效果
            TextView label = (TextView) View.inflate(mContext, R.layout.item_label, null);
            //获取数据
            final String data = hotKeywordList.get(i).getKeyword();
            //绑定数据
            label.setText(data);
            label.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, data, Toast.LENGTH_SHORT).show();
                }
            });
            //加到容器中,parent是FlowLayout
            mFlow.addView(label);

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder2 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder2.unbind();
    }
}
