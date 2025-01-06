package rahulshettyacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageObjectModel.CartPage;
import rahulshettyacademy.pageObjectModel.ConfirmationPage;
import rahulshettyacademy.pageObjectModel.LandingPage;
import rahulshettyacademy.pageObjectModel.ProductCatelogue;
import rahulshettyacademy.pageObjectModel.checkOutPage;

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		String productName = "ADIDAS ORIGINAL";

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		ProductCatelogue productCatelogue = landingPage.loginApplication("adarsh.mqt@hotmail.com", "Adarsh@2001");

		List<WebElement> products = productCatelogue.getProductList();
		productCatelogue.addProductToCart(productName);
		CartPage cartPage = productCatelogue.goToCartPage();

		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		checkOutPage CheckOutPage = cartPage.goToCheckOut();
		CheckOutPage.SelectCountry("Inia");
		ConfirmationPage confirmationPage = CheckOutPage.submitOrder();
		String confirmationMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
	}

}
