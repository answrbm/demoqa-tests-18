import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    public static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    public void fillFormTest() {
        open("/automation-practice-form");

        SelenideElement firstNameInput = $("#firstName").scrollTo();
        firstNameInput.setValue("Adam");

        SelenideElement lastNameInput = $("#lastName");
        lastNameInput.setValue("Smith");

        SelenideElement userEmailInput = $("#userEmail");
        userEmailInput.setValue("test@mail.com");

        SelenideElement maleRadio = $("#gender-radio-1");
        maleRadio.parent().click();

        SelenideElement userNumberInput = $("#userNumber");
        userNumberInput.setValue("1234567890");

        SelenideElement birthDateInput = $("#dateOfBirthInput");
        birthDateInput.click();

        SelenideElement birthMonthSelect = $(".react-datepicker__month-select");
        birthMonthSelect.selectOption("January");

        SelenideElement birthYearSelect = $(".react-datepicker__year-select");
        birthYearSelect.selectOption("1998");

        SelenideElement birthDaySelect = $(".react-datepicker__day.react-datepicker__day--015");
        birthDaySelect.click();

        SelenideElement subjectsInput = $("#subjectsInput").scrollTo();
        subjectsInput.click();
        subjectsInput.setValue("Maths");
        subjectsInput.pressEnter();

        SelenideElement sportCheckbox = $("#hobbies-checkbox-1");
        sportCheckbox.parent().click();

        SelenideElement uploadPictureInput = $("#uploadPicture");
        uploadPictureInput.uploadFile(new File("/Users/ansarbektassov/Desktop/Screenshot 2024-05-02 at 15.59.32.png"));

        SelenideElement currentAddressInput = $("#currentAddress").scrollTo();
        currentAddressInput.setValue("My address");

        SelenideElement stateSelect = $("#state");
        stateSelect.click();
        SelenideElement stateOption = $("#react-select-3-option-0");
        stateOption.click();

        SelenideElement citySelect = $("#city");
        citySelect.click();
        SelenideElement cityOption = $("#react-select-4-option-0");
        cityOption.click();

        SelenideElement submitButton = $("#submit").scrollTo();
        submitButton.click();

        SelenideElement tableWindow = $(".table");

        tableWindow.shouldHave(text("Adam Smith"), text("test@mail.com"), text("1234567890"), text("15 January,1998"),
                text("Maths"), text("Sports"), text("Screenshot 2024-05-02 at 15.59.32.png"), text("My address"), text("NCR Delhi"));
    }
}
