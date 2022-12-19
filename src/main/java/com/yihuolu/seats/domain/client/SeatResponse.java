package com.yihuolu.seats.domain.client;

import com.alibaba.fastjson.JSON;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@ToString
public class SeatResponse extends BaseResponse {
    public List<Seat> getSeats() {
        Object seats = getParams().get("seats");
        return JSON.parseArray(String.valueOf(seats), Seat.class);
    }
}
