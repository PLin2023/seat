package com.yihuolu.seats.domain.client;

import lombok.Data;

import java.util.Map;

@Data
public class BaseResponse {
    private Boolean status;
    private String content;

    private Map<String, Object> params;
}
