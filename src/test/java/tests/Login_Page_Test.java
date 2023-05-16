package tests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import actions.Login_Page_Acions;

import base.Base_Configuration;

import ui_elements.Login_UI;

public class Login_Page_Test extends Base_Configuration{
	public Login_Page_Acions login_page_actions;
	public Login_UI login_ui;
	
	@BeforeClass
	public void setup() throws InterruptedException {
		browser();
		login_page_actions= new Login_Page_Acions();
		login_ui = new Login_UI();
	}
	
	@Test(priority = 1)
	public void valid_login() throws InterruptedException {
		login_page_actions.valid_login();
		
	}
	

}
