package com.yihuolu.seats.domain.client;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private Integer roomId;
    private Integer totalSeats;
    private Integer floor;
    private String name;

    @JSONField(name = "room")
    public String getName() {
        return name;
    }

    @JSONField(name = "room")
    public void setName(String name) {
        this.name = name;
    }
}
