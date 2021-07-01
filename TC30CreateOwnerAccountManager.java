//3/9/2020
//This script selects the first available company that has a CREATE ACCOUNT MANAGER button.  

package sanityTest;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TC30CreateOwnerAccountManager extends testEnvironment {

	public static void main(String[] args) throws InterruptedException {
		
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
	        
	    //go to a Company with Create Account Manager button
	    List<WebElement> test = driver.findElements(By.xpath("//*[contains(text(), 'Create Account Manager')]"));
	    test.get(0).click();	//tells it how many buttons to go down
	    System.out.println("clicked on Create Account Manager Button");
	    
	    
	    //Wait for page to load
	    Thread.sleep(3000);
	
	    //Input Account Manager data
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[1]/div/fragment[1]/div/input")).sendKeys("SanityAddAcctMgr"+ nxt);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[1]/div/fragment[2]/div/input")).sendKeys("Gina");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[1]/div/fragment[3]/div/input")).sendKeys("SeleniumAutomation");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[2]/div/fragment[1]/div/input")).sendKeys("gvrana@eagle.org");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[2]/div/fragment[2]/div/input")).sendKeys("281-299-0000");
	    System.out.println("Added Account Manager data");
	    
	    //Select Company Type
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[3]/div/fragment/div/input")).click();
	    Thread.sleep(1000);	    
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[3]/div/fragment/div/ul/li[2]/span")).click();
	    System.out.println("Company Type selected");
	    
	    //Select Permissions
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div[3]/div/div/label/span")).click();
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div/div/div[2]/div/div/div/div[4]/div/div/label/span")).click();
	    System.out.println("Plan Review and Finance Permissions added");
	    
	    //Select Access Profile
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div/div[1]/div[2]/fragment/div/input")).click();
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div/div[1]/div[2]/fragment/div/ul/li[2]/span")).click();
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div[2]/div[5]/button")).click();
	    System.out.println("Access Profile selected and info submitted");

	    
	    //SIT PASS or SIT FAIL
	    Thread.sleep(2000);	   
	    List<WebElement> userAdded = driver.findElements(By.xpath("//div[contains(text(), 'Action Successful')]"));
	    
	    if (userAdded.size() > 0) {
	    	System.out.println("SANITY TEST PASS"); 
	    } else {
	    	System.out.println("SANITY TEST FAIL");
	    }
	    
        //screen capture
	    Thread.sleep(6000);
		 new newScreenCapture().createNewCapture();
	    
	    //close System Response message
	    driver.findElement(By.xpath("//button[contains(.,\'✖\')]")).click();
	    
	    //Log out
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/div/li[2]/a/div")).click();	    	

	    driver.close();

	}
}
