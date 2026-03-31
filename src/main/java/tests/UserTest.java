package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.AddUserPage;
import pages.DashboardPage;
import pages.LoginPage;

public class UserTest extends BaseTest {

	@Test(dataProvider = "userData")
	public void fullUserFlow(String username, String password) throws InterruptedException {

		String newUser = "Mahmoud"; 
		String employeeToSearch = "a";  

		// Step 1: Login
		LoginPage login = new LoginPage(driver);
		login.login(username, password);

		// Step 2: Validate that login done successfully
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login Failed!");

		// Step 3: Navigate to Admin module
		wait.waitForURLContains("dashboard");
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.goToAdmin();

		// Step 4: Click Add User
		AdminPage admin = new AdminPage(driver);
		admin.clickAdd();

		// Step 5: Create new user with valid details
		AddUserPage addUser = new AddUserPage(driver);
		addUser.fillUserDetails(employeeToSearch, newUser, "Password123!");


		// Step 6: Search for the created user
		Thread.sleep(8000);
		admin.searchUser(newUser);

		// Step 7: Verify user existence in records
		Thread.sleep(2000);
		Assert.assertTrue(driver.getPageSource().contains(newUser), "User NOT found after creation!");

		// Step 8: Remove the user record
		admin.deleteUser();

		// Step 9: Log out from the system
		dashboard.logout();

		// Step 10: Verify logout redirection
		Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Logout Failed!");
	}

	@DataProvider(name = "userData")
	public Object[][] getData() {
		return new Object[][] {
			{"Admin", "admin123"}
		};
	}
}