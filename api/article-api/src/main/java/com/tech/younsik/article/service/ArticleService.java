package com.tech.younsik.article.service;

import com.tech.younsik.article.domain.object.ArticleObject;
import com.tech.younsik.article.domain.response.ArticleResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ArticleService {

  @Value("${app.article.title.min:4}")
  private int titleMinSize;

  @Value("${app.article.title.max:20}")
  private int titleMaxSize;

  @Value("${app.article.content.min:60}")
  private int contentMinSize;

  @Value("${app.article.content.max:60}")
  private int contentMaxSize;

  public ArticleResponse createArticle() {
    ArticleObject object =
        ArticleObject.create(
            RandomUtils.nextInt(titleMinSize, titleMaxSize),
            RandomUtils.nextInt(contentMinSize, contentMaxSize));
    return ArticleResponse.of(object);
  }

  public List<ArticleResponse> createArticleList(int size) {
    List<ArticleObject> objectList = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      objectList.add(
          ArticleObject.create(
              RandomUtils.nextInt(titleMinSize, titleMaxSize),
              RandomUtils.nextInt(contentMinSize, contentMaxSize)));
    }
    return objectList.stream().map(ArticleResponse::of).toList();
  }
}
