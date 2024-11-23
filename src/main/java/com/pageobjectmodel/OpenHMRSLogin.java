package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.baseclass.BaseClass;
import com.srcfilereadermanager.FileReaderManager;
import com.webelementsinterface.ElementsInterface;

@SuppressWarnings("static-access")
public class OpenHMRSLogin extends BaseClass implements ElementsInterface {

	@FindBy(xpath = userNameXPath)
	private WebElement username;

	@FindBy(xpath = PasswordXPath)
	private WebElement password;

	@FindBy(xpath = departmentXpath)
	private WebElement department;

	@FindBy(xpath = loginButton)
	private WebElement login;

	@FindBy(xpath = errorMsg)
	private WebElement passwordError;

	@FindBy(xpath = locationMsg)
	private WebElement locationError;

	public OpenHMRSLogin(WebDriver Driver) {
		PageFactory.initElements(driver, this);
	}

	public boolean vaildLogin(ExtentTest extenttext){
		try {
			FileReaderManager file = new FileReaderManager();
			launchUrl(file.getDataProperty("URL"));
			passValues(username, file.getDataProperty("Username"));
			passValues(password, file.getDataProperty("Password"));
			clickElement(department);
			clickElement(login);
			validation(driver.getTitle(), file.getDataProperty("Tittle"));
			extenttext.log(Status.PASS,"Login Sucessful");
		} catch (Exception e) {
			Assert.fail("Error Occur During Valid Password");
			return false;
		}
		return true;
	}

	public boolean invaildPassword() {
		try {
			FileReaderManager file = new FileReaderManager();
			launchUrl(file.getDataProperty("URL"));
			passValues(username, file.getDataProperty("Username"));
			passValues(password, file.getDataProperty("InvalidPassword"));
			clickElement(department);
			clickElement(login);
			validation(passwordError.getText(), file.getDataProperty("InvalidUserAndPassMsg"));
		} catch (Exception e) {
			Assert.fail("Error Occur During Invalid Password");
		}
		return true;

	}

	public boolean invaildDepartment() {
		try {
			FileReaderManager file = new FileReaderManager();
			launchUrl(file.getDataProperty("URL"));
			passValues(username, file.getDataProperty("Username"));
			passValues(password, file.getDataProperty("Password"));
			clickElement(login);
			validation(locationError.getText(), file.getDataProperty("InvalidLocationMsg"));
		} catch (Exception e) {
			Assert.fail("Error Occur During Invalid Password");
		}
		return true;
	}

	public boolean withoutAnyData(){
		try {
			FileReaderManager file = new FileReaderManager();
			launchUrl(file.getDataProperty("URL"));
			clickElement(login);
			validation(locationError.getText(), file.getDataProperty("InvalidLocationMsg"));
		} catch (Exception e) {
			Assert.fail("Error Occur During Invalid Password");
		}
		return true;
	}
	
	public boolean departmentOnly() {
		try {
			FileReaderManager file = new FileReaderManager();
			launchUrl(file.getDataProperty("URL"));
			clickElement(department);
			clickElement(login);
			validation(passwordError.getText(), file.getDataProperty("InvalidUserAndPassMsg"));
		} catch (Exception e) {
			Assert.fail("Error Occur During Invalid Password");
		}
		return true;
	}
}
