package com.bawei.text.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * 类用途：
 * 作者：史壮壮
 * 时间：2017/3/16 13:36
 */

public class PeriodBean implements Serializable {

    public int code;
    public DataBean data;
    public String message;

    public static class DataBean {

        public int timestamp;
        public int since;
        public List<ComicsBean> comics;

        public static class ComicsBean implements Serializable {

            public int info_type;
            public String label_color;
            public String cover_image_url;
            public int storyboard_cnt;
            public int created_at;
            public String title;
            public String url;
            public int likes_count;
            public int updated_at;
            public int comments_count;
            public String label_text;
            public int push_flag;
            public TopicBean topic;
            public int shared_count;
            public int id;
            public String label_text_color;
            public int serial_no;
            public String status;
            public boolean is_liked;

            public static class TopicBean implements Serializable {

                public String discover_image_url;
                public String vertical_image_url;
                public String cover_image_url;
                public String update_day;
                public String description;
                public int created_at;
                public String title;
                public String update_status;
                public int updated_at;
                public int id;
                public UserBean user;
                public int label_id;
                public int order;
                public int comics_count;

                public static class UserBean implements Serializable {
                    public int pub_feed;
                    public String avatar_url;
                    public int grade;
                    public String nickname;
                    public String reg_type;
                    public int id;
                }
            }
        }
    }
}
