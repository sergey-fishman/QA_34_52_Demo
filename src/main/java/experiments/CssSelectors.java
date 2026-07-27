package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

        WebElement divElements = // Ищет по первому вхождению в коде
                driver.findElement(By.cssSelector("div[class='avatar mx-auto white']"));
        divElements.click();
        pause(2000);

        driver.navigate().back();
        pause(2000);

        WebElement imgTools = driver.findElement
                (By.cssSelector("img[src='/assets/Toolsqa-DZdwt2ul.jpg']"));
        System.out.println(imgTools.getTagName()); // img
        System.out.println(imgTools.getAttribute("src"));

        driver.navigate().forward();
        pause(2000);

        driver.navigate().refresh();
        pause(2000);

        WebElement btnTextBox =
                driver.findElement(By.cssSelector("li[id='item-0']"));
        btnTextBox.click();
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
}
