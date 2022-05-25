package com.demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable1 {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\jeyapandi\\eclipse-workspace\\MavenProject\\driver\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.get("https://demo.guru99.com/test/web-table-element.php");
	      driver.manage().window().maximize();
	   WebElement table=   driver.findElement(By.tagName("table"));
	          List<WebElement> allrow=  table .findElements(By.tagName("tr"));
	          for (int i = 0; i < allrow.size(); i++) {
	  			WebElement row=allrow.get(i);
	  			List<WebElement> alldata=	row.findElements(By.tagName("td"));
	  			for (int j = 0; j < alldata.size(); j++) {
	  			WebElement data=alldata.get(j);
	  			String company=data.getText();
	  			String com="Escorts Ltd.";
	  			if (company.equals(com)) {
	  				WebElement D=alldata.get(3);
	  				System.out.println("CurrentPrice:" +D.getText()); 
	  			}} }
	      	JavascriptExecutor js=(JavascriptExecutor)driver;
	         js.executeScript("arguments[0].scrollIntoView(true)",table);  
	         TakesScreenshot ts=(TakesScreenshot)driver;
	  File source =   ts.getScreenshotAs(OutputType.FILE);
	  File target=new File("C:\\Users\\jeyapandi\\eclipse-workspace\\MavenProject\\Screenshot\\webtable.png");
          FileUtils.copyFile(source, target);
	}}

