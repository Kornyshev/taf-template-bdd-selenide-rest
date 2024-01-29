package org.example.steps.technical;


import org.example.core.annotations.Injections;

/**
 * TECHNICAL: Parent class of all Step Definition classes.
 */
public class CucumberSteps {

    protected CucumberSteps() {
        Injections.inject(this);
    }

}
