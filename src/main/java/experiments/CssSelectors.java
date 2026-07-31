package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class CssSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorsHomePage() {
        driver.manage().window().maximize();
        driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/");
        pause(1000);
        hideFooter();
        pause(2000);

        WebElement divElements = // Ищет по первому вхождению в коде
                driver.findElement(By.cssSelector("div[class='avatar mx-auto white']"));
        divElements.click();
        pause(1000);

        driver.navigate().back();
        pause(1000);

        WebElement imgTools = driver.findElement
                (By.cssSelector("img[src='/assets/Toolsqa-DZdwt2ul.jpg']"));
        System.out.println(imgTools.getTagName()); // img
        System.out.println(imgTools.getAttribute("src"));

        driver.navigate().forward();
        pause(1000);
//
//        driver.navigate().refresh();
//        pause(1000);

        WebElement btnTextBox =
                driver.findElement(By.cssSelector("a[href='/text-box']"));
        btnTextBox.click();
        pause(1000);

        WebElement btnRadioButton =
                driver.findElement(By.linkText("Radio Button"));
        btnRadioButton.click();
        pause(1000);

        driver.navigate().back();
        pause(1000);
        driver.navigate().back();
        pause(1000);
        driver.navigate().back();
        pause(1000);

        scrollActions();
        WebElement btnBookStore =
                driver.findElement(By.cssSelector("div.category-cards a:last-child"));
        btnBookStore.click();
        pause(1000);
        driver.navigate().back();
        pause(1000);

        WebElement btnForms =
                driver.findElement(By.cssSelector("div.category-cards a:nth-child(2)"));
        btnForms.click();
        pause(1000);

        driver.navigate().back();
        pause(1000);

        WebElement textInForms =
                driver.findElement(By.cssSelector("div > a:nth-child(2) > div > div > div.card-body > h5"));
        textInForms.click();
//        new WebDriverWait(driver, Duration.ofSeconds(5))
//                .until(ExpectedConditions
//                        .elementToBeClickable(driver.findElement(By.cssSelector("#item-0")))).click();

//        WebElement btnTexBox = driver.findElement(By.xpath("//li[@id='item-0']"));
//        btnTexBox.click();
        pause(2000);


        driver.quit();
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void scrollActions(){
        Actions actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            actions.scrollByAmount(0, 700).perform();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void hideFooter(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display = 'none'");
    }
}
