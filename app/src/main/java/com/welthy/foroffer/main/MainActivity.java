package com.welthy.foroffer.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.welthy.foroffer.BaseFOActivity;
import com.welthy.foroffer.R;
import com.welthy.foroffer.bean.ArticleBean;
import com.welthy.foroffer.fragments.BaseFOFragment;
import com.welthy.foroffer.fragments.MainAndroidFragment;
import com.welthy.foroffer.fragments.MainBasicFragment;
import com.welthy.foroffer.fragments.MainJavaFragment;
import com.welthy.foroffer.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseFOActivity{

    private final String TAG = MainActivity.class.getSimpleName();


    @BindView(R.id.main_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.main_drawer)
    NavigationView mNavigationDrawer;
    @BindView(R.id.main_vp)
    ViewPager mMainVP;
    @BindView(R.id.main_tab_layout)
    TabLayout mTabLayout;

    private List<Fragment> mFragments;
    private String[] mTitles;
    private MainPageFragmentAdapter mMainPageAdapter;

    private Handler mMainHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        initToolbar();
        initNavigationDrawer();

        initFragmentsAndTitles();
        initViewPager();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        mToolbar.setTitle(getResources().getString(R.string.app_name));
    }

    private void initNavigationDrawer() {
        mNavigationDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigationview01:
                        LogUtil.normal(TAG,"Android");
                        break;
                    case R.id.navigationview02:
                        LogUtil.normal(TAG,"网课");
                        break;
                    case R.id.navigationview03:
                        LogUtil.normal(TAG,"设置");
                        break;
                }
                return false;
            }
        });
    }

    private void initFragmentsAndTitles() {
        mFragments = new ArrayList<>();
        mFragments.add(new MainAndroidFragment());
        mFragments.add(new MainJavaFragment());
        mFragments.add(new MainBasicFragment());

        mTitles = getResources().getStringArray(R.array.main_tab_titles);
    }

    private void initViewPager() {
        mMainPageAdapter = new MainPageFragmentAdapter(getSupportFragmentManager(), mFragments, mTitles);
        mMainVP.setAdapter(mMainPageAdapter);
        mMainVP.addOnPageChangeListener(new MainViewPagerListener());
        mMainVP.setCurrentItem(0);

        mTabLayout.setupWithViewPager(mMainVP);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    class MainViewPagerListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //updateCurrentItem(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    private void updateCurrentItem(int pos) {
        mMainVP.setCurrentItem(pos);
    }
}