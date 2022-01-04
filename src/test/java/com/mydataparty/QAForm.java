package com.mydataparty;

import com.mydataparty.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class QAForm {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test

    void reWorkFormQA(){

        registrationPage.openPage()
                .typeFirstName("Vasja")
                .typeLastName("Pupkin")
                .typeEmail("vasja@gmail.com")
                .selectGender("Male")
                .typePhoneNumber("1234567890")
                .setBirthDate("29","February","2020")
                .typeAddress("I live here.");
                                        ;

        // sleep(5000);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-dropdown-container").find(byText("2012")).click();
        // $(".react-datepicker__year-dropdown-container").selectOption("2012");
        $(".react-datepicker__month-dropdown-container").find(byText("February")).click();
        $("[aria-label='Choose Wednesday, February 29th, 2012']").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        var fileForUpload = new File("src/test/resources/img/upload.txt");

        $("#uploadPicture").uploadFile(fileForUpload);
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();


        // check result
        registrationPage.checkResults("Student Name", "Vasja Pupkin")
                        .checkResults("Student Email", "vasja@gmail.com");


    }
}