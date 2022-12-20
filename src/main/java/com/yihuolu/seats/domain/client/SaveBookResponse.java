package com.yihuolu.seats.domain.client;

import lombok.Data;

@Data
public class SaveBookResponse {
    private String status;
    private InnerData data;
    private String message;
    private String code;

    @Data
    static class InnerData {
        private int id;
        private String receipt;
        private String onDate;
        private String begin;
        private String end;
        private String location;
        private Boolean checkedIn;
        private String checkInMsg;
    }
}