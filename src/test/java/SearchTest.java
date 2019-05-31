import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchTest {

    private WebDriver driver;

//     my function which includes delays
    private void waitt(int timee) {
        try {Thread.sleep(timee);}
        catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/miki/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

//    @After
//        public void tearDown() {
//        driver.quit();}


// *************** Exercise 1 ***************

    @Test
    public void loginTest() {
        driver.get("https://men-men-s-01.codersguru.pl/");
        driver.findElement(By.cssSelector("button.header__button")).click();


        assertEquals("Zaloguj się", driver.findElement(By.cssSelector("h1.registration__header.header")).getText());

    }


    @Test
    public void pricesTest() {
        driver.get("https://men-men-s-01.codersguru.pl/");
        List<WebElement> lstPrices = driver.findElements(By.xpath("//ul//li//a"));
        lstPrices.get(1).click();

        assertEquals("Cennik", driver.findElement(By.cssSelector("h1.pricing__header")).getText());


    }

    @Test
      public void howItWorksTest() {
            driver.get("https://men-men-s-01.codersguru.pl/");
            List<WebElement> lstHowItWorks = driver.findElements(By.xpath("//ul//li//a"));
            lstHowItWorks.get(0).click();

            assertEquals("Jak działamy?", driver.findElement(By.cssSelector("h2.main-page-how-it-works__heading")).getText());

        }

    @Test
    public void setAccountTest() {
        driver.get("https://men-men-s-01.codersguru.pl/");
        WebElement element = driver.findElement(By.xpath("//input[@class='link main-page-top__email-input-sent']"));
        element.click();

        assertEquals("Zarejestruj się", driver.findElement(By.cssSelector("h1.registration__header.header")).getText());

    }


    @Test
    public void contactTest() {
        driver.get("https://men-men-s-01.codersguru.pl/");
        WebElement element = driver.findElement(By.linkText("kontakt@codersguru.pl"));
        element.click();

        if (element.isDisplayed()) {
            System.out.println("Yes, link is there");
        } else {
            System.out.println("Missing link");
        }
    }


    @Test
    public void statuteTest() {
        driver.get("https://men-men-s-01.codersguru.pl/");
        driver.findElement(By.linkText("Regulamin")).click();

        assertEquals("§1 POSTANOWIENIA OGÓLNE", driver.findElement(By.className("regulations__subheading")).getText());

        }


    @Test
    public void howItWorks2Test() {
        driver.get("https://men-men-s-01.codersguru.pl/");
        List<WebElement> lstHowItWorks2 = driver.findElements(By.xpath("//a[@class='link link--grey']"));
        lstHowItWorks2.get(1).click();

        assertEquals("Jak działamy?", driver.findElement(By.cssSelector("h2.main-page-how-it-works__heading")).getText());

        }


    @Test
    public void facebookTest() {
        driver.get("https://men-men-s-01.codersguru.pl/");
        driver.findElement(By.xpath("//img[@alt='facebook icon']")).click();

        assertEquals("Zaloguj się do Facebooka", driver.findElement(By.className("_cqp")).getText());
    }


    @Test
    public void coderslabLinkTest() {
        driver.get("https://men-men-s-01.codersguru.pl/");
        WebElement element = driver.findElement(By.xpath("//a[@href='https://coderslab.pl/pl']"));
        element.click();

        ArrayList<String> availableWindows = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(availableWindows.get(1));

        waitt(5000);  // my function which includes delay; WebDriverWait wait does not work for unknown reason

        String currentUrl = driver.getCurrentUrl();

        assertEquals(currentUrl, "https://coderslab.pl/pl");
    }


// *************** Optional tests to check how CodersLab page works if opened directly ***************

    @Test
    public void coderslabPageTest1() {

        driver.get("https://coderslab.pl/pl");

        WebDriverWait wait = new WebDriverWait(driver, 5);
            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("OFERTA KURSÓW")));
            searchButton.click();
    }

    @Test
    public void coderslabPageTest2() {

        driver.get("https://coderslab.pl/pl");
        driver.findElement(By.linkText("KURS ZDALNY")).click();

    }


} // end of public class SearchTest






