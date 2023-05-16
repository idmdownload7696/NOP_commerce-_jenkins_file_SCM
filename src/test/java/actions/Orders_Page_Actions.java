package actions;

import org.openqa.selenium.JavascriptExecutor;

import ui_elements.Orders_UI;


public class Orders_Page_Actions extends Orders_UI{
	Orders_UI order_page_ui= new Orders_UI();
	public JavascriptExecutor jsExecutor;
	
	
	
	public void Sales_Button()  throws InterruptedException{
		order_page_ui.Sales_button().click();	
		order_page_ui.Sales_Button_Orders_list().click();	
	}
	public void Date_Selection_and_search()  throws InterruptedException{
		
		String x = order_page_ui.Search_plus_button_dynamic_attribute().getAttribute("class");
		System.out.println(x);
		if(x.equals("far fa-angle-down")) {
			order_page_ui.Search_plus_button().click();
		}
		else {
			System.out.println("button already exapnd");
		}
//		order_page_ui.Start_date().click();	
//		order_page_ui.End_date().click();	
//		order_page_ui.Order_Search().click();
		
		jsExecutor=(JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", order_page_ui.Order_Status_Text());

		
	}
	


}
