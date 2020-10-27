package com.welthy.foroffer.main;

import com.welthy.foroffer.bean.ArticleBean;
import com.welthy.foroffer.mvp.models.MainDataSource;
import com.welthy.foroffer.thread.ThreadUtil;
import com.welthy.foroffer.util.FileParser;

import java.util.List;

import static com.welthy.foroffer.util.PreConditions.checkNotNull;

public class MainController implements MainDataSource {

    @Override
    public void loadFile(LoadCallback callback) {
        checkNotNull(callback);
        callback.onTaskPreload();
        ThreadUtil.runOnWorkThread(new Runnable() {
            @Override
            public void run() {
                FileParser.getInstance().parseAssetsFile(null, new MainDataSource.TaskCallback() {
                    @Override
                    public void onTaskUpdate() {}

                    @Override
                    public void onTaskComplete(List<ArticleBean> datas) {
                        callback.onTaskFinished(datas);
                    }

                    @Override
                    public void onError(Exception e) {
                        callback.onError(e);
                    }
                });
            }
        });
    }
}
