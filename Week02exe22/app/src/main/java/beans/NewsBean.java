package beans;

import java.util.List;

/**
 * Created by Lenovo on 2018/11/11.
 */

public class NewsBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2018-11-11 00:00","title":"南京中医药大学翰林学院实验室爆燃，致使多名师生受伤","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1111/057F2EB96377D0887567930E3511347A8FED124A_size94_w600_h1108.jpeg","url":"http://news.ifeng.com/a/20181111/60154885_0.shtml"},{"ctime":"2018-11-11 00:00","title":"福建检察机关第一时间介入泉港碳九泄漏事件","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p2.ifengimg.com/2018_46/8BC913D68ED0440A5B718EF1D4611140A452B2EB_w900_h675.jpg","url":"http://news.ifeng.com/a/20181111/60154648_0.shtml"},{"ctime":"2018-11-11 00:00","title":"湖北省经信委原副主任夏平减刑被拒：不积极退赃","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1111/C032A6A8F028151ACDFC188FBA196D2E911426FD_size104_w400_h299.jpeg","url":"http://news.ifeng.com/a/20181111/60154590_0.shtml"},{"ctime":"2018-11-11 00:00","title":"除了性生活，只剩打麻将：中国2000多个县城生活实录","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p1.ifengimg.com/2018_46/49F72352AD4A3A37238435D07C3E4488E3A3F52A_w600_h400.jpg","url":"http://news.ifeng.com/a/20181111/60154574_0.shtml"},{"ctime":"2018-11-11 00:00","title":"北京一婴儿游泳馆经营不善关门跑路，消费者喊退钱","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1111/C032A6A8F028151ACDFC188FBA196D2E911426FD_size104_w400_h299.jpeg","url":"http://news.ifeng.com/a/20181111/60154446_0.shtml"},{"ctime":"2018-11-11 00:00","title":"今年双11成交破千亿仅用了1小时47分，比去年快了7小时","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1110/1A79475D3719487891CFF862929D2948FAE7243F_size68_w640_h348.jpeg","url":"http://news.ifeng.com/a/20181111/60154356_0.shtml"},{"ctime":"2018-11-10 00:00","title":"湖北一狱警涉嫌醉驾撞伤5名行人被免职","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1110/1A79475D3719487891CFF862929D2948FAE7243F_size68_w640_h348.jpeg","url":"http://news.ifeng.com/a/20181110/60154129_0.shtml"},{"ctime":"2018-11-10 00:00","title":"吴京凭战狼2获百花奖影帝 红海行动摘五奖成最大赢家","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1110/1A79475D3719487891CFF862929D2948FAE7243F_size68_w640_h348.jpeg","url":"http://news.ifeng.com/a/20181110/60154101_0.shtml"},{"ctime":"2018-11-10 00:00","title":"聂树斌案真凶发现者郑成月身患重病 网友已筹善款47万","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1110/D1F199C00314DFF3F05AAC78869D9CDF65678237_size41_w600_h800.jpeg","url":"http://news.ifeng.com/a/20181110/60154084_0.shtml"},{"ctime":"2018-11-10 00:00","title":"武汉一老师从教学楼跳下身亡 死前将绝笔发单位群","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1110/A5EF3D6523869C53000153EEE1EA68B7469E1492_size289_w1080_h1828.jpeg","url":"http://news.ifeng.com/a/20181110/60154031_0.shtml"}]
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
         * ctime : 2018-11-11 00:00
         * title : 南京中医药大学翰林学院实验室爆燃，致使多名师生受伤
         * description : 凤凰社会
         * picUrl : http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1111/057F2EB96377D0887567930E3511347A8FED124A_size94_w600_h1108.jpeg
         * url : http://news.ifeng.com/a/20181111/60154885_0.shtml
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
