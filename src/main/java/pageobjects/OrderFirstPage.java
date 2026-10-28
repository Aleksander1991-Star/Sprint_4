package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderFirstPage {
    private WebDriver driver;

    public OrderFirstPage(WebDriver driver) {
        this.driver = driver;
    }

    // здесь будут находиться локаторы
    // Поле имя.
    private final By FieldName = By.xpath(".//input[@placeholder = '* Имя']");

    // Поле фамилия.
    private final By FieldSurname = By.xpath(".//input[@placeholder = '* Фамилия']");

    // Поле адрес.
    private final By FieldAddress = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");

    // Поле с выпадающим списком станций метро.
    private final By DropdownListMetro = By.className("select-search__value");

    // Значение в списке станций метро - "Ясенево".
    private final By ListMetro = By.xpath(".//div[text()='Ясенево']");

    // Поле с номером телефона.
    private final By FieldPhoneNumber = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");

    // Кнопка "Далее".
    private final By OrderButtonNext = By.xpath(".//button[text()='Далее']");

    // Заголовок "Для кого самокат".
    private final By HeaderFirstPageOrder = By.xpath(".//div[@class='Order_Header__BZXOb' and text()='Для кого самокат']");


    // здесь будут находиться методы
    public void fillInFieldName(String name) {
        driver.findElement(FieldName).sendKeys(name);
    }

    public void fillInFieldSurname(String surname) {
        driver.findElement(FieldSurname).sendKeys(surname);
    }

    public void fillInFieldAddress(String address) {
        driver.findElement(FieldAddress).sendKeys(address);
    }

    public void clickDropdownListMetro() {
        driver.findElement(DropdownListMetro).click();
    }

    public void chooseStationMetro(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(ListMetro)));
        driver.findElement(ListMetro).click();
    }

    public void fillInFieldPhone(String phoneNumber){
        driver.findElement(FieldPhoneNumber).sendKeys(phoneNumber);
    }

    public OrderSecondPage clickOrderButtonNext() {
        driver.findElement(OrderButtonNext).click();
        return new OrderSecondPage(driver);
    }

    public boolean checkHeaderFirstPageOrderDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(HeaderFirstPageOrder));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

}
