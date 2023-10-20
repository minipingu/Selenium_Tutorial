package KasirAja.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/KasirAja/cucumber/features/Login",
        glue = "KasirAja.cucumber.stepDef.Login",
        plugin = {"html:target/HTML_report_Login.html"}
)
public class RunLogin { }
