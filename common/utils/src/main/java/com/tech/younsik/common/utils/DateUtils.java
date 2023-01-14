package com.tech.younsik.common.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

@Slf4j
public class DateUtils {

  private static final LocalDateTime DEFAULT_DATE_TIME = LocalDateTime.of(2023, 1, 1, 0, 0, 0);

  public static LocalDate createRandomBirth(int minAge, int maxAge) {
    LocalDate current = LocalDate.now();
    long currentEpoch = current.toEpochDay();

    long maxEpoch = LocalDate.of(current.getYear() - minAge, 12, 31).toEpochDay();
    long minEpoch = LocalDate.of(current.getYear() - maxAge, 1, 1).toEpochDay();

    long revertEpoch = Math.max(Math.abs(maxEpoch), Math.abs(minEpoch));

    maxEpoch += revertEpoch;
    minEpoch += revertEpoch;

    if (maxEpoch > currentEpoch) {
      maxEpoch = currentEpoch;
    }

    if (minEpoch >= maxEpoch) {
      minEpoch = maxEpoch;
    }

    return LocalDate.ofEpochDay(RandomUtils.nextLong(minEpoch, maxEpoch) - revertEpoch);
  }

  public static LocalDateTime createRandomDateTimeBeforeCurrent() {
    LocalDateTime current = LocalDateTime.now();

    long currentEpoch = current.toEpochSecond(ZoneOffset.UTC);
    long beforeEpoch = DEFAULT_DATE_TIME.toEpochSecond(ZoneOffset.UTC);

    long between = RandomUtils.nextLong(beforeEpoch, currentEpoch);

    return LocalDateTime.ofInstant(
        Instant.ofEpochSecond(between), ZoneId.of(ZoneOffset.UTC.getId()));
  }

  public static LocalDateTime createRandomDateTimeAfterCurrent(int maxDays) {
    LocalDateTime current = LocalDateTime.now();

    long currentEpoch = current.toEpochSecond(ZoneOffset.UTC);

    int rand = RandomUtils.nextInt(0, maxDays);

    long afterEpoch = currentEpoch + (24L * 60L * 60L * rand);

    long between = RandomUtils.nextLong(currentEpoch, afterEpoch);

    return LocalDateTime.ofInstant(
        Instant.ofEpochSecond(between), ZoneId.of(ZoneOffset.UTC.getId()));
  }

  public static LocalDateTime createRandomDateTimeAfterTarget(LocalDateTime target) {
    LocalDateTime current = LocalDateTime.now();

    long currentEpoch = current.toEpochSecond(ZoneOffset.UTC);

    long targetEpoch = target.toEpochSecond(ZoneOffset.UTC);

    long rand = RandomUtils.nextLong(0, currentEpoch - targetEpoch);

    return LocalDateTime.ofInstant(
        Instant.ofEpochSecond(targetEpoch + rand), ZoneId.of(ZoneOffset.UTC.getId()));
  }
}
