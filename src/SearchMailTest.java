import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;

public class SearchMailTest extends TestSettings{

  @Test
  public void testGmail() throws Exception {
	  
//Login into gmail account
    driver.get(baseUrl + "/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1");
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys(email);
    driver.findElement(By.id("Passwd")).clear();
    driver.findElement(By.id("Passwd")).sendKeys(password);
    driver.findElement(By.id("signIn")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("gb_71"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }
//searching the letter by subject
    driver.findElement(By.id("gbqfq")).clear();
    driver.findElement(By.id("gbqfq")).sendKeys(subject);
    driver.findElement(By.id("gbqfb")).click();
    assertTrue(isElementPresent(By.id(":3u")));
    driver.findElement(By.cssSelector("span.gb_7.gbii")).click();
    driver.findElement(By.id("gb_71")).click();
  }
}