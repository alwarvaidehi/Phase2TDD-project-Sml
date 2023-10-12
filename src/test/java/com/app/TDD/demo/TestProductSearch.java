package com.app.TDD.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestProductSearch {
	WebDriver driver;
	@Test(priority='1')
	public void findproduct()
	{
		String course="TestNg";
		int ExpectedTraining=20;
		ProductSearch ps=new ProductSearch();
		
		int count=ps.getProduct(course);
		System.out.println(count);
		Assert.assertEquals(count,ExpectedTraining);
		
		
	}
	@Test(priority='2')
	public void findproductemptyinput()
	{
		try {
			String course="";
			int ExpectedTraining =0;
			ProductSearch ps=new ProductSearch();
			int count=ps.getProduct(course);
		}
		catch(NullPointerException e)
		{
			System.out.println("course name cannot be empty");
			
		}
	}
		@Test(priority='3')
		public void findproductInvalidInput()
		{

			try {
				String course="Jenkins";
				int ExpectedTraining =30;
				ProductSearch ps=new ProductSearch();
				int count=ps.getProduct(course);
			}
			catch(NullPointerException e)
			{
				System.out.println("course name doesnot exist in the product list");
				
			}
		}
		@Test
		public void OpenBrowser()
		{

			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.simplilearn.com/");
			
		}
		
		@Test
		public void searchcourseinsimplilearn() throws InterruptedException
		{
			Thread.sleep(1000);
			
			Actions a = new Actions(driver);
			
			WebElement e1= driver.findElement(By.xpath("//span[@class='courses-mega-menu']"));
			
			a.moveToElement(e1).perform();
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
			}
			
			
			driver.findElement(By.xpath("//a[@title='Agile and Scrum'][1]")).click();
			
			}
		
		@Test
	    public void closebrowser() throws InterruptedException
	    {
			Thread.sleep(1500);
	    	driver.close();

	    }
		
	

}
