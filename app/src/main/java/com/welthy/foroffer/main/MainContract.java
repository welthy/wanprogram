package com.welthy.foroffer.main;

import com.welthy.foroffer.BasePresentor;
import com.welthy.foroffer.BaseView;
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
