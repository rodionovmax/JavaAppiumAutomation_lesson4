package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

//  TestCase is a method in junit
public class CoreTestCase extends TestCase {

    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";


    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";

    @Override   //mentioning that we override parent method
    protected void setUp() throws Exception
    {
        super.setUp(); // mentioning that we use method setUp() from TestCase

        DesiredCapabilities capabilities = this.getCapabilitiesByPlatformEnv();
        this.rotateScreenPortrait();
    }

    @Override
    protected void tearDown() throws Exception
    {
        driver.quit();

        super.tearDown(); // mentioning that we use method tearDown() from TestCase
    }

    protected void rotateScreenPortrait()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void backgroundApp(int seconds)
    {
        driver.runAppInBackground(seconds);
    }

    public DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception{

        String platform = System.getenv("PLATFORM");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if(platform.equals(PLATFORM_ANDROID)) {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "AndroidTestDevice");
            capabilities.setCapability("platformVersion", "6.0");
            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("appPackage", "org.wikipedia");
            capabilities.setCapability("appActivity", "main.MainActivity");
            capabilities.setCapability("app", "/Users/rodionovmax/IdeaProjects/JavaAppiumAutomation_homework1/apks/org.wikipedia.apk");

            driver = new AndroidDriver(new URL(AppiumURL), capabilities);

        } else if(platform.equals(PLATFORM_IOS)){
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("deviceName", "iPhone 7");
            capabilities.setCapability("platformVersion", "12.2");
            capabilities.setCapability("app", "/Users/rodionovmax/Desktop/JavaAppiumAutomation/Wikipedia.app");
            capabilities.setCapability("automationName", "XCUITest");

            driver = new IOSDriver(new URL(AppiumURL), capabilities);

        } else {
            throw new Exception("Cannot get run platform from env variable. Platform value " + platform);
        }
        return capabilities;
    }

}
