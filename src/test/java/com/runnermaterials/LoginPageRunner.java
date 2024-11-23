package com.runnermaterials;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.baseclass.BaseClass;
import com.listeners.ExtentReport_Test;
import com.listeners.ITestListenerClass;
import com.pageobjectmanager.PageObjectManager;
@Listeners(ITestListenerClass.class)
public class LoginPageRunner extends BaseClass {

	PageObjectManager pageobject = new PageObjectManager();

	@BeforeTest
	public void browser() {
		launchBrowser(pageobject.getFileReader().getDataProperty("Browser"));
	}
	@Test
	public void validLoginTest() {

		ExtentReport_Test.extenttest = extentReports
				.createTest("Login Test" + " " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("ValidLogin");
		Assert.assertTrue(pageobject.getLoginpage().vaildLogin(ExtentReport_Test.extenttest));
	}
	@AfterTest
	public void closeBrowser() {
		terminateBrowser();
	}
	@BeforeTest
	private void extendReportStartup() {
		extentReportsStart("D:\\Greens Java Selenium\\Test NG\\TestNG\\Reports");
	}
	@AfterTest
	private void extendReportEnd() throws IOException {
		extentReportTearDown("D:\\Greens Java Selenium\\Test NG\\TestNG\\Reports\\index.html");
	}
}