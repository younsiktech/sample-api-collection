package com.tech.younsik.common.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SimpleResponse<T> {

  @JsonProperty(value = "paging")
  private Paging paging;

  @JsonProperty(value = "data")
  private List<T> data;

  @Builder
  public SimpleResponse(Paging paging, List<T> data) {
    this.paging = paging;
    this.data = data;
  }
}
