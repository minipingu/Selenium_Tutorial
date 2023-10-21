package KasirAja.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/KasirAja/cucumber/features/AddPelanggan",
        glue = "KasirAja.cucumber.stepDef.AddPelanggan",
        plugin = {"html:target/HTML_report_AddPelanggan.html"}
)
public class RunAddPelanggan { }
