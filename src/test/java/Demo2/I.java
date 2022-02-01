package Demo2;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class I
{
	 
	 WebDriver driver;
	 Set<Cookie>cookie;
	 

		@BeforeSuite
		public void openbrowser() throws  InterruptedException
		{
		 
		System.out.println("open browser");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahul Yadav\\Downloads\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		Thread.sleep(3000);
		}

		@BeforeTest
		public void getURL()
		{
			System.out.println("get URL");
			driver.get("https://www.mercurytravels.co.in/home/index");
		}

		@BeforeClass
		public void URLMaximizie() throws  InterruptedException
		{
			System.out.println(" URLMaximizie");
			driver.manage().window().maximize();
			Thread.sleep(3000);
		}


		@BeforeMethod 
		public void getcookies() throws  InterruptedException

		{
			cookie=driver.manage().getCookies();
			System.out.println("get cookies");
			Thread.sleep(3000);
		}

         @Test(dataProvider= "logindata")
     	public void login1(String email, String passward) throws InterruptedException
     	{
        	 WebElement
     		//System.out.println("a");
             //Thread.sleep(4000);
        	 
        	 Customer_login=driver.findElement(By.xpath("(//a[@class=\"dropdown-toggle\"])[2]"));
        	 
             
             Actions s=new Actions(driver);
             s.moveToElement(Customer_login).build().perform();
             Thread.sleep(2000);
           
             
             driver.findElement(By.linkText("User Login")).click();
             Thread.sleep(2000);
             
             driver.findElement(By.id("sign_user_email")).sendKeys("tandalemahesh0144@gmail.com");
             Thread.sleep(2000);
            
             driver.findElement(By.id("sign_user_password")).sendKeys("Amu@4321");
             Thread.sleep(2000);
             
             
             driver.findElement(By.xpath("(//button[@class=\"btn btn-lg btn-primary modal-btn ajax-submit\"])[1]")).click();
             Thread.sleep(3000);
             
            s.moveToElement(driver.findElement(By.xpath("(//span[@class=\"caret\"])[2]"))).build().perform();
            Thread.sleep(2000);
            
            driver.findElement(By.xpath("(//span[@class=\"glyphicon glyphicon-off\"])[2]")).click();
             
     	}
         
       
         
         @DataProvider(name= "logindata")
     	public Object[][] handlingdata()
     	{
     		return new Object[][]
     				{
     		    new Object[] {"amolyadav006@gmail.com", "Amol@1234"},
     			  
     			new Object[] {"tandalemahesh0144@gmail.com", "Amu@4321"},
     			 
     			new Object[] {"amolyadav006@gmail.com", "Amol@4321"}
     				};
     	}

         @AfterMethod
     	public void getscreenshot() throws IOException
     	{
     		System.out.println("get ss");
     		
     		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     		FileUtils.copyFileToDirectory(src, new File("C:\\Users\\Rahul Yadav\\eclipse-workspace\\Maven-Project\\screenshot"));
     	}
     	
     	@AfterClass
     	public void deleteallcookies() throws InterruptedException
     	{
     		
     		System.out.println("dlt cookies");
     	}


     	@AfterTest
     	public void closedbconnection()
     	{
     		System.out.println("close db connection");
     	}



     	@AfterSuite
     	public void closebrowser()
     	{
     		System.out.println("close browser");
     		driver.close();
     	}

     	}

         
