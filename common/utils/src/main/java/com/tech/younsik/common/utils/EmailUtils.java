package com.tech.younsik.common.utils;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailUtils {

  public static String createRandomEmail() {
    String email = UUID.randomUUID().toString().replaceAll("-", "");
    return email + "@test.com";
  }
}
