package com.runnermaterials;

import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.pageobjectmanager.PageObjectManager;

public class DynamicParameter extends BaseClass {

	PageObjectManager pageobject = new PageObjectManager();
	
	@Test(priority = 2)
	public void chrome() {
		launchBrowser("chrome");
		launchUrl("https://www.google.com/");
		terminateBrowser();
	}
	
	@Test(invocationCount = 5)
	public void edge() {
		launchBrowser("edge");
		launchUrl("https://www.google.com/");
		terminateBrowser();
	}
	
	@Test(priority = 1)
	public void firefox() {
		launchBrowser("firefox");
		launchUrl("https://www.google.com/");
		terminateBrowser();
	}
}