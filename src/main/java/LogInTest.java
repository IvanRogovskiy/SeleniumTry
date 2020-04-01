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

        // Открыл страницу авторизации и проверил что это именно она, а не страница с уже залогиненым пользователем.
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class,\"post-47 page type-page status-publish hentry\")]//h1[text() = \"My account\"]")));
        WebElement Check = driver.findElement(By.xpath
                ("//div[contains(@class,\"single-entry-summary\")]//h2"));
        String CheckPAge = Check.getText();
        Assert.assertEquals(CheckPAge,"Авторизация");

        // Жду загрузки полей ввода логина и пароля
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
