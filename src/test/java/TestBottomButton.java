import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobjects.MainPage;
import pageobjects.OrderFirstPage;

import static org.junit.Assert.assertTrue;


public class TestBottomButton {
    private WebDriver driver;

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void testBottomButtonLeadToOrderPage() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        OrderFirstPage orderFirstPage = new OrderFirstPage(driver);
        mainPage.openSite();
        mainPage.scrollOrderBottomButton();
        mainPage.clickOrderBottomButton();
        assertTrue(orderFirstPage.checkHeaderFirstPageOrderDisplayed());
    }

}
