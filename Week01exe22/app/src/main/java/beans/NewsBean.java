package beans;

import java.util.List;

/**
 * Created by Lenovo on 2018/11/4.
 */

public class NewsBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2018-11-02 00:00","title":"侠客岛：15条人命，带来的教训足够深刻了","description":"凤凰社会","picUrl":"","url":"http://news.ifeng.com/a/20181102/60140842_0.shtml"},{"ctime":"2018-11-02 00:00","title":"法制日报评论：错过一站地，可怜一车人","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/2018_44/7FD1F122FE492F1F9F30ACECF4226DC84FC4CD7C_w550_h860.jpg","url":"http://news.ifeng.com/a/20181102/60140874_0.shtml"},{"ctime":"2018-11-02 00:00","title":"男子与公交司机拉扯致车撞电线杆 获刑2年","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/2018_44/1A11EA3EFA3C4753DFED33ABFDB861D2485C2061_w440_h904.jpg","url":"http://news.ifeng.com/a/20181102/60141112_0.shtml"},{"ctime":"2018-11-02 00:00","title":"青岛\u201c因万圣节惊悚装被骂\u201d当事人：希望骂人者道歉","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p1.ifengimg.com/2018_44/1BA46FAED16DAEC0950296F1B6C9E32A0FCC6A34_w598_h440.png","url":"http://news.ifeng.com/a/20181102/60140918_0.shtml"},{"ctime":"2018-11-02 00:00","title":"成年人公交出行保命指南","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p2.ifengimg.com/2018_44/BBC1205A60349664170950115C5CFDEE64EE033F_w441_h270.png","url":"http://news.ifeng.com/a/20181102/60141152_0.shtml"},{"ctime":"2018-11-02 00:00","title":"在公交车上\u201c动手\u201d，这些乘客和司机都被判了刑","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/2018_44/9621452BA483A5180E1E43D3ABD0E68491B07B81_w300_h184.jpg","url":"http://news.ifeng.com/a/20181102/60141029_0.shtml"},{"ctime":"2018-11-02 00:00","title":"新华社点赞：这一脚，踹得好！","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1102/D63F339A3B55C98CCE59C731CE6C9C8ED2992632_size36_w476_h546.jpeg","url":"http://news.ifeng.com/a/20181102/60141080_0.shtml"},{"ctime":"2018-11-02 00:00","title":"女儿磨蹭到十点半还没写完作业 33岁妈妈气出脑梗","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p1.ifengimg.com/2018_44/2A975F4DA9A78E21FDF7817D236FBB90701B359A_w552_h344.gif","url":"http://news.ifeng.com/a/20181102/60141099_0.shtml"},{"ctime":"2018-11-02 00:00","title":"重庆坠江公交吵架女乘客所开布艺店已关闭","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p3.ifengimg.com/2018_44/E0DB68F3553E7481AD12457ED6F6310457E13978_w637_h325.jpg","url":"http://news.ifeng.com/a/20181102/60141109_0.shtml"},{"ctime":"2018-11-02 00:00","title":"合肥：刺死警察的嫌犯涉嫌故意杀人罪被批捕","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p2.ifengimg.com/2018_44/3CE731DEF134B38EC3D8B706BBB8061E415FFDB7_w384_h273.jpg","url":"http://news.ifeng.com/a/20181102/60141125_0.shtml"}]
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
         * ctime : 2018-11-02 00:00
         * title : 侠客岛：15条人命，带来的教训足够深刻了
         * description : 凤凰社会
         * picUrl :
         * url : http://news.ifeng.com/a/20181102/60140842_0.shtml
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
