package com.welthy.foroffer.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.welthy.foroffer.R;
import com.welthy.foroffer.bean.ArticleBean;
import com.welthy.foroffer.main.MainAdapter;
import com.welthy.foroffer.mvp.contracts.MainContract;
import com.welthy.foroffer.main.MainController;
import com.welthy.foroffer.main.MainPresentor;
import com.welthy.foroffer.util.FFConstants;
import com.welthy.foroffer.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainAndroidFragment extends BaseFOFragment implements MainContract.View {

    private final String TAG = MainAndroidFragment.class.getSimpleName();

    @BindView(R.id.main_android_recyclerview)
    RecyclerView mAndroidRecycleriew;

    private final int MSG_UPDATE_DATA = 0x01;

    private MainContract.Presentor mPresentor;
    private MainAdapter mMainAdapter;
    private List<ArticleBean> mDatas;

    private Context mContext;

    private Handler mMainAndroidHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case MSG_UPDATE_DATA:
                    LogUtil.normal(TAG,"update datas");
                    mMainAdapter.updateDatas((List<ArticleBean>) msg.obj);
                    break;
            }
        }
    };

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    @Override
    public String getType() {
        return FFConstants.FRAGMENT_ANDROID;
    }

    @Override
    public View getLayoutView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.main_android_fragment_layout,container,false);
    }

    private void init() {
        mContext = getActivity();
        mPresentor = new MainPresentor(this, new MainController());
        mDatas = new ArrayList<>();
        mMainAdapter = new MainAdapter(mContext,mDatas);
        mAndroidRecycleriew.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mAndroidRecycleriew.setAdapter(mMainAdapter);

        if ((mDatas != null) && (mDatas.size() <= 0)) {
            LogUtil.normal(TAG, "load article data.");
            mPresentor.loadArticles();
        }
    }

    @Override
    public void onDestroyView() {
        mDatas.clear();
        mDatas = null;
        super.onDestroyView();
    }

    @Override
    public void showArticles() {

    }

    @Override
    public void updateArticleList(List<ArticleBean> datas) {
        LogUtil.normal(TAG,datas + "");
        Message msg = mMainAndroidHandler.obtainMessage(MSG_UPDATE_DATA);
        msg.obj = datas;
        msg.sendToTarget();
    }

    @Override
    public void setPresentor(MainContract.Presentor presentor) {
        this.mPresentor = presentor;
    }
}
