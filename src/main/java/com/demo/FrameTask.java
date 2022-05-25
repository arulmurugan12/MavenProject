package com.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameTask {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jeyapandi\\eclipse-workspace\\MavenProject\\driver\\chromedriver.exe");
		   WebDriver driver =new ChromeDriver();
		   driver.get("https://demo.guru99.com/test/guru99home/");
		   driver.manage().window().maximize();
		   driver.findElement(By.xpath("//input[@placeholder='Enter Email']")).sendKeys("arulmurugan12201gmail.com");
		  WebElement dropdown =driver.findElement(By.tagName("select"));
		   Select select =new Select(dropdown);
		   select.selectByVisibleText("SAP PP");
		   TakesScreenshot ts=(TakesScreenshot)driver;
		 File source1=  ts.getScreenshotAs(OutputType.FILE);
		 File target1= new File("C:\\Users\\jeyapandi\\eclipse-workspace\\MavenProject\\Screenshot\\submission.png");
		 FileUtils.copyFile(source1, target1);
		 driver.switchTo().frame("a077aa5e");
		 driver.findElement(By.xpath("//img[contains(@src,'Jm')]")).click();
		String pwin= driver.getWindowHandle();
		Set<String> allwin=driver.getWindowHandles();
		List<String> win=new ArrayList<String>();
		win.addAll(allwin);
		driver.switchTo().window(win.get(1));
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement redbox=	 driver.findElement(By.xpath("//h3[text()='What will I Learn?']"));
	    JavascriptExecutor js =(JavascriptExecutor)driver;
     	js.executeScript("arguments[0].scrollIntoView(true)", redbox);
		WebElement hre=driver.findElement(By.xpath("//a[text()=' here']"));
		Actions a = new Actions(driver);	
		a.moveToElement(hre).perform();
		File source2=ts.getScreenshotAs(OutputType.FILE);
		 File target2= new File("C:\\Users\\jeyapandi\\eclipse-workspace\\MavenProject\\Screenshot\\submission1.png");
		 FileUtils.copyFile(source2, target2);
	}
}

