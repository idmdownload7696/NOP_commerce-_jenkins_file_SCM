package actions;



import base.Base_Configuration;
import ui_elements.Login_UI;

public class Login_Page_Acions extends Base_Configuration{
	
	Login_UI login_ui=new Login_UI();


	public void valid_login() throws InterruptedException {
		login_ui.email_label().clear();
		login_ui.email_label().sendKeys(prop.getProperty("valid_email"));
		login_ui.password_label().clear();
		login_ui.password_label().sendKeys(prop.getProperty("valid_password"));
		login_ui.login_button().click();
		
		
	}

}