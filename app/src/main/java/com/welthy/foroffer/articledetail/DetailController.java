package com.welthy.foroffer.articledetail;

import com.welthy.foroffer.cache.db.FODbManager;

public class DetailController implements DetailDataSource{

    @Override
    public void loadArticles(LoadCallback loadCallback) {
        loadCallback.onLoadComplete(FODbManager.getInstance().queryAll());
    }
}
