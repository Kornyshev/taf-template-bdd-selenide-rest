package org.example.fe.pom;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.example.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

@Getter
@DefaultUrl(url = "https://github.com/login")
public class LoginPage extends PageObject {

    @FindBy(css = "div.application-main div.auth-form-header h1")
    private SelenideElement signInPageHeader;

    @Override
    public void pageIsLoaded() {
        signInPageHeader.shouldBe(visible);
    }

}
