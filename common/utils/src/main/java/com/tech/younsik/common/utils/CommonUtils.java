package com.tech.younsik.common.utils;

import java.time.Instant;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

@Slf4j
public class CommonUtils {
  public static long createRandomId() {
    return Long.parseLong(
        String.valueOf(Instant.now().getEpochSecond())
            + String.valueOf(Instant.now().getNano()));
  }
}
