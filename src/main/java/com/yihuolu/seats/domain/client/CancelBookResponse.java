package com.yihuolu.seats.domain.client;

import lombok.Data;

@Data
public class CancelBookResponse {
  private String status;
  private InnerData data;
  private String message;
  private String code;

  @Data
  static class InnerData {
    private Integer totalCancelled;
    private Integer allowedCancel;
  }

}