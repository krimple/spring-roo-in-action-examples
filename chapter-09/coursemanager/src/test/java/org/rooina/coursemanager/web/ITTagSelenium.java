package org.rooina.coursemanager.web;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class ITTagSelenium extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testUntitled() throws Exception {
		selenium.open("http://localhost:8080/coursemanagertest/tags?form&lang=en_US");
		selenium.type("_tag_id", "someTag1");
		selenium.type("_description_id", "someDescription1");
		selenium.click("//input[@id='proceed']");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(""));
		verifyEquals("someTag1", selenium.getText("//div[@id='_s_org_rooina_coursemanager_model_Tag_tag_tag_id']"));
		verifyEquals("someDescription1", selenium.getText("//div[@id='_s_org_rooina_coursemanager_model_Tag_description_description_id']"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
