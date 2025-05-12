package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "src\\test\\java\\features\\TaggedHooks.feature",
		glue= {"stepDefinition","hooks"},
		dryRun = false,
		snippets= SnippetType.CAMELCASE,
		monochrome=true,
		plugin = {"pretty", "html:src\\test\\resources\\Reports\\HtmlReports\\htmlreports",
				"json:src\\test\\resources\\Reports\\JsonReports\\jsonreports"
		}
		//tags = "@SmokeTesting and not @RegressionTesting"
	//	tags = "@SmokeTesting or @RegressionTesting"
			//	tags = "@SmokeTesting"
			)



public class TestRunner extends AbstractTestNGCucumberTests{

}
