package com.yihuolu.seats.domain.client;

import com.alibaba.fastjson.JSON;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@ToString
public class BookHistoryResponse extends BaseResponse {
    public List<BookHistory> getHistory() {
        Object histories = getParams().get("history");
        return JSON.parseArray(String.valueOf(histories), BookHistory.class);
    }
}
