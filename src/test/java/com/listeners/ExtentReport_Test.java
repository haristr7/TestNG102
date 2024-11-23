package com.listeners;

import java.io.IOException;

import org.junit.platform.suite.api.BeforeSuite;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentTest;
import com.baseclass.BaseClass;

public class ExtentReport_Test {

	public static ExtentTest extenttest;
	
	@BeforeSuite
	public void extentTestReportsStartup()throws IOException {
		BaseClass base = new BaseClass() {

		};
		base.extentReportsStart(null);
	}
	
	@AfterSuite
	public void extendReportEnd() throws IOException {
		BaseClass base = new BaseClass() {

		};
		base.extentReportTearDown(null);
	}
}