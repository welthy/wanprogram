package com.welthy.foroffer.util;

import android.content.res.AssetManager;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.welthy.foroffer.ForOfferApp;
import com.welthy.foroffer.bean.ArticleBean;
import com.welthy.foroffer.cache.db.FODbManager;
import com.welthy.foroffer.main.MainDataSource;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.welthy.foroffer.util.FFConstants.ASSET_PRE;
import static com.welthy.foroffer.util.PreConditions.checkNotNull;


public class FileParser {

    private final String TAG = FileParser.class.getSimpleName();

    private static FileParser mInstance;
    private FileParser(){}

    public static FileParser getInstance(){
        if (mInstance == null) {
            synchronized (FileParser.class) {
                if (mInstance == null) {
                    mInstance = new FileParser();
                }
            }
        }
        return mInstance;
    }

    public void parseAssetsFile(List<ArticleBean> datas, MainDataSource.TaskCallback taskCallback) {
        if (datas == null) {
            datas = new ArrayList<>();
        }
        AssetManager am = ForOfferApp.getContext().getAssets();
        try {
            String[] dirNames = am.list("");
            Log.d("welthy", Arrays.toString(dirNames));
            for (String dir : dirNames) {
                if (("sounds".equals(dir)) || ("webkit".equals(dir))) {
                    continue;
                }
                String[] files = am.list(dir);
                for (String file : files) {
                    if (file.endsWith(".html")) {
                        ArticleBean ab = new ArticleBean();
                        ab.setType(dir);
                        ab.setTitle(file.replace(".html",""));
                        //开始解析md文件
                        InputStream is = am.open(dir + "/" + file);
                        String msg = parseFile(is);
                        ab.setContent(msg);
                        ab.setFileLocate(ASSET_PRE + dir + "/" + file);
                        datas.add(ab);
                        taskCallback.onTaskUpdate();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            taskCallback.onError(e);
        }finally {
           // am.close();
            FODbManager.getInstance().insertAll(datas);
            taskCallback.onTaskComplete(datas);
            String json = JSON.toJSONString(datas);
            LogUtil.normal(TAG,json);
        }
    }

    public String parseFile(InputStream is) {
        StringBuffer sb = new StringBuffer();
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                checkNotNull(isr);
                isr.close();
                checkNotNull(br);
                br.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
