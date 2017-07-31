package williamhill.sports.pageobjects.centermain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import williamhill.sports.pageobjects.rightsidebar.BetSlip;

import java.util.List;

/**
 * This page object is for interacting with the sport events
 */
public class Events {
    private WebDriver driver;

    private static final By ARTICLES_LIST = By.cssSelector(".event-container article");
    private static final By EVENTS_LIST = By.cssSelector(".event");
    private static final By EVENT_BET_OPTIONS = By.cssSelector(".btmarket__actions div");

    public Events(WebDriver _driver) {
        this.driver = _driver;
    }

    /**
     * Gets all the displayed articles (an article is a collection of events)
     *
     * @return A list of WebElements of all the articles
     */
    public List<WebElement> getAllArticlesList() {
        return driver.findElements(ARTICLES_LIST);
    }

    /**
     * Gets an article by its index
     *
     * @param index The chosen article index
     * @return WebElement for the chosen article
     */
    public WebElement getArticleFromListByIndex(int index) {
        return this.getAllArticlesList().get(index);
    }

    /**
     * Gets all the events for an article by article index
     *
     * @param index The index of the chosen article
     * @return A list of WebElements of all events for the chosen article
     */
    public List<WebElement> getAllEventsForAnArticleByIndex(int index) {
        return this.getArticleFromListByIndex(index).findElements(EVENTS_LIST);
    }

    /**
     * Clicks on a bet option (home, draw, away) for an event in an article by indexes.
     * Be aware that not all events have 3 betting options so the indexes can change.
     * This method will also wait for the number of bets to increase by 1 after adding a new bet
     *
     * @param articleIndex The index of the chosen article
     * @param eventIndex   The index of the chosen event
     * @param betIndex     The index of the chosen bet option (e.g. 0->home, 1->draw, 2->away)
     */
    public void betOnEventByArticleEventOptionIndexes(int articleIndex, int eventIndex, int betIndex) {
        BetSlip betSlip = new BetSlip(driver);
        int initialBetsInBetSlip = betSlip.getNumberOfBetsInBetSlip();
        this.getAllEventsForAnArticleByIndex(articleIndex).get(eventIndex).findElements(EVENT_BET_OPTIONS).get(betIndex).click();
        // wait for the number of bets in bet slip to increase by 1
        int neededNumberOfBets = initialBetsInBetSlip + 1;
        betSlip.waitForNumberOfBetsInBetSlip(neededNumberOfBets);
    }
}
