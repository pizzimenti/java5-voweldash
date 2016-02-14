import org.junit.*;
import static org.junit.Assert.*;

public class UnitTest {

  @Test
  public void VowelsToDashes_test_t_st() {
    App testApp = new App();
    assertEquals("sn-ggl-", testApp.VowelsToDashes("snuggle"));
  }

  @Test
  public void Hint_t_st_ng_testing() {
    App testApp = new App();
    assertEquals("snuggl-", testApp.Hint("sn-ggl-"));
  }
}
