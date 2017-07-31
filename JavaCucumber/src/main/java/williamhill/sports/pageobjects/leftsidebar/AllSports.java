package williamhill.sports.pageobjects.leftsidebar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import williamhill.sports.utils.ActionDriverUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This page object is for interacting with the all sports area
 */
public class AllSports {
    private WebDriver driver;
    private ActionDriverUtils driverUtils;

    private static final By ALL_SPORTS_LIST = By.cssSelector("ul[data-toggle-receive=\"all-sports\"] li");

    public AllSports(WebDriver _driver) {
        this.driver = _driver;
        this.driverUtils = new ActionDriverUtils(driver);
    }

    /**
     * Gets the unique id of the element for a chosen sport by using a map
     *
     * @param sportName The chosen sport
     * @return String for the unique id of the chosen sport
     */
    public String getSportUniqueIdByName(String sportName) {
        Map<String, String> sports = new HashMap<String, String>();
        sports.put("Football", "nav-football");
        sports.put("Tennis", "nav-tennis");
        sports.put("Winter Sports", "nav-winter-sports");

        String locatorId = null;
        if (sports.containsKey(sportName)) {
            locatorId = sports.get(sportName);
        }
        sports.clear();
        return locatorId;
    }

    /**
     * Gets the li element for the chosen sport
     *
     * @param sportName The chosen sport
     * @return WebElement for the corresponding sport
     */
    public WebElement getSportLiElementByName(String sportName) {
        return driver.findElement(By.cssSelector("ul[data-toggle-receive=\"all-sports\"] #" + this.getSportUniqueIdByName(sportName)));
    }

    /**
     * Opens the chosen sport from the list (clicks on the li element)
     *
     * @param sportName The chosen sport
     */
    public void openSportFromList(String sportName) {
        this.getSportLiElementByName(sportName).click();
        driverUtils.waitUntilSpinnerIsHidden();
    }

    /**
     * Checks if the given element from the "All Sports" list is active (has the active class)
     *
     * @param sportLiElement The element to check
     * @return Returns true if it has the active class or false if it doesn't
     */
    public boolean sportItemIsActiveInList(WebElement sportLiElement) {
        return sportLiElement.findElement(By.tagName("a")).getAttribute("class").contains("c-list__item--active");
    }

    /**
     * Gets all li elements in the "All Sports" area
     *
     * @return List of all WebElements
     */
    public List<WebElement> getAllSportsList() {
        return driver.findElements(ALL_SPORTS_LIST);
    }
}
