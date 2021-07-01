//3/9/2020
//This script always uses WCN 068446 and replaces the account manager for this company.

package sanityTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;



public class TC31ReplaceOwnerAccountManager extends testEnvironment  {


	public static void main(String[] args) throws InterruptedException 	{
		
		Random ran = new Random();
		int nxt = ran.nextInt(1000);
		
		getEnvironment();
	
	    //login to Portal as ABS Admin
	    driver.findElement(By.xpath("//div[2]/div")).click();
	    driver.findElement(By.xpath("//input")).sendKeys("absadmin1");
	    driver.findElement(By.xpath("//div[2]/input")).sendKeys("abc12345");
	    driver.findElement(By.xpath("//button")).click();
		
	    //Wait for page to load
	    Thread.sleep(3000);
	    
	    //Search for Account Manager to replace
	    driver.findElement(By.xpath("//*[@id=\"access-manager-search\"]")).click();
	    driver.findElement(By.xpath("//*[@id=\"access-manager-search\"]")).sendKeys("068446");
	    driver.findElement(By.xpath("//*[@id=\"access-manager-search\"]")).sendKeys(Keys.ENTER);
	    
	    //Click on Company
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[3]/div/div/div/div/div/div/div[2]/div[2]/div/div/ol/li/div/div/div[1]/div[1]/div[1]/strong")).click();
	    
	    //Click on Replace Account Manager Button
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[4]/div[3]/div/div/div/button")).click();
	    
	    //Confirm New Account Manager Details screen has popped up
	    WebDriverWait wait1 = new WebDriverWait(driver, 20);
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[4]/div[3]/div/div/div/div[2]/div/div/div[1]/h4")));
	    System.out.println("New Account Manager Details screen has popped!");
		
		//Input New Account Manager details
	    driver.findElement(By.xpath("//*[@id=\"first-element\"]")).sendKeys("SanityNewAccountMgr3"+ nxt);
		driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[4]/div[3]/div/div/div/div[2]/div/div/div[2]/fragment[2]/div/input")).sendKeys("Gina");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[4]/div[3]/div/div/div/div[2]/div/div/div[2]/fragment[3]/div/input")).sendKeys("SanityNewAccountMgr");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[4]/div[3]/div/div/div/div[2]/div/div/div[2]/fragment[5]/div/input")).sendKeys("gvrana@eagle.org");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[4]/div[3]/div/div/div/div[2]/div/div/div[2]/fragment[6]/div/input")).sendKeys("281-299-0000");
	    driver.findElement(By.xpath("//*[@id=\"last-element\"]")).click();
	    System.out.println("New Account Manager Details have been input");
	    
	    
	    //SIT PASS or SIT FAIL
	    Thread.sleep(3000);	   
	    List<WebElement> userAdded = driver.findElements(By.xpath("//div[contains(text(), 'Action Successful')]"));
	    
        //screen capture
	    Thread.sleep(6000);
		 new newScreenCapture().createNewCapture();
	    
	    if (userAdded.size() > 0) {
	    	System.out.println("SANITY TEST PASS"); 
	    } else {
	    	System.out.println("SANITY TEST FAIL");
	    }
	    //close System Response message
	    driver.findElement(By.xpath("//button[contains(.,\'✖\')]")).click();
	    
	    //Log out
	    //Thread.sleep(2000);
	    //driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/div/li[2]/a/div")).click();	    	

	    driver.close();
	        
	}

}

	

