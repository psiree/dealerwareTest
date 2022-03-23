

package stepDefinitions;

//import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(features="src/test/resources/features/", glue="stepDefinitions",tags="@sample",
strict = true,
dryRun=false
)

public class TestRunner  extends AbstractTestNGCucumberTests{


}


