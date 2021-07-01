package sanityTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TC34RegressionOwnerIMPERSONATELandingPage extends testEnvironment  {

	public static void main(String[] args) throws InterruptedException {
		
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
	    driver.findElement(By.xpath("//*[@id=\"access-manager-search\"]")).sendKeys("016015");
	    driver.findElement(By.xpath("//*[@id=\"access-manager-search\"]")).sendKeys(Keys.ENTER);
	        
	    //click on IMPERSONATE
	    Thread.sleep(3000);
	    List<WebElement> test = driver.findElements(By.xpath("//*[contains(text(), ' Impersonate')]"));
	    test.get(0).click();	//tells it how many buttons to go down
	    System.out.println("clicked on IMPERSONATE Button");
	     
	    //wait for Reports to load in the left menu before continuing
	    WebDriverWait wait1 = new WebDriverWait(driver, 90);
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[6]/li/a")));
	    
	    //Validate Landing Page
	    System.out.println("I M P E R S O N A T E   P A G E   D I S P L A Y E D ,   V A L I D A T I N G   L A N D I N G   P A G E");
	    
        //screen capture
	    Thread.sleep(6000);
		 new newScreenCapture().createNewCapture();
	    
	  //My Eagle Login Present
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/li[2]/div"));
	    System.out.println("My Eagle Logo--PASS");
	    
	    //Left Menu
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/a[1]/li/a"));
	    System.out.println("\nDISPLAY-Left Menu-Home--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/a[2]/li/a"));
	    System.out.println("DISPLAY-Left Menu-Fleet Overview--PASS");	    
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/a[3]/li/a"));
	    System.out.println("DISPLAY-Left Menu-Company Dashboard--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/a[4]/li/a"));
	    System.out.println("DISPLAY-Left Menu-Finance--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/a[5]/li/a"));
	    System.out.println("DISPLAY-Left Menu-Plan Review--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/a[6]/li/a"));
	    System.out.println("DISPLAY-Left Menu-Access Manager--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/a[7]/li/a"));
	    System.out.println("DISPLAY-Left Menu-Reports--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[1]/div/ul/li[2]/ul/li/a"));
	    System.out.println("DISPLAY-Left Menu-Quick Links--PASS");

	    //Map
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div/div[2]/div/div[1]/div/div/div/div/div[1]/div[3]"));
	    System.out.println("\nDISPLAY-Map--PASS");

	    //Donut
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//*[@id=\"doughnutChart\"]"));
	    System.out.println("\nDISPLAY-Donut--PASS");
	   
	    //Your Vessels
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div/div[1]/div/ul/li[1]/span"));
	    System.out.println("DISPLAY-Vessels with Overdue Surveys--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div/div[1]/div/ul/li[2]/span"));
	    System.out.println("DISPLAY-Vessels with Surveys Overdue Within 180 Days--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div/div[1]/div/ul/li[3]/span"));
	    System.out.println("DISPLAY-Vessels with Overdue Findings--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div/div[1]/div/ul/li[4]/span"));	    
	    System.out.println("DISPLAY-Vessels with Findings Overdue Within 180 Days--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div/div[1]/div/ul/li[5]/span"));
	    System.out.println("DISPLAY-Vessels with Certificates expiring in 180 days--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div/div[1]/div/ul/li[6]/span"));
	    System.out.println("DISPLAY-Vessels with Submitted Orders--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[1]/div/div[1]/div/ul/li[7]/span"));
	    System.out.println("DISPLAY-Vessels with Attendance In Progress--PASS");
	    
	    //Plan Review
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div/div[2]/div/div[1]/h1"));
	    System.out.println("\nDISPLAY-Plan Review Drawings-- Not Submitted--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div/div[2]/div/div[2]/h1"));
	    System.out.println("DISPLAY-Plan Review Drawings--Customer Action--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/h1"));
	    System.out.println("DISPLAY-Plan Review Comments-- Technical--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/h1"));
	    System.out.println("DISPLAY-Plan Review Comments-- Survey--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[3]/h1"));
	    System.out.println("DISPLAY-Plan Review Comments-- Customer Action--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div[1]/div[2]/div[3]/div/div/div[2]/div/div/h1"));
	    System.out.println("DISPLAY-Plan Review Projects--Number of Vessels--PASS");
	    
	    //Company Status
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/h1"));
	    System.out.println("\nDISPLAY-Company Status Survey/Audits--Overdue--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/h1"));
	    System.out.println("DISPLAY-Company Status Survey/Audits--Due--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div[2]/div[3]/div/div/div[2]/div/div[1]/h1"));
	    System.out.println("DISPLAY-Company Status Findings--Overdue--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div[2]/div[3]/div/div/div[2]/div/div[2]/h1"));
	    System.out.println("DISPLAY-Company Status Findings--Due--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div[2]/div[4]/div/div/div[2]/div/div/h1"));
	    System.out.println("DISPLAY-Company Status Certificates--Expiring within 180 Days--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[1]/div[2]/div[5]/div/div/div[2]/div/div/h1"));
	    System.out.println("DISPLAY-Company Status Attendance--In Progress--PASS");
	        
	    //Orders & Attendances
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div/div/div/div[1]/h3"));
	    System.out.println("\nDISPLAY-Orders & Attendances Active Orders--PASS");
	    
	    //Rules and Calculations
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[3]/div/div/div[2]/div[1]"));
	    System.out.println("\nDISPLAY-Web Calc Machinery--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[3]/div/div/div[2]/div[2]"));
	    System.out.println("DISPLAY-Web Calc Structures--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[3]/div/div/div[2]/div[3]"));
	    System.out.println("DISPLAY-Rules Manager--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[3]/div/div/div[2]/div[4]"));
	    System.out.println("DISPLAY-Rules Download--PASS");
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[3]/div/div/div[2]/div[5]"));
	    System.out.println("DISPLAY-Rules Archive--PASS");

	    //Testing View Orders button works
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div[2]/div/div/div/div[2]/div/div/div/div[1]/div/div[3]/button")).click();

	    //confirm Orders Page displays
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/main/div/div[2]/div/div/h1"));
	    System.out.println("Clicking on Order Details button takes you to Order Details screen--PASS");
	    
	    //Landing page verification complete
	    System.out.println("\nL A N D I N G   P A G E----------------------------PASS");
	    
	    //Exit IMPERSONATE
	    driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/li[3]/div/button")).click();
	    
	    //Log out
	    //Thread.sleep(2000);
	    //driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div[2]/nav/div/ul/div/div/li[2]/a/div")).click();	    	

	    driver.close();
  		

	}
}
