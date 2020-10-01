package steps;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.nio.file.Paths;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.*;
import io.cucumber.java.en.*;


public class BrowserTest {
	private WebDriver driver;  
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				Paths.get("libs/chromedriver.exe").toString());
		if (driver == null) {
			driver = new ChromeDriver();
		}
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
	    
@Given("launch the application")
public void launch_the_application() {
	  driver.navigate().to("http://www.google.com/");
}

@When("user perfroms actions")
public void user_perfroms_actions() throws AWTException, InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("report portal");
	driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")).click();
	
  
}


@Then("validate the home page")
public void validate_the_home_page() throws InterruptedException {
	Thread.sleep(5000); 
	String actual=driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/a/div/cite")).getText();
	System.out.println("Text: " + actual);
	Assert.assertEquals("reportportal.io", actual);
    
}

}
