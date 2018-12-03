package com.bwei.week02exe11.beans;

import java.util.List;

/**
 * Created by Lenovo on 2018/11/9.
 */

public class NewsBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2018-11-09 00:00","title":"泉州碳九泄露事故：化工区距最近居民区仅174米","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1109/075BB7E7D8D980B0C84F469CD3937C10DD946601_size58_w750_h424.jpeg","url":"http://news.ifeng.com/a/20181109/60151839_0.shtml"},{"ctime":"2018-11-09 00:00","title":"被人大代表性侵后的850天：\u201c我们家都是无期\u201d","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p3.ifengimg.com/2018_45/08E3F8263B0E2CFE493DBD84B64DF0C32DAD865D_w1024_h576.jpg","url":"http://news.ifeng.com/a/20181109/60151803_0.shtml"},{"ctime":"2018-11-09 00:00","title":"泉州市政府新闻办：碳九泄漏初步认定为安全生产责任事故","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p3.ifengimg.com/2018_45/F3C983C671FC6AED1EC25F7EDFF5393346DC0CAF_w392_h273.gif","url":"http://news.ifeng.com/a/20181109/60151580_0.shtml"},{"ctime":"2018-11-09 00:00","title":"重庆教育考试院回应高考\u201c政审\u201d：发布信息把关不严","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1109/157B3EA442758C07185EB9E71F06DC3339E17A10_size276_w750_h511.jpeg","url":"http://news.ifeng.com/a/20181109/60151579_0.shtml"},{"ctime":"2018-11-08 00:00","title":"女子护孩遭狗主殴打 检察日报：养犬管理法不能再沉睡","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p1.ifengimg.com/2018_45/8D72D583D00E7097CB102636324C826E0B537B91_w1080_h756.jpg","url":"http://news.ifeng.com/a/20181108/60151130_0.shtml"},{"ctime":"2018-11-08 00:00","title":"父子拔枪互射致儿死 法院：死者有违人伦 其父获轻判","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p3.ifengimg.com/2018_45/F3C983C671FC6AED1EC25F7EDFF5393346DC0CAF_w392_h273.gif","url":"http://news.ifeng.com/a/20181108/60151138_0.shtml"},{"ctime":"2018-11-08 00:00","title":"女职工50岁退休是浪费资源 这位大学教授的文章火了","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p1.ifengimg.com/2018_45/8D72D583D00E7097CB102636324C826E0B537B91_w1080_h756.jpg","url":"http://news.ifeng.com/a/20181108/60151105_0.shtml"},{"ctime":"2018-11-08 00:00","title":"福建碳九泄漏：学生戴口罩上课 两消防人员中毒","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1108/9163A828D41BD58E9D4A53679B46EEE416DEF765_size59_w641_h987.jpeg","url":"http://news.ifeng.com/a/20181108/60150991_0.shtml"},{"ctime":"2018-11-08 00:00","title":"学生称迟到被老师殴打打断四把扫把 学校：警方介入","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p2.ifengimg.com/2018_45/674343C6C06D109811817B7949694E4121C58B4F_w321_h552.jpg","url":"http://news.ifeng.com/a/20181108/60150989_0.shtml"},{"ctime":"2018-11-08 00:00","title":"官方通报泉港碳九泄漏：52人就诊","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p1.ifengimg.com/2018_45/DD5BADC1B6E7724A96B0E44ED0340108753F989F_w662_h424.png","url":"http://news.ifeng.com/a/20181108/60151007_0.shtml"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2018-11-09 00:00
         * title : 泉州碳九泄露事故：化工区距最近居民区仅174米
         * description : 凤凰社会
         * picUrl : http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1109/075BB7E7D8D980B0C84F469CD3937C10DD946601_size58_w750_h424.jpeg
         * url : http://news.ifeng.com/a/20181109/60151839_0.shtml
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
