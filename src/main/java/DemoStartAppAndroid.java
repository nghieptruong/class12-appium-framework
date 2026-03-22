import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DemoStartAppAndroid {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options androidOptions = new UiAutomator2Options();
        androidOptions.setPlatformName("Android");
        androidOptions.setAutomationName("UiAutomator2");
        androidOptions.setUdid("emulator-5554");
        androidOptions.setDeviceName("Pixel 9");
        androidOptions.setPlatformVersion("15");
        androidOptions.setNewCommandTimeout(Duration.ofSeconds(300));
        androidOptions.setAppPackage("com.saucelabs.mydemoapp.android");
        androidOptions.setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), androidOptions);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        String username = "bod@example.com";
        String password = "10203040";

        //Step 1: Click main menu
        By byMainMenu = AppiumBy.accessibilityId("View menu");
        WebElement mainMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(byMainMenu));
        mainMenu.click();

        //Step 2: Click 'Log in' menu item
        By byLnkLoginMenuItem = AppiumBy.androidUIAutomator("new UiSelector().text(\"Log In\")");
        WebElement lnkLoginMenuItem = wait.until(ExpectedConditions.visibilityOfElementLocated(byLnkLoginMenuItem));
        lnkLoginMenuItem.click();

        //Step 3: Enter username
        By byTxtUserName = AppiumBy.androidUIAutomator("new UiSelector().resourceIdMatches(\"com.saucelabs.mydemoapp.android.*:id/nameET\")");
        WebElement txtUserName = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtUserName));
        txtUserName.sendKeys(username);

        //Step 4: Enter password
        By byTxtPassword = AppiumBy.androidUIAutomator("new UiSelector().resourceIdMatches(\"com.saucelabs.mydemoapp.android.*:id/passwordET\")");
        WebElement txtPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(byTxtPassword));
        txtPassword.sendKeys(password);

        //Step 5: Click Login
        By byBtnLogin = AppiumBy.accessibilityId("Tap to login with given credentials");
        WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(byBtnLogin));
        btnLogin.click();

        //Step 6: Verify valid account login successfully
        //VP1: Verify user is navigated to Products page
        By byLblPageTitle = AppiumBy.accessibilityId("title");
        WebElement lblPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblPageTitle));
        String recordedTitle = lblPageTitle.getText();
        Assert.assertEquals(recordedTitle, "Products", "Products title not display");

        //VP2: Verify Log out menu item displays
        mainMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(byMainMenu));
        mainMenu.click();
        By byLnkLogoutMenuItem = AppiumBy.androidUIAutomator("new UiSelector().text(\"Log Out\")");
        WebElement lnkLogoutMenuItem = wait.until(ExpectedConditions.visibilityOfElementLocated(byLnkLogoutMenuItem));
        Assert.assertTrue(lnkLogoutMenuItem.isDisplayed(), "Log out menu item not display");

        Thread.sleep(5000);

        driver.quit();
    }
}
