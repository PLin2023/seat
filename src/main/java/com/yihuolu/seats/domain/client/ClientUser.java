package com.yihuolu.seats.domain.client;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClientUser {
  private Integer id;
  private Boolean enabled;
  private String name;
  private String username;
  private String username2;
  private String status;
  private Boolean isAdmin;
  private Boolean superviseAway;
  private LocalDateTime lastLogin;
  private LocalDateTime lastIn;
  private LocalDateTime lastOut;
  private Boolean checkedIn;
  private String reservationStatus;
  private Integer violationCount;
  private Long lastInBuildingId;
  private String lastInBuildingName;

}