package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class OrderSecondPage {
    private WebDriver driver;

    public OrderSecondPage(WebDriver driver) {
        this.driver = driver;
    }


    // Поле когда привезти самокат.
    private final By FieldCalendarDate = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");

    // Поле с выпадающем списком сроков аренды.
    private final By DropdownListRentPeriod = By.xpath(".//span[@class='Dropdown-arrow']");

    // Значение в списке сроков аренды - "двое суток".
    private final By RentPeriodTwoDays = By.xpath(".//div[@role='option' and text()='двое суток']");

    // Чек-бокс цвета самоката - "серая безысходность".
    private final By ScooterColourGrey = By.id("grey");

    // Поле комментарий для курьера.
    private final By FieldComment = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");

    // Кнопка "Заказать".
    private final By OrderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']//button[contains(text(), 'Заказать')]");

    // Кнопка "Да" во всплывающем уведомлении "Хотите оформить заказ?".
    private final By OrderButtonYes = By.xpath("//div[@class='Order_Buttons__1xGrp']//button[text()='Да']");

    // Всплывающее подтверждение оформленного заказа.
    private final By ConfirmationNewOrder = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");


    public void typeFieldCalendarDate(String calendarDate) {
        driver.findElement(FieldCalendarDate).sendKeys(calendarDate);
    }

    public void clickDropdownListRentPeriod() {
        driver.findElement(DropdownListRentPeriod).click();
    }

    public void pickRentPeriodTwoDays() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(RentPeriodTwoDays)));
        driver.findElement(RentPeriodTwoDays).click();
    }

    public void chooseScooterColourGrey() {
        driver.findElement(ScooterColourGrey).click();
    }

    public void fillInFieldComment(String comment) {
        driver.findElement(FieldComment).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(OrderButton).click();
    }

    public void clickOrderButtonYes(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(OrderButtonYes)));
        driver.findElement(OrderButtonYes).click();
    }

    public boolean checkConfirmationNewOrderDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmationNewOrder));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }


}
