package com.welthy.foroffer.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.welthy.foroffer.R;
import com.welthy.foroffer.util.FFConstants;

public class MainBasicFragment extends BaseFOFragment{

    @Override
    public String getType() {
        return FFConstants.FRAGMENT_BASIC;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public View getLayoutView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.main_basic_fragment_layout,container,false);
    }
}
