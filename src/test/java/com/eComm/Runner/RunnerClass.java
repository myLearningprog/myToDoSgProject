package com.eComm.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"/src/test/resources/Features"},glue={"com.eComm.StepDefinations"}, tags = {"@sanity"})
public class RunnerClass extends AbstractTestNGCucumberTests {

}
