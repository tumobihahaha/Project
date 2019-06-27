package com.example.lenovo.tumobi;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.lenovo.tumobi.adapter.PageFragmentAdapter;
import com.example.lenovo.tumobi.base.BaseActivity;
import com.example.lenovo.tumobi.fragment.HomeFragment;
import com.example.lenovo.tumobi.fragment.MeFragment;
import com.example.lenovo.tumobi.fragment.Search;
import com.example.lenovo.tumobi.fragment.ShopingFragment;
import com.example.lenovo.tumobi.fragment.SortFragment;
import com.example.lenovo.tumobi.fragment.TopicFragment;
import com.example.lenovo.tumobi.interfaces.IPersenter;
import com.example.lenovo.tumobi.model.bean.Bean;
import com.example.lenovo.tumobi.utils.Utils;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.http.HEAD;


public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.msv)
    MaterialSearchView msv;
    @BindView(R.id.abl)
    AppBarLayout abl;
    @BindView(R.id.main_tab)
    TabLayout mainTab;
    @BindView(R.id.fram)
    FrameLayout fram;

    private MenuItem mMySearchItem;
    private int index = 0;
    private ArrayList<Fragment> fragments;
    private int a = 0;
    private String[] arr={"主页","专题","分类","购物车","我的"};
    private FragmentManager supportFragmentManager;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }
    //设置toolbar
    @Override
    protected void initView() {
        toolbar.setTitle("主页");
        setSupportActionBar(toolbar);
        msv.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Bean bean = new Bean();
                bean.setName(query);
                Utils utils = new Utils();
                utils.insert(bean);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        msv.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {

            private Search mSeachFragment;

            @Override
            public void onSearchViewShown() {
                //Toast.makeText(MainActivity.this, "哈哈哈", Toast.LENGTH_SHORT).show();
                mSeachFragment = new Search();
                FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                transaction.add(R.id.fram, mSeachFragment);

                transaction.hide(fragments.get(index));
                transaction.show(mSeachFragment);
                transaction.commit();

            }

            @Override
            public void onSearchViewClosed() {
                FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                transaction.show(fragments.get(index));
                transaction.hide(mSeachFragment);
                transaction.commit();

            }
        });
        initFragment();
    }

    private void initFragment() {

        mainTab.addTab(mainTab.newTab().setText("主页").setIcon(R.drawable.selector_home));
        mainTab.addTab(mainTab.newTab().setText("专题").setIcon(R.drawable.selector_topic));
        mainTab.addTab(mainTab.newTab().setText("分类").setIcon(R.drawable.selector_sort));
        mainTab.addTab(mainTab.newTab().setText("购物车").setIcon(R.drawable.selector_shoping));
        mainTab.addTab(mainTab.newTab().setText("我的").setIcon(R.drawable.selector_me));

        fragments = new ArrayList<>();
        HomeFragment h1 = new HomeFragment();
        TopicFragment h2 = new TopicFragment();
        SortFragment h3 = new SortFragment();
        ShopingFragment h4 = new ShopingFragment();
        MeFragment h5 = new MeFragment();

        fragments.add(h1);
        fragments.add(h2);
        fragments.add(h3);
        fragments.add(h4);
        fragments.add(h5);

        supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();

        for (int i = 0; i < fragments.size(); i++) {
            transaction.add(R.id.fram,fragments.get(i));
        }

        transaction.show(h1).hide(h2).hide(h3).hide(h4).hide(h5);
        transaction.commit();

        //TabLayout 和 viewPager相互绑定
        mainTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                supportFragmentManager.beginTransaction().show(fragments.get(position)).hide(fragments.get(index)).commit();
                index = position;
                toolbar.setTitle(arr[tab.getPosition()]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });
    }
    @Override
    protected void initData() {

    }

    @Override
    protected IPersenter createPersenter() {
        return null;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        mMySearchItem = menu.findItem(R.id.action_search);
        msv.setMenuItem(mMySearchItem);
        return super.onCreateOptionsMenu(menu);
       
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
