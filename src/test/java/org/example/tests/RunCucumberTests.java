package org.example.tests;

import org.junit.platform.suite.api.*;

import static io.cucumber.core.options.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
//@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,rerun:target/rerun.txt")
public class RunCucumberTests {
}
