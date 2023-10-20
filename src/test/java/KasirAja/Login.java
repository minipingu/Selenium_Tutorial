package KasirAja;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    @Test //Tag untuk running script  di bawah ini
    public void success_login(){

        WebDriver driver;
        String baseURL = "https://kasirdemo.belajarqa.com/";
        WebDriverManager.chromedriver().setup();

        //apply firefox driver setup
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        String title = driver.getTitle();
        System.out.println(title);

        driver.findElement(By.id("email")).sendKeys("feriashen@naraka.com");
        driver.findElement(By.id("password")).sendKeys("feriashen");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //timeout
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //assertion
        driver.findElement(By.xpath("//div[contains(text(),'dashboard')]"));
        String username = driver.findElement(By.xpath("//dd[contains(text(),'hai')]/preceding-sibling::dt")).getText();
        Assert.assertEquals(username,"Toko Senjata Feria Shen");

        //driver.close();

    }

    @Test //Tag untuk running script  di bawah ini
    public void failed_login(){

        WebDriver driver;
        String baseURL = "https://kasirdemo.belajarqa.com/";
        WebDriverManager.chromedriver().setup();

        //apply firefox driver setup
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        String title = driver.getTitle();
        System.out.println(title);

        driver.findElement(By.id("email")).sendKeys("feriashen@naraka.com");
        driver.findElement(By.id("password")).sendKeys("bukanferiashen");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //timeout
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //assertion
        String wrong_credential = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(wrong_credential,"Kredensial yang Anda berikan salah");

        //driver.close();

    }
}
