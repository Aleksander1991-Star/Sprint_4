import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.MainPage;

public class TestFAQAnswersText {
    private WebDriver driver;

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void answerCoast() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openSite();
        mainPage.scrollBlockFaq();
        mainPage.clickTextQuestionCoast();
        mainPage.checkTextAnswerCoast("Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
    }
    @Test
    public void answerFewScooters() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openSite();
        mainPage.scrollBlockFaq();
        mainPage.clickQuestionFewScooters();
        mainPage.checkTextAnswerFewScooters("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
    }

    @Test
    public void answerTimeRent() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openSite();
        mainPage.scrollBlockFaq();
        mainPage.clickQuestionTimeRent();
        mainPage.checkTextAnswerTimeRent("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
    }

    @Test
    public void answerRentToday() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openSite();
        mainPage.scrollBlockFaq();
        mainPage.clickQuestionRentToday();
        mainPage.checkTextAnswerRentToday("Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
    }

    @Test
    public void answerExtendOrReturn() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openSite();
        mainPage.scrollBlockFaq();
        mainPage.clickQuestionExtendOrReturn();
        mainPage.checkTextAnswerExtendOrReturn("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
    }

    @Test
    public void answerAboutCharger() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openSite();
        mainPage.scrollBlockFaq();
        mainPage.clickQuestionAboutCharger();
        mainPage.checkTextAnswerAboutCharger("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
    }

    @Test
    public void answerDenyOrder() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openSite();
        mainPage.scrollBlockFaq();
        mainPage.clickQuestionDenyOrder();
        mainPage.checkTextAnswerDenyOrder("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
    }

    @Test
    public void answerDeliveryOutsideMKAD() {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openSite();
        mainPage.scrollBlockFaq();
        mainPage.clickQuestionDeliveryOutsideMKAD();
        mainPage.checkTextAnswerDeliveryOutsideMKAD("Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }

}

