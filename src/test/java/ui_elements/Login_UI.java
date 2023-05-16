package ui_elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base_Configuration;

public class Login_UI extends Base_Configuration{

	@FindBy(xpath = "//input[@id='Email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement password;

	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement login_button;


	public Login_UI() {
		PageFactory.initElements(driver, this);	
	}
	public WebElement email_label() {
		return email;
	}
	public WebElement password_label() {
		return password;
	}
	public WebElement login_button() {
		return login_button;
	}




}



