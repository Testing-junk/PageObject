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
            genderFemale = $("[for=gender-radio-2]"),
            genderOther = $("[for=gender-radio-3]"),
            numberInput = $("#userNumber"),
            addressInput = $("#currentAddress"),
            resultsTable = $(".table-responsive"),
            subjectsInput = $("#subjectsInput"),
            hobbySelectionSports = $(byText("Sports")),
            hobbySelectionReading = $(byText("Reading")),
            hobbySelectionMusic = $(byText("Music")),
            uploadButton = $("#uploadPicture"),
            stateScrolling = $("#state"),
            stateAndCitySelection = $("#stateCity-wrapper"),
            cityScrolling = $("#city"),
            submitButton = $("#submit");

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
            {genderSelection = genderFemale;
            genderSelection.click();
        }
        else if (gender.equalsIgnoreCase("Other"))
            {genderSelection = genderOther;
            genderSelection.click();
        }
        else
            genderSelection.click();

        return this;
    }

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


    public RegistrationPage uploadFile(String filename) {
        uploadButton.uploadFromClasspath(filename);
        return this;
    }

    public RegistrationPage typeAddress(String userAddress) {
            addressInput.setValue(userAddress);
        return this;
    }

    public RegistrationPage selectState(String userState) {
            stateScrolling.scrollTo().click();
            stateAndCitySelection.$(byText(userState)).click();
        return this;
    }

    public RegistrationPage selectCity(String userCity) {
            cityScrolling.click();
            stateAndCitySelection.$(byText(userCity)).click();
        return this;
    }

    public RegistrationPage pressSubmit() {
            submitButton.click();
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

