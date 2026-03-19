package drivers;

import io.appium.java_client.AppiumDriver;

public class DriverFactory {

    private static ThreadLocal<AppiumDriver> driverThreadLocal = new ThreadLocal<>();

    public static void setDriverThreadLocal(AppiumDriver driver) {
        driverThreadLocal.set(driver);
    }

    public static AppiumDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void removeDriverThreadLocal() {
        driverThreadLocal.remove();
    }
}
