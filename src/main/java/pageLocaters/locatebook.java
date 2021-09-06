package pageLocaters;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class locatebook {
	public WebDriver driver;
	By contactus=By.linkText("Contact Us");
	By name=By.cssSelector("input[placeholder=\"Name\"]");
	By email=By.cssSelector("input[placeholder=\"Email\"]");
	By feedback=By.cssSelector("textarea[placeholder=\"Feedback\"]");
	public locatebook(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement findbook() {
		return driver.findElement(contactus);
	}
	public WebElement name() {
		return driver.findElement(name);
	}
	public WebElement email() {
		return driver.findElement(email);
	}
	public WebElement feedback() {
		return driver.findElement(feedback);
	}
}
