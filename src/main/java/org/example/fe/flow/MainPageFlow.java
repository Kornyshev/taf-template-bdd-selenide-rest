package org.example.fe.flow;

import org.example.fe.pom.MainPage;

import static com.codeborne.selenide.Selenide.page;

public class MainPageFlow {

    public boolean isSignUpEmailFieldVisible() {
        return page(MainPage.class).getUserEmailInput().isDisplayed();
    }

    public boolean isSignUpButtonVisible() {
        return page(MainPage.class).getSignUpButton().isDisplayed();
    }

}
