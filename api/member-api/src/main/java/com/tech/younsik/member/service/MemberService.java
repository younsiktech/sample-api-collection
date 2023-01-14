package com.tech.younsik.member.service;

import com.tech.younsik.member.domain.object.MemberObject;
import com.tech.younsik.member.domain.response.MemberResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberService {

  @Value("${app.member.age.min:20}")
  private int minAge;

  @Value("${app.member.age.max:60}")
  private int maxAge;

  public MemberResponse createMember() {
    MemberObject object = MemberObject.create(minAge, maxAge);
    log.info("Object : {}", object.toString());
    return MemberResponse.of(object);
  }

  public List<MemberResponse> createMemberList(int size) {
    List<MemberObject> objectList = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      objectList.add(MemberObject.create(minAge, maxAge));
    }
    log.info("ObjectList : {}", objectList.toString());
    return objectList.stream().map(MemberResponse::of).toList();
  }
}
