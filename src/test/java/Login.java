import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {
    @Test //Tag untuk running script  di bawah ini
    public void open_browser(){

        WebDriver driver;
        String baseURL = "https://kasirdemo.belajarqa.com/";
        WebDriverManager.chromedriver().setup();

        //apply chrome driver setup
        driver = new FirefoxDriver();
        driver.manage().window().maximize();//
        driver.get(baseURL);
        String title = driver.getTitle();
        System.out.println(title);

        driver.findElement(By.id("email")).sendKeys("feriashen@naraka.com");
        driver.findElement(By.id("password")).sendKeys("feriashen");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.close();

    }
}
