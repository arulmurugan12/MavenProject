package com.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\jeyapandi\\eclipse-workspace\\MavenProject\\driver\\chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      driver.get("https://demo.guru99.com/test/web-table-element.php");
      driver.manage().window().maximize();
   WebElement table=   driver.findElement(By.tagName("table"));
          List<WebElement> allrow=  table .findElements(By.tagName("tr"));
          for(WebElement row:allrow) {
        	 List<WebElement>alldata= row.findElements(By.tagName("td"));
        	 for(WebElement data:alldata) {
        		String com= data.getText();
        		String Wcom="Escorts Ltd.";
        		if (com.equals(Wcom)) {
					System.out.println(data.getText());
				}
        	 }
          }
			
		}
          
	}


