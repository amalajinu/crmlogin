package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utility.ElementUtility;

public class BaseTest {
	 WebDriver driver;
	  @Parameters ({"browser"})
	  @BeforeMethod(alwaysRun = true)
	  public void beforeMethod(@Optional ("chrome") String browser) {
		  if(browser.equalsIgnoreCase("chrome"))
		  {
			  //WebDriverManager.chromedriver().setup();
			  driver=new ChromeDriver();
		  }
		  else if(browser.equalsIgnoreCase("edge"))
		  {
		     driver=new EdgeDriver();
		  }
		  else
		  {
			  System.out.println("Enter correct browser");
		  }
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		  driver.get(ElementUtility.getPropertyValue("baseUrl"));
	  }

}
