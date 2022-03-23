package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class accountCreation {
	
	WebDriver driver = null;
	
	public accountCreation() {
		//Change the driver path 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\psire\\part\\CucumberJava\\dealerwareTest\\src\\test\\resources\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public void gotoHomepage() { 
		System.out.println("inside browser step is open");	
		System.out.println("user go the home page");		
		driver.navigate().to("http://automationpractice.com/index.php");	
	}
	
	public void signIn() throws InterruptedException {
		System.out.println("user enter invalid details");
		WebElement ele = driver.findElement(By.className("login"));		
		ele.click();		
		Thread.sleep(6000);	
	}
	
	public void createAccount(account acc) throws InterruptedException {
		System.out.println("user starting with creating account");	
		WebElement ele = driver.findElement(By.className("login"));	
		ele.click();
		//Change all sleeps to webDriver waits xxxWait()
		Thread.sleep(6000);						
		System.out.println("user creating a account");	
		WebElement ele1 = driver.findElement(By.cssSelector("div[class='form-group']>input[type='text']"));
		ele1.sendKeys(acc.emailId);
	
		WebElement submit = driver.findElement(By.cssSelector("div[class='submit']>button[type='submit']"));
		submit.click();	
		Thread.sleep(10000);					
		//filling the form	
		WebElement radio = driver.findElement(By.xpath("//*[@id='id_gender2']"));		
		System.out.println(">>>>>"+radio.getText());		
		radio.click();	
		Thread.sleep(7000);		
		WebElement firstName = driver.findElement(By.name("customer_firstname"));	
		firstName.sendKeys(acc.firstName);		
		WebElement lastName = driver.findElement(By.name("customer_lastname"));		
		lastName.sendKeys(acc.lastName);	
		Thread.sleep(6000);	
		WebElement password = driver.findElement(By.name("passwd"));		
		password.sendKeys(acc.passwd);
		Select daysSelect = new Select(driver.findElement(By.id("days")));
		Select monthSelect = new Select(driver.findElement(By.id("months")));		
		Select yearSelect = new Select(driver.findElement(By.id("years")));		
		daysSelect.selectByValue(acc.dobDay);	
		monthSelect.selectByValue(acc.dobMonth);		
		yearSelect.selectByValue(acc.dobYear);		
		Thread.sleep(5000);			
		WebElement checkBox = driver.findElement(By.xpath("//*[@id='newsletter']"));		
		checkBox.click();
	
		//Your address	
		WebElement fn = driver.findElement(By.id("firstname"));		
		fn.sendKeys(acc.firstName);	
		WebElement ln = driver.findElement(By.id("lastname"));	
		ln.sendKeys(acc.lastName);		
		WebElement company = driver.findElement(By.id("company"));	
		company.sendKeys("fff");		
		WebElement address1 = driver.findElement(By.id("address1"));	
		address1.sendKeys(acc.addrStreat);		
		//WebElement address2 = driver.findElement(By.id("address2"));	
		//address2.sendKeys("lllll");		
		WebElement city = driver.findElement(By.id("city"));		
		city.sendKeys(acc.addrCity);		
		WebElement postalCode = driver.findElement(By.id("postcode"));	
		postalCode.sendKeys(acc.addrZip);			
		Select stateSelect = new Select(driver.findElement(By.id("id_state")));	
		stateSelect.selectByValue("6");			
		Select countrySelect = new Select(driver.findElement(By.id("id_country")));	
		countrySelect.selectByValue("21");			
		WebElement mobilePhone = driver.findElement(By.id("phone_mobile"));	
		mobilePhone.sendKeys(acc.addrMobile);		
		WebElement otherAddress = driver.findElement(By.id("alias"));		
		otherAddress.sendKeys(acc.addrAlias);		
		WebElement submitButton = driver.findElement(By.id("submitAccount"));		
		submitButton.click();		
		Thread.sleep(10000);			
		System.out.println("User created account successfully");		
	}
	
	public void signOut() {
		WebElement submitButton = driver.findElement(By.className("logout"));
		submitButton.click();
		driver.quit();
	}
	
	public void loginWithCreds(String login, String passwd) {
		WebElement signIn = driver.findElement(By.className("login"));
		signIn.click();
		WebElement userName = driver.findElement(By.id("email"));
		userName.sendKeys(login);
		WebElement password = driver.findElement(By.id("passwd"));
		password.sendKeys(passwd);
		WebElement sign = driver.findElement(By.id("SubmitLogin"));
		sign.click();
	}
	
	public void errorMessgaeChecking() throws InterruptedException {
		Thread.sleep(10000);
		WebElement error = driver.findElement(By.xpath("//*[@id='center_column']/div[1]"));
		String errorMessage = error.getText();
		//String actualErrorMessage = "There is 1 error Invalid email addres";
		System.out.println(">>>>>>>>>>>>>>>>>."+errorMessage);
		if(errorMessage.equals("actualErrorMessage")) {
			System.out.println("Test case pass");
		}else {
			System.out.println("Test case failed");
		}
	}
	
	public void close() {
		driver.quit();
	}
	
}
