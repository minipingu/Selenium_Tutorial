import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Login {
    @Test //Tag untuk running script  di bawah ini
    public void open_browser(){

        WebDriver driver;
        String baseURL = "https://kasirdemo.belajarqa.com/";
        WebDriverManager.chromedriver().setup();
    }
}
