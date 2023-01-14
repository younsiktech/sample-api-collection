import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class CalenderTest {

  @Test
  void testLocalDate() {

    List<Integer> testYears = List.of(0, 1900, 1970, 2000, 2020, 2200);

    for (int year : testYears) {
      LocalDate testDate = LocalDate.of(year, 1, 1);

      log.info(testDate.format(DateTimeFormatter.ISO_DATE));

      long epochDay = LocalDate.of(year, 1, 1).toEpochDay();

      log.info("{}/1/1 => {} days", year, epochDay);

      testDate = LocalDate.ofEpochDay(epochDay);
      log.info("Reconvert => {}", testDate);

      Assertions.assertEquals(year, testDate.getYear());
    }
  }
}
