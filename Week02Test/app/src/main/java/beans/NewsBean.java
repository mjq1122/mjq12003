package beans;

import java.util.List;

/**
 * Created by Lenovo on 2018/11/12.
 */

public class NewsBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2018-11-12 00:00","title":"献礼改革开放40周年 \u201c下沙蝶变\u201d征文活动结果揭晓","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p1.ifengimg.com/2018_46/B0507B66BB231517C7CEB8CF0139FA52098239CD_w540_h897.jpg","url":"http://news.ifeng.com/a/20181112/60155644_0.shtml"},{"ctime":"2018-11-11 00:00","title":"双目失明却用爱点亮盲童心灯 河北盲校长获外媒点赞","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1111/718A6E25DFAA5BC60B2E005FD838AFDF6A9F32C8_size49_w809_h609.jpeg","url":"http://news.ifeng.com/a/20181111/60155230_0.shtml"},{"ctime":"2018-11-11 00:00","title":"新骗局：女子称被男友抛弃，要转账散财报复\u201c渣男\u201d","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p1.ifengimg.com/2018_46/B0507B66BB231517C7CEB8CF0139FA52098239CD_w540_h897.jpg","url":"http://news.ifeng.com/a/20181111/60155251_0.shtml"},{"ctime":"2018-11-11 00:00","title":"西安：快递员一月交通违法2次扣钱，3次将被逐出行业","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1111/578F6E8D7C17BDA92426175AD90CFD203A073C47_size33_w600_h450.jpeg","url":"http://news.ifeng.com/a/20181111/60155156_0.shtml"},{"ctime":"2018-11-11 00:00","title":"南京中医药大学翰林学院实验室爆燃，致使多名师生受伤","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1111/057F2EB96377D0887567930E3511347A8FED124A_size94_w600_h1108.jpeg","url":"http://news.ifeng.com/a/20181111/60154885_0.shtml"},{"ctime":"2018-11-11 00:00","title":"福建检察机关第一时间介入泉港碳九泄漏事件","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p2.ifengimg.com/2018_46/8BC913D68ED0440A5B718EF1D4611140A452B2EB_w900_h675.jpg","url":"http://news.ifeng.com/a/20181111/60154648_0.shtml"},{"ctime":"2018-11-11 00:00","title":"湖北省经信委原副主任夏平减刑被拒：不积极退赃","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1111/C032A6A8F028151ACDFC188FBA196D2E911426FD_size104_w400_h299.jpeg","url":"http://news.ifeng.com/a/20181111/60154590_0.shtml"},{"ctime":"2018-11-11 00:00","title":"除了性生活，只剩打麻将：中国2000多个县城生活实录","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p1.ifengimg.com/2018_46/49F72352AD4A3A37238435D07C3E4488E3A3F52A_w600_h400.jpg","url":"http://news.ifeng.com/a/20181111/60154574_0.shtml"},{"ctime":"2018-11-11 00:00","title":"北京一婴儿游泳馆经营不善关门跑路，消费者喊退钱","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1111/C032A6A8F028151ACDFC188FBA196D2E911426FD_size104_w400_h299.jpeg","url":"http://news.ifeng.com/a/20181111/60154446_0.shtml"},{"ctime":"2018-11-11 00:00","title":"今年双11成交破千亿仅用了1小时47分，比去年快了7小时","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1110/1A79475D3719487891CFF862929D2948FAE7243F_size68_w640_h348.jpeg","url":"http://news.ifeng.com/a/20181111/60154356_0.shtml"}]
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
         * ctime : 2018-11-12 00:00
         * title : 献礼改革开放40周年 “下沙蝶变”征文活动结果揭晓
         * description : 凤凰社会
         * picUrl : http://d.ifengimg.com/w150_h95/p1.ifengimg.com/2018_46/B0507B66BB231517C7CEB8CF0139FA52098239CD_w540_h897.jpg
         * url : http://news.ifeng.com/a/20181112/60155644_0.shtml
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
