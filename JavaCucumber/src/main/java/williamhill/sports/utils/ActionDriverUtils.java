package williamhill.sports.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;

public class ActionDriverUtils {
    private WebDriver driver;

    public ActionDriverUtils(WebDriver _driver) {
        this.driver = _driver;
    }

    /**
     * Checks if an element is present in DOM.
     *
     * @param locator The By locator for the element.
     * @return True or False if the element is present or not.
     */
    public boolean isPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    /**
     * Waits an amount of time for an element to be visible (displayed, not hidden). On timeout, it throws an explicit error.
     *
     * @param elementBy      The By locator for the element.
     * @param timeoutSeconds The number of seconds to wait before timeout.
     * @return The element that is now visible.
     */
    public WebElement waitForVisiblePresence(By elementBy, int timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
        } catch (org.openqa.selenium.TimeoutException e) {
            throw new Error("Timeout during waiting for visibility of: " + elementBy.toString());
        }
        return driver.findElement(elementBy);
    }

    /**
     * Waits an amount of time for an element to be present in DOM. On timeout, it throws an explicit error.
     *
     * @param elementBy      The By locator for the element.
     * @param timeoutSeconds The number of seconds to wait before timeout.
     * @return The element that is now present.
     */
    public WebElement waitForPresence(By elementBy, int timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(elementBy));
        } catch (org.openqa.selenium.TimeoutException e) {
            throw new Error("Timeout during waiting for presence of: " + elementBy.toString());
        }
        return driver.findElement(elementBy);
    }

    /**
     * Waits an amount of time for an element to have text in it. On timeout, it throws an explicit error.
     *
     * @param elementBy      The By locator for the element.
     * @param timeoutSeconds The number of seconds to wait before timeout.
     * @return The element that has text now.
     */
    public WebElement waitForTextNotEmpty(final By elementBy, int timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
            wait.until(
                    new ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver d) {
                            return d.findElement(elementBy).getText().length() != 0;
                        }
                    }
            );
        } catch (org.openqa.selenium.TimeoutException e) {
            throw new Error("Timeout during waiting for presence of: " + elementBy.toString());
        }
        return driver.findElement(elementBy);
    }

    /**
     * Waits an amount of time for an element to be hidden (not displayed but present in DOM). On timeout, it throws an explicit error.
     *
     * @param elementBy      The By locator for the element.
     * @param timeoutSeconds The number of seconds to wait before timeout.
     * @return The element that is now hidden.
     */
    public WebElement waitForHiddenPresence(By elementBy, int timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
        } catch (org.openqa.selenium.TimeoutException e) {
            throw new Error("Timeout during waiting for element " + elementBy.toString() + "to be hidden.");
        }
        return driver.findElement(elementBy);
    }

    /**
     * Waits until de loading overlay disappears.
     */
    public void waitUntilSpinnerIsHidden() {
        this.waitForHiddenPresence(By.id("wh-global-overlay"), 20);
    }

    /**
     * An ExpectedCondition that checks if the number of elements in the page has reached the wanted number.
     *
     * @param locator                The selector for the elements.
     * @param numberOfWantedElements The expected number of elements.
     * @return True if the condition is met.
     */
    public ExpectedCondition<Boolean> numberOfElements(final By locator, final int numberOfWantedElements) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElements(locator).size() == numberOfWantedElements;
            }
        };
    }

    /**
     * Waits for the number of elements for a selector to reach a specified number.
     *
     * @param elementsBy             The selector for the elements to wait.
     * @param numberOfWantedElements The expected number of elements.
     * @param timeoutSeconds         The number of seconds to wait before timeout.
     * @return True if the condition is met of throws a TimeoutException.
     */
    public boolean waitForNumberOfElements(By elementsBy, int numberOfWantedElements, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
        return wait.until(this.numberOfElements(elementsBy, numberOfWantedElements));
    }

    /**
     * Converts the displayed UI currency in Double format. It also removes any character that it's not a number or a dot (like currency symbols).
     *
     * @param uiCurrency The text extracted from the UI element.
     * @return The currency in Double format.
     * @throws ParseException When pareDouble is unable to parse the string.
     */
    public Double convertCurrencyUiFormatToDouble(String uiCurrency) throws ParseException {
        return Double.parseDouble(uiCurrency.replaceAll("[^\\d\\.]", ""));
    }
}
