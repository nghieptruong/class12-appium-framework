package pages.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.abstracts.LoginPage;

public class AndroidLoginPage extends LoginPage {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"com.saucelabs.mydemoapp.android.*:id/nameET\")")
    WebElement txtUserName;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"com.saucelabs.mydemoapp.android.*:id/passwordET\")")
    WebElement txtPassword;

    @AndroidFindBy(accessibility = "Tap to login with given credentials")
    WebElement btnLogin;

    public AndroidLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public void enterAccount(String accountName) {
        inputText(txtUserName, accountName);
    }

    @Override
    public void enterPassword(String password) {
        inputText(txtPassword, password);
    }

    @Override
    public void clickLoginButton() {
        click(btnLogin);
    }
}
