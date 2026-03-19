package testcases.login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageFactory;
import pages.abstracts.HomePage;
import pages.abstracts.LoginPage;
import reports.ExtentReportManager;


public class Login01_Verify_Login_Function extends BaseTest {

    @Test(description = "Verify valid login successfully")
    public void testValidLogin() {

        String username = "bod@example.com";
        String password = "10203040";

        HomePage homePage = PageFactory.getHomePage();
        LoginPage loginPage = PageFactory.getLoginPage();

        //Step 1: Click main menu
        ExtentReportManager.info("Step 1: Click main menu");
        LOG.info("Step 1: Click main menu");
        homePage.getNavigationBar().clickMainMenu();

        //Step 2: Click 'Log in' menu item
        ExtentReportManager.info("Step 2: Click 'Log in' menu item");
        LOG.info("Step 2: Click 'Log in' menu item");
        homePage.getNavigationBar().navigateToLoginPage();

        //Step 3: Enter username
        ExtentReportManager.info("Step 3: Enter username");
        LOG.info("Step 3: Enter username");
        loginPage.enterAccount(username);

        //Step 4: Enter password
        ExtentReportManager.info("Step 4: Enter password");
        LOG.info("Step 4: Enter password");
        loginPage.enterPassword(password);

        //Step 5: Click login button
        ExtentReportManager.info("Step 5: Click login button");
        LOG.info("Step 5: Click login button");
        loginPage.clickLoginButton();

        //Step 6: Verify login successfully with valid account
        ExtentReportManager.info("Step 6: Verify login successfully with valid account");
        LOG.info("Step 6: Verify login successfully with valid account");
        //VP1: Verify user is navigated to Products page
        ExtentReportManager.info("VP1: Verify user is navigated to Products page");
        LOG.info("VP1: Verify user is navigated to Products page");
        String recordedTitle = homePage.getTitle();
        Assert.assertEquals(recordedTitle, "Products", "Products title not display");

        //VP2: Verify Log out menu item displays
        ExtentReportManager.info("VP2: Verify Log out menu item displays");
        LOG.info("VP2: Verify Log out menu item displays");
        homePage.getNavigationBar().clickMainMenu();
        boolean isLogoutDisplayed = homePage.getNavigationBar().isLogoutDisplayed();
        Assert.assertTrue(isLogoutDisplayed, "Log out menu item not display");

    }
}
