package org.example.steps;

import io.cucumber.java.en.Then;
import org.example.core.annotations.Flow;
import org.example.fe.flow.MainPageFlow;
import org.example.steps.technical.CucumberSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageSteps extends CucumberSteps {

    @Flow
    MainPageFlow mainPageFlow;

    @Then("user sees Sign Up email input on Main Page")
    public void verifySignUpEmailInput() {
        assertThat(mainPageFlow.isSignUpEmailFieldVisible()).isTrue();
    }

    @Then("user sees Sign Up button on Main Page")
    public void verifySignUpButton() {
        assertThat(mainPageFlow.isSignUpButtonVisible()).isTrue();
    }

}
