package com.xu.headline.bean.authorinfo;

import java.util.List;

/**
 * Created by xusn10 on 2018/2/24.
 * @author xu
 */

public class OrderedInfoBean4 extends BaseOrderedInfoBean {

    /**
     * data : [{"aggr_type":1,"group_id":6519344328546976260,"impr_id":"6519344328546976260_6519344328546976260","item_id":6519344328546976260,"log_pb":{"impr_id":"20180224162428010010023222209F57"},"open_page_url":"sslocal://detail?is_quick_exit=1&groupid=6519344328546976260&item_id=6519344328546976260&gd_label=click_related&gd_ext_json={\"enter_from\":\"click_related\"}&log_pb={\"impr_id\":\"20180224162428010010023222209F57\"}&from_gid=6525910609031070216","title":"阿司匹林肠溶片是终身吃，还是吃一段时间就不吃了？","type_name":""},{"aggr_type":1,"group_id":6523892928937460231,"impr_id":"6523892928937460231_6523892928937460231","item_id":6523892928937460231,"log_pb":{"impr_id":"20180224162428010010023222209F57"},"open_page_url":"sslocal://detail?is_quick_exit=1&groupid=6523892928937460231&item_id=6523892928937460231&gd_label=click_related&gd_ext_json={\"enter_from\":\"click_related\"}&log_pb={\"impr_id\":\"20180224162428010010023222209F57\"}&from_gid=6525910609031070216","title":"中国战机不如土耳其？巴铁为何弃中国战机而选择土耳其战机","type_name":""},{"aggr_type":1,"group_id":6519802799394390531,"impr_id":"6519802799394390531_6519802799394390531","item_id":6519802799394390531,"log_pb":{"impr_id":"20180224162428010010023222209F57"},"open_page_url":"sslocal://detail?is_quick_exit=1&groupid=6519802799394390531&item_id=6519802799394390531&gd_label=click_related&gd_ext_json={\"enter_from\":\"click_related\"}&log_pb={\"impr_id\":\"20180224162428010010023222209F57\"}&from_gid=6525910609031070216","title":"人工授精的过程和授精后注意事项","type_name":""},{"aggr_type":1,"group_id":6522288471229334019,"impr_id":"6522288471229334019_6522288471229334019","item_id":6522288471229334019,"log_pb":{"impr_id":"20180224162428010010023222209F57"},"open_page_url":"sslocal://detail?is_quick_exit=1&groupid=6522288471229334019&item_id=6522288471229334019&gd_label=click_related&gd_ext_json={\"enter_from\":\"click_related\"}&log_pb={\"impr_id\":\"20180224162428010010023222209F57\"}&from_gid=6525910609031070216","title":"一年军费近5万亿，战机数量高达4万架，为何一直都拖不垮","type_name":""}]
     * name : related_news
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
         * aggr_type : 1
         * group_id : 6519344328546976260
         * impr_id : 6519344328546976260_6519344328546976260
         * item_id : 6519344328546976260
         * log_pb : {"impr_id":"20180224162428010010023222209F57"}
         * open_page_url : sslocal://detail?is_quick_exit=1&groupid=6519344328546976260&item_id=6519344328546976260&gd_label=click_related&gd_ext_json={"enter_from":"click_related"}&log_pb={"impr_id":"20180224162428010010023222209F57"}&from_gid=6525910609031070216
         * title : 阿司匹林肠溶片是终身吃，还是吃一段时间就不吃了？
         * type_name :
         */

        private int aggr_type;
        private long group_id;
        private String impr_id;
        private long item_id;
        private LogPbBean log_pb;
        private String open_page_url;
        private String title;
        private String type_name;

        public int getAggr_type() {
            return aggr_type;
        }

        public void setAggr_type(int aggr_type) {
            this.aggr_type = aggr_type;
        }

        public long getGroup_id() {
            return group_id;
        }

        public void setGroup_id(long group_id) {
            this.group_id = group_id;
        }

        public String getImpr_id() {
            return impr_id;
        }

        public void setImpr_id(String impr_id) {
            this.impr_id = impr_id;
        }

        public long getItem_id() {
            return item_id;
        }

        public void setItem_id(long item_id) {
            this.item_id = item_id;
        }

        public LogPbBean getLog_pb() {
            return log_pb;
        }

        public void setLog_pb(LogPbBean log_pb) {
            this.log_pb = log_pb;
        }

        public String getOpen_page_url() {
            return open_page_url;
        }

        public void setOpen_page_url(String open_page_url) {
            this.open_page_url = open_page_url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType_name() {
            return type_name;
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }

        public static class LogPbBean {
            /**
             * impr_id : 20180224162428010010023222209F57
             */

            private String impr_id;

            public String getImpr_id() {
                return impr_id;
            }

            public void setImpr_id(String impr_id) {
                this.impr_id = impr_id;
            }
        }
    }
}
