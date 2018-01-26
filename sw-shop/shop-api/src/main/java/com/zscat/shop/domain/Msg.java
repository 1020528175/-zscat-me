package com.zscat.shop.domain;



import java.io.Serializable;

/**
 * Created by summer on 2017/5/5.
 */

public class Msg implements Serializable {
        private static final long serialVersionUID = -3258839839160856613L;

        private Long id;
        private String videourl;
        private String username;
        private Long type;
        private String uid;
        private String headurl;
        private String commentlist;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getVideourl() {
                return videourl;
        }

        public void setVideourl(String videourl) {
                this.videourl = videourl;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public Long getType() {
                return type;
        }

        public void setType(Long type) {
                this.type = type;
        }

        public String getUid() {
                return uid;
        }

        public void setUid(String uid) {
                this.uid = uid;
        }

        public String getHeadurl() {
                return headurl;
        }

        public void setHeadurl(String headurl) {
                this.headurl = headurl;
        }

        public String getCommentlist() {
                return commentlist;
        }

        public void setCommentlist(String commentlist) {
                this.commentlist = commentlist;
        }

        @Override
        public String toString() {
                return "Msg{" +
                        "id=" + id +
                        ", videourl='" + videourl + '\'' +
                        ", username='" + username + '\'' +
                        ", type=" + type +
                        ", uid='" + uid + '\'' +
                        ", headurl='" + headurl + '\'' +
                        ", commentlist='" + commentlist + '\'' +
                        '}';
        }
}
