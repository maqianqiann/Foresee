package com.future.mqq.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 *
 * 类的注释：精选专辑的详情bean
 */

public class JingBean {


    /**
     * data : {"topic_image":"https://pretty.f8cam.com/static/image/product/pc/pcsdmdhzfg.jpg","title":"专辑测试1","abstract":"就是用于测试","object_id":"20000028","course":[{"price":2000,"volume":0,"title2":"点点滴滴","speaker":"点点滴滴","title":"点点滴滴","image":"https://pretty.f8cam.com/static/image/product/dp/dpsyducksc.jpg","type":1,"length":611,"object_id":"10000021"},{"price":500,"volume":0,"title2":"全网营销","speaker":"黄金之旅","title":"企业管理","image":"https://pretty.f8cam.com/static/image/product/cr/crgmihflyo.jpg","type":1,"length":126,"object_id":"10000026"},{"price":300,"volume":0,"title2":"建立利润中心","speaker":"男2","title":"如何洞悉企业成本","image":"https://pretty.f8cam.com/static/image/product/nc/ncqcfqlrrt.jpg","type":2,"length":25,"object_id":"10000027"},{"price":600,"volume":0,"title2":"测试2","speaker":"女","title":"测试1","image":"https://pretty.f8cam.com/static/image/product/nx/nxjmrgkrxc.jpg","type":2,"length":48,"object_id":"10000032"},{"price":1500,"volume":0,"title2":"视频","speaker":"男","title":"视频1","image":"https://pretty.f8cam.com/static/image/product/mw/mwfzzxogju.jpg","type":1,"length":611,"object_id":"10000033"}],"title2":"测试","booked_num":0}
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
         * topic_image : https://pretty.f8cam.com/static/image/product/pc/pcsdmdhzfg.jpg
         * title : 专辑测试1
         * abstract : 就是用于测试
         * object_id : 20000028
         * course : [{"price":2000,"volume":0,"title2":"点点滴滴","speaker":"点点滴滴","title":"点点滴滴","image":"https://pretty.f8cam.com/static/image/product/dp/dpsyducksc.jpg","type":1,"length":611,"object_id":"10000021"},{"price":500,"volume":0,"title2":"全网营销","speaker":"黄金之旅","title":"企业管理","image":"https://pretty.f8cam.com/static/image/product/cr/crgmihflyo.jpg","type":1,"length":126,"object_id":"10000026"},{"price":300,"volume":0,"title2":"建立利润中心","speaker":"男2","title":"如何洞悉企业成本","image":"https://pretty.f8cam.com/static/image/product/nc/ncqcfqlrrt.jpg","type":2,"length":25,"object_id":"10000027"},{"price":600,"volume":0,"title2":"测试2","speaker":"女","title":"测试1","image":"https://pretty.f8cam.com/static/image/product/nx/nxjmrgkrxc.jpg","type":2,"length":48,"object_id":"10000032"},{"price":1500,"volume":0,"title2":"视频","speaker":"男","title":"视频1","image":"https://pretty.f8cam.com/static/image/product/mw/mwfzzxogju.jpg","type":1,"length":611,"object_id":"10000033"}]
         * title2 : 测试
         * booked_num : 0
         */

        private String topic_image;
        private String title;
        @SerializedName("abstract")
        private String abstractX;
        private String object_id;
        private String title2;
        private int booked_num;
        private List<CourseBean> course;

        public String getTopic_image() {
            return topic_image;
        }

        public void setTopic_image(String topic_image) {
            this.topic_image = topic_image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAbstractX() {
            return abstractX;
        }

        public void setAbstractX(String abstractX) {
            this.abstractX = abstractX;
        }

        public String getObject_id() {
            return object_id;
        }

        public void setObject_id(String object_id) {
            this.object_id = object_id;
        }

        public String getTitle2() {
            return title2;
        }

        public void setTitle2(String title2) {
            this.title2 = title2;
        }

        public int getBooked_num() {
            return booked_num;
        }

        public void setBooked_num(int booked_num) {
            this.booked_num = booked_num;
        }

        public List<CourseBean> getCourse() {
            return course;
        }

        public void setCourse(List<CourseBean> course) {
            this.course = course;
        }

        public static class CourseBean {
            /**
             * price : 2000
             * volume : 0
             * title2 : 点点滴滴
             * speaker : 点点滴滴
             * title : 点点滴滴
             * image : https://pretty.f8cam.com/static/image/product/dp/dpsyducksc.jpg
             * type : 1
             * length : 611
             * object_id : 10000021
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
