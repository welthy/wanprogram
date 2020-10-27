package com.welthy.foroffer.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.welthy.foroffer.util.LogUtil;

import butterknife.ButterKnife;

public abstract class BaseFOFragment extends Fragment {

    private final String TAG = BaseFOFragment.class.getSimpleName();

    private String mType;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.normal(TAG,"onCreate()");
        mType = getType();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUtil.normal(TAG,"onCreateView() mType = "+mType);
        View root = getLayoutView(inflater,container);
        ButterKnife.bind(this,root);
        return root;
    }

    public abstract String getType();
    public abstract View getLayoutView(LayoutInflater inflater,ViewGroup container);

}
