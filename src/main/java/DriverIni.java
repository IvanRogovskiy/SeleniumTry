import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverIni
{
    public static WebDriver GetDriver(String driverType)
    {
        if (driverType.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            return new ChromeDriver();
        }
        else {
            return null;
        }

    }
}
