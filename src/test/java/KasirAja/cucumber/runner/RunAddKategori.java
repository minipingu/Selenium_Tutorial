package KasirAja.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/KasirAja/cucumber/features/AddKategori",
        glue = "KasirAja.cucumber.stepDef.AddKategori",
        plugin = {"html:target/HTML_report_AddKategori.html"}
)
public class RunAddKategori { }
