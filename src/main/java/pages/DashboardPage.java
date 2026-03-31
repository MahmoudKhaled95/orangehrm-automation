package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class DashboardPage {

	WebDriver driver;
	WaitUtils wait;

	//By adminMenu = By.xpath("/html/body/div[1]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a");
	By adminMenu = By.xpath("//span[text()='Admin']");
	By profile = By.xpath("//p[@class='oxd-userdropdown-name']");
	By logout = By.xpath("//a[text()='Logout']");

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitUtils(driver);
	}

	public void goToAdmin() {
		wait.waitForClickable(adminMenu);
		driver.findElement(adminMenu).click();
	}

	public void logout() {
		wait.waitForClickable(profile);
		driver.findElement(profile).click();

		wait.waitForClickable(logout);
		driver.findElement(logout).click();
	}
}