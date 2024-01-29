package org.example.steps;

import io.cucumber.java.en.Given;
import org.example.core.annotations.Flow;
import org.example.fe.flow.BrowserFlow;
import org.example.steps.technical.CucumberSteps;

public class BrowserSteps extends CucumberSteps {

    @Flow
    BrowserFlow browserFlow;

    @Given("user navigates to {string}")
    public void openPage(String page) {
        browserFlow.open(page);
    }

}
