package org.example.steps.api;

import io.cucumber.java.en.When;
import org.example.be.controllers.UserController;
import org.example.core.annotations.Flow;
import org.example.steps.technical.CucumberSteps;

public class UsersSteps extends CucumberSteps {

    @Flow
    UserController userController;

    @When("print in console current User data requested via API")
    public void printUserDataInConsole() {
        System.out.println(userController.executeGetUserData());
    }

}
