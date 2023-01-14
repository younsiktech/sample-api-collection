package com.tech.younsik.member.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech.younsik.member.domain.object.MemberObject;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponse {

  @JsonProperty(value = "id")
  private Long id;

  @JsonProperty(value = "name")
  private String name;

  @JsonProperty(value = "email")
  private String email;

  @JsonProperty(value = "address")
  private String address;

  @JsonProperty(value = "birth")
  private LocalDate birth;

  @Builder
  public MemberResponse(Long id, String name, String email, String address, LocalDate birth) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.address = address;
    this.birth = birth;
  }

  public static MemberResponse of(MemberObject object) {
    return MemberResponse.builder()
        .id(object.getId())
        .name(object.getName())
        .email(object.getEmail())
        .address(object.getAddress())
        .birth(object.getBirth())
        .build();
  }
}
