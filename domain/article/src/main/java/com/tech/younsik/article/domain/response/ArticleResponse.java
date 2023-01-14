package com.tech.younsik.article.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech.younsik.article.domain.object.ArticleObject;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ArticleResponse {

  @JsonProperty(value = "id")
  private Long id;

  @JsonProperty(value = "authorId")
  private Long authorId;

  @JsonProperty(value = "title")
  private String title;

  @JsonProperty(value = "content")
  private String content;

  @JsonProperty(value = "createdAt")
  private LocalDateTime createdAt;

  @JsonProperty(value = "updatedAt")
  private LocalDateTime updatedAt;

  @Builder
  public ArticleResponse(
      Long id,
      Long authorId,
      String title,
      String content,
      LocalDateTime createdAt,
      LocalDateTime updatedAt) {
    this.id = id;
    this.authorId = authorId;
    this.title = title;
    this.content = content;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public static ArticleResponse of(ArticleObject object) {
    return ArticleResponse.builder()
        .id(object.getId())
        .authorId(object.getAuthorId())
        .title(object.getTitle())
        .content(object.getContent())
        .createdAt(object.getCreatedAt())
        .updatedAt(object.getUpdatedAt())
        .build();
  }
}
