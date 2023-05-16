package ui_elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base_Configuration;


public class Product_Page_UI extends Base_Configuration{
	@FindBy(xpath = "//div[@class='content-header']/h1")
	WebElement dashboard_page_heading;

	@FindBy(xpath = "//i[@class='nav-icon fas fa-book']")
	WebElement catalog_drop_down_icon;

	@FindBy(xpath = "//a[@href='/Admin/Product/List']")
	WebElement products_list_text;

	@FindBy(xpath = "//div[@class='content-header clearfix']")
	WebElement product_page_heading;

	@FindBy(xpath = "//a[@href='/Admin/Product/Create']")
	WebElement add_new_product;

	@FindBy(xpath = "//label[@class='onoffswitch-label']")
	WebElement on_off_button;

	@FindBy(xpath = "//*[@id='product-info']/div[1]/div[2]/button/i")
	WebElement product_info_plus_button;
	
	@FindBy(xpath = "//*[@id='product-price']/div[1]/div[2]/button/i")
	WebElement product_price_button;
	
	@FindBy(xpath = "//*[@id='product-shipping']/div[1]/div[2]/button/i")
	WebElement product_shipping_button;
	
	@FindBy(xpath = "//*[@id='product-inventory']/div[1]/div[2]/button/i")
	WebElement product_inventory_button;
	
	
	
	
	@FindBy(xpath = "//*[@id='product-multimedia']/div[1]/div[2]/button/i")
	WebElement multimedia_card_plus_button;
	


	@FindBy(xpath = "//input[@id='Name']")
	WebElement product_name;

	@FindBy(xpath = "//textarea[@id='ShortDescription']")
	WebElement short_description; 

	@FindBy(xpath = "//iframe[@id='FullDescription_ifr']")
	WebElement full_description_frame;

	@FindBy(xpath = "//*[@id='tinymce']/p")
	WebElement full_description;

	@FindBy(xpath = "//input[@id='Sku']")
	WebElement sku;

	@FindBy(xpath = "//*[@id=\"product-info\"]/div[2]/div[2]/div[2]/div/div")
	WebElement category;

	@FindBy(xpath = "//ul[@id='SelectedCategoryIds_listbox']/li[1]")
	WebElement category_list_desktop;

	@FindBy(xpath = "//label[@id='SelectedManufacturerIds_label']")
	WebElement manufacturer_text;

	@FindBy(xpath = "//div[@id='product-price-area']/div[2]/span[1]/span[1]/input")
	WebElement product_price;

	@FindBy(xpath = "//select[@id='TaxCategoryId']")
	WebElement product_taxcategory;

	@FindBy(xpath = "//select[@id='TaxCategoryId']/option[@value='2']")
	WebElement product_taxcategory_list;

	@FindBy(xpath = "//label[@id='SelectedCategoryIds_label']")
	WebElement category_text_click;

	//shipping method

	@FindBy(xpath = "//label[@class='col-form-label' and @for='Height']")
	WebElement product_height_text;
	
	
	@FindBy(xpath = "//input[@title='0.0000 lb(s)']")
	WebElement product_weight;

	@FindBy(xpath = "(//input[@title='0.0000 inch(es)'])[1]")
	WebElement product_length;

	@FindBy(xpath = "(//input[@title='0.0000 inch(es)'])[2]")
	WebElement product_width;

	@FindBy(xpath = "(//span[@class='k-numeric-wrap k-state-default'])[12]")
	WebElement product_height;
	
	@FindBy(xpath = "//*[@id=\"ManageInventoryMethodId\"]/option[1]")
	WebElement inventory_method;
	
	
	@FindBy(xpath = "//button[@name='save']")
	WebElement save_button;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	WebElement product_added_successfully;
	
	@FindBy(xpath = "//input[@name='SearchProductName']")
	WebElement product_search_by_name;
	
	@FindBy(xpath = "(//input[@name='checkbox_products'])[1]")
	WebElement product_select_checkbox;
	
	@FindBy(xpath = "//input[@name='SearchProductName']")
	WebElement edit_select_product;
	
	@FindBy(xpath = "//button[@id='search-products']")
	WebElement product_search_button;
	
	@FindBy(xpath = "(//i[@class='fas fa-pencil-alt'])[1]")
	WebElement selected_product_edit_button;
	
	@FindBy(xpath = "(//input[@title='file input'])[1]")
	WebElement product_image_upload;
	
	@FindBy(xpath = "//span[@title='mac.jpg']")
	WebElement product_image_file_name;
	
	@FindBy(xpath = "//div[@class='search-text']")
	WebElement product_search_card_search_txt;
	
