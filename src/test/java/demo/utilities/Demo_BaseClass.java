package demo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Demo_BaseClass {
	public static WebDriver driver;

	@BeforeMethod
	public void Steup() {
		try {
			FileInputStream file = new FileInputStream(
					"C:\\Eclipse New\\NewWorkSpace\\Demo.appLitool\\src\\test\\java\\demo\\utilities\\global.properties");
			Properties prop = new Properties();
			try {
				prop.load(file);
				String url = prop.getProperty("baseurl");
				String browser = prop.getProperty("browser");

				if (browser.equalsIgnoreCase("chrome")) {
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--start-maximized");
					driver = new ChromeDriver(options);
					driver.get(url);
				} else if (browser.equalsIgnoreCase("firefox")) {
					FirefoxOptions options = new FirefoxOptions();
					options.addArguments("--start-maximized");
					driver = new FirefoxDriver(options);
					driver.get(url);
				} else if (browser.equalsIgnoreCase("edge")) {
					EdgeOptions options = new EdgeOptions();
					options.addArguments("--start-maximized");
					driver = new EdgeDriver(options);
					driver.get(url);
				}
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterMethod(alwaysRun = true)
	public void teardown() {
		driver.quit();
	}


}
