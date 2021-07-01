//This script impersonates for WCN 016015 then goes to the first survey and clicks on the survey requirements button.  If an error message does not pop, it is a pass.

package sanityTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC43OwnerIMPERSONATESurveyRequirements extends testEnvironment{

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
	    System.out.println("IMPERSONATE PAGE DISPLAYED, Validating Survey Requirements");
	    
	    //Validate Survey Requirements
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/a[2]/li/a")).click();
	    Thread.sleep(10000);
	    System.out.println("IMPERSONATE PAGE DISPLAYED, validating Survey Requirements download works");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[5]/div/div/div/div[2]/div/div/div")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/li[1]/div/div/ul/a[7]/li/a")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[3]/div[1]/div/div[2]/div/div/div/div/div[1]/div/div/div[3]/button")).click();
    	System.out.println("Selected Survey Requirement to download");
	    
	    //SIT PASS or SIT FAIL
	    Thread.sleep(6000);	   
	    List<WebElement> docdownloaded = driver.findElements(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div[2]/div[3]/div/div/div/div[1]/div[3]/div[1]/div/div[2]/div/div/div/div/div[1]/div/div/div[3]"));

	    if (docdownloaded.size() > 0) {
	    	System.out.println("ACTION NOT SUCCESSFUL SIT-FAIL"); 
	    } else {
	    	System.out.println("ACTION SUCCESSFUL - SIT PASS");
	    }
	    
        //screen capture
	    Thread.sleep(6000);
		 new newScreenCapture().createNewCapture();

        driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div[2]/div[2]/div/div/div")).click();
        
	    //Log out
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/div/li[2]/a/div")).click();	    	

	    Thread.sleep(3000);
	    driver.close();
 	    

	}

}
