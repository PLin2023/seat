package com.yihuolu.seats.domain.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    private Integer id;
    private String name;
    private Integer col;
    private Integer row;
    private Boolean computer;
    private Boolean power;
    private Boolean window;
    private SeatStatus status;
    private SeatType type;
}
