package com.future.mqq.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/5/24.
 */

public class BannerBeans {

    /**
     * data : {"banner":[{"image":"https://pretty.f8cam.com/static/image/product/vr/vrklmjnzwj.jpg","click":""},{"image":"https://pretty.f8cam.com/static/image/product/yd/ydjsjzydzm.jpg","click":"http://baidu.com"},{"image":"https://pretty.f8cam.com/static/image/product/up/uphngailac.jpg","click":""}]}
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
        private List<BannerBean> banner;

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public static class BannerBean {
            /**
             * image : https://pretty.f8cam.com/static/image/product/vr/vrklmjnzwj.jpg
             * click :
             */

            private String image;
            private String click;

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getClick() {
                return click;
            }

            public void setClick(String click) {
                this.click = click;
            }
        }
    }
}
