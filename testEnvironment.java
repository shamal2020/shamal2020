//This method establishes the driver and the url to be used in all scripts.  Update the test environment from this scripts.  All other classes call this method.

package sanityTest;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class testEnvironment {

	public static WebDriver driver;
	public static void getEnvironment() {
		

		//load driver
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gvrana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
			
		//open URL and maximize screen
		//driver.get ("https://fredint.eagle.org/portal/#/Login");
		driver.get ("https://portaluat.eagle.org/portal/#/Login");
		//driver.get ("https://freddata.eagle.org/portal/#/Login");
		//driver.get ("https://fredqa.eagle.org/portal/#/Login");
		driver.manage().window().maximize();
		
	}
	
	}

	

