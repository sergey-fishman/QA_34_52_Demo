package tests;

import dto.Student;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTests extends AppManager {
    @Test
    public void practiceFormPositiveTest(){
        Student student = Student.builder()
                .firstName("Sergio")
                .lastName("Wopper")
                .email("sir.gey@geymail.com")
                .mobile("0123456789")
                .gender("male")
                .dateOfBirth("22 Aug 2003")
                .subjects("Maths, Chemistry,English")
                .hobbies("sport")
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
