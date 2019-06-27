package com.example.lenovo.tumobi.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 吕尚勇 on 2019/6/24.
 */

public class SearchBean {

    /**
     * errno : 0
     * errmsg :
     * data : {"defaultKeyword":{"keyword":"520元礼包抢先领","is_hot":1,"is_default":1,"is_show":1,"sort_order":1,"scheme _url":"","id":1,"type":0},"historyKeywordList":[],"hotKeywordList":[{"keyword":"520元礼包抢先领","is_hot":1},{"keyword":"母亲节","is_hot":0},{"keyword":"日式","is_hot":0},{"keyword":"新品上市","is_hot":0},{"keyword":"墨镜","is_hot":0},{"keyword":"夏凉被","is_hot":0},{"keyword":"单鞋","is_hot":0}]}
     */

    private int errno;
    private String errmsg;
    private DataBean data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * defaultKeyword : {"keyword":"520元礼包抢先领","is_hot":1,"is_default":1,"is_show":1,"sort_order":1,"scheme _url":"","id":1,"type":0}
         * historyKeywordList : []
         * hotKeywordList : [{"keyword":"520元礼包抢先领","is_hot":1},{"keyword":"母亲节","is_hot":0},{"keyword":"日式","is_hot":0},{"keyword":"新品上市","is_hot":0},{"keyword":"墨镜","is_hot":0},{"keyword":"夏凉被","is_hot":0},{"keyword":"单鞋","is_hot":0}]
         */

        private DefaultKeywordBean defaultKeyword;
        private List<?> historyKeywordList;
        private List<HotKeywordListBean> hotKeywordList;

        public DefaultKeywordBean getDefaultKeyword() {
            return defaultKeyword;
        }

        public void setDefaultKeyword(DefaultKeywordBean defaultKeyword) {
            this.defaultKeyword = defaultKeyword;
        }

        public List<?> getHistoryKeywordList() {
            return historyKeywordList;
        }

        public void setHistoryKeywordList(List<?> historyKeywordList) {
            this.historyKeywordList = historyKeywordList;
        }

        public List<HotKeywordListBean> getHotKeywordList() {
            return hotKeywordList;
        }

        public void setHotKeywordList(List<HotKeywordListBean> hotKeywordList) {
            this.hotKeywordList = hotKeywordList;
        }

        public static class DefaultKeywordBean {
            /**
             * keyword : 520元礼包抢先领
             * is_hot : 1
             * is_default : 1
             * is_show : 1
             * sort_order : 1
             * scheme _url :
             * id : 1
             * type : 0
             */

            private String keyword;
            private int is_hot;
            private int is_default;
            private int is_show;
            private int sort_order;
            @SerializedName("scheme _url")
            private String _$Scheme_url6; // FIXME check this code
            private int id;
            private int type;

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }

            public int getIs_hot() {
                return is_hot;
            }

            public void setIs_hot(int is_hot) {
                this.is_hot = is_hot;
            }

            public int getIs_default() {
                return is_default;
            }

            public void setIs_default(int is_default) {
                this.is_default = is_default;
            }

            public int getIs_show() {
                return is_show;
            }

            public void setIs_show(int is_show) {
                this.is_show = is_show;
            }

            public int getSort_order() {
                return sort_order;
            }

            public void setSort_order(int sort_order) {
                this.sort_order = sort_order;
            }

            public String get_$Scheme_url6() {
                return _$Scheme_url6;
            }

            public void set_$Scheme_url6(String _$Scheme_url6) {
                this._$Scheme_url6 = _$Scheme_url6;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class HotKeywordListBean {
            /**
             * keyword : 520元礼包抢先领
             * is_hot : 1
             */

            private String keyword;
            private int is_hot;

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }

            public int getIs_hot() {
                return is_hot;
            }

            public void setIs_hot(int is_hot) {
                this.is_hot = is_hot;
            }
        }
    }
}
