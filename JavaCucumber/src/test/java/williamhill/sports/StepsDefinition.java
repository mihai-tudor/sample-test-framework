package williamhill.sports;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import williamhill.sports.pageobjects.Header;
import williamhill.sports.pageobjects.centermain.Coupons;
import williamhill.sports.pageobjects.centermain.Events;
import williamhill.sports.pageobjects.leftsidebar.AllSports;
import williamhill.sports.pageobjects.rightsidebar.BetSlip;

import java.io.File;
import java.text.ParseException;

public class StepsDefinition {

    private WebDriver driver;
    private Header header;
    private BetSlip betSlip;
    private Double initialBalance;
    private Double betStakeValue;

    @Before
    public void beforeScenario() {
        // TODO add a browser management tool
        final File file = new File("D:/Workspace/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        // UK Proxy, in Romania williamhill.com domain is blocked
        // if the domain is not blocked in you country, performance reasons, fell free to remove the proxy
        // don't forget to remove "cap" from line "driver = new ChromeDriver(cap);"
        String PROXY = "51.15.4.132:3128";
        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
        proxy.setHttpProxy(PROXY).setFtpProxy(PROXY).setSslProxy(PROXY);
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.PROXY, proxy);

        //new chrome driver with proxy capabilities
        driver = new ChromeDriver(cap);
        //maximize the browser
        driver.manage().window().maximize();
    }

    @Given("^User navigates to Williamhill Sports$")
    public void User_navigates_to_Williamhill_Sports() {
        // open sports.williamhill.com with white list cookie
        driver.get("https://sports.williamhill.com/sr-admin-set-white-list-cookie.html");
    }

    @Given("^I am logged in with username ([^\"]*) and password ([^\"]*)$")
    public void i_am_logged_in_with_username_and_password(String username, String password) throws ParseException {
        // I couldn't login with WHATA_FOG2 / F0gUaTtest (maybe because of the proxy) so I've created a new account
        header = new Header(driver);
        // using the wrapper function to enter user, password and press the login,
        // it will also wait for the user balance to contain an amount, it's the last thing that occurs on login
        header.loginWithUserAndPass(username, password);
        // store the credit amount, it will be used in the final step
        initialBalance = header.getUserBalanceDouble();
        // check if the header has a specific logged in element
        Assert.assertTrue(header.isLoggedIn());
    }

    @When("^I navigate to a ([^\\\"]*) event$")
    public void i_navigate_to_a_football_event(String sport) {
        AllSports allSports = new AllSports(driver);
        // search for the chosen sport and click on the li element
        // openSportFromList() uses a map to get the id attribute for each sport
        // I did not used getText().toContain("Football") to identify the li element because I want the test to work on any language
        allSports.openSportFromList(sport);
        // check if the selected sport appears "active" in the list
        Assert.assertTrue(allSports.sportItemIsActiveInList(allSports.getSportLiElementByName(sport)));
    }

    @And("^I add the first active selection to the bet slip$")
    public void i_add_the_first_active_selection_to_the_bet_slip() {
        Coupons coupons = new Coupons(driver);
        // I decided to use the coupons section to get events because "In Play" and "Highlights" are not always available
        // It will click on the first Coupon in the list
        Events events = coupons.openCouponItemFromListByIndex(0);
        // the next function will click on the first bet option (probably "Home")
        // the idea is to be able to click on any bet option from any event in any article
        // E.g. for football: an article can be "US Major League Soccer", an event can be "Colorado v Vancouver"
        // and betting options are 0 - Home, 1 - Draw, 2 - Away
        // This method will add a new bet in the bet slip and it will also wait for the number of bets to increase by 1
        events.betOnEventByArticleEventOptionIndexes(0, 0, 0);

        betSlip = new BetSlip(driver);
        // because I only added 1 bet I should have 1 bet in the bet slip
        Assert.assertEquals(betSlip.getNumberOfBetsInBetSlip(), 1);
    }

    @And("^I make a bet of (\\d*\\.?\\d+) in bet slip$")
    public void i_make_a_bet_of_in_bet_slip(String betValue) {
        // add a bet value for a chosen bet in the bet slip, in this case, we only have one so the index is 0
        betSlip.typeBetValueByIndex(betValue, 0);
        // check if the typed bet value is written in the input
        Assert.assertTrue(betSlip.getBetValueByIndex(0).contentEquals(betValue));
    }

    @Then("^I should have To Return value on the bet receipt$")
    public void i_should_have_To_Return_value_on_the_bet_receipt() throws ParseException {
        // check that the "To Return" value is not null, getToReturnValue() will return null if getText() is empty
        Assert.assertNotNull(betSlip.getToReturnValue());
    }

    @And("^I should have Total Stake value on the bet receipt$")
    public void i_should_have_Total_Stake_value_on_the_bet_receipt() throws ParseException {
        // store the stake value, it will be used in the final step
        betStakeValue = betSlip.getTotalStakeValue();
        // check that the "Total Stake" value is not null, getTotalStakeValue() will return null if getText() is empty
        Assert.assertNotNull(betStakeValue);
    }

    @And("^The user balance should be updated$")
    public void the_user_balance_should_be_updated() throws ParseException {
        // check it the initial balance minus the bet stake equals the balance displayed in the UI header
        Assert.assertEquals(header.getUserBalanceMinusStake(initialBalance, betStakeValue), header.getUserBalanceDouble());
    }

    @After
    public void afterScenario() {
        // close the browser after each scenario
        driver.close();
    }
}