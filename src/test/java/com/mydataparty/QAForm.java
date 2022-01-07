package com.mydataparty;
import com.github.javafaker.Faker;
import com.mydataparty.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import java.io.File;

public class QAForm {
    RegistrationPage registrationPage = new RegistrationPage();
    File fileForUpload = new File("src/test/resources/img/upload.txt");
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String emailAddress = faker.internet().emailAddress();
    String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    String address = faker.address().fullAddress();


    @Test
    void reWorkFormQA(){
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(emailAddress)
                .selectGender("Male")
                .typePhoneNumber(phoneNumber)
                .setBirthDate("29","February","2020")
                .typeSubjects("Math")
                .selectHobbySports()
                .selectHobbyReading()
                .selectHobbyMusic()
                .uploadFile(fileForUpload)
                .typeAddress(address);

        // sleep(5000);

        // $("#state").scrollTo().click();
        // $("#stateCity-wrapper").$(byText("NCR")).click();
        // $("#city").click();
        // $("#stateCity-wrapper").$(byText("Delhi")).click();
        // $("#submit").click();


        check result
        registrationPage.checkResults("Student Name", lastName)
                        // .checkResults("Student Email", "vasja@gmail.com");


    }

}