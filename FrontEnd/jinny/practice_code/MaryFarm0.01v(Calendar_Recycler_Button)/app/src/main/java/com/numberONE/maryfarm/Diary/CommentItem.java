package com.numberONE.maryfarm.Diary;

public class CommentItem {

        int profileImg;
        String profileName;
        String commentContent;

        public CommentItem(int profileImg, String profileName, String commentContent) {
                this.profileImg = profileImg;
                this.profileName = profileName;
                this.commentContent = commentContent;
        }

        public int getProfileImg() {
                return profileImg;
        }

        public void setProfileImg(int profileImg) {
                this.profileImg = profileImg;
        }

        public String getProfileName() {
                return profileName;
        }

        public void setProfileName(String profileName) {
                this.profileName = profileName;
        }

        public String getCommentContent() {
                return commentContent;
        }

        public void setCommentContent(String commentContent) {
                this.commentContent = commentContent;
        }
}
