package com.yihuolu.seats.domain.client;

import com.alibaba.fastjson.JSON;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@ToString
public class RoomResponse extends BaseResponse {
    public List<Room> getRooms() {
        Object rooms = getParams().get("rooms");
        return JSON.parseArray(String.valueOf(rooms), Room.class);
    }
}
