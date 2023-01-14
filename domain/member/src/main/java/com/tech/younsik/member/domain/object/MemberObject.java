package com.tech.younsik.member.domain.object;

import com.tech.younsik.common.utils.CommonUtils;
import com.tech.younsik.common.utils.DateUtils;
import com.tech.younsik.common.utils.StringUtils;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberObject {

  private Long id;

  private String name;

  private String email;

  private String address;

  private LocalDate birth;

  @Builder
  public MemberObject(Long id, String name, String email, String address, LocalDate birth) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.address = address;
    this.birth = birth;
  }

  public static MemberObject create(int nameLength, int minAge, int maxAge) {
    return MemberObject.builder()
        .id(CommonUtils.createRandomId())
        .name(StringUtils.createRandomString(nameLength))
        .email(StringUtils.createRandomEmail())
        .address(StringUtils.createRandomKorAddress())
        .birth(DateUtils.createRandomBirth(minAge, maxAge))
        .build();
  }
}
