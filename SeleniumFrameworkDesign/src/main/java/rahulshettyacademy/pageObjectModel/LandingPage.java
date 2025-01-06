package rahulshettyacademy.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement submit;

	public ProductCatelogue loginApplication(String email, String password) {

		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		ProductCatelogue productCatelogue = new ProductCatelogue(driver);
		return productCatelogue;
	}

	public void goTo() {

		driver.get("https://rahulshettyacademy.com/client/");

	}

}
