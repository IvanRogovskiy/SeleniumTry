import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;

public class StuffPriceTest extends TestBase {

    @Test

    public void simpleTest()
    {
        // Открыл страницу.

        driver.get("http://cw07529-wordpress.tw1.ru/");

        // Получил заголовок страницы в переменную title.

        String title = driver.getTitle();

        // Сравнил заголовок с требуемым, данным убедившись, что нужная страница открыта.

        Assert.assertEquals("T-Time — Test University T-Systems", title);

        /* Нашел элемент " строка поиска", в консоле разработки командой "document.querySelectorAll(class="nav-link")"
        убедился, что такой элемент один на странице, добавил ожидание его видимости на странице
        и ввел в него "Oldies". */

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("header-search-input")));
        driver.findElement(By.className("header-search-input")).sendKeys("Oldies");

        //Нашел кнопку поиска и кликнул по ней.
        driver.findElement(By.className("header-search-button")).click();

        //Ожидание, когда прогузиться страница до footer.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("colophon")));

        //Находим элемент по Xpath, загоняем в переменную типа String и командой getText вытаскиваем текст.
        WebElement nameOfStuff = driver.findElement(By.xpath("//div[@id=\"product-107\"]//h1"));
        String ElementName = nameOfStuff.getText();

        //Сравниваем, что данный элемент действительно "Oldies".
        Assert.assertEquals(ElementName,"Oldies");

        //Находим селектор цвета по id и выбираем черный цвет.
        Select ColorSelector = new Select(driver.findElement(By.id("color")));
        ColorSelector.selectByValue("Black");

        //Находим блок с ценой и проверяем, что там 90 фунтов.
        WebElement Price = driver.findElement(By.xpath
                ("//div[contains(@class,\"single_variation_wrap\")]//span[contains(@class, \"woocommerce-Price-amount\")]"));
        String StuffPrice = Price.getText();
        Assert.assertEquals(StuffPrice,"£90.00");

    }

}





