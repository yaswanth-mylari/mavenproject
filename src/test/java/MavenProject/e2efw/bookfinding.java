package MavenProject.e2efw;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pageLocaters.locatebook;
import resources.base;

public class bookfinding extends base{
	public static Logger log=LogManager.getLogger(base.class.getName());
	@Test//(dependsOnMethods= {"contactus_details"})
	public void click_on_book() throws IOException, InterruptedException {
		driver=initializeDriver();
		driver.get(p.getProperty("resulturl"));
		//Thread.sleep(3000);
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		locatebook lb=new locatebook(driver);
		lb.findbook().click();
		System.out.println(lb.findbook().getText());
		log.info("contact us clicked");	
		driver.quit();
	}
	@Test
	public void contactus_details() throws IOException, InterruptedException {
		driver=initializeDriver();
		driver.get(p.getProperty("contacturl"));
		locatebook lb=new locatebook(driver);
		//System.out.println("it id"+lb.name().getText());
		excelcode ec=new excelcode();
		ArrayList<String> lis = excelcode.getdata("Fname","testing","Testdata","C:\\xeldriven.xlsx");
		lb.name().sendKeys(lis.get(1));
		lb.email().sendKeys(lis.get(2));
		lb.feedback().sendKeys(lis.get(3));
		log.info("entered details");
		Thread.sleep(3000);
		driver.quit();
		}
}
