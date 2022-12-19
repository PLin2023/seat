package com.yihuolu.seats.domain.client;

public enum BookStat {
    CANCEL("已取消"),
    AWAY("暂时离开"),
    CHECK_IN("履约中"),
    COMPLETE("已履约"),
    INCOMPLETE("早退"),
    MISS("失约"),
    STOP("结束使用");

    private String name;
    BookStat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
