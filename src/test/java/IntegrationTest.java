import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();


  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Enter any phrase to have its vowels obfuscated:");
  }

  @Test
  public void VowelstoDashes_putVowels_getDashes() {
    goTo("http://localhost:4567");
    fill("#textInput").with("Believe you can and you're halfway there. Theodore Roosevelt");
    submit(".btn");
    assertThat(pageSource()).contains("B-l--v- y-- c-n -nd y--'r- h-lfw-y th-r-. Th--d-r- R--s-v-lt");
  }

  /*
  @Test
  public void negativeNumber() {
    goTo("http://localhost:4567");
    fill("#userChange").with("-87");
    submit(".btn");
    assertThat(pageSource()).contains("Please enter a positive value");
  }
*/

}
