package beans;

import java.util.List;

/**
 * Created by Lenovo on 2018/11/5.
 */

public class NewsBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2018-11-05 00:00","title":"中国父母，活得好像一条狗啊","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p2.ifengimg.com/2018_45/6428C681F30BC0E5AEF0DD7D767787ABE37FD0AB_w958_h494.jpg","url":"http://news.ifeng.com/a/20181105/60145587_0.shtml"},{"ctime":"2018-11-05 00:00","title":"武汉一对男女铁轨上争吵 三列火车头受阻20分钟","description":"凤凰社会","picUrl":"","url":"http://news.ifeng.com/a/20181105/60144822_0.shtml"},{"ctime":"2018-11-05 00:00","title":"滨海新区发布中国首款自主RapidIO二代交换芯片","description":"凤凰社会","picUrl":"","url":"http://news.ifeng.com/a/20181105/60144905_0.shtml"},{"ctime":"2018-11-05 00:00","title":"专科真的不如本科吗？2017年高职高专就业率已超本科","description":"凤凰社会","picUrl":"","url":"http://news.ifeng.com/a/20181105/60145326_0.shtml"},{"ctime":"2018-11-05 00:00","title":"他被编入了\u201c高考状元高分低能案例大全\u201d","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p3.ifengimg.com/2018_45/5FC50CC93229553503310F659CA82E8C7C4116A1_w644_h484.png","url":"http://news.ifeng.com/a/20181105/60145294_0.shtml"},{"ctime":"2018-11-05 00:00","title":"西安千亿国企新任10名高管曝光：全是\u201c80后90后\u201d","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1105/4D34053425F0BF94298705EB58B15C3FD90FB691_size44_w676_h482.jpeg","url":"http://news.ifeng.com/a/20181105/60145384_0.shtml"},{"ctime":"2018-11-05 00:00","title":"森林警察接到老人求助电话：我家有头黑熊 养不起了","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/2018_45/4BA46C9719C7A9876F3CE97B87022F77E263FAAC_w550_h366.jpg","url":"http://news.ifeng.com/a/20181105/60145473_0.shtml"},{"ctime":"2018-11-05 00:00","title":"老挝湖南商会原会长被害 湖南警方：生意纠纷雇凶杀人","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/2018_45/7A3714C2D5238B705763E34896F521EA0FD1580C_w750_h502.jpg","url":"http://news.ifeng.com/a/20181105/60145489_0.shtml"},{"ctime":"2018-11-05 00:00","title":"部署\u201c寻找京津冀最美慈善义工\u201d媒体联合宣传","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1105/13C121DFA17D6BD1E21D60C41D9BA04534DB9C50_size51_w600_h399.jpeg","url":"http://news.ifeng.com/a/20181105/60145502_0.shtml"},{"ctime":"2018-11-05 00:00","title":"【\u201c最美\u201d候选人】李冰洋","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p3.ifengimg.com/2018_45/9E926BB827FBA253333F4003570AD1906868D57F_w600_h450.jpg","url":"http://news.ifeng.com/a/20181105/60145493_0.shtml"}]
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
         * ctime : 2018-11-05 00:00
         * title : 中国父母，活得好像一条狗啊
         * description : 凤凰社会
         * picUrl : http://d.ifengimg.com/w150_h95/p2.ifengimg.com/2018_45/6428C681F30BC0E5AEF0DD7D767787ABE37FD0AB_w958_h494.jpg
         * url : http://news.ifeng.com/a/20181105/60145587_0.shtml
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
