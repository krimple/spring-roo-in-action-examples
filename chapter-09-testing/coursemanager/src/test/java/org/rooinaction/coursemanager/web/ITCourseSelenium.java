package org.rooinaction.coursemanager.web;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ITCourseSelenium {

  private WebDriver webDriver;

  @Before
  public void setUp() throws Exception {
    webDriver = new FirefoxDriver();
  }

  @Test

  public void testCourseCreate() throws Exception {
    webDriver.get("http://localhost:8080/coursemanager/courses?form");
    // implicitly wait 10 seconds for anything needed
    // to appear...
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    webDriver.findElement(By.id("_name_id")).sendKeys("someName1");    
    webDriver.findElement(By.id("_description_id")).sendKeys("someDescription1");
    webDriver.findElement(By.id("_maximumCapacity_id")).sendKeys("1");
    webDriver.findElement(By.id("_createdDate_id")).sendKeys("5/1/11");
    webDriver.findElement(By.id("proceed")).click();
    Assert.assertEquals(true, 0 < webDriver.getPageSource().indexOf("Show Course"));
  }

}
