package com.tech.younsik.article.domain.object;

import com.tech.younsik.common.utils.CommonUtils;
import com.tech.younsik.common.utils.DateUtils;
import com.tech.younsik.common.utils.StringUtils;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ArticleObject {

  private Long id;

  private Long authorId;

  private String title;

  private String content;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  @Builder
  public ArticleObject(
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

  public static ArticleObject create(int titleSize, int contentSize) {
    LocalDateTime temp = DateUtils.createRandomDateTimeBeforeCurrent();
    return ArticleObject.builder()
        .id(CommonUtils.createRandomId())
        .authorId(CommonUtils.createRandomId())
        .title(StringUtils.createRandomString(titleSize))
        .content(StringUtils.createRandomString(contentSize))
        .createdAt(temp)
        .updatedAt(DateUtils.createRandomDateTimeAfterTarget(temp))
        .build();
  }
}
