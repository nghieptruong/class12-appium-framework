package pages.abstracts;

import org.openqa.selenium.WebDriver;

public abstract class LoginPage extends CommonPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public abstract void enterAccount(String accountName);

    public abstract void enterPassword(String password);

    public abstract void clickLoginButton();

}
