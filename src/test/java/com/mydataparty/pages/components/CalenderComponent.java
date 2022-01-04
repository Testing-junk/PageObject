package com.mydataparty.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CalenderComponent {

    public void setDate(String day, String month, String year) {

/*
       //  TO DO надо попробовать сделать с этим
       $("#dateOfBirthInput").click();
        $(".react-datepicker__year-dropdown-container").find(byText("2012")).click();
        // $(".react-datepicker__year-dropdown-container").selectOption("2012");
        $(".react-datepicker__month-dropdown-container").find(byText("February")).click();
        $("[aria-label$='February 29th, 2012']").click();
*/

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        // String dayLocator = format("[aria-label$=%s %sth, %s]", month, day, year);
        // $(dayLocator).click();
        // TO DO здесь у меня aria работает, а выше - не работает !!
        // $("[aria-label$='"+ month + " " + day + "th, " + year +"']").click();
        String dayLocator = format(".react-datepicker__day--0%s" + ":not(.react-datepicker__day--outside-month)", day);
        $(dayLocator).click();

    }
}
