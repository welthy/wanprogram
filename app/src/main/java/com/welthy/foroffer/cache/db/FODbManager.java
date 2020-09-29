package com.welthy.foroffer.cache.db;

import com.welthy.foroffer.bean.ArticleBean;
import com.welthy.foroffer.util.LogUtil;

import org.litepal.LitePal;
import org.litepal.tablemanager.callback.DatabaseListener;

import java.util.List;

public class FODbManager {

    private final String TAG = FODbManager.class.getSimpleName();

    private static FODbManager mInstance;
    private FODbManager() {}
    public static FODbManager getInstance() {
        if (mInstance == null) {
            synchronized (FODbManager.class) {
                if (mInstance == null) {
                    mInstance = new FODbManager();
                }
            }
        }
        return mInstance;
    }

    public void insertData() {

    }

    public void insertAll(List<ArticleBean> mDatas) {
        if (LitePal.saveAll(mDatas)) {
            LogUtil.normal(TAG, "insertAll success.");
            return;
        }
        LogUtil.normal(TAG,"insertAll fail.");
    }

    public void delData(int id) {
        LitePal.delete(ArticleBean.class,id);
    }

    public void delAll() {
        LitePal.deleteAll(ArticleBean.class);
    }

    public ArticleBean queryData(int id) {
        return LitePal.find(ArticleBean.class,id);
    }

    public List<ArticleBean> queryAll() {
        return LitePal.findAll(ArticleBean.class);
    }

    public void registerDBListener(DatabaseListener listener) {
        LitePal.registerDatabaseListener(listener);
    }

}
