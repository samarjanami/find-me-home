package com.samar.findmehome.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Samar J on 8/1/2020.
 */

public class Media {
    @JsonProperty("Order")
    private int order;
    @JsonProperty("MediaURL")
    private String mediaUrl;
    @JsonProperty("MediaCategory")
    private String mediaCategory;
    @JsonProperty("MimeType")
    private String mimeType;
    @JsonProperty("ShortDescription")
    private String shortDescription;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getMediaCategory() {
        return mediaCategory;
    }

    public void setMediaCategory(String mediaCategory) {
        this.mediaCategory = mediaCategory;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
