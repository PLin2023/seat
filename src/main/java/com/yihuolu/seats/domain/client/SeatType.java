package com.yihuolu.seats.domain.client;

public enum SeatType {
    empty("空"),
    door("门"),
    window("窗"),
    word("工位"),
    desk("桌位"),
    seat("座位");

    private String name;
    SeatType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
