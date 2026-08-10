package pages;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class PracticeFormPage extends BasePage{
    public PracticeFormPage(WebDriver driver) {
        PageFactory.initElements
                (new AjaxElementLocatorFactory
                        (driver,10),this);
    }
    @FindBy(id = "firstName")
    WebElement inputFirstName;
    @FindBy(id = "lastName")
    WebElement inputLastName;
    @FindBy(id = "userEmail")
    WebElement inputUserEmail;
    @FindBy(id = "userNumber")
    WebElement inputUserNumber;
    @FindBy(id = "dateOfBirthInput")
    WebElement inputDateOfBirth;
    @FindBy(id = "currentAddress")
    WebElement textAreaCurrentAddress;
    @FindBy(id = "subjectsInput")
    WebElement inputSubjects;

    public void typePracticeForm(Student student){
        inputFirstName.sendKeys(student.getFirstName());
        inputLastName.sendKeys(student.getLastName());
        inputUserEmail.sendKeys(student.getEmail());
        chooseGender(student.getGender());
        inputUserNumber.sendKeys(student.getMobile());
//        inputDateOfBirth.click();
//        inputDateOfBirth.sendKeys(student.getDateOfBirth());
        typeDateOfBirth(student.getDateOfBirth());
        textAreaCurrentAddress.sendKeys(student.getAddress());
        typeSubjects(student.getSubjects());
        chooseHobbies(student.getHobbies());
    }

    private void chooseGender(Gender gender){
        driver.findElement(By.id(gender.getLocator())).click();
    }

    private void chooseHobbies(List<Hobbies>hobbies) {
        for (Hobbies h : hobbies){
            switch (h){
                case SPORTS -> driver.findElement
                        (By.id(h.getLocator())).click();
                case READING -> driver.findElement
                        (By.id(h.getLocator())).click();
                case MUSIC -> driver.findElement
                        (By.id(h.getLocator())).click();
            }

        }
    }

    private void typeDateOfBirth(String dateOfBirth) {
        inputDateOfBirth.click();
        String OS = System.getProperty("os.name");
        System.out.println(OS);
        if (OS.startsWith("Win"))
            inputDateOfBirth.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        if (OS.startsWith("Mac"))
            inputDateOfBirth.sendKeys(Keys.chord(Keys.COMMAND,"a"));
        inputDateOfBirth.sendKeys(dateOfBirth);
        inputDateOfBirth.sendKeys(Keys.ENTER);
    }

    private void typeSubjects(String subjects) {
        inputSubjects.click();
        String[] array = subjects.trim().split(",");
        for (String subject : array){
            inputSubjects.sendKeys(subject);
            inputSubjects.sendKeys(Keys.ENTER);
        }
    }
}
