package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

import java.time.Duration;

public class AdminPage {

	WebDriver driver;
	WaitUtils wait;
	WebDriverWait explicitWait;
	
    By addBtn = By.xpath("//button[normalize-space()='Add']");
	By usernameSearch = By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
    By searchBtn = By.xpath("//button[@type='submit']");
    By deleteBtn = By.xpath("//i[@class='oxd-icon bi-trash']/parent::button");
    By confirmDelete = By.xpath("//button[normalize-space()='Yes, Delete']");
	By userRole = By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[1]/label");
	By admin = By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]");
	By status = By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]");
	By employeeNameInput = By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[1]/label");
	By autoSuggestion = By.xpath("//div[@role='listbox']//span");


	public AdminPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitUtils(driver);
		this.explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickAdd() {
		wait.waitForClickable(addBtn);
		driver.findElement(addBtn).click();
	}

	public void selectuserRole() {
		wait.waitForClickable(userRole);
		driver.findElement(userRole).click();
		wait.waitForClickable(admin);
		driver.findElement(admin).click();
	}

	public void selectstatus() {
		wait.waitForClickable(status);
		driver.findElement(status).click();

		By enabled = By.xpath("//span[text()='Enabled']");
		explicitWait.until(ExpectedConditions.elementToBeClickable(enabled)).click();
	}

	public void enterEmployeeName(String name) {
		WebElement input = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameInput));
		input.clear();
		input.sendKeys(name);
		WebElement suggestion = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(autoSuggestion));
		explicitWait.until(ExpectedConditions.elementToBeClickable(suggestion)).click();
	}

	public void searchUser(String user) {
		wait.waitForClickable(usernameSearch);
		WebElement input = driver.findElement(usernameSearch);
		input.sendKeys(user);
		wait.waitForClickable(searchBtn);
		driver.findElement(searchBtn).click();
	}

	public void deleteUser() {
		explicitWait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
		explicitWait.until(ExpectedConditions.elementToBeClickable(confirmDelete)).click();
	}
}