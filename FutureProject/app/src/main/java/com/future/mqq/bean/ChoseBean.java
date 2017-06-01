package com.future.mqq.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/5/25.
 */

public class ChoseBean {

    /**
     * data : {"course":[{"price":1000,"volume":0,"title2":"vvv","speaker":"bgfg","title":"视频CESHI","image":"https://pretty.f8cam.com/static/image/product/tu/tuauimijnc.jpg","type":1,"length":1242,"object_id":"10000036"},{"price":500,"volume":0,"title2":" 人挺好还有","speaker":" 更好","title":" 用户好一反跳痛人","image":"https://pretty.f8cam.com/static/image/product/dw/dwapgryyjn.jpg","type":1,"length":41,"object_id":"10000039"}],"page_index":"0","total":2,"page_size":"10"}
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
         * course : [{"price":1000,"volume":0,"title2":"vvv","speaker":"bgfg","title":"视频CESHI","image":"https://pretty.f8cam.com/static/image/product/tu/tuauimijnc.jpg","type":1,"length":1242,"object_id":"10000036"},{"price":500,"volume":0,"title2":" 人挺好还有","speaker":" 更好","title":" 用户好一反跳痛人","image":"https://pretty.f8cam.com/static/image/product/dw/dwapgryyjn.jpg","type":1,"length":41,"object_id":"10000039"}]
         * page_index : 0
         * total : 2
         * page_size : 10
         */

        private String page_index;
        private int total;
        private String page_size;
        private List<CourseBean> course;

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

        public List<CourseBean> getCourse() {
            return course;
        }

        public void setCourse(List<CourseBean> course) {
            this.course = course;
        }

        public static class CourseBean {
            /**
             * price : 1000
             * volume : 0
             * title2 : vvv
             * speaker : bgfg
             * title : 视频CESHI
             * image : https://pretty.f8cam.com/static/image/product/tu/tuauimijnc.jpg
             * type : 1
             * length : 1242
             * object_id : 10000036
             */

            private int price;
            private int volume;
            private String title2;
            private String speaker;
            private String title;
            private String image;
            private int type;
            private int length;
            private String object_id;

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getVolume() {
                return volume;
            }

            public void setVolume(int volume) {
                this.volume = volume;
            }

            public String getTitle2() {
                return title2;
            }

            public void setTitle2(String title2) {
                this.title2 = title2;
            }

            public String getSpeaker() {
                return speaker;
            }

            public void setSpeaker(String speaker) {
                this.speaker = speaker;
            }

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

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getLength() {
                return length;
            }

            public void setLength(int length) {
                this.length = length;
            }

            public String getObject_id() {
                return object_id;
            }

            public void setObject_id(String object_id) {
                this.object_id = object_id;
            }
        }
    }
}
