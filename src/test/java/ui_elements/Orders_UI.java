package ui_elements;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base_Configuration;


public class Orders_UI extends Base_Configuration{
	
	@FindBy(xpath = "//i[@class='nav-icon fas fa-shopping-cart']")
	WebElement sales_drop_down_icon;
	
	@FindBy(xpath = "//a[@href='/Admin/Order/List']")
	WebElement order_list_text;
	
	@FindBy(xpath = "//a[@title='Thursday, January 1, 2015']")
	WebElement start_date;
	
	@FindBy(xpath = "//a[@title='Tuesday, January 1, 2019']")
	WebElement end_date;
	
	@FindBy(xpath = "//button[@id='search-orders']")
	WebElement order_search_button;
	
	@FindBy(xpath = "//div[@class='dataTables_scrollBody']//tbody/tr")
	List<WebElement> order_details_in_table;
	
	@FindBy(xpath = "//div[@class='search-text']")
	WebElement search_plus_button;
	
	@FindBy(xpath = "//div[@class='icon-collapse']/i")
	WebElement search_plus_button_dynamic_selection;
	
	@FindBy(xpath = "//th[text()='Order status']")
	WebElement order_status_text;
	
	
	
	
	
	
	


	
	
	public Orders_UI() {
		PageFactory.initElements(driver, this);

	}
	public WebElement Order_Status_Text() {
		return order_status_text;	
	}
	public WebElement Search_plus_button_dynamic_attribute() {
		return search_plus_button_dynamic_selection;	
	}
	public WebElement Search_plus_button() {
		return search_plus_button;	
	}
	public List<WebElement> Order_Search_Data() {
		return order_details_in_table;	
	}
	public WebElement Order_Search() {
		return order_search_button;	
	}
	public WebElement End_date() {
		return end_date;	
	}
	public WebElement Start_date() {
		return start_date;	
	}
	public WebElement Sales_button() {
		return sales_drop_down_icon;	
	}
	public WebElement Sales_Button_Orders_list() {
		return order_list_text;	
	}
}
