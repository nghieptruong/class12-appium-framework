package utils;

import drivers.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class PlatformUtils {

    public static boolean isAndroid() {
        AppiumDriver driver = DriverFactory.getDriver();
        if(driver instanceof AndroidDriver) {
            return true;
        } else {
            return false;
        }
    }
}
