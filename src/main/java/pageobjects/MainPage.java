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

    //Кнопка с вопросом "Сколько это стоит? И как оплатить?"
    private final By idQuestionCoast = By.id("accordion__heading-0");
    //Текст ответа на вопрос о стоимости.
    private final By textAnswerCoast = By.xpath("//div[@id='accordion__panel-0']//p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");

    //Кнопка с вопросом "Хочу сразу несколько самокатов! Так можно?"
    private final By idQuestionFewScooters = By.id("accordion__heading-1");
    //Текст ответа на вопрос о количестве самокатов.
    private final By textAnswerFewScooters = By.xpath("//div[@id='accordion__panel-1']//p[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']");

    //Кнопка с вопросом "Как рассчитывается время аренды?"
    private final By idQuestionTimeRent = By.id("accordion__heading-2");
    //Текст ответа на вопрос о времени аренды.
    private final By textAnswerTimeRent = By.xpath("//div[@id='accordion__panel-2']//p[text()='Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']");

    //Кнопка с вопросом "Можно ли заказать самокат прямо на сегодня?"
    private final By idQuestionRentToday = By.id("accordion__heading-3");
    //Текст ответа на вопрос об аренде сегодня.
    private final By textAnswerRentToday = By.xpath("//div[@id='accordion__panel-3']//p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']");

    //Кнопка с вопросом "Можно ли продлить заказ или вернуть самокат раньше?"
    private final By idQuestionExtendOrReturn = By.id("accordion__heading-4");
    //Текст ответа на вопрос о продлении и возврате.
    private final By textAnswerExtendOrReturn = By.xpath("//div[@id='accordion__panel-4']//p[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']");

    //Кнопка с вопросом "Вы привозите зарядку вместе с самокатом?"
    private final By idQuestionAboutCharger = By.id("accordion__heading-5");
    //Текст ответа на вопрос о зарядке.
    private final By textAnswerAboutCharger = By.xpath("//div[@id='accordion__panel-5']//p[text()='Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']");

    //Кнопка с вопросом "Можно ли отменить заказ?"
    private final By idQuestionDenyOrder = By.id("accordion__heading-6");
    //Текст ответа на вопрос об отмене заказа.
    private final By textAnswerDenyOrder = By.xpath("//div[@id='accordion__panel-6']//p[text()='Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']");

    //Кнопка с вопросом "Я живу за МКАДом, привезёте?"
    private final By idQuestionDeliveryOutsideMKAD = By.id("accordion__heading-7");
    //Текст ответа на вопрос о доставка за МКАД.
    private final By textAnswerDeliveryOutsideMKAD = By.xpath("//div[@id='accordion__panel-7']//p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']");




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
