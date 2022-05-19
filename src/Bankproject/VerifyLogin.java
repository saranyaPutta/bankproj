package Bankproject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class VerifyLogin {

public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.gecko.driver","D:\\selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.navigate().to("");

		Actions action=new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
	WebElement userId= driver.findElement(By.xpath("//input[@name='uid']"));
	userId.clear();
		userId.sendKeys(" mngr406025");
		
		WebElement pass=	driver.findElement(By.xpath("//input[@name='password']"));
		pass.clear();
        pass.sendKeys(" yzYgysy");
        
        Thread.sleep(10);
        
	 driver.findElement(By.name("btnLogin")).click();
	
	 String baseURL=driver.getCurrentUrl();
	
     System.out.println(baseURL);
     
     String actualTitle =  driver.getTitle();
    //it can be done with junit...
     //Assert.assertEquals("Condition true", actualTitle, expectedTitle);
     String expectedTitle = "GTPL Bank Manger HomePage";
	 if(actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("Title Matched");
		else
			System.out.println("Title didn't match");
		driver.close();
		driver.quit();
	 System.out.println( actualTitle );
	 
	 File Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     FileUtils.copyFile(Screenshot, new File("D:\\txt2.jpg"));
	}
	}

