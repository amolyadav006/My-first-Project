package Demo2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Action 
{
	

	public static  void  main(String[] args)  throws IOException, InterruptedException
	{
		System.setProperty("webdriver.gecko.driver","E:\\driver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://demoqa.com/buttons");
		Thread.sleep(2000);
		
		Actions s=new Actions(driver);
		WebElement  click=driver.findElement(By.id("doubleClickBtn"));
		s.doubleClick(click).build().perform();
		
	String text=	driver.findElement(By.id("doubleClickBtn")).getText();
	System.out.println(text);
	Thread.sleep(2000);
	
	WebElement right=driver.findElement(By.id("rightClickBtn"));
	s.contextClick(right).build().perform();
	String text1=driver.findElement(By.id("rightClickBtn")).getText();
	System.out.println(text1);
	
	WebElement c=driver.findElement(By.id("27O7i"));
	s.click(c).build().perform();
	String text2=driver.findElement(By.id("27O7i")).getText();
	System.out.println(text2);
		driver.close();
		
	}
}

