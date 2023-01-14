package com.tech.younsik.common.utils;

import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

@Slf4j
public class StringUtils {

  private static final char UNICODE_KOREAN_START = 0xAC00;
  private static final int UNICODE_KOREAN_RANGE = 11172;

  private static final List<String> areaList =
      List.of(
          "서울특별시", "부산광역시", "인천광역시", "대구광역시", "광주광역시", "대전광역시", "울산광역시", "세종특별자치시", "경기도", "강원도",
          "충청북도", "충청남도", "전라북도", "전라남도", "경상북도", "경상남도", "제주특별자치도");

  public static String createRandomKorAddress() {
    return areaList.get(RandomUtils.nextInt(0, areaList.size() - 1));
  }

  public static String createRandomEmail() {
    String email = UUID.randomUUID().toString().replaceAll("-", "");
    return email + "@younsiktech.com";
  }

  public static String createRandomString(int size) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < size; i++) {
      char ch = (char) (RandomUtils.nextInt(0, UNICODE_KOREAN_RANGE) + UNICODE_KOREAN_START);
      stringBuilder.append(ch);
    }
    return stringBuilder.toString();
  }
}
