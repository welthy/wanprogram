package com.welthy.foroffer.mvp.models;

import com.welthy.foroffer.bean.ArticleBean;

import java.util.List;

public interface MainDataSource {

    interface LoadCallback {

        void onTaskPreload();
        void onTaskFinished(List<ArticleBean> datas);
        void onError(Exception e);
    }

    interface TaskCallback {
        void onTaskUpdate();
        void onTaskComplete(List<ArticleBean> datas);
        void onError(Exception e);
    }


    void loadFile(LoadCallback callback);
}
