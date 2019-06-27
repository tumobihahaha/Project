package com.example.lenovo.tumobi.utils;



import com.example.lenovo.tumobi.apps.MyApplication;
import com.example.lenovo.tumobi.dao.BeanDao;
import com.example.lenovo.tumobi.dao.DaoMaster;
import com.example.lenovo.tumobi.dao.DaoSession;
import com.example.lenovo.tumobi.model.bean.Bean;

import java.util.List;

/**
 * Created by 吕尚勇 on 2019/6/24.
 */

public class Utils {

    private final BeanDao mBeanDao;

    public Utils() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApplication.getApp(), "my.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        mBeanDao = daoSession.getBeanDao();
    }
    private static Utils utils;

    public static Utils getUtils() {
        if(utils==null){
            synchronized (Utils.class){
                if(utils==null){
                    utils = new Utils();
                }
            }
        }
        return utils;
    }

    public boolean has(Bean bean){
        List<Bean> list = (List<Bean>) mBeanDao.queryBuilder().where(BeanDao.Properties.Name.eq(bean.getName())).list();
        if(list!=null && list.size()>0){
            return true;
        }
        return false;
    }

    public void insert(Bean bean){
        if(has(bean)){
            return;
        }
        mBeanDao.insert(bean);
    }

    public List<Bean> queryAll(){
        List<Bean> list = mBeanDao.queryBuilder().list();
        return list;
    }

    public void delete(){
        mBeanDao.deleteAll();
    }
}
