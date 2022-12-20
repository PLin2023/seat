package com.yihuolu.seats.domain.client;

import lombok.Data;

@Data
public class Book {
    private long id;
    private String receipt;
    private String onDate;
    private int seatId;
    private String status;
    private String location;
    private String begin;
    private String end;
    private String actualBegin;
    private String awayBegin;
    private String awayEnd;
    private boolean userEnded;
    private String message;
    private String qiandaoid;
}