package beans;

import java.util.List;

/**
 * Created by Lenovo on 2018/11/19.
 */

public class NewsBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2018-11-19 00:00","title":"杭州城管通报文明养犬治理工作情况","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/e0.ifengimg.com/01/2018/1119/3098EECE4EFDA00B3FDA5EE260B87A73F897D29D_size422_w740_h1263.jpeg","url":"http://news.ifeng.com/a/20181119/60166626_0.shtml"},{"ctime":"2018-11-18 00:00","title":"女人堕落导致国家堕落？张雨绮怒怼后，俞敏洪道歉","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p3.ifengimg.com/2018_47/E24361FFC64B60FE9F3A58556CE6E4659B60B639_w649_h239.jpg","url":"http://news.ifeng.com/a/20181118/60166357_0.shtml"},{"ctime":"2018-11-18 00:00","title":"24小时不到\u201c花总\u201d个人信息两度遭泄露，谁该负责？","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p2.ifengimg.com/2018_47/032872640758478E3F390583A81CC2B2858DF67A_w495_h847.jpg","url":"http://news.ifeng.com/a/20181118/60166332_0.shtml"},{"ctime":"2018-11-18 00:00","title":"西湖景区失联女生被害案嫌犯落网 抓捕场面曝光","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p2.ifengimg.com/2018_47/95F6D92F2C9F4FF2DD481A88A0F07EE107E6780B_w750_h1000.jpg","url":"http://news.ifeng.com/a/20181118/60166226_0.shtml"},{"ctime":"2018-11-18 00:00","title":"张家界一女子称医院不告知原因就切除子宫 官方回应","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p3.ifengimg.com/2018_47/5CD86E95F2CC3AC094765EC64B86C75D73BFA531_w660_h766.png","url":"http://news.ifeng.com/a/20181118/60166270_0.shtml"},{"ctime":"2018-11-18 00:00","title":"一架直升机迫降峨眉山景区，一名驾驶员轻伤","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p3.ifengimg.com/2018_47/D438FAE3224F5C68307914B09E67BC6D5720A319_w674_h488.png","url":"http://news.ifeng.com/a/20181118/60166072_0.shtml"},{"ctime":"2018-11-18 00:00","title":"全国最好的医院都在这儿了|名单","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p2.ifengimg.com/2018_47/83BBE91794BC7EB3F7BA6E0D8820349DDAB5716A_w600_h1236.jpg","url":"http://news.ifeng.com/a/20181118/60166109_0.shtml"},{"ctime":"2018-11-18 00:00","title":"女子说买辆玛莎拉蒂就结婚 男子轻松\u201c做到\u201d却被刑拘","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p3.ifengimg.com/2018_47/1387F0E9AFFA78A7A9C9F0986FECC3FB3E1DBB30_w1080_h720.jpg","url":"http://news.ifeng.com/a/20181118/60166141_0.shtml"},{"ctime":"2018-11-18 00:00","title":"乘客飞机上要换靠窗座 空乘用纸画了个\u201c窗户\u201d","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/e0.ifengimg.com/02/2018/1118/2F2436E5DDA51CAEA4D9F9F6DFE3A753DF711C2E_size444_w600_h467.png","url":"http://news.ifeng.com/a/20181118/60166171_0.shtml"},{"ctime":"2018-11-18 00:00","title":"一个癌症病人的自我剖析","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p2.ifengimg.com/2018_47/95F6D92F2C9F4FF2DD481A88A0F07EE107E6780B_w750_h1000.jpg","url":"http://news.ifeng.com/a/20181118/60166177_0.shtml"}]
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
         * ctime : 2018-11-19 00:00
         * title : 杭州城管通报文明养犬治理工作情况
         * description : 凤凰社会
         * picUrl : http://d.ifengimg.com/w150_h95/e0.ifengimg.com/01/2018/1119/3098EECE4EFDA00B3FDA5EE260B87A73F897D29D_size422_w740_h1263.jpeg
         * url : http://news.ifeng.com/a/20181119/60166626_0.shtml
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
