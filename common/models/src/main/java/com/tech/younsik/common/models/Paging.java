package com.tech.younsik.common.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Paging {
  // 한 요청에서 나타내는 원소의 수
  @JsonProperty(value = "size")
  private int size;

  // 페이지 번호 (0번 부터 시작)
  @JsonProperty(value = "page")
  private int page;

  // 현재 응답 데이터의 갯수
  @JsonProperty(value = "current")
  private int current;

  // 페이지로 제공되는 총 페이지 수
  @JsonProperty(value = "totalPages")
  private long totalPages;

  // 모든 페이지에 존재하는 총 원소 수
  @JsonProperty(value = "totalElements")
  private long totalElements;

  @Builder
  public Paging(int size, int page, int current, long totalPages, long totalElements) {
    this.size = size;
    this.page = page;
    this.current = current;
    this.totalPages = totalPages;
    this.totalElements = totalElements;
  }

  public static Paging single() {
    return Paging.builder().page(1).size(1).current(1).totalElements(1).totalPages(1).build();
  }

  public static Paging create(int page, int size, int current) {
    return Paging.builder()
        .page(page)
        .size(size)
        .current(current)
        .totalElements(1)
        .totalPages(1)
        .build();
  }
}
