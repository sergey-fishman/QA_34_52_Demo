package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.AppManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {
    SoftAssert softAssert = new SoftAssert();

    @Test(groups = {"smoke","regress","student"})
    public void practiceFormPositiveTest(){
        List<Hobbies>hobbiesList = new ArrayList<>();
        hobbiesList.add(Hobbies.SPORTS);
        hobbiesList.add(Hobbies.MUSIC);
        Student student = Student.builder()
                .firstName("Sergio")
                .lastName("Wopper")
                .email("sir.gey@geymail.com")
                .mobile("0123456789")
                .gender(Gender.MALE)
                .dateOfBirth("02 Apr 2003")
                .subjects("Maths,Chemistry,English")
                .hobbies(hobbiesList)
                .picture("")
                .address("Dudo dotan 5")
                .state(StateCity.NCR.getState())
                .city(StateCity.NCR.getCities()[0])
                .build();
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.typePracticeForm(student);
        Assert.assertTrue(practiceFormPage.validateModalMessage
                ("Thanks for submitting the form"));
    }

    @Test(groups = {"smoke","student"})
    public void practiceFormPositiveWithSoftAssertTest(){
        List<Hobbies>hobbiesList = new ArrayList<>();
        hobbiesList.add(Hobbies.SPORTS);
        hobbiesList.add(Hobbies.MUSIC);
        Student student = Student.builder()
                .firstName("Sergio")
                .lastName("Wopper")
                .email("sir.gey@geymail.com")
                .mobile("0123456789")
                .gender(Gender.MALE)
                .dateOfBirth("02 Apr 2003")
                .subjects("Maths,Chemistry,English")
                .hobbies(hobbiesList)
                .picture("")
                .address("Dudo dotan 5")
                .state(StateCity.NCR.getState())
                .city(StateCity.NCR.getCities()[0])
                .build();
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.typePracticeForm(student);
//        softAssert.assertTrue(practiceFormPage.validateModalMessage
//                ("wrong"),"wrong test");
//        System.out.println("test working");
        softAssert.assertTrue(practiceFormPage.validateModalMessage
                ("Thanks for submitting the form"),
                "validate correct message");
        softAssert.assertTrue(getDriver().findElement
                (By.xpath("//tbody/tr[1]/td[2]"))
                .getText().contains(student.getFirstName()),
                "validate first name");
        softAssert.assertAll();
    }
}
