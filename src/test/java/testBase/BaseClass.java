package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties property;

	@BeforeClass(groups = { "Master" })
	@Parameters({ "os", "browser" })
	public void setUp(String os, String br) throws InterruptedException, IOException {

		logger = LogManager.getLogger(this.getClass());

		FileReader file = new FileReader("./src//test//resources//config.properties");
		property = new Properties();
		property.load(file);

		if (property.getProperty("execution_env").equalsIgnoreCase("remote")) {

			DesiredCapabilities capability = new DesiredCapabilities();

			switch (os.toLowerCase()) {
			case "windows":
				capability.setPlatform(Platform.WIN11);
				break;
			case "mac":
				capability.setPlatform(Platform.MAC);
				break;
			case "linux":
				capability.setPlatform(Platform.LINUX);
				break;
			default:
				System.out.println("No matching OS");
				return;
			}

			switch (br.toLowerCase()) {
			case "chrome":
				capability.setBrowserName("chrome");
				break;
			case "edge":
				capability.setBrowserName("MicrosoftEdge");
				break;
			case "firefox":
				capability.setBrowserName("firefox");
				break;
			case "opera":
				capability.setBrowserName("opera");
				break;
			default:
				System.out.println("No mactching Browser");
				return;
			}

			driver = new RemoteWebDriver(new URL("http://192.168.1.5:4444/wd/hub"), capability);
		}

		if (property.getProperty("execution_env").equalsIgnoreCase("local")) {

			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("Invalid browser...");
				return;
			}

		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get(property.getProperty("appURL"));
		Thread.sleep(2000);

	}

	@AfterClass(groups = { "Master" })
	public void tearDown() {
		driver.quit();
	}

	public String randomString() {
		String randomGeneratedString = RandomStringUtils.randomAlphabetic(5);
		return randomGeneratedString;
	}

	public String randomNumber() {
		String randomGeneratedNumber = RandomStringUtils.randomNumeric(10);
		return randomGeneratedNumber;
	}

	public String randomAlphaNumeric() {
		String randomGeneratedString = RandomStringUtils.randomAlphabetic(3);
		String randomGeneratedNumber = RandomStringUtils.randomNumeric(3);

		return ("@" + randomGeneratedString + "#" + randomGeneratedNumber + "$");
	}

	public String captureScreen(String testName) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + testName + "_" + timeStamp
				+ ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}

}
