package com.tech.younsik.member.controller;

import com.tech.younsik.common.models.DefaultConstants;
import com.tech.younsik.common.models.Paging;
import com.tech.younsik.common.models.SimpleResponse;
import com.tech.younsik.member.domain.response.MemberResponse;
import com.tech.younsik.member.service.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/sample-api/v1/members")
@RequiredArgsConstructor
public class SampleMemberController {

  private final MemberService memberService;

  @GetMapping(value = "/search")
  public SimpleResponse<MemberResponse> memberList(
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

    List<MemberResponse> data = memberService.createMemberList(size);

    return SimpleResponse.<MemberResponse>builder()
        .paging(Paging.create(page, size, data.size()))
        .data(data)
        .build();
  }

  @GetMapping(value = "/pick")
  public SimpleResponse<MemberResponse> memberOne() {

    List<MemberResponse> data = List.of(memberService.createMember());

    return SimpleResponse.<MemberResponse>builder().paging(Paging.single()).data(data).build();
  }
}
