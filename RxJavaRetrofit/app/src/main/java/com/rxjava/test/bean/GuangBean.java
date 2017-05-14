package com.rxjava.test.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/5/12.
 */

public class GuangBean {

    private List<AdsBean> ads;
    private List<List<String>> dropdown;

    public List<AdsBean> getAds() {
        return ads;
    }

    public void setAds(List<AdsBean> ads) {
        this.ads = ads;
    }

    public List<List<String>> getDropdown() {
        return dropdown;
    }

    public void setDropdown(List<List<String>> dropdown) {
        this.dropdown = dropdown;
    }

    public static class AdsBean {
        /**
         * id : 73
         * imgsrc : http://service.meiyinkeqiu.com:80/upload/back/ads/4a84a427-d38b-4584-8ca8-869aa41c1eab.png
         * url : http://service.meiyinkeqiu.com:80/service/product/fenxiang/352
         * type : cptj
         * adsorder : 2
         * typecn : null
         * gonggaoren : 陈思美容代理公司
         * timelength : 30
         * state : 1
         * ptime : 2017-04-20 16:21:01
         * lianjietype : 内部
         * docid : 352
         * menuurl : cptj
         * infotype : 2
         */

        private int id;
        private String imgsrc;
        private String url;
        private String type;
        private int adsorder;
        private Object typecn;
        private String gonggaoren;
        private int timelength;
        private int state;
        private String ptime;
        private String lianjietype;
        private String docid;
        private String menuurl;
        private String infotype;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getAdsorder() {
            return adsorder;
        }

        public void setAdsorder(int adsorder) {
            this.adsorder = adsorder;
        }

        public Object getTypecn() {
            return typecn;
        }

        public void setTypecn(Object typecn) {
            this.typecn = typecn;
        }

        public String getGonggaoren() {
            return gonggaoren;
        }

        public void setGonggaoren(String gonggaoren) {
            this.gonggaoren = gonggaoren;
        }

        public int getTimelength() {
            return timelength;
        }

        public void setTimelength(int timelength) {
            this.timelength = timelength;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getLianjietype() {
            return lianjietype;
        }

        public void setLianjietype(String lianjietype) {
            this.lianjietype = lianjietype;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public String getMenuurl() {
            return menuurl;
        }

        public void setMenuurl(String menuurl) {
            this.menuurl = menuurl;
        }

        public String getInfotype() {
            return infotype;
        }

        public void setInfotype(String infotype) {
            this.infotype = infotype;
        }
    }
}
