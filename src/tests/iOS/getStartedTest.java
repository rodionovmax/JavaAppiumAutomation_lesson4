package tests.iOS;

import lib.CoreTestCase;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class getStartedTest extends CoreTestCase {

    @Test
    public void testPassThroughWelcome(){

        if(this.Platform.isAndroid()){
            return;
        }
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver);

        welcomePageObject.waitForLearnMoreLink();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForNewWayToExplore();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForAddOrEditPreferLangText();
        welcomePageObject.clickNextButton();
        
        welcomePageObject.waitForLearnMoreAboutDataCollectedText();
        welcomePageObject.clickGetStartedButton();

    }
}
