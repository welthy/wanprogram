package com.welthy.foroffer.main;

import com.welthy.foroffer.bean.ArticleBean;
import com.welthy.foroffer.cache.db.FODbManager;
import com.welthy.foroffer.mvp.contracts.MainContract;
import com.welthy.foroffer.mvp.models.MainDataSource;

import java.util.List;

public class MainPresentor implements MainContract.Presentor {

    private MainContract.View mMainView;
    private MainController mMainController;

    public MainPresentor(MainContract.View mMainView, MainController mMainController) {
        this.mMainView = mMainView;
        this.mMainController = mMainController;
        mMainView.setPresentor(this);
    }

    @Override
    public void loadArticles() {

        mMainController.loadFile(new MainDataSource.LoadCallback() {
            @Override
            public void onTaskPreload() {
                FODbManager.getInstance().delAll();
            }

            @Override
            public void onTaskFinished(List<ArticleBean> datas) {
                mMainView.updateArticleList(datas);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    @Override
    public void addNewTask() {

    }

    @Override
    public void init() {

    }
}
