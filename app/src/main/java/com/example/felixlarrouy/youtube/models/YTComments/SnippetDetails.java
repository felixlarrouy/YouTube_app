
package com.example.felixlarrouy.youtube.models.YTComments;

import com.google.gson.annotations.SerializedName;

public class SnippetDetails {

    @SerializedName("authorDisplayName")
    private String authorDisplayName;

    @SerializedName("authorProfileImageUrl")
    private String authorProfileImageUrl;

    @SerializedName("textOriginal")
    private String textOriginal;

    @SerializedName("publishedAt")
    private String publishedAt;

    public String getAuthorDisplayName() {
        return authorDisplayName;
    }

    public String getAuthorProfileImageUrl() {
        return authorProfileImageUrl;
    }

    public String getTextOriginal() {
        return textOriginal;
    }

    public String getPublishedAt() {
        return publishedAt.substring(0, 10);
    }
}
