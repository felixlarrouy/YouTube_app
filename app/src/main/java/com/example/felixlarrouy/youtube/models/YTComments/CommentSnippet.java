
package com.example.felixlarrouy.youtube.models.YTComments;

import com.google.gson.annotations.SerializedName;

public class CommentSnippet {

    @SerializedName("topLevelComment")
    private TopLevelComment topLevelComment;

    @SerializedName("totalReplyCount")
    private Integer totalReplyCount;

    public TopLevelComment getTopLevelComment() {
        return topLevelComment;
    }
}
