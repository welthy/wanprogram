package com.welthy.foroffer.articledetail;

import com.welthy.foroffer.mvp.BasePresentor;
import com.welthy.foroffer.mvp.BaseView;
import com.welthy.foroffer.bean.ArticleBean;

import java.util.List;

public interface ArticleDetailContract {

    interface View extends BaseView<Presentor> {

        void showArticle(List<ArticleBean> abs);
    }

    interface Presentor extends BasePresentor {

        void getArticles();
    }
}
