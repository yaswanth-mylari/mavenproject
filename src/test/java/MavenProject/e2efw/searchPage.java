package MavenProject.e2efw;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageLocaters.booksearching;
import resources.base;

public class searchPage extends base{
	public static Logger log=LogManager.getLogger(base.class.getName());
	@Test
	public void pageSearching() throws IOException {
		driver=initializeDriver();
		driver.get(p.getProperty("searchurl"));
		booksearching bs=new booksearching(driver);
		bs.searchbox().sendKeys("india");
		bs.searchbox().sendKeys(Keys.ENTER);
		log.info("Search done");
		driver.quit();
	}

}
