package Demo2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class N
{

    WebDriver driver;

    @BeforeSuite
	public void openbrowser1()
	{	
	System.out.println("open browser");
	System.setProperty("webdriver.gecko.driver", "E:\\driver\\geckodriver.exe");
	driver=new FirefoxDriver();
	}
    
	@BeforeSuite
	public void openbrowser()
	{	
	System.out.println("open browser");
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahul Yadav\\Downloads\\chromedriver\\chromedriver.exe");
	driver=new ChromeDriver();
	}
	

	

	@BeforeTest
	public void getURL()
	{
		//htmlReporter =new ExtentHtmlReporter("extent.html");
		//extent =new ExtentReports();
	//	extent.attachReporter(htmlReporter);
	//	test=extent.createTest("Simple", "login");
		
		System.out.println("get URL");
		driver.get("https://www.mercurytravels.co.in/home/index");
	}
	
	@BeforeClass
	public void URLMaximizie()
	{
		System.out.println("maximize url");
		driver.manage().window().maximize();
	}


	@BeforeMethod
	public void getcookies()
	{
		System.out.println("get cookies");
	}
	

    @Test
   
	public void login1() throws InterruptedException
	{
   	 WebElement
		//System.out.println("");
      //  Thread.sleep(4000);
   	 
   	 Customer_login=driver.findElement(By.xpath("(//a[@class=\"dropdown-toggle\"])[2]"));
   	 
        
        Actions s=new Actions(driver);
        s.moveToElement(Customer_login).build().perform();
        Thread.sleep(2000);
      
        
        driver.findElement(By.linkText("User Login")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.id("sign_user_email")).sendKeys("amolyadav006@gmail.com");
        Thread.sleep(2000);
       
        driver.findElement(By.id("sign_user_password")).sendKeys("Amol@1234");
        Thread.sleep(2000);
        
        
        driver.findElement(By.xpath("(//button[@class=\"btn btn-lg btn-primary modal-btn ajax-submit\"])[1]")).click();
        Thread.sleep(3000);
        
       s.moveToElement(driver.findElement(By.xpath("(//span[@class=\"caret\"])[2]"))).build().perform();
       Thread.sleep(2000);
       
       driver.findElement(By.xpath("(//span[@class=\"glyphicon glyphicon-off\"])[2]")).click();
       Thread.sleep(3000);
	}
    
    @AfterMethod
	public void getscreenshot() throws IOException
	{
		System.out.println("get ss");
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src, new File("C:\\Users\\Rahul Yadav\\eclipse-workspace\\Maven-Project\\screenshot"));
	}
	
	@AfterClass
	public void deleteallcookies()
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
