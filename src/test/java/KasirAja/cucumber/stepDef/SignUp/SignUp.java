package KasirAja.cucumber.stepDef.SignUp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class SignUp {
    //set driver fir test using webdriver from selenium
    WebDriver driver;

    //set base url
    String baseUrl = "https://kasirdemo.belajarqa.com/";

    @Given("user is on KasirAja login page")
    public void user_is_on_kasir_aja_login_page() {

        //setup firefox driver automatically using web driver manager
        WebDriverManager.chromedriver().setup();
        //create object to setup option for firefox driver
        ChromeOptions opt = new ChromeOptions();
        //set firefox driver to not using headless mode
        opt.setHeadless(false);

        //apply firefox driversetup to driver
        driver = new ChromeDriver(opt);
        //set timeout for web driver on waiting element
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //maximize window
        driver.manage().window().maximize();
        //access base url
        driver.get(baseUrl);
    }

    @When("user click signup link")
    public void user_click_signup_link(){
        String klik_daftar = "ingin mencoba, daftar ?";
        driver.findElement(By.partialLinkText(klik_daftar)).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @And("user input (.*) as name$")
    public void user_input_tdd_selenium_as_name(String name){
        driver.findElement(By.cssSelector("#name")).sendKeys(name);
    }

    @When("user input (.*) as email$")
    public void user_input_tdd_selenium_gmail_com_as_email(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    @And("user input (.*) as password$")
    public void user_input_tdd_selenium_as_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("user click submit")
    public void user_click_submit() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("user verify (.*) signup result$")
    public void user_verify_success_signup_result(String status){
        //assertion
        if (status.equals("success")) {
            //assert success signup
            String signup_text = driver.findElement(By.xpath("//a[contains(text(),'ingin mencoba, daftar ?')]")).getText();
            Assert.assertEquals(signup_text, "ingin mencoba, daftar ?");
            driver.close();
        } else {
            //assert error message
            String wrong_format= driver.findElement(By.xpath("//div[@role='alert']")).getText();
            Assert.assertEquals(wrong_format, "\"email\" must be a valid email");
            driver.close();
        } //else

    }

}
