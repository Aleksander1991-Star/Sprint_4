package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
}

// здесь будут находиться локаторы

    //Верхняя кнопка "Заказать".
    private final By orderTopButton = By.className("Button_Button__ra12g");

    //Нижняя кнопка "Заказать".
    private final By orderBottomButton = By.xpath("//div[@class='Home_FinishButton__1_cWm']//button[contains(text(), 'Заказать')]");

    //Блок с разделом "Вопросы о важном".
    private final By blockFaq = By.className("Home_FourPart__1uthg");



    // здесь будут находиться методы
public void openSite() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        if (driver.findElement(By.id("rcc-confirm-button")).isDisplayed())
            driver.findElement(By.id("rcc-confirm-button")).click();
    }

    public OrderFirstPage clickOrderTopButton() {
        driver.findElement(orderTopButton).click();
        return new OrderFirstPage(driver);
    }

    public void scrollBlockFaq() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(blockFaq));
    }

    public void scrollOrderBottomButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderBottomButton));
    }

    public OrderFirstPage clickOrderBottomButton() {
        driver.findElement(orderBottomButton).click();
        return new OrderFirstPage(driver);
    }

    public void clickQuestionByIndex(int index) {
        By question = By.id("accordion__heading-" + index);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(question))
                .click();
    }

    public String getAnswerTextByIndex(int index) {
        By answer = By.xpath("//div[@id='accordion__panel-" + index + "']//p");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(answer));
        return driver.findElement(answer).getText();
    }

}
