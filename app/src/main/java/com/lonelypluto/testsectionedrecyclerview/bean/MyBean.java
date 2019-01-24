package com.lonelypluto.testsectionedrecyclerview.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: bean
 * @author: ZhangYW
 * @time: 2019/1/24 9:15
 */
public class MyBean {
    private String header;
    private String footer;
    private List<ItemBean> list = new ArrayList<>();

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public List<ItemBean> getList() {
        return list;
    }

    public void setList(List<ItemBean> list) {
        this.list = list;
    }

    public static class ItemBean {
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
