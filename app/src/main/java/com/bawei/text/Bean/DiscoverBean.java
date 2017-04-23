package com.bawei.text.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 类用途：
 * 作者：史壮壮
 * 时间：2017/3/21 18:38
 */

public class DiscoverBean {

    public int code;
    public DataBean data;
    public String message;

    public static class DataBean {
        public ArrayList<InfosBean> infos;

        public static class InfosBean {

            public int action_type;
            public int item_type;
            public String action;
            public String title;
            public boolean more_flag;
            public String guide_text;
            public int style;
            public ArrayList<BannersBean> banners;
            public ArrayList<TopicsBean> topics;

            public static class BannersBean {


                public String target_app_url;
                public String good_price;
                public String sub_title;
                public String special_list_url;
                public int target_id;
                public String pic;
                public int type;
                public String target_package_name;
                public String hybrid_url;
                public String target_web_url;
                public String target_title;
                public int id;
                public String request_id;
                public String good_alias;
                public int chapter_count;

            }

            public static class TopicsBean {


                public String label_color;
                public String description;
                public int target_id;
                public String pic;
                public int type;
                public String title;
                public String recommended_text;
                public int likes_count;
                public String label_text;
                public int comments_count;
                public String label_text_color;
                public UserBean user;
                public int label_id;
                public ArrayList<String> category;

                @Override
                public String toString() {
                    return "TopicsBean{" +
                            "label_color='" + label_color + '\'' +
                            ", description='" + description + '\'' +
                            ", target_id=" + target_id +
                            ", pic='" + pic + '\'' +
                            ", type=" + type +
                            ", title='" + title + '\'' +
                            ", recommended_text='" + recommended_text + '\'' +
                            ", likes_count=" + likes_count +
                            ", label_text='" + label_text + '\'' +
                            ", comments_count=" + comments_count +
                            ", label_text_color='" + label_text_color + '\'' +
                            ", user=" + user +
                            ", label_id=" + label_id +
                            ", category=" + category +
                            '}';
                }

                public static class UserBean {


                    public int pub_feed;
                    public String avatar_url;
                    public int grade;
                    public String nickname;
                    public String reg_type;
                    public int id;

                    @Override
                    public String toString() {
                        return "UserBean{" +
                                "pub_feed=" + pub_feed +
                                ", avatar_url='" + avatar_url + '\'' +
                                ", grade=" + grade +
                                ", nickname='" + nickname + '\'' +
                                ", reg_type='" + reg_type + '\'' +
                                ", id=" + id +
                                '}';
                    }
                }
            }
        }
    }
}
