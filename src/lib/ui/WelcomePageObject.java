package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject {

    public WelcomePageObject(AppiumDriver driver){
        super(driver);
    }

    private static final String
        STEP_LEARN_MORE_LINK = "//XCUIElementTypeButton[@name='Learn more about Wikipedia']",
        STEP_NEW_WAYS_TO_EXPLORE_TEXT = "New ways to explore",
        STEP_ADD_OR_EDIT_PREFFERED_LANG_LINK = "Add or edit preferred languages",
        LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "Learn more about data collected",
        NEXT_LINK = "//XCUIElementTypeButton[@name='Next']",
        GET_STARTED_BUTTON = "Get started";

    public void waitForLearnMoreLink(){
        this.waitForElementPresent(By.xpath(STEP_LEARN_MORE_LINK),
                "Cannot find 'Learn more about Wikipedia' link", 10);
    }

    public void waitForNewWayToExplore(){
        this.waitForElementPresent(By.id(STEP_NEW_WAYS_TO_EXPLORE_TEXT),
                "Cannot find 'New ways to explore' link", 10);
    }

    public void waitForAddOrEditPreferLangText(){
        this.waitForElementPresent(By.id(STEP_ADD_OR_EDIT_PREFFERED_LANG_LINK),
                "Cannot find 'Add or edit preferred languages' link", 10);
    }

    public void waitForLearnMoreAboutDataCollectedText(){
        this.waitForElementPresent(By.id(LEARN_MORE_ABOUT_DATA_COLLECTED_LINK),
                "Cannot find 'Learn more about data collected' link", 10);
    }

    public void clickNextButton(){
        this.waitForElementAndClick(By.xpath(NEXT_LINK),
                "Cannot find and click 'Next' button", 10);
    }

    public void clickGetStartedButton(){
        this.waitForElementAndClick(By.id(GET_STARTED_BUTTON),
                "Cannot find and click 'Get started' button", 10);
    }




}
