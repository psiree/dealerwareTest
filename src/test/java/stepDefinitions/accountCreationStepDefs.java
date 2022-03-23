package stepDefinitions;
import pageObjects.accountCreation;
import pageObjects.account;

import java.io.IOException;

//import java.util.List;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class accountCreationStepDefs  {	
	
	accountCreation create = new accountCreation (); 
	//AccountCreation creation ;		
	
	@Given("User navigates to the home page")
	public void go_to_the_home_page() {
		create.gotoHomepage();
	}			
	
	@When("user clicks on signIn")	
	public void user_enter_invalid_login_details() throws Exception {	
		// Write code here that turns the phrase above into concrete actions	
		create.signIn();
	}
	
	//Get the minimum information from the feature file using data table. 
	@And("User creates a new account with login {string} and password {string} and default information")
	public void user_creates_a_new_account_with_login_and_password_and_default_information(String email, String passwd) throws IOException, InterruptedException{
		account acc = new account();
		acc.emailId = email;
		acc.firstName = "fffff";
		acc.lastName = "lllll";
		acc.dobDay   = "1";
		acc.dobMonth = "1";
		acc.dobYear  = "2000";
		acc.passwd   = passwd;
		acc.addrStreat = "1234 stststst";
		acc.addrCity   = "cccc";
		acc.addrState  = "ssss";
		acc.addrCountry = "usa";
		acc.addrZip    ="12345";
		acc.addrAlias  = "aaaa";
		acc.addrMobile ="5123334444";
		create.createAccount(acc);
	}	
	@Then("User signs out")
	public void User_signs_out() {
		create.signOut();
		create.close();
	}
		
	@And("User signs in with login {string} and password {string} credentials")
	//@And("User creates  a new account with  and default information")
	public void User_signs_in_with_invalid_credentials (String login, String password) throws IOException {
		create.loginWithCreds(login, password);
	}

	@Then("user receives error message")
	public void user_receives_error_message() throws InterruptedException {
		create.errorMessgaeChecking();
		create.close();
	}
}