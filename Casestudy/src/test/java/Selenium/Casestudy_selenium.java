package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Casestudy_selenium {
	
	String URL = " https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	WebDriver driver;
	
	@BeforeTest
	public void BT() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	    driver.get(URL);
	    Thread.sleep(2000);
	    
	}
	
	@SuppressWarnings("deprecation")
	@Test(enabled=true,priority=0)
	 public void test1() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
 
	@SuppressWarnings("deprecation")
	@Test(enabled=true,priority=1)
	 public void test2() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		List<WebElement> lp=driver.findElements(By.tagName("a"));
		int sizes=lp.size();
		System.out.println("Total links of the page:"+sizes);
	}

	@SuppressWarnings("deprecation")
	@Test(enabled=true,priority=2)
	  public void test3() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		List<WebElement> li=driver.findElements(By.xpath("//*[@role='row']"));
		int size=li.size();
		System.out.println("Total size of the webelements:"+size);
		for(int i=0;i<=size;i++) 
		{
			if(i==6) {
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.findElements(By.xpath("//*[@class='oxd-icon bi-check oxd-checkbox-input-icon']")).get(i).click();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.findElements(By.xpath("//*[@class='oxd-icon bi-trash']")).get(i).click();
				driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
			}
		}
	}

	@Test (enabled = true,priority =3 )
	  public void TestCase2() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='oxd-userdropdown']")).click();
		Thread.sleep(3000);
		WebElement logout= driver.findElement(By.xpath("//*[@class='oxd-dropdown-menu']/li[4]/a"));

		if(logout.isDisplayed())
		{
			logout.click();
		}
		System.out.println("Logout is Done");
	  }

	@AfterTest
		public void AT() throws InterruptedException {
			Thread.sleep(3000);
			driver.close();
			}
}


