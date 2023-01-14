package com.tech.younsik.common.utils;

import java.time.LocalDate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

@Slf4j
public class CalenderUtils {

  public static LocalDate createRandomBirth(int minAge, int maxAge) {
    LocalDate current = LocalDate.now();
    long currentEpoch = current.toEpochDay();

    long maxEpoch = LocalDate.of(current.getYear() - minAge, 12, 31).toEpochDay();
    long minEpoch = LocalDate.of(current.getYear() - maxAge, 1, 1).toEpochDay();


    long revertEpoch = Math.max(Math.abs(maxEpoch), Math.abs(minEpoch));

    log.info("MaxEpoch: {}", maxEpoch);
    log.info("MinEpoch: {}", minEpoch);
    log.info("revertEpoch: {}", revertEpoch);


    maxEpoch += revertEpoch;
    minEpoch += revertEpoch;

    if (maxEpoch > currentEpoch) {
      maxEpoch = currentEpoch;
    }

    if (minEpoch >= maxEpoch) {
      minEpoch = maxEpoch;
    }

    return LocalDate.ofEpochDay(RandomUtils.nextLong(minEpoch, maxEpoch)-revertEpoch);
  }
}
