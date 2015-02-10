import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;

public class SendingMailTest extends TestSettings{

  @Test
  public void testGmailSendMailSelenium() throws Exception {
	  
//login gmail account
    driver.get(baseUrl + "/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1");
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys(email);
    driver.findElement(By.id("Passwd")).clear();
    driver.findElement(By.id("Passwd")).sendKeys(password);
    driver.findElement(By.id("signIn")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [clickAt | //div[2]/div/div/div/div[2]/div/div/div/div/div | ]]
//    for (int second = 0;; second++) {
//    	if (second >= 60) fail("timeout");
//    	try { if (isElementPresent(By.name("to"))) break; } catch (Exception e) {}
//    	Thread.sleep(1000);
//    }
//composing and sending letter
    driver.findElement(By.xpath("//div[text()=\"НАПИСАТЬ\"]")).click();
    driver.findElement(By.name("to")).clear();
    driver.findElement(By.name("to")).sendKeys(email);
    driver.findElement(By.name("subjectbox")).click();
    driver.findElement(By.name("subjectbox")).clear();
    driver.findElement(By.name("subjectbox")).sendKeys(subject);
    driver.findElement(By.cssSelector("div[aria-label='Тело письма']")).clear();
    driver.findElement(By.cssSelector("div[aria-label='Тело письма']")).sendKeys(text);
    driver.findElement(By.xpath("//div[4]/table/tbody/tr/td/div/div[2]")).click();
  }
}