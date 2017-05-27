package easytox.apptest.stepdefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources/easytox/apptest/features/AuditAndUserLog.feature",
plugin={"html:target/cucumber-html-report"})

public class RunTest {

}
