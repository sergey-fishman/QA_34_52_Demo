package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {
    @Test
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
                .state("NCR")
                .city("Delhi")
                .build();
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.typePracticeForm(student);
    }
}
