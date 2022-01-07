package com.mydataparty.pages;

import com.codeborne.selenide.SelenideElement;
import com.mydataparty.pages.components.CalenderComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    public CalenderComponent calenderComponent = new CalenderComponent();

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderSelection = $("[for=gender-radio-1]"), // override from selectGender method for 'Female' and 'Other'.
            numberInput = $("#userNumber"),
            addressInput = $("#currentAddress"),
            resultsTable = $(".table-responsive"),
            subjectsInput = $("#subjectsInput"),
            hobbySelectionSports = $(byText("Sports")),
            hobbySelectionReading = $(byText("Reading")),
            hobbySelectionMusic = $(byText("Music")),
            uploadButton = $("#uploadPicture");
/*        .setValue("Math").pressEnter();
        var fileForUpload = new File("src/test/resources/img/upload.txt");

        $("#uploadPicture").uploadFile(fileForUpload);
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

// 2nd option
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day.react-datepicker__day--001").click();

        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();


        $("#uploadPicture").uploadFromClasspath("img/upload.txt");

        $("#currentAddress").setValue("Moscow, Zelenaya, 12-5");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();


     */



    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public RegistrationPage typeFirstName(String userFirstName){
        firstNameInput.setValue(userFirstName);
        return this;
    }

    public RegistrationPage typeLastName(String userLastName) {
        lastNameInput.setValue(userLastName);
        return this;
    }

    public RegistrationPage typeEmail(String userEmail) {
        emailInput.setValue(userEmail).pressEnter();
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        calenderComponent.setDate(day, month, year);
        return this;
    }




    public RegistrationPage selectGender(String gender) {

        if (gender.equalsIgnoreCase("Female"))
            {genderSelection = $("[for=gender-radio-2]");
            genderSelection.click();
        }
        else if (gender.equalsIgnoreCase("Other"))
            {genderSelection = $("[for=gender-radio-3]");
            genderSelection.click();
        }
        else
            genderSelection.click();

        return this;
    }

    /*
    //option  1 - if we need to put all locators into instance fields
    // add SelenideElements called genderSelectionMale, genderSelectionFemale and genderSelectionOther
    and then define method like this:
    public RegistrationPage selectGender(String gender) {

        if (gender.equalsIgnoreCase("male"))
            genderSelectionMale.click();
        else if (gender.equalsIgnoreCase("female"))
            genderSelectionFemale.click();
        else
            genderSelectionOther.click();

        return this;
    }

*/

    public RegistrationPage typePhoneNumber(String userPhoneNumber) {
            numberInput.setValue(userPhoneNumber);
        return this;
    }

    public RegistrationPage typeSubjects(String subjects){
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public RegistrationPage selectHobbySports(){
        hobbySelectionSports.click();
        return this;
    }

    public RegistrationPage selectHobbyReading(){
        hobbySelectionReading.click();
        return this;
    }

    public RegistrationPage selectHobbyMusic(){
        hobbySelectionMusic.click();
        return this;
    }


    public RegistrationPage uploadFile(File file) {
        uploadButton.uploadFile(file);
        return this;
    }

    public RegistrationPage typeAddress(String userAddress) {
            addressInput.setValue(userAddress);
        return this;
    }



  // with locators and using .parent():
    public RegistrationPage checkResults(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return this;


/*    // simple version
    public RegistrationPage checkResults(String value) {
            resultsTable.shouldHave(text(value));
        return this;
    }
*/
    }
}

