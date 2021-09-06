package pageLocaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class booksearching {
	public WebDriver driver;
	By searchbox=By.id("searchBox");
	public WebElement searchbox() {
		return driver.findElement(searchbox);
	}
	public booksearching(WebDriver driver) {
		this.driver=driver;
	}
}
