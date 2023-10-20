package KasirAja.cucumber.stepDef.AddKategori;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class AddKategori {
    //set driver fir test using webdriver from selenium
    WebDriver driver;

    //set base url
    String baseUrl = "https://kasirdemo.belajarqa.com/";

    @Given("user is on KasirAja login page")
    public void user_is_on_kasir_aja_login_page(){

        //setup firefox driver automatically using web driver manager
        WebDriverManager.firefoxdriver().setup();
        //create object to setup option for firefox driver
        FirefoxOptions opt = new FirefoxOptions();
        //set firefox driver to not using headless mode
        opt.setHeadless(false);

        //apply firefox driversetup to driver
        driver = new FirefoxDriver(opt);
        //set timeout for web driver on waiting element
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //maximize window
        driver.manage().window().maximize();
        //access base url
        driver.get(baseUrl);
    }

    @When("user input (.*) as email$")
    public void user_input_tdd_selenium_gmail_com_as_email(String email){
        driver.findElement(By.id("email")).sendKeys(email);
    }

    @And("user input (.*) as password$")
    public void user_input_tdd_selenium_as_password(String password){
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("user click submit")
    public void user_click_submit() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    //div[contains(text(),'kategori')]

    @Then("user verify (.*) login result$")
    public void user_verify_success_login_result(String status){
        //assertion
        if (status.equals("success")) {
            //assert success login
            driver.findElement(By.xpath("//div[contains(text(),'dashboard')]"));
            String username = driver.findElement(By.xpath("//dd[contains(text(),'hai')]/preceding-sibling::dt")).getText();
            Assert.assertEquals(username, "Toko Senjata Feria Shen");
            driver.close();
        } else {
            //assert error message
            String wrong_credential = driver.findElement(By.xpath("//div[@role='alert']")).getText();
            Assert.assertEquals(wrong_credential, "Kredensial yang Anda berikan salah");
            driver.close();
        } //else

    }

}
