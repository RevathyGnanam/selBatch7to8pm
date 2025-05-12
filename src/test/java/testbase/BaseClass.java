package testbase;

import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	static public WebDriver driver;
	public Logger logger;
	public Properties p;
	

	@BeforeClass(groups= {"Regression","Master","Sanity"})
	@Parameters({"browser"})
	public void setUp(String br) throws Exception {
		
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		
		logger = LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase()) {
		case "chrome": driver= new ChromeDriver(); break;
		case "edge": driver= new EdgeDriver(); break;
		case "firefox": driver= new FirefoxDriver(); break;
		default: System.out.println("No browser launched"); return;
		}

		
		driver.manage().deleteAllCookies();
		implicitwaits(10);
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();

	}

	@AfterClass(groups= {"Regression","Master","Sanity"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randomAlphabetic() {
		return RandomStringUtils.randomAlphabetic(5);
	}
	public String randomAlphaNumeric() {
		return RandomStringUtils.randomAlphabetic(5)+RandomStringUtils.randomNumeric(3);
	}
	
	public void implicitwaits(int waitTime) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
	}
	
	public String captureScreen(String tname) {
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 
		 TakesScreenshot screenshot =  (TakesScreenshot)driver;
		 File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
		 
		 String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname +"_"+timeStamp;
		 File targetFile  = new File(targetFilePath);
		 srcfile.renameTo(targetFile);
		 
		 return targetFilePath;
		 
	}

}
