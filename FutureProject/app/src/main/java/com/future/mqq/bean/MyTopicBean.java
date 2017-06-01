package com.future.mqq.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/5/26.
 */

public class MyTopicBean {

    /**
     * data : {"topic":[{"title":"专辑测试1","image":"https://pretty.f8cam.com/static/image/product/pc/pcsdmdhzfg.jpg","title2":"测试","object_id":"20000028","length":5,"type":1},{"title":"测试所用","image":"https://pretty.f8cam.com/static/image/product/tf/tfmphswfje.jpg","title2":"111","object_id":"20000031","length":3,"type":2},{"title":"专辑测试1","image":"https://pretty.f8cam.com/static/image/product/pc/pcsdmdhzfg.jpg","title2":"测试","object_id":"20000030","length":1,"type":1},{"title":"ghmm","image":"https://pretty.f8cam.com/static/image/product/np/nplxaplnag.jpg","title2":"mjhm","object_id":"20000037","length":1,"type":1}],"page_index":"0","total":4,"page_size":"10"}
     * ret : 0
     */

    private DataBean data;
    private int ret;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public static class DataBean {
        /**
         * topic : [{"title":"专辑测试1","image":"https://pretty.f8cam.com/static/image/product/pc/pcsdmdhzfg.jpg","title2":"测试","object_id":"20000028","length":5,"type":1},{"title":"测试所用","image":"https://pretty.f8cam.com/static/image/product/tf/tfmphswfje.jpg","title2":"111","object_id":"20000031","length":3,"type":2},{"title":"专辑测试1","image":"https://pretty.f8cam.com/static/image/product/pc/pcsdmdhzfg.jpg","title2":"测试","object_id":"20000030","length":1,"type":1},{"title":"ghmm","image":"https://pretty.f8cam.com/static/image/product/np/nplxaplnag.jpg","title2":"mjhm","object_id":"20000037","length":1,"type":1}]
         * page_index : 0
         * total : 4
         * page_size : 10
         */

        private String page_index;
        private int total;
        private String page_size;
        private List<TopicBean> topic;

        public String getPage_index() {
            return page_index;
        }

        public void setPage_index(String page_index) {
            this.page_index = page_index;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getPage_size() {
            return page_size;
        }

        public void setPage_size(String page_size) {
            this.page_size = page_size;
        }

        public List<TopicBean> getTopic() {
            return topic;
        }

        public void setTopic(List<TopicBean> topic) {
            this.topic = topic;
        }

        public static class TopicBean {
            /**
             * title : 专辑测试1
             * image : https://pretty.f8cam.com/static/image/product/pc/pcsdmdhzfg.jpg
             * title2 : 测试
             * object_id : 20000028
             * length : 5
             * type : 1
             */

            private String title;
            private String image;
            private String title2;
            private String object_id;
            private int length;
            private int type;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getTitle2() {
                return title2;
            }

            public void setTitle2(String title2) {
                this.title2 = title2;
            }

            public String getObject_id() {
                return object_id;
            }

            public void setObject_id(String object_id) {
                this.object_id = object_id;
            }

            public int getLength() {
                return length;
            }

            public void setLength(int length) {
                this.length = length;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
