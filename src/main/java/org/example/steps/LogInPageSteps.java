package org.example.steps;

import io.cucumber.java.en.Then;
import org.example.core.annotations.Flow;
import org.example.fe.flow.LogInPageFlow;
import org.example.steps.technical.CucumberSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class LogInPageSteps extends CucumberSteps {

    @Flow
    LogInPageFlow logInPageFlow;

    @Then("user sees Sign In page header text equals to {string} on Login Page")
    public void verifySignInPageHeaderText(String expectedText) {
        assertThat(logInPageFlow.getSignInPageHeaderText()).isEqualTo(expectedText);
    }

}
