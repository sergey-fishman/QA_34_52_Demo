package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void xpathSelectors(){
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        pause(1000);
        WebElement btnForms = driver.findElement(By.xpath
                ("//a[@href='/forms']"));
        btnForms.click();
        pause(1000);

        WebElement btnElements = driver.findElement(By.xpath
                ("//span[@class='group-header']"));
        btnElements.click();
        pause(1000);

        WebElement btnTextBox = driver.findElement(By.xpath
                ("//ul[@class='menu-list']//a[@href='/text-box']"));
        btnTextBox.click();
        pause(1000);

        WebElement inputFullName = driver.findElement(By.xpath
                ("//form/div[1]/div[2]/input"));
        inputFullName.sendKeys("Sergey Sergeev");
        WebElement inputEmail = driver.findElement(By.xpath
                ("//form/div[2]/div[2]/input"));
        inputEmail.sendKeys("text.test@gmail.com");
        WebElement textCurrAddress = driver.findElement(By.xpath
                ("//form/div[3]/div[2]/textarea"));
        textCurrAddress.sendKeys("dudu-dotan 6 rishon le zion");
        WebElement textPermAddress = driver.findElement(By.xpath
                ("//form/div[4]/div[2]/textarea"));
        textPermAddress.sendKeys("aynot\n 0000\n ayanot");
        WebElement btnSubmit = driver.findElement(By.xpath
                ("//button[text()='Submit']"));
        btnSubmit.click();
        WebElement output = driver.findElement(By.xpath
                ("//*[@id='output']"));
        System.out.println(output.getText());
        pause(3000);
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
