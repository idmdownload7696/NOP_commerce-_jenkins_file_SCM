package tests;




import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import actions.Product_Page_Actions;
import base.Base_Configuration;
import ui_elements.Product_Page_UI;

public class Product_Drop_Down_List_Test extends Base_Configuration {
	public ExtentTest extent_test;
	public ExtentReports extent_report;
	Product_Page_UI product_page_ui;
	Product_Page_Actions product_page_actions;
	public JavascriptExecutor jsExecutor;

	@BeforeClass
	public void setup1() throws InterruptedException, IOException  {
		Login_Page_Test login_page_test   = new Login_Page_Test();
		login_page_test.setup();
		product_page_actions = new Product_Page_Actions();
		product_page_ui = new Product_Page_UI();
		login_page_test.valid_login();
		
		
		File directory = new File(product_page_actions.download_file_location);
		FileUtils.cleanDirectory(directory);
	}
	@BeforeTest
	public void report_path() {
		extent_report=new ExtentReports("C:\\Users\\nnawaz\\.jenkins\\workspace\\nop_Commerce\\product_page_test.html",true);
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
		extent_test.log(LogStatus.INFO, "Dashboard page test initiated");
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
	public void Catalog_Icon_Click_and_Product_Page() throws InterruptedException {
		extent_test=extent_report.startTest("Catalog_Icon Functionality");
		extent_test.log(LogStatus.INFO, "Catalog_Icon test initiated");
		extent_test.log(LogStatus.INFO, "Catalog_Icon test runs successfully");
		product_page_actions.Catalog_Button();
		String s2 = product_page_ui.Product_Page_Heading().getText();
		
		if(s2.contains(prop.getProperty("product_page_heading"))) {
			extent_test.log(LogStatus.PASS, "Catalog_Icon test clicked successfully");
		}else {
			extent_test.log(LogStatus.FAIL, "Catalog_Icon test not clicked");
		}
		Assert.assertEquals(s2.contains(prop.getProperty("product_page_heading")), true);	
	}
	@Test(priority = 4, dependsOnMethods = "Catalog_Icon_Click_and_Product_Page")
	public void Add_New_Product_Button() throws InterruptedException {
		extent_test=extent_report.startTest("Add_New_Product_Button Functionality");
		extent_test.log(LogStatus.INFO, "Add_New_Product_Button page test initiated");
		extent_test.log(LogStatus.INFO, "Add_New_Product_Button page test runs successfully");
		product_page_actions.Add_New_Product();
		Thread.sleep(1000);
		product_page_actions.expand_button_and_toggle_button();
		product_page_actions.product_info();
		product_page_actions.product_price_card();
		product_page_actions.product_shipping();
     	product_page_actions.product_inventory();
     	String product_add_msg_text = product_page_ui.Product_Added_Successfully().getText();
     	
     	if(product_add_msg_text.contains(prop.getProperty("new_product_add_message"))) {
			extent_test.log(LogStatus.PASS, "Add_New_Product_Button page test runs successfully and addedd product details as well");
		}else {
			extent_test.log(LogStatus.FAIL, "Add_New_Product_Button page test and product details not filled successfully");
		}
     	Assert.assertEquals(product_add_msg_text.contains(prop.getProperty("new_product_add_message")), true);

	}
	@Test(priority = 5, dependsOnMethods = "Add_New_Product_Button")
	public void Product_Search_and_Select_Checkbox() throws InterruptedException {
		extent_test=extent_report.startTest("Product_Search_and_Select_Checkbox Functionality");
		extent_test.log(LogStatus.INFO, "Product_Search_and_Select_Checkbox test initiated");
		extent_test.log(LogStatus.INFO, "Product_Search_and_Select_Checkbox card list runs successfully");
		product_page_actions.Product_search_and_checkbox_click();
		String edit_page_title= driver.getTitle();
		if(edit_page_title.equals(prop.getProperty("edit_product_title"))) {
			extent_test.log(LogStatus.PASS, "Product_Search_and_Select_Checkbox search and select product successfully");
		}else {
			extent_test.log(LogStatus.FAIL, "Product_Search_and_Select_Checkbox searched and select product not successfully");
		}
		Assert.assertEquals(edit_page_title.contains(prop.getProperty("edit_product_title")), true);	
	}
	@Test(priority = 6, dependsOnMethods = "Product_Search_and_Select_Checkbox")
	public void Product_image_upload() throws InterruptedException {
		extent_test=extent_report.startTest("Product_image_upload Functionality");
		extent_test.log(LogStatus.INFO, "Product_image_upload card test initiated");
		extent_test.log(LogStatus.INFO, "Product_image_upload card test runs successfully");
		product_page_actions.Multimedia_Upload_Image();
		String image_file_name = product_page_ui.Product_Image_Upload_File_Name().getText();
		System.out.println(image_file_name);
		if(image_file_name.equals(prop.getProperty("product_image_file_name"))) {
			extent_test.log(LogStatus.PASS, "Product_image uploaded successfully");
		}else {
			extent_test.log(LogStatus.FAIL, "Product_image is not uploaded successfuly");
		}
		Assert.assertEquals(image_file_name.contains(prop.getProperty("product_image_file_name")), true);	
	}
	@Test(priority = 7, dependsOnMethods = "Product_image_upload")
	public void Product_updated_successfully() throws InterruptedException {
		extent_test=extent_report.startTest("Product_updated_successfully Functionality");
		extent_test.log(LogStatus.INFO, "Product_updated test started");
		extent_test.log(LogStatus.INFO, "Product_updated test runs successfuly");
		product_page_actions.product_updated_successfully();
		String product_updated_msg_text = product_page_ui.Product_Added_Successfully().getText();
		if(product_updated_msg_text.contains(prop.getProperty("new_product_updated_message"))) {
			extent_test.log(LogStatus.PASS, "Product_updated successfully");
		}else {
			extent_test.log(LogStatus.FAIL, "Product is not updated successfully");
		}
		Assert.assertEquals(product_updated_msg_text.contains(prop.getProperty("new_product_updated_message")), true);	
	}
	
	// from 08-05-2023////
	
	@Test(priority = 8, dependsOnMethods = "Catalog_Icon_Click_and_Product_Page")
	public void Catalog_PDF_Download() throws InterruptedException {
		extent_test=extent_report.startTest("Catalog PDF download Functionality");
		extent_test.log(LogStatus.INFO, "Catalog PDF download test started");
		extent_test.log(LogStatus.INFO, "Catalog PDF download test runs successfully");
		product_page_actions.download_catalog_as_pdf();
		if(product_page_actions.download_file_name.equals("pdfcatalog.pdf")) {
			extent_test.log(LogStatus.PASS, "Catalog PDF downloaded successfully");
		}else {
			extent_test.log(LogStatus.FAIL, "Catalog PDF is not downloaded successfully");
		}
		Assert.assertTrue(product_page_actions.download_file_name.equals("pdfcatalog.pdf"), "Downloaded file name is not matching with expected file name");
	}
	
	@Test(priority = 9, dependsOnMethods = "Catalog_Icon_Click_and_Product_Page")
	public void Export_button() throws InterruptedException {
		extent_test=extent_report.startTest("Export button Functionality");
		extent_test.log(LogStatus.INFO, "Export button test initiated");
		extent_test.log(LogStatus.INFO, "Export button test runs successfully");
		product_page_actions.export_button();
		if(product_page_actions.download_file_name2.equals("products.xlsx")) {
			extent_test.log(LogStatus.PASS, "Export button excel file downloaded successfully");
		}else {
			extent_test.log(LogStatus.FAIL, "Export button excel file is not downloaded successfully");
		}
		Assert.assertTrue(product_page_actions.download_file_name2.equals("products.xlsx"), "Downloaded file name is not matching with expected file name");
	}
	@Test(priority = 10, dependsOnMethods = "Add_New_Product_Button")
	public void Delete_Button() throws InterruptedException {
		extent_test=extent_report.startTest("Delete button Functionality");
		extent_test.log(LogStatus.INFO, "Delete button test initiated");
		extent_test.log(LogStatus.INFO, "Delete button test runs successfully");
		product_page_actions.Search_Card();
		product_page_ui.Product_Search_By_Name().sendKeys("imac");
		product_page_ui.Product_Search_Button().click();
		jsExecutor=(JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", product_page_ui.Search_Product_Checkbox());
		Thread.sleep(1000);
		product_page_ui.Search_Product_Checkbox().click();
		product_page_actions.product_delete();
		driver.navigate().refresh();
		product_page_ui.Product_Search_By_Name().sendKeys("imac");
		product_page_ui.Product_Search_Button().click();
		if((prop.getProperty("product_name").equals(prop.getProperty("product_name")))) {
			extent_test.log(LogStatus.PASS, "Delete button clicked and deleted selected product successfully");
		}else {
			extent_test.log(LogStatus.FAIL, "Delete button not deleted the selected product successfully");
		}
		Assert.assertEquals(prop.getProperty("product_name"), prop.getProperty("product_name"));	
	}
	@Test(priority = 11, dependsOnMethods = "Catalog_Icon_Click_and_Product_Page")
	public void Log_Out() throws InterruptedException {
		extent_test=extent_report.startTest("Logout button Functionality");
		extent_test.log(LogStatus.INFO, "Logout button test initiated");
		extent_test.log(LogStatus.INFO, "Logout button test runs successfully");
		product_page_actions.Log_out_button();
		if((driver.getCurrentUrl().equals(prop.getProperty("url")))) {
			extent_test.log(LogStatus.PASS, "Logout button clicked and log out admin user successfully");
		}else {
			extent_test.log(LogStatus.FAIL, "Logout button is not able to logout the admin user successfully");
		}
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("url"));
		
	}
	
	
	
	
	
	
}
