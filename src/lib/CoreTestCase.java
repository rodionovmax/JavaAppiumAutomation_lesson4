package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

//  TestCase is a method in junit
public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";

    @Override   //mentioning that we override parent method
    protected void setUp() throws Exception
    {
        super.setUp(); // mentioning that we use method setUp() from TestCase

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", "main.MainActivity");
        capabilities.setCapability("app", "/Users/rodionovmax/IdeaProjects/JavaAppiumAutomation_homework1/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL(AppiumURL), capabilities);
    }

    @Override
    protected void tearDown() throws Exception
    {
        driver.quit();

        super.tearDown(); // mentioning that we use method tearDown() from TestCase
    }
}