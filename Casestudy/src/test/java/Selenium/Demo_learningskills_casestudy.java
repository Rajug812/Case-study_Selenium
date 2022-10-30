package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo_learningskills_casestudy {

	String url=" http://elearningm1.upskills.in/";
	 WebDriver driver;
	 
	 @BeforeTest
	 public void BT() throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
		 driver =new ChromeDriver();
		 driver.get(url);
		 Thread.sleep(2000);
		 }
	
	 @Test
	 public void testcase1() throws InterruptedException {
		 driver.findElement(By.xpath("//*[@class='nav nav-pills nav-stacked']")).click();
		 driver.findElement(By.name("firstname")).sendKeys("raju");
		 driver.findElement(By.name("lastname")).sendKeys("kumar");
		 driver.findElement(By.name("email")).sendKeys("raju123@gmail.com"); 
		 driver.findElement(By.name("official_code")).sendKeys("raju123");
		 driver.findElement(By.name("username")).sendKeys("rajug");
		 driver.findElement(By.name("pass1")).sendKeys("raju9966");
		 driver.findElement(By.name("pass2")).sendKeys("raju9966");
		 driver.findElement(By.name("phone")).sendKeys("9966570454");
		 Thread.sleep(2000);
		 driver.findElement(By.name("submit")).click();
		 
	 }
	 
@AfterTest
public void AT() throws InterruptedException {
	Thread.sleep(2000);
	driver.close();
	}
}

