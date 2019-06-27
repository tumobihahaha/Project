package com.example.lenovo.tumobi.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lenovo.tumobi.R;
import com.example.lenovo.tumobi.adapter.NaviLvAdapter;
import com.example.lenovo.tumobi.base.BaseMvpFragment;
import com.example.lenovo.tumobi.interfaces.IPersenter;
import com.example.lenovo.tumobi.interfaces.home.HomeContract;
import com.example.lenovo.tumobi.model.bean.SearchBean;
import com.example.lenovo.tumobi.model.bean.home_bean.Frist_Bean;
import com.example.lenovo.tumobi.persenter.home_persenter.HomePersenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseMvpFragment implements HomeContract.View {


    @BindView(R.id.frist_ban)
    Banner fristBan;
    @BindView(R.id.iv_frist_home)
    ImageView ivFristHome;
    @BindView(R.id.tv_frist_home)
    TextView tvFristHome;
    @BindView(R.id.iv_frist_kitchen)
    ImageView ivFristKitchen;
    @BindView(R.id.tv_frist_kitchen)
    TextView tvFristKitchen;
    @BindView(R.id.iv_frist_parts)
    ImageView ivFristParts;
    @BindView(R.id.tv_frist_parts)
    TextView tvFristParts;
    @BindView(R.id.iv_frist_clothes)
    ImageView ivFristClothes;
    @BindView(R.id.tv_frist_clothes)
    TextView tvFristClothes;
    @BindView(R.id.iv_frist_more)
    ImageView ivFristMore;
    @BindView(R.id.tv_frist_more)
    TextView tvFristMore;
    Unbinder unbinder;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.navi_tv)
    TextView naviTv;
    @BindView(R.id.navi_lv)
    RecyclerView naviLv;
    private ArrayList<Frist_Bean.DataBean.BrandListBean> list;
    private NaviLvAdapter adapter;
    private int a ;

    @Override
    protected void initData() {
        ((HomePersenter) mPresenter).getHome();
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        adapter = new NaviLvAdapter(getActivity(),list);
        naviLv.setAdapter(adapter);
        naviLv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

    }

    @Override
    protected IPersenter initMvpPresenter() {
        return new HomePersenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }


    @Override
    public void showError(String err) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getHomeReturn(Frist_Bean frist_bean) {
        List<Frist_Bean.DataBean.BrandListBean> brandList1 = frist_bean.getData().getBrandList();
        list.addAll(brandList1);

        List<Frist_Bean.DataBean.ChannelBean> channel = frist_bean.getData().getChannel();

        Glide.with(getContext()).load(channel.get(0).getIcon_url()).into(ivFristHome);
        Glide.with(getContext()).load(channel.get(1).getIcon_url()).into(ivFristClothes);
        Glide.with(getContext()).load(channel.get(2).getIcon_url()).into(ivFristKitchen);
        Glide.with(getContext()).load(channel.get(3).getIcon_url()).into(ivFristParts);
        Glide.with(getContext()).load(channel.get(4).getIcon_url()).into(ivFristMore);


        tvFristHome.setText(channel.get(0).getName());
        tvFristClothes.setText(channel.get(1).getName());
        tvFristKitchen.setText(channel.get(2).getName());
        tvFristParts.setText(channel.get(3).getName());
        tvFristMore.setText(channel.get(4).getName());




        fristBan.setImages(frist_bean.getData().getBanner())
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Frist_Bean.DataBean.BannerBean dataBean = (Frist_Bean.DataBean.BannerBean) path;
                        Glide.with(context).load(dataBean.getImage_url()).into(imageView);
                    }
                }).start();

        if (frist_bean != null) {
            List<Frist_Bean.DataBean.BrandListBean> brandList = frist_bean.getData().getBrandList();
            brandList.addAll(brandList);
            adapter.notifyDataSetChanged();
            Toast.makeText(mContext, frist_bean.getData().toString(), Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(mContext, "数据加载失败", Toast.LENGTH_SHORT).show();
        }
        adapter.notifyDataSetChanged();
    }
}
