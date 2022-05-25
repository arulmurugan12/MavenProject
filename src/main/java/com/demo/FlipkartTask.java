package com.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartTask {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\jeyapandi\\eclipse-workspace\\MavenProject\\driver\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.get("https://www.flipkart.com/");
	      driver.manage().window().maximize();
	      driver.findElement(By.xpath("//button[text()='✕']")).click();
	      driver.findElement(By.name("q")).sendKeys("mobiles");
	      driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
	      Thread.sleep(3000);
	      Actions a =new Actions(driver);
	      WebElement filter=     driver.findElement(By.xpath("//div[@title='realme']"));
	    a.moveToElement(filter).click().build().perform();
	    Thread.sleep(3000);
	    WebElement source = driver.findElement(By.xpath("(//div[@class='_3FdLqY'])[2]"));
	    a.dragAndDropBy(source, -150, 0).perform();
	    Thread.sleep(3000);
	   List <WebElement> allMname=driver.findElements(By.xpath("//div[@class='_4rR01T']"));
	   for(int i=0;i<24;i++) {
		  WebElement mobilename= allMname.get(i);
		 String realme=mobilename.getText();
		  System.out.println(realme);
		  File f= new File("C:\\Users\\jeyapandi\\Desktop\\sample.xls.xlsx");
		     FileInputStream f1= new FileInputStream(f);
		     XSSFWorkbook book= new XSSFWorkbook(f1);
		     XSSFSheet sheet=book.getSheet("Sheet1");
		     for (int j = i; j <24;) {
		    	 sheet.getRow(j).createCell(1).setCellValue(realme);
		    	FileOutputStream w= new FileOutputStream(f);
		    	book.write(w);
		    	
		    
			}
		     
	}
 
}
}