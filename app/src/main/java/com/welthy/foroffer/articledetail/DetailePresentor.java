package com.welthy.foroffer.articledetail;

import com.welthy.foroffer.bean.ArticleBean;

import java.util.List;

public class DetailePresentor implements ArticleDetailContract.Presentor{

    private ArticleDetailContract.View mView;
    private DetailDataSource mController;

    public DetailePresentor(ArticleDetailContract.View mView, DetailDataSource mController) {
        this.mView = mView;
        this.mController = mController;

        mView.setPresentor(this);
    }

    @Override
    public void getArticles() {
        mController.loadArticles(new DetailDataSource.LoadCallback() {
            @Override
            public void onLoadComplete(List<ArticleBean> mDatas) {
                mView.showArticle(mDatas);
            }
        });
    }

    @Override
    public void init() {

    }
}
