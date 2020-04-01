import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class TestBase {
    public static WebDriver driver;

    //Инициализация драйвера до теста
    @BeforeClass

    public static void beforeTest()
    {

        driver = DriverIni.GetDriver("chrome");
    }

    //Закрытие драйвера после теста
   @AfterClass
    public static void AfterClass() {
        driver.close();
    }
}
