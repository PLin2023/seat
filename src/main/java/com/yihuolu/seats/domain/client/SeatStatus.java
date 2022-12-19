package com.yihuolu.seats.domain.client;

public enum SeatStatus {

    FREE("空闲"),
    NOSELECT("无法选座"),
    IN_USE("使用中"),
    AWAY("暂时离开"),
    BOOKED("已有预约"),
    FULL("预约已满");

    private String name;
    SeatStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
