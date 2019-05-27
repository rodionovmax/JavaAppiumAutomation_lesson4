package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;

//  TestCase is a method in junit
public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;
    protected Platform Platform;

    @Override   //mentioning that we override parent method
    protected void setUp() throws Exception
    {
        super.setUp(); // mentioning that we use method setUp() from TestCase
        this.Platform = new Platform();
        driver = this.Platform.getDriver();
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

}
