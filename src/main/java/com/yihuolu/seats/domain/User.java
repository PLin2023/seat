package com.yihuolu.seats.domain;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String openId;
    private String email;
}
