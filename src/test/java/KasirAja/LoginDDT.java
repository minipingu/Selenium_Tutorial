package KasirAja;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginDDT {
    @Test //Tag untuk running script  di bawah ini
    public void login() {

        WebDriver driver;
        String baseURL = "https://kasirdemo.belajarqa.com/";
        //setup firefox driver automatically using web driver manager
        WebDriverManager.firefoxdriver().setup();
        //create object to setup option for firefox driver
        FirefoxOptions opt = new FirefoxOptions();
        //set firefox driver to not using headless mode
        opt.setHeadless(false);

        String fileDir = System.getProperty("user.dir") + "/src/test/data/test-data.csv";

        //Read the CSV file and run the test for each row
        try (CSVReader reader = new CSVReader(new FileReader(fileDir))) {
            //try read csv data

            String[] nextLine;

            while ( (nextLine = reader.readNext()) != null) {

                String email = nextLine[0];
                String password = nextLine[1];
                String status = nextLine[2];

                //open the browser and access the url
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.get(baseURL);

                //filling the field
                driver.findElement(By.id("email")).sendKeys(email);
                driver.findElement(By.id("password")).sendKeys(password);
                driver.findElement(By.xpath("//button[@type='submit']")).click();
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                //timeout


                //assertion
                if (status.equals("success")) {
                    //assert success login
                    driver.findElement(By.xpath("//div[contains(text(),'dashboard')]"));
                    String username = driver.findElement(By.xpath("//dd[contains(text(),'hai')]/preceding-sibling::dt")).getText();
                    Assert.assertEquals(username, "Toko Senjata Feria Shen");
                    driver.close();
                } else {
                    //assert error message
                    String wrong_credential = driver.findElement(By.xpath("//a[contains(text(),'ingin mencoba, daftar ?')]")).getText();
                    Assert.assertEquals(wrong_credential, "Kredensial yang Anda berikan salah");
                    driver.close();
                } //else


            }//while

        }//try
        catch (CsvValidationException | IOException e){
            throw new RuntimeException(e);
        }

    }//login

}//loginDDT
