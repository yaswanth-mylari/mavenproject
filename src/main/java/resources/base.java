package resources;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public static WebDriver driver=null;
	public static Properties p;
	public static WebDriver initializeDriver() throws IOException {
		// TODO Auto-generated method stub
		p=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\yaswa\\eclipse-workspace\\e2efw\\src\\main\\java\\resources\\data.properties");
		p.load(fis);
		
		String browserName=p.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.edge.driver", ".\\drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		return driver;
		
	}
	public void getScreenshot(String res) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".//Screenshots//"+res+"screenshot.png"));
	}

}
