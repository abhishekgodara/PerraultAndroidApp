package com.perraulthealth.model;

/**
 * Created by sutu on 11/10/2016.
 */

public class ListViewItem {
    public ListViewItem() {
    }
    private int imgId;
    private String title;

    public ListViewItem(int imgId, String title) {
        this.imgId = imgId;
        this.title = title;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
