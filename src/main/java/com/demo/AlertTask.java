package com.demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertTask {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jeyapandi\\eclipse-workspace\\MavenProject\\driver\\chromedriver.exe");
   WebDriver driver =new ChromeDriver();
   driver.get("https://demoqa.com/alerts");
   driver.manage().window().maximize();
   driver.findElement(By.id("alertButton")).click();
   Alert alert= driver.switchTo().alert(); 
   alert.accept();
   driver.findElement(By.id("timerAlertButton")).click();
   WebDriverWait wait =new WebDriverWait(driver,10);
   wait.until(ExpectedConditions.alertIsPresent());
   alert.accept();
   Thread.sleep(2000);
   driver.findElement(By.id("confirmButton")).click();
   alert.accept();
   Thread.sleep(2000);
   String text= driver.findElement(By.id("confirmResult")).getText();
   System.out.println(text);
   driver.findElement(By.id("promtButton")).click();
   alert.sendKeys("Arul");
   alert.accept();
   Thread.sleep(2000);
   String text2=   driver.findElement(By.id("promptResult")).getText();
   System.out.println(text2);
	}

}