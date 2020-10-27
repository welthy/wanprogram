package com.welthy.foroffer.ui.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.welthy.foroffer.R;
import com.welthy.foroffer.util.FFConstants;

public class MainJavaFragment extends BaseFOFragment{

    @Override
    public String getType() {
        return FFConstants.FRAGMENT_JAVA;
    }

    @Override
    public View getLayoutView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.main_java_fragment_layout,container,false);
    }
}
