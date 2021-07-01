//Impersonate scripts are broken into several scripts.  Each script goes through each screen and validates variables on the screen.  There are no updates made in any of the 
//impersonate scripts.package sanityTest;

package sanityTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC40OwnerIMPERSONATEAccessManager extends testEnvironment{

	public static void main(String[] args) throws InterruptedException {
		
		getEnvironment();

	    //login to Portal as ABS Admin
	    driver.findElement(By.xpath("//div[2]/div")).click();
	    driver.findElement(By.xpath("//input")).sendKeys("absadmin1");
	    driver.findElement(By.xpath("//div[2]/input")).sendKeys("abc12345");
	    driver.findElement(By.xpath("//button")).click();
		
	    //Wait for page to load
	    Thread.sleep(3000);
	    
	    //Search for WCN
	    driver.findElement(By.xpath("//*[@id=\"access-manager-search\"]")).click();
	    driver.findElement(By.xpath("//*[@id=\"access-manager-search\"]")).sendKeys("016015");
	    driver.findElement(By.xpath("//*[@id=\"access-manager-search\"]")).sendKeys(Keys.ENTER);
	        
	    //click on IMPERSONATE
	    Thread.sleep(3000);
	    List<WebElement> test = driver.findElements(By.xpath("//*[contains(text(), ' Impersonate')]"));
	    test.get(0).click();	//tells it how many buttons to go down
	     
	    //wait for Reports to load in the left menu before continuing
	    WebDriverWait wait1 = new WebDriverWait(driver, 90);
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[6]/li/a")));
	    System.out.println("IMPERSONATE PAGE DISPLAYED, Validating ACCESS MANAGER");
	    
	    //click on Access Manager
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/a[6]/li/a")).click();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[1]/div/div/div[2]/div/a/h1"));
	    System.out.println("DISPLAY-Users--PASS");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div/a[1]/h1"));
	    System.out.println("DISPLAY-Project Groups--PASS");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div/a[2]/h1"));
	    System.out.println("DISPLAY-Projects--PASS");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[3]/div/div/div[2]/div/a[1]/h1"));
	    System.out.println("DISPLAY-Oversight Groups--PASS");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[3]/div/div/div[2]/div/a[2]/h1"));
	    System.out.println("DISPLAY-Oversight Projects--PASS");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[4]/div/div/div[2]/div/a[1]/h1"));
	    System.out.println("DISPLAY-Fleets--PASS");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[1]/div[4]/div/div/div[2]/div/a[2]/h1"));
	    System.out.println("DISPLAY-Vessels--PASS");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div/input"));
	    System.out.println("DISPLAY-Search--PASS");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[4]/div/div/div/div/div[2]/div[2]/div/div/div[1]/ol/li/div[1]/div/div[2]/div[1]/div[1]/span"));
	    System.out.println("DISPLAY-Users--PASS"); 
	    
	    
	    //validate Show only Active Users toggle
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[3]/div/div/label/span")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[3]/div/div/label/span")).click();
	    System.out.println("TOGGLE-Show only Active Users--PASS");
	    
	    
        //screen capture
	    Thread.sleep(3000);
		 new newScreenCapture().createNewCapture();
	    
	    System.out.println("IMPERSONATE-Access Manager--SANITY CHECK PASSED");
	    
	    //Log out
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/div/li[2]/a/div")).click();	    	

	    driver.close();
	}
}
