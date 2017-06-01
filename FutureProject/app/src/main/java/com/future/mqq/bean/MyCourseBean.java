package com.future.mqq.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lenovo on 2017/5/26.
 */

public class MyCourseBean {

    /**
     * data : {"try_length":30,"comment_num":0,"abstract":"好hhjy","volume":0,"title2":"vvv","course_video":"https://pretty.f8cam.com/static/image/transcoded_files/20170525/20170525094444.mp4","title":"视频CESHI","speaker_head":"https://pretty.f8cam.com/static/image/product/uz/uzsccwupkj.jpg","object_id":"10000036","exam_score":-1,"service_tel":"13800000000","speaker_audio":"https://pretty.f8cam.com/static/image/media_upload/20170526/vsxosmrbpu.mp3","type":1}
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
         * try_length : 30
         * comment_num : 0
         * abstract : 好hhjy
         * volume : 0
         * title2 : vvv
         * course_video : https://pretty.f8cam.com/static/image/transcoded_files/20170525/20170525094444.mp4
         * title : 视频CESHI
         * speaker_head : https://pretty.f8cam.com/static/image/product/uz/uzsccwupkj.jpg
         * object_id : 10000036
         * exam_score : -1
         * service_tel : 13800000000
         * speaker_audio : https://pretty.f8cam.com/static/image/media_upload/20170526/vsxosmrbpu.mp3
         * type : 1
         */

        private int try_length;
        private int comment_num;
        @SerializedName("abstract")
        private String abstractX;
        private int volume;
        private String title2;
        private String course_video;
        private String title;
        private String speaker_head;
        private String object_id;
        private int exam_score;
        private String service_tel;
        private String speaker_audio;
        private int type;

        public int getTry_length() {
            return try_length;
        }

        public void setTry_length(int try_length) {
            this.try_length = try_length;
        }

        public int getComment_num() {
            return comment_num;
        }

        public void setComment_num(int comment_num) {
            this.comment_num = comment_num;
        }

        public String getAbstractX() {
            return abstractX;
        }

        public void setAbstractX(String abstractX) {
            this.abstractX = abstractX;
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

        public String getCourse_video() {
            return course_video;
        }

        public void setCourse_video(String course_video) {
            this.course_video = course_video;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSpeaker_head() {
            return speaker_head;
        }

        public void setSpeaker_head(String speaker_head) {
            this.speaker_head = speaker_head;
        }

        public String getObject_id() {
            return object_id;
        }

        public void setObject_id(String object_id) {
            this.object_id = object_id;
        }

        public int getExam_score() {
            return exam_score;
        }

        public void setExam_score(int exam_score) {
            this.exam_score = exam_score;
        }

        public String getService_tel() {
            return service_tel;
        }

        public void setService_tel(String service_tel) {
            this.service_tel = service_tel;
        }

        public String getSpeaker_audio() {
            return speaker_audio;
        }

        public void setSpeaker_audio(String speaker_audio) {
            this.speaker_audio = speaker_audio;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
