package com.welthy.foroffer.articledetail;

import com.welthy.foroffer.bean.ArticleBean;

import java.util.List;

public interface DetailDataSource {

    interface LoadCallback {
        void onLoadComplete(List<ArticleBean> mDatas);
    }

    void loadArticles(LoadCallback loadCallback);
}
