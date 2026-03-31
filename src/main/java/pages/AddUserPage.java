package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddUserPage {

    WebDriver driver;
    WebDriverWait wait;

    By userRoleDropdown = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
    By adminOption = By.xpath("//div[@role='listbox']//span[text()='Admin']");
    By statusDropdown = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
    By enabledOption = By.xpath("//div[@role='listbox']//span[text()='Enabled']");
    
    By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");
    By autoSuggestion = By.xpath("//div[@role='listbox']//span");
    
    By username = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By password = By.xpath("(//input[@type='password'])[1]");
    By confirmPassword = By.xpath("(//input[@type='password'])[2]");
    By saveBtn = By.xpath("//button[normalize-space()='Save']");

    public AddUserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillUserDetails(String empName, String user, String pass) {
        // 1. Select User Role
        driver.findElement(userRoleDropdown).click();
        wait.until(ExpectedConditions.elementToBeClickable(adminOption)).click();

        // 2. Select Status
        driver.findElement(statusDropdown).click();
        wait.until(ExpectedConditions.elementToBeClickable(enabledOption)).click();

        // 3. Enter Employee Name and Click Suggestion (Fixes the "Invalid" error)
        WebElement empInput = driver.findElement(employeeNameInput);
        empInput.clear(); // Clears any existing text to prevent concatenation
        empInput.sendKeys(empName);
         WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(autoSuggestion));
        suggestion.click();

        // 4. Enter Credentials
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);
        
        // 5. Save
        driver.findElement(saveBtn).click();
    }
}