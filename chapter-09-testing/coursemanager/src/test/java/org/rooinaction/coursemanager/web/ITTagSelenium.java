package org.rooinaction.coursemanager.web;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ITTagSelenium {
	
  private WebDriver webDriver;
  
  @Before
	public void setUp() throws Exception {
    webDriver = new FirefoxDriver();
	}

	@Test
	public void testCreateTag() throws Exception {
		webDriver.get("http://localhost:8080/coursemanager-chapter-09/tags?form&lang=en_US");
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    webDriver.findElement(By.id("_name_id")).sendKeys("someTag1");
    webDriver.findElement(By.id("_description_id")).sendKeys("someDescription1");
		webDriver.findElement(By.id("proceed")).click();
    Assert.assertEquals(true, 0 < webDriver.getPageSource().indexOf("Show Tag"));
	}
	
	@After
	public void tearDown() throws Exception {
	  webDriver.close();
	}

}
