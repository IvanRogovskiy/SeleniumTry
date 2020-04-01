import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class TestBase {
    public static WebDriver driver;
    @BeforeClass

    public static void beforeTest()
    {

        driver = DriverIni.GetDriver("chrome");
    }

}

/*
   @AfterClass
    public static void AfterClass() {
        driver.close();
}
}
*/