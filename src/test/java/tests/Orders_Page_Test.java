package tests;


import static org.testng.Assert.assertEquals;

import java.io.IOException;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import actions.Orders_Page_Actions;

import base.Base_Configuration;
import ui_elements.Orders_UI;
import ui_elements.Product_Page_UI;


public class Orders_Page_Test extends Base_Configuration{
	public ExtentTest extent_test;
	public ExtentReports extent_report;
	Orders_UI order_page_ui;
	Product_Page_UI product_page_ui;
	Orders_Page_Actions order_page_actions;
	public JavascriptExecutor jsExecutor;

	@BeforeClass
	public void setup1() throws InterruptedException, IOException  {
		Login_Page_Test login_page_test   = new Login_Page_Test();
		login_page_test.setup();
		order_page_actions = new Orders_Page_Actions();
		product_page_ui = new Product_Page_UI();
		order_page_ui = new Orders_UI();
		login_page_test.valid_login();


		//File directory = new File(order_page_actions.download_file_location);
		//FileUtils.cleanDirectory(directory);
	}
	@BeforeTest
	public void report_path() {
		extent_report=new ExtentReports("C:\\Users\\nnawaz\\.jenkins\\workspace\\nop_Commerce\\order_page_test.html",true);
	}
	@AfterTest
	public void reportend() {
		extent_report.endTest(extent_test);
		extent_report.flush();
	}


	@Test(priority = 1)
	public void Login() throws InterruptedException {
		extent_test=extent_report.startTest("Login Functionality");
		extent_test.log(LogStatus.INFO, "Login page test initiated");
		extent_test.log(LogStatus.INFO, "Login page test runs successfully");
		String s1 = driver.getCurrentUrl();
		if(s1.equals(prop.getProperty("admin_url"))) {
			extent_test.log(LogStatus.PASS, "Login Successfully");
		}else {
			extent_test.log(LogStatus.FAIL, "Login Fail");
		}
		Assert.assertEquals(s1, prop.getProperty("admin_url"));
	}
	@Test(priority = 2, dependsOnMethods = "Login")
	public void Dashboard_Heading() throws InterruptedException {
		extent_test=extent_report.startTest("Dashboard_Heading Functionality");
		extent_test.log(LogStatus.INFO, "Dashboard page test initiated*");
		extent_test.log(LogStatus.INFO, "Dashboard page test runs successfully");
		String s1 = product_page_ui.Dashboard_Heading().getText();
		if(s1.equals(prop.getProperty("dashboard_heading"))) {
			extent_test.log(LogStatus.PASS, "Dashboard page load successfully");
		}else {
			extent_test.log(LogStatus.FAIL, "Dashboard page fail to load");
		}
		Assert.assertEquals(s1, prop.getProperty("dashboard_heading"));	
	}
	@Test(priority = 3, dependsOnMethods = "Login")
	public void Sales_Icon_Click_and_Order_Page() throws InterruptedException {
		extent_test=extent_report.startTest("Sales_Icon Functionality");
		extent_test.log(LogStatus.INFO, "Sales_Icon test initiated");
		extent_test.log(LogStatus.INFO, "Sales_Icon test runs successfully");
		order_page_actions.Sales_Button();
		String s2 = product_page_ui.Product_Page_Heading().getText();
		
		if(s2.contains(prop.getProperty("oders_page_heading"))) {
			extent_test.log(LogStatus.PASS, "Sales_Icon test clicked successfully");
		}else {
			extent_test.log(LogStatus.FAIL, "Sales_Icon test not clicked");
		}
		Assert.assertEquals(s2.contains(prop.getProperty("oders_page_heading")), true);	
	}
	@Test(priority = 4, dependsOnMethods = "Sales_Icon_Click_and_Order_Page")
	public void Verifying_Product_Count() throws InterruptedException {
		extent_test=extent_report.startTest("Product_Search using date Functionality");
		extent_test.log(LogStatus.INFO, "Product_Search using date test initiated");
		extent_test.log(LogStatus.INFO, "Product_Search using date test runs successfully");
		order_page_actions.Date_Selection_and_search();
		
	
		int number=order_page_ui.Order_Search_Data().size();	
		System.out.println(number);
		if(number==5) {
			extent_test.log(LogStatus.PASS, "Product_Search using date test clicked successfully");
		}else {
			extent_test.log(LogStatus.FAIL, "Product_Search using date test not clicked");
		}
	
		assertEquals(number, 5);

	}
}