package org.example.fe.flow;

import org.example.fe.pom.LoginPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class LogInPageFlow {

    public String getSignInPageHeaderText() {
        return page(LoginPage.class).getSignInPageHeader().shouldBe(visible).text();
    }

}
