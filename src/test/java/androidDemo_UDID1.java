import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class androidDemo_UDID1 {
    UiAutomator2Options options;
    AndroidDriver driver;

    @BeforeMethod()
    public void setUp() throws MalformedURLException, InterruptedException {

//        Test on Local -------------------------------------------------------
//        options = new UiAutomator2Options().setAppPackage("com.swaglabsmobileapp").setAppActivity("com" +
//                ".swaglabsmobileapp.MainActivity").setUdid("THE-UDID-OF-DEVICE").setApp("/Users/stdcheers/IdeaProjects" +
//                "/aws-appium-devicefarm-demo/apks/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        // AWS Device Farm  -------------------------------------------------------
        // Wait for 5 seconds before starting a new session
        Thread.sleep(5000);
        UiAutomator2Options options = new UiAutomator2Options();
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity(".MainActivity");
        options.setAutomationName("UIAutomator2");

        // Force Appium to relaunch the app for each test
        options.setCapability("appium:forceAppLaunch", true);
        // Set timeouts for Appium server to wait for the app to launch
        options.setCapability("appium:uiautomator2ServerLaunchTimeout", 60000);
        options.setCapability("appium:uiautomator2ServerInstallTimeout", 60000);

        // AWS Device Farm uses Appium sever 1.x you have to add "/wd/hub/", don't missing "/" in the end
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"), options);
    }

    @Test(groups = {"functional"})
    public void userLoginTest1() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys("standard_user");
        driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys("secret_sauce");
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]")).isDisplayed();
    }

    @Test(groups = {"functional"})
    public void userLoginTest2() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys("standard_user");
        driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys("secret_sauce");

        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).isDisplayed();
    }

    @AfterMethod()
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            // Make sure to give some time for the local process to clean up after driver quit
            driver = null;
        }
    }
}
