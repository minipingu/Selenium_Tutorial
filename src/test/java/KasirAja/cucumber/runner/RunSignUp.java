package KasirAja.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/KasirAja/cucumber/features/SignUp",
        glue = "KasirAja.cucumber.stepDef.SignUp",
        plugin = {"html:target/HTML_report_SignUp.html"}
)
public class RunSignUp {
}
