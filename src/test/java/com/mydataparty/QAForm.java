package com.mydataparty;
import com.github.javafaker.Faker;
import com.mydataparty.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Selenide.sleep;

public class QAForm {
    RegistrationPage registrationPage = new RegistrationPage();
    String fileForUpload = "img/upload.txt";

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String emailAddress = faker.internet().emailAddress();
    String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    String address = faker.address().fullAddress();

    String gender = "female";
    String day = "29";
    String month = "February";
    String year = "2020";
    String subject = "Math";
    String state = "NCR";
    String city = "Delhi";

    @Test
    void reWorkFormQA(){
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(emailAddress)
                .selectGender(gender)
                .typePhoneNumber(phoneNumber)
                .setBirthDate(day,month,year)
                .typeSubjects(subject)
                .selectHobbySports()
                .selectHobbyReading()
                .selectHobbyMusic()
                .uploadFile(fileForUpload)
                .typeAddress(address)
                .selectState(state)
                .selectCity(city)
                .pressSubmit();

                // sleep(5000);

        // check result
        registrationPage.checkResults("Student Name", firstName + " " + lastName)
                        .checkResults("Student Email", emailAddress)
                        .checkResults("Gender", gender)
                        .checkResults("Date of Birth", day + " " + month + "," +year)
                        .checkResults("Subjects", subject)
                        .checkResults("Hobbies", "Sports, Reading, Music")
                        //.checkResults("Picture", fileForUpload.toString())
                        .checkResults("Address", address)
                        .checkResults("State and City", state + " " + city);

    }

}