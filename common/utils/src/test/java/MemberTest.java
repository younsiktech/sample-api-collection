import com.tech.younsik.common.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class MemberTest {

  @Test
  void idTest() {
    long id = CommonUtils.createRandomId();
    log.info("createId : {}", id);
    log.info("Long Max : {}", Long.MAX_VALUE);
  }
}
