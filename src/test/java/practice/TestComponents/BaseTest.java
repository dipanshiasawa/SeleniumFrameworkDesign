package practice.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	
	public void initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\practice\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			//invoke gecko driver
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			//invoke edge driver
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

}
