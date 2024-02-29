package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import util.utilitie_1;

public class NewTest  extends utilitie_1 {
  @Test
  public void t1() {
	WebElement emailfield=  driver.findElement(By.id("email"));
	emailfield.click();
	  
  }
  @Test
  public void t2() {
	  
  }
  @Test
  public void t3() {
	  
  }
}
