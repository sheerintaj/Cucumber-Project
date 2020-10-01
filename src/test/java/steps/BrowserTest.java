package steps;

import java.nio.file.Paths;

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
public void user_perfroms_actions() {
  
}

@Then("validate the home page")
public void validate_the_home_page() {
    
}

}
