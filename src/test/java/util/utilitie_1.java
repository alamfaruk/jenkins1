package util;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
    
public class utilitie_1 {
public static	WebDriver driver;
	String ud= System.getProperty("user.dir");

 

   
  @Parameters({"browser","website"})
  @BeforeClass
  public void beforeClass(String browser,String website) throws InterruptedException {
	  browser(browser,website);
  }

  @AfterClass
  public void afterClass() {
	   teardown();
  }
  

  public  void browser(String browsername, String url ) throws InterruptedException {
		
		
		
		if(browsername.equalsIgnoreCase("chrome")) {

			 WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				Thread.sleep(2000);
				driver.get(url);
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			
			  WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				driver.manage().window().maximize();
				Thread.sleep(2000);
				driver.get(url);
		}
		
		

}
  
  public  void screenshort(String foldername) throws IOException {
		 Date time=new Date();
			 
			 System.out.println(time);
			
			String newtime= time.toString().replace(" ","_").replace(":","_");
			
			File ss= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(ss,new File(ud+"\\Pictures\\"+foldername+"\\"+newtime+"home.jpg") );
			
			
		}
  public void teardown() {
	  driver.close();
  }
  public  void waitfortitle(String pagetitle) {
	    WebElement bests=driver.findElement(By.linkText("Best Sellers"));
	    WebDriverWait wait=new WebDriverWait(driver,Duration.ofHours(1));
	    wait.until(ExpectedConditions.titleContains(pagetitle));
	}
	public void implicitywait(WebDriver driver) {
		 WebDriverWait waits=new WebDriverWait(driver,Duration.ofSeconds(30));
	}

}
