package actions;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.Base_Configuration;
import ui_elements.Product_Page_UI;

public class Product_Page_Actions extends Product_Page_UI{

	Base_Configuration baseconfiguration;
	Product_Page_UI product_page_ui= new Product_Page_UI();
	public JavascriptExecutor jsExecutor;


	public final String download_file_name2 = "products.xlsx";
	public final String download_file_name = "pdfcatalog.pdf";
	public final String download_file_location = "C:/Users/nnawaz/Downloads";


	public void Catalog_Button() {
		product_page_ui.Catalog_Drop_Down_Icon1().click();	
		product_page_ui.Product_List().click();	
	}
	public void Add_New_Product() throws InterruptedException {
		product_page_ui.Add_New_Product_Button().click();
	}
	public void expand_button_and_toggle_button() throws InterruptedException {
		// plus button click below from here 
		//Thread.sleep(2000);
		String x = product_page_ui.Product_Info_Plus_Button().getAttribute("class");
		System.out.println(x);
		if(x.equals("fa toggle-icon fa-plus")) {
			product_page_ui.Product_Info_Plus_Button().click();
		}
		else {
			System.out.println("button already exapnd");
		}
		//Thread.sleep(6000);

		Boolean manufacture = product_page_ui.Manufacturer_text().isDisplayed();
		System.out.println(manufacture);
		String Manufacturer = "Manufacturers";
		if(manufacture==true) {
			//Thread.sleep(5000);
			product_page_ui.On_off_button().click(); //it will execute when advance is enable
		}
		else {
			System.out.println("Basic is already enable"); //if already basic is then there is no need to click

		}

	}
	public void product_info() {
		//		product_page_ui.Product_Info_Plus_Button().click();
		product_page_ui.Product_Name().sendKeys(prop.getProperty("product_name"));
		product_page_ui.Short_Description().sendKeys(prop.getProperty("product_short_desc"));
		driver.switchTo().frame(product_page_ui.full_description_fram());
		product_page_ui.full_description_text().sendKeys(prop.getProperty("product_full_desc"));	
		driver.switchTo().defaultContent();
		product_page_ui.SKU().sendKeys(prop.getProperty("sku"));
		product_page_ui.Category().click();
		product_page_ui.Category_Desktop().click();
		product_page_ui.Category_Text_Click().click();

		//		product_page_ui.Category().sendKeys(Keys.ARROW_UP);
		//product_page_ui.Category().sendKeys(Keys.ARROW_UP);
	}
	public void product_price_card() throws InterruptedException {

		String x = product_page_ui.Product_Price_Plus_Button().getAttribute("class");
		System.out.println(x);
		if(x.equals("fa toggle-icon fa-plus")) {
			product_page_ui.Product_Price_Plus_Button().click();
		}
		else {
			System.out.println("button already exapnd");
		}
		product_page_ui.Product_Price().sendKeys("600");
		jsExecutor=(JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", product_page_ui.Product_tax());

		product_page_ui.Product_tax().click();
		product_page_ui.Product_tax_category_list().click();

		//product_page_ui.Category().sendKeys(Keys.ARROW_UP);
	}

	public void product_shipping() throws InterruptedException {
		//		product_page_ui.Product_Info_Plus_Button().click();
		String x = product_page_ui.Product_Shipping_Plus_Button().getAttribute("class");
		System.out.println(x);
		if(x.equals("fa toggle-icon fa-plus")) {
			product_page_ui.Product_Shipping_Plus_Button().click();
		}
		else {
			System.out.println("button already exapnd");
		}
		product_page_ui.Product_Height_Text().click();
		product_page_ui.Product_Weight().sendKeys("200");
		product_page_ui.Product_Length().sendKeys("27");
		product_page_ui.Product_Width().sendKeys("20");

		//product_page_ui.Product_Height().sendKeys("22");
		product_page_ui.Product_Height_Text().click();
		//product_page_ui.Category().sendKeys(Keys.ARROW_UP);
	}

	public void product_inventory() throws InterruptedException {

		String x = product_page_ui.Product_Inventory_Plus_Button().getAttribute("class");
		System.out.println(x);
		if(x.equals("fa toggle-icon fa-plus")) {
			product_page_ui.Product_Inventory_Plus_Button().click();
		}
		else {
			System.out.println("button already exapnd");
		}


		WebElement inventorymethod = driver.findElement(By.xpath("//select[@id='ManageInventoryMethodId']"));

		Select objSelect = new Select(inventorymethod);

		objSelect.selectByVisibleText("Track inventory");

		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", product_page_ui.Save_Button());
		product_page_ui.Save_Button().click();
	}
	public void Product_search_and_checkbox_click() throws InterruptedException {
		product_page_ui.Product_Search_By_Name().sendKeys("imac");
		product_page_ui.Product_Search_Button().click();
		jsExecutor=(JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", product_page_ui.Search_Product_Checkbox());
		Thread.sleep(1000);
		product_page_ui.Search_Product_Checkbox().click();
		product_page_ui.Product_Edit_Button1().click();	
	}
	public void Multimedia_Upload_Image() throws InterruptedException {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", product_page_ui.Multimedia_Plus_Button());
		String x = product_page_ui.Multimedia_Plus_Button().getAttribute("class");
		System.out.println(x);

		if(x.equals("fa toggle-icon fa-plus")) {
			product_page_ui.Multimedia_Plus_Button().click();
		}
		else {
			System.out.println("button already exapnd");
		}
		product_page_ui.Product_Image_Upload().sendKeys("C:/Users/nnawaz/Desktop/mac.jpg");

		Thread.sleep(1000);

	}
	public void product_updated_successfully() {
		product_page_ui.Save_Button().click();
	}

	///  from 08-05-2023
	// catalog file pdf download 
	public void download_catalog_as_pdf() {
		product_page_ui.download_catalog_asElement_pdf().click();
	}

	// checking file loaction for pdf one
	public boolean is_file_downloaded() {
		boolean flag = false;
		File dir = new File(download_file_location);
		File[] dir_contents = dir.listFiles();
		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(download_file_name))
				return flag=true;
		}
		return flag;	
	}

	public void export_button() throws InterruptedException {
		product_page_ui.Export_Button_Arrow().click();
		
		product_page_ui.Export_To_Excel().click();
	}
	public boolean is_file_downloaded2() {
		boolean flag = false;
		File dir = new File(download_file_location);
		File[] dir_contents = dir.listFiles();
		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(download_file_name2))
				return flag=true;
		}
		return flag;	
	}
	public void Search_Card() throws InterruptedException {
		String x = product_page_ui.Search_Button_UP_DOWN().getAttribute("class");
		System.out.println(x);

		if(x.equals("far fa-angle-down")) {
			product_page_ui.Product_Search_card_search_txt().click();
		}
		else {
			System.out.println("button already exapnd");
		}


	}


	public void product_delete() {
		product_page_ui.Delete_Button().click();
		product_page_ui.Delete_Confirmation_Pop_Up().click();



	}
	public void Log_out_button() {
		product_page_ui.Log_Out().click();

	}













}
