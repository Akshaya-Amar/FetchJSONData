package com.example.fetchdatafromjson.model;

public class ImageModel {

    private final int id;
    private final String title;
    private final String url;
    private final String thumbnailUrl;

    public ImageModel(int id, String title, String url, String thumbnailUrl) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
