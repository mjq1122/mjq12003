package beans;

import java.util.List;

/**
 * Created by Lenovo on 2018/11/15.
 */

public class NewsBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2018-11-15 00:00","title":"北京柏悦酒店回应卫生乱象：是单一事件","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/e0.ifengimg.com/09/2018/1115/63343496338624BCA4F747ABAF94A2C21713D0CC_size85_w600_h641.jpeg","url":"http://news.ifeng.com/a/20181115/60161360_0.shtml"},{"ctime":"2018-11-15 00:00","title":"酒店卫生为何屡爆丑闻？五星级酒店管理漏洞调查","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p3.ifengimg.com/2018_46/BD95B5C94BA386D21CE6A1B3803639E0CDE34C4A_w580_h423.jpg","url":"http://news.ifeng.com/a/20181115/60161473_0.shtml"},{"ctime":"2018-11-15 00:00","title":"副局长4分钟内4次未接省巡查组电话 县纪委：党内警告","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p1.ifengimg.com/2018_46/B83AA33E210C36EBA60BBF2E0B32DFB15CBBA6C3_w440_h249.jpg","url":"http://news.ifeng.com/a/20181115/60161534_0.shtml"},{"ctime":"2018-11-15 00:00","title":"福州香格里拉回应卫生乱象：情况确实存在 向公众道歉","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/2018_46/835930B6F960D90951977624C6D56A0D805D1E73_w600_h336.jpg","url":"http://news.ifeng.com/a/20181115/60161287_0.shtml"},{"ctime":"2018-11-15 00:00","title":"外滩华尔道夫回应酒店卫生乱象：已启动调查","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/e0.ifengimg.com/07/2018/1115/099A05E6CE1D4EABB358C172C2DD1365340F10F1_size30_w600_h339.jpeg","url":"http://news.ifeng.com/a/20181115/60161304_0.shtml"},{"ctime":"2018-11-15 00:00","title":"海归等于百万年薪？职场究竟靠学历还是靠实力？","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p3.ifengimg.com/2018_46/1054DF1FBB0CB1DD17430B1C88B0AC28F29C9DDC_w1269_h846.jpg","url":"http://news.ifeng.com/a/20181115/60161328_0.shtml"},{"ctime":"2018-11-15 00:00","title":"深圳渔民村老村长：没有改革开放，你看到的地方都是泥塘","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1115/FB0CE84E23DF52807F81663521688677F64FC692_size23_w600_h348.jpeg","url":"http://news.ifeng.com/a/20181115/60161032_0.shtml"},{"ctime":"2018-11-15 00:00","title":"昨日\u201c立霾\u201d？听听专家怎么说","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1115/FB0CE84E23DF52807F81663521688677F64FC692_size23_w600_h348.jpeg","url":"http://news.ifeng.com/a/20181115/60161036_0.shtml"},{"ctime":"2018-11-15 00:00","title":"不仅浴巾擦马桶这么简单 星级酒店的神操作你根本防不住","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1115/01B55EB855A1F93A4A921CF890C6EC91AF0458A5_size115_w450_h254.jpeg","url":"http://news.ifeng.com/a/20181115/60161021_0.shtml"},{"ctime":"2018-11-15 00:00","title":"多家五星级酒店被曝卫生乱象 上海旅游局：正核实调查","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/1115/228BBF476F66642FFC3684B71D6CC978063F3355_size12_w440_h587.jpeg","url":"http://news.ifeng.com/a/20181115/60161135_0.shtml"}]
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
         * ctime : 2018-11-15 00:00
         * title : 北京柏悦酒店回应卫生乱象：是单一事件
         * description : 凤凰社会
         * picUrl : http://d.ifengimg.com/w150_h95/e0.ifengimg.com/09/2018/1115/63343496338624BCA4F747ABAF94A2C21713D0CC_size85_w600_h641.jpeg
         * url : http://news.ifeng.com/a/20181115/60161360_0.shtml
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
