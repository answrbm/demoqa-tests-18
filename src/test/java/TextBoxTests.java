import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    public static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        //https://demoqa.com/text-box
        open("/text-box");

        SelenideElement userNameInput = $("[id=userName]").setValue("Adam Smith");
//        $("[#userName]").setValue("Adam Smith");

        SelenideElement userEmailInput = $("[id=userEmail]").scrollTo();
        userEmailInput.setValue("adamsmith@mail.com");
        SelenideElement currentAddressInput = $("[id=currentAddress]").scrollTo();
        currentAddressInput.setValue("Some address 1");
        SelenideElement permanentAddressInput = $("[id=permanentAddress]").scrollTo();
        permanentAddressInput.setValue("Some address 2");
        SelenideElement submitButton = $("[id=submit]").scrollTo();
        submitButton.click();

        SelenideElement outputBox = $("[id=output]").scrollTo();
        outputBox.shouldHave(text("Adam Smith"), text("adamsmith@mail.com"), text("Some address 1"),
                text("Some address 2"));
    }
}
