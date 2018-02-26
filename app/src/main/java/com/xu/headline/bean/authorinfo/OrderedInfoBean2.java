package com.xu.headline.bean.authorinfo;

/**
 * Created by xusn10 on 2018/2/24.
 * @author xu
 */

public class OrderedInfoBean2 extends BaseOrderedInfoBean {

    /**
     * data : {"like_num":1312,"user_like":0}
     * name : like_and_rewards
     */

    private DataBean data;
    private String name;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class DataBean {
        /**
         * like_num : 1312
         * user_like : 0
         */

        private int like_num;
        private int user_like;

        public int getLike_num() {
            return like_num;
        }

        public void setLike_num(int like_num) {
            this.like_num = like_num;
        }

        public int getUser_like() {
            return user_like;
        }

        public void setUser_like(int user_like) {
            this.user_like = user_like;
        }
    }
}
