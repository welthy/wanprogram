package com.welthy.foroffer.mvp.contracts;

import com.welthy.foroffer.mvp.BasePresentor;
import com.welthy.foroffer.mvp.BaseView;
import com.welthy.foroffer.bean.ArticleBean;

import java.util.List;

public interface MainContract {

    interface View extends BaseView<Presentor> {

        void showArticles();

        void updateArticleList(List<ArticleBean> datas);

    }

    interface Presentor extends BasePresentor {

        void loadArticles();

        void addNewTask();
    }
}
