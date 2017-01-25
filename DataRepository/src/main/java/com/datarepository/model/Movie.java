package com.datarepository.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ThangNTX on 12/1/2016.
 */

public class Movie {
    @SerializedName("id")
    private long id;

    @SerializedName("poster_path")
    private String posterUrl;

    @SerializedName("title")
    private String title;

    @SerializedName("overview")
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
