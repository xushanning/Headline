package com.xu.headline.bean.authorinfo;

import java.util.List;

/**
 * Created by xusn10 on 2018/2/24.
 *
 * @author xu
 */

public class OrderedInfoBean1 extends BaseOrderedInfoBean {

    /**
     * data : [{"link":"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6525910609031070216%7D&from=article_tag2&gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D&keyword=%E6%B5%B7%E5%8D%97%E5%A4%A7%E5%AD%A6","word":"海南大学"},{"link":"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6525910609031070216%7D&from=article_tag2&gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D&keyword=%E6%B5%B7%E5%8D%97%E8%88%AA%E7%A9%BA","word":"海南航空"},{"link":"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6525910609031070216%7D&from=article_tag2&gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D&keyword=%E7%8E%8B%E6%A2%A6%E6%81%95","word":"王梦恕"},{"link":"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6525910609031070216%7D&from=article_tag2&gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D&keyword=%E4%BA%A4%E9%80%9A","word":"交通"}]
     * name : labels
     */

    private String name;
    private List<DataBean> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * link : sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6525910609031070216%7D&from=article_tag2&gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D&keyword=%E6%B5%B7%E5%8D%97%E5%A4%A7%E5%AD%A6
         * word : 海南大学
         */

        private String link;
        private String word;

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }
    }
}
