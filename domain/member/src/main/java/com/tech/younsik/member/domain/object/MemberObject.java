package com.tech.younsik.member.domain.object;

import com.tech.younsik.common.utils.AddressUtils;
import com.tech.younsik.common.utils.CalenderUtils;
import com.tech.younsik.common.utils.EmailUtils;
import com.tech.younsik.common.utils.MemberUtils;
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

  public static MemberObject create(int minAge, int maxAge) {
    return MemberObject.builder()
        .id(MemberUtils.createRandomId())
        .name(MemberUtils.createRandomKorName())
        .email(EmailUtils.createRandomEmail())
        .address(AddressUtils.createRandomKorAddress())
        .birth(CalenderUtils.createRandomBirth(minAge, maxAge))
        .build();
  }
}
