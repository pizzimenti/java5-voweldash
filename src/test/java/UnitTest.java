import org.junit.*;
import static org.junit.Assert.*;

public class UnitTest {

@Test
public void VowelsToDashes_test_t_st() {
  App testApp = new App();
  assertEquals("sn-ggl-", testApp.VowelsToDashes("snuggle"));
}

/*
@Test
public void giveChange_25cents_1quarter() {
  App testApp = new App();
  assertEquals("{Nickels=0, Dimes=0, Quarters=1, Pennies=0}", testApp.giveChange(25).toString());
}
*/

}
