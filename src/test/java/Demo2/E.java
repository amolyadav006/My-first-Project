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

public class E
{
	
    WebDriver driver;

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


	@Test(dataProvider= "use_value_dp")
	public void login1(String email, String passward) throws InterruptedException
	{
		System.out.println("login1");
        Thread.sleep(4000);
        
        Actions s=new Actions(driver);
       
        s.moveToElement(driver.findElement(By.xpath("(//a[@class=\"dropdown-toggle\"])[1]")));
        
        Thread.sleep(4000);
        driver.findElement(By.xpath("(//a[@data-target=\"#modalLogin\"])[1]"));
        Thread.sleep(4000);
		
        driver.findElement(By.id("sign_user_email")).sendKeys("amolyadav006@gmail.com");
        driver.findElement(By.id("sign_user_password")).sendKeys("Amol@1234");
        driver.findElement(By.xpath("(//button[@class=\"btn btn-lg btn-primary modal-btn ajax-submit\"])[1]")).click();
        Thread.sleep(3000);
        
        WebElement logout=driver.findElement(By.xpath("(//a[@href=\"https://www.mercurytravels.co.in/b2c/logout\"])[1]"));
        logout.click();
        
        System.out.println("Logout successful");

	}

	@Test(dataProvider= "use_value_dp")
	public void login2(String email, String passward) throws InterruptedException
	{
		System.out.println("login2");
        Thread.sleep(4000);
        

        driver.findElement(By.id("sign_user_email")).sendKeys("tandalemahesh0144@gmail.com");
        driver.findElement(By.id("sign_user_password")).sendKeys("Amu@4321");
        driver.findElement(By.xpath("(//button[@class=\"btn btn-lg btn-primary modal-btn ajax-submit\"])[1]")).click();
        Thread.sleep(3000);
        
        WebElement logout=driver.findElement(By.xpath("(//a[@href=\"https://www.mercurytravels.co.in/b2c/logout\"])[1]"));
        logout.click();
        
        System.out.println("Logout successful");
        
		
	}

	@Test(enabled= false)
	public void login3(String email, String passward) throws InterruptedException
	{
		System.out.println("login3");
        Thread.sleep(4000);
        
        driver.findElement(By.id("sign_user_email")).sendKeys("amolyadav006@gmail.com");
        driver.findElement(By.id("sign_user_password")).sendKeys("Amol@1234");
        driver.findElement(By.xpath("(//button[@class=\"btn btn-lg btn-primary modal-btn ajax-submit\"])[1]")).click();
        Thread.sleep(3000);
        
        WebElement logout=driver.findElement(By.xpath("(//a[@href=\"https://www.mercurytravels.co.in/b2c/logout\"])[1]"));
        logout.click();
        
        System.out.println("Logout successful");
	}
	
	@DataProvider(name= "use_value_dp")
	public Object[][] dp()
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