	@FindBy(xpath = "//i[@class='far fa-angle-up']")
	WebElement product_search_card_search_txt_dynamic;
	
	
	@FindBy(xpath = "//button[@class='btn bg-purple']")
	WebElement catalog_pdf_button;
	
	@FindBy(xpath = "//button[@class='btn btn-success dropdown-toggle']")
	WebElement export_button_arrow;
	
	@FindBy(xpath = "//button[@name='exportexcel-all']")
	WebElement export_to_excel_link_text;
	
	@FindBy(id = "delete-selected")
	WebElement delete_button;
	
	@FindBy(xpath = "//button[@id='delete-selected-action-confirmation-submit-button']")
	WebElement delete_confirmation_pop_up;
	
	@FindBy(xpath = "//a[@href='/logout']")
	WebElement log_out_button;
	
	
	
	
	
	
	
	


	public Product_Page_UI() {
		PageFactory.initElements(driver, this);

	}
	public WebElement Delete_Confirmation_Pop_Up() {
		return delete_confirmation_pop_up;	
	}
	public WebElement Log_Out() {
		return log_out_button;	
	}
	public WebElement Search_Button_UP_DOWN() {
		return product_search_card_search_txt_dynamic;	
	}
	public WebElement Delete_Button() {
		return delete_button;	
	}
	public WebElement Export_To_Excel() {
		return export_to_excel_link_text;	
	}
	public WebElement Export_Button_Arrow() {
		return export_button_arrow;	
	}
	public WebElement download_catalog_asElement_pdf() {
		return catalog_pdf_button;	
	}
	public WebElement Product_Image_Upload_File_Name() {
		return product_image_file_name;	
	}
	public WebElement Product_Search_card_search_txt() {
		return product_search_card_search_txt;	
	}
	public WebElement Product_Image_Upload() {
		return product_image_upload;	
	}
	public WebElement Multimedia_Plus_Button() {
		return multimedia_card_plus_button;	
	}
	public WebElement Product_Edit_Button1() {
		return selected_product_edit_button;	
	}
	public WebElement Product_Search_By_Name() {
		return product_search_by_name;	
	}
	public WebElement Product_Search_Button() {
		return product_search_button;	
	}
	public WebElement Search_Product_Checkbox() {
		return product_select_checkbox;	
	}
	public WebElement Product_Edit_Button() {
		return edit_select_product;	
	}
	public WebElement Product_Added_Successfully() {
		return product_added_successfully;	
	}
	public WebElement Save_Button() {
		return save_button;	
	}
	public WebElement Inventory_Method_Drop_dwon_Click() {
		return inventory_method;	
	}
	
	public WebElement Product_Height_Text() {
		return product_height_text;	
	}
	public WebElement Product_Weight() {
		return product_weight;	
	}
	public WebElement Product_Length() {
		return product_length;	
	}
	public WebElement Product_Width() {
		return product_width;	
	}
	public WebElement Product_Height() {
		return product_height;	
	}
	public WebElement Category_Text_Click() {
		return category_text_click;	
	}
	public WebElement Dashboard_Heading() {
		return dashboard_page_heading;	
	}
	public WebElement Catalog_Drop_Down_Icon1() {
		return catalog_drop_down_icon;	
	}
	public WebElement Product_List() {
		return products_list_text;	
	}
	public WebElement Product_Page_Heading() {
		return product_page_heading;	
	}
	public WebElement Add_New_Product_Button() {
		return add_new_product;	
	}
	public WebElement On_off_button() {
		return on_off_button;	
	}
	public WebElement Product_Info_Plus_Button() {
		return product_info_plus_button;	
	}
	public WebElement Product_Price_Plus_Button() {
		return product_price_button;	
	}
	public WebElement Product_Shipping_Plus_Button() {
		return product_shipping_button;	
	}
	public WebElement Product_Inventory_Plus_Button() {
		return product_inventory_button;	
	}

	public WebElement Manufacturer_text() {
		return manufacturer_text;	
	}

	public WebElement Product_Name() {
		return product_name;	
	}

	public WebElement Short_Description() {
		return short_description;	
	}
	public WebElement full_description_fram() {
		return full_description_frame;	
	}
	public WebElement full_description_text() {
		return full_description;	
	}
	public WebElement SKU() {
		return sku;	
	}
	public WebElement Category() {
		return category;	
	}
	public WebElement Category_Desktop() {
		return category_list_desktop;	
	}
	public WebElement Product_Price() {
		return product_price;	
	}
	public WebElement Product_tax() {
		return product_taxcategory;	
	}
	public WebElement Product_tax_category_list() {
		return product_taxcategory_list;	
	}







	//public WebElement advance() {
	//return 	on_off_button_advance;	
	//}



}



















