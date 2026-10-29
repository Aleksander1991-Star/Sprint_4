import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pageobjects.MainPage;
import pageobjects.OrderFirstPage;
import pageobjects.OrderSecondPage;


import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TestOrder {
    private WebDriver driver;

    String name;
    String surname;
    String address;
    String phoneNumber;
    String calendarDate;
    String comment;

    public TestOrder(String name, String surname, String address, String phoneNumber, String calendarDate, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.calendarDate = calendarDate;
        this.comment = comment;
    }
    @Parameterized.Parameters
    public static Object[][] enterInformation() {
        return new Object[][] {
                {"Иван", "Иванов", "Новоясеневский проспект, 22к1", "89294453421", "29.10.2026", "к 20.00"},
                {"Петр", "Петров", "Литовский бульвар, 15к1", "89165436532", "28.10.2026", "как можно скорее"}
        };
    }

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void testOrderByTopButton() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        OrderFirstPage orderFirstPage = new OrderFirstPage(driver);
        OrderSecondPage orderSecondPage = new OrderSecondPage(driver);
        mainPage.openSite();
        mainPage.clickOrderTopButton();

        orderFirstPage.fillInFieldName(name);
        orderFirstPage.fillInFieldSurname(surname);
        orderFirstPage.fillInFieldAddress(address);
        orderFirstPage.clickDropdownListMetro();
        orderFirstPage.chooseStationMetro();
        orderFirstPage.fillInFieldPhone(phoneNumber);
        orderFirstPage.clickOrderButtonNext();

        orderSecondPage.typeFieldCalendarDate(calendarDate);
        orderSecondPage.clickDropdownListRentPeriod();
        orderSecondPage.pickRentPeriodTwoDays();
        orderSecondPage.chooseScooterColourGrey();
        orderSecondPage.fillInFieldComment(comment);
        orderSecondPage.clickOrderButton();
        orderSecondPage.clickOrderButtonYes();
        assertTrue(orderSecondPage.checkConfirmationNewOrderDisplayed());
    }

}
