package com.tech.younsik.article.controller;

import com.tech.younsik.article.domain.response.ArticleResponse;
import com.tech.younsik.article.service.ArticleService;
import com.tech.younsik.common.models.DefaultConstants;
import com.tech.younsik.common.models.Paging;
import com.tech.younsik.common.models.SimpleResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/sample-api/v1/articles")
@RequiredArgsConstructor
public class SampleArticleController {
  private final ArticleService articleService;

  @GetMapping(value = "/search")
  public SimpleResponse<ArticleResponse> memberList(
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "size", defaultValue = "20") int size) {

    if (page < 0 || page > DefaultConstants.MAX_TOTAL_PAGE) {
      throw new IllegalArgumentException(
          "Page must be less than " + DefaultConstants.MAX_TOTAL_PAGE);
    }

    if (size < 0 || size > DefaultConstants.MAX_SIZE_PER_REQUEST) {
      throw new IllegalArgumentException(
          "Size must be less than " + DefaultConstants.MAX_SIZE_PER_REQUEST);
    }

    List<ArticleResponse> data = articleService.createArticleList(size);

    return SimpleResponse.<ArticleResponse>builder()
        .paging(Paging.create(page, size, data.size()))
        .data(data)
        .build();
  }

  @GetMapping(value = "/pick")
  public SimpleResponse<ArticleResponse> memberOne() {

    List<ArticleResponse> data = List.of(articleService.createArticle());

    return SimpleResponse.<ArticleResponse>builder().paging(Paging.single()).data(data).build();
  }}
