import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInTest extends TestBase{

    @Test

    public void simpleTest2()
    {

        // Открыл страницу авторизации
        driver.get ("http://cw07529-wordpress.tw1.ru/my-account/");

        // Проверил, что это действительно она
        String title = driver.getTitle();
        Assert.assertEquals(title,"My account — T-Time");

        // Жду загрузки полей ввода логина и пароля
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

        // Ввожу данные регистрации
        driver.findElement(By.id("username")).sendKeys("Test1");
        driver.findElement(By.id("password")).sendKeys("Studen123456!");

        // Щелкаю по кнопке войти
        driver.findElement(By.className("woocommerce-form-login__submit")).click();

        // Жду открытия страницы после авторизации
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class,\"woocommerce-MyAccount-content\")]/p[text() = \"Добро пожаловать, \"]")));

        // Проверяю, что зашел под нужным логином
        WebElement User = driver.findElement
                (By.xpath("//div[contains(@class,\"woocommerce-MyAccount-content\")]//strong"));
        String UserName = User.getText();
        Assert.assertEquals(UserName,"Test1 Test1" );

    }
}
