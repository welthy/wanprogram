package com.welthy.foroffer.articledetail;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.welthy.foroffer.ui.BaseFOActivity;
import com.welthy.foroffer.R;
import com.welthy.foroffer.bean.ArticleBean;
import com.welthy.foroffer.util.LogUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.welthy.foroffer.util.PreConditions.checkNotNull;

public class ArticleDetailActivity extends BaseFOActivity implements ArticleDetailContract.View{

    private final String TAG = ArticleDetailActivity.class.getSimpleName();
    private final int MSG_SHOW_ARTICLE = 0x01;

    /*@BindView(R.id.article_content)
    TextView content;*/
    @BindView(R.id.webview)
    WebView mWebView;

    private ArticleDetailContract.Presentor mPresentor;

    private int mIndex;

    private Handler mDetailMainHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case MSG_SHOW_ARTICLE:
                    ArticleBean ab = (ArticleBean)msg.obj;
                    LogUtil.normal(TAG,"path = " + ab.getFileLocate());
                    mWebView.loadUrl(ab.getFileLocate());
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        init();
        loadArticle();
    }

    @Override
    public int getLayout() {
        return R.layout.article_detail_layout;
    }

    private void init() {
        mPresentor = new DetailePresentor(this, new DetailController());
        Intent it = getIntent();
        mIndex = it.getIntExtra("item",0);
        LogUtil.normal(TAG,"pos = " + mIndex);
    }

    private void loadArticle() {
        mPresentor.getArticles();
    }

    @Override
    public void showArticle(List<ArticleBean> abs) {
        checkNotNull(abs);
        Message msg = mDetailMainHandler.obtainMessage(MSG_SHOW_ARTICLE);
        msg.obj = abs.get(mIndex);
        msg.sendToTarget();
    }

    @Override
    public void setPresentor(ArticleDetailContract.Presentor presentor) {
        this.mPresentor = presentor;
    }
}
