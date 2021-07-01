//This screen assumes that there will be a SAC work type and there are surveys preselected.

package sanityTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TCPlaceOrder extends testEnvironment {

	public static void main(String[] args) throws InterruptedException  {

		
		getEnvironment();
		
				
		//login to Portal
	    driver.findElement(By.xpath("//div[2]/div")).click();
	    driver.findElement(By.xpath("//input")).sendKeys("transocean");		//OWNER  
	    driver.findElement(By.xpath("//div[2]/input")).sendKeys("abc12345");
	    driver.findElement(By.xpath("//button")).click();
	    Thread.sleep(3000);
	    
	    //wait for Reports to load in the left menu before continuing
	    WebDriverWait wait1 = new WebDriverWait(driver, 60);
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[6]/li/a")));
	    
	    //refresh to close ChatBot window
	    driver.navigate().refresh();		//refreshes the page so that Chatbot will close
	    	    
	    //click on Fleet Overview and select Vessel
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/a[2]/li/a")).click();	//click on Fleet Overview
	    Thread.sleep(15000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div[2]/div[5]/div/div/div/div[1]/div/div/div/div")).click();    //click on 1st vessel

	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div/div/div/div/div[2]/div/div/div/div/div/div/div[2]/button")).click();    //click on Place Order
	    
	    //complete place order
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[3]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div[1]/input")).click();	//click on WorkType
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[3]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div[1]/ul/li[2]/span")).click();  //Select first
	    
	    //Dates of Survey
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[3]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[1]/div[2]/div/div[1]/div/div[1]/div/input")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[3]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[1]/div[2]/div/div[1]/div/div[1]/div/input")).sendKeys(Keys.ENTER);    //pick current date
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[3]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div[1]/div/input")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[3]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[1]/div[2]/div/div[2]/div/div[1]/div/input")).sendKeys(Keys.ENTER);    //pick current date
		
		//Place of Survey
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[3]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/div[1]/input")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[3]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/div[1]/ul/li[183]/span")).click();   //United States
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[3]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/div[2]/input")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[3]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/div[2]/ul/li[184]/span")).click();  //Houston
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[3]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[2]/div[1]/div/div[3]/input")).sendKeys("test");  //location description
	    
	    Thread.sleep(2000);
	    WebElement radio1 = driver.findElement(By.xpath("//label[contains(text(),'Same as requester')]"));
	    radio1.click();    //click on Same as requester
	    
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[3]/div[2]/div[6]/div/div/button[2]")).click();     //Submit
	    
	    //SIT PASS or SIT FAIL
	    Thread.sleep(2000);	   
	    List<WebElement> orderCreated = driver.findElements(By.xpath("//div[contains(text(), 'Save Successful')]"));
	    
	    if (orderCreated.size() > 0) {
	    	System.out.println("ORDER CREATED--SIT PASS"); 
	    } else {
	    	System.out.println("ORDER NOT CREATED--SIT FAIL");
	    }
	    
	    
        //screen capture
	    Thread.sleep(6000);
		 new newScreenCapture().createNewCapture();
        
        //close System Response message
	    driver.findElement(By.xpath("//button[contains(.,\'✖\')]")).click(); 
	    
	    driver.close();
        
	}

}
