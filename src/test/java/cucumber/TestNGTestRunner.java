package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//cucumber can't run on it's own. It depends up on JUnit or TestNG to run.

//FAQ: How do you decide which runner you want to use?
//Ans: That depends upon what kind of assertions you have in your code. if you use TestNG assertions completely for running your framework, then go with TestNG. 
//if you are using JUnit assertions and libraries to completely run your framework,then go with JUnit.

@CucumberOptions(features="src/test/java/cucumber",glue="rahulshettyacademy.stepDefinitions",monochrome=true,tags="@Regression",plugin={"html:target/cucumber.html"})

public class TestNGTestRunner extends AbstractTestNGCucumberTests{

		
	
}
