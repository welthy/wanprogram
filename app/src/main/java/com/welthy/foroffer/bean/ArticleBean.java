package com.welthy.foroffer.bean;

import android.graphics.Bitmap;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

public class ArticleBean extends LitePalSupport {

    @Column(unique = true, defaultValue = "Anonymous")
    private int id;

    private String type;
    private String title;
    private String abstractMsg;
    private String author;
    private Bitmap abstractBmp;
    private String content;
    private String fileLocate;

    public String getFileLocate() {
        return fileLocate;
    }

    public void setFileLocate(String fileLocate) {
        this.fileLocate = fileLocate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAbstractMsg() {
        return abstractMsg;
    }

    public void setAbstractMsg(String abstractMsg) {
        this.abstractMsg = abstractMsg;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Bitmap getAbstractBmp() {
        return abstractBmp;
    }

    public void setAbstractBmp(Bitmap abstractBmp) {
        this.abstractBmp = abstractBmp;
    }
}
