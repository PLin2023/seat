package com.yihuolu.seats.domain.client;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookHistory {
    private Integer id;
    private String receipt;
    private LocalDate date;
    private String begin;
    private String end;
    private String awayBegin;
    private String awayEnd;
    private String loc;

    @JSONField(serialize = false, deserialize = false)
    @ToString.Exclude
    private BookStat bookStat;

    @JSONField(name = "stat")
    @ToString.Include(name = "stat")
    public String getStat() {
        if (bookStat == null) {
            return null;
        }
        return bookStat.getName();
    }

    @JSONField(name = "stat")
    public void setStat(String bookStat) {
        this.bookStat = BookStat.valueOf(bookStat);
    }
}
