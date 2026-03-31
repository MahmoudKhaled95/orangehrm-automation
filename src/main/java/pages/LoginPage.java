package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	By usernameFeild = By.name("username");
	By passwordFeild = By.name("password");
	By loginBtn = By.xpath("//button[@type='submit']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String user, String pass) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(usernameFeild).sendKeys(user);
		driver.findElement(passwordFeild).sendKeys(pass);
		driver.findElement(loginBtn).click();
	}
}