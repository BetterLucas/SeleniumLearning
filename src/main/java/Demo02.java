import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Demo02 {
    WebDriver  driver;
    @BeforeTest
    public void initDriver() {
         driver = new ChromeDriver();
    }

    @Test
    public void testDemo1() {


        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        System.out.println("title: " + driver.getTitle());
        //等待页面元素准备
        driver.manage().timeouts().implicitlyWait(500l, TimeUnit.MILLISECONDS);

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        System.out.println("msg: " + message.getText());
    }

    @AfterTest
    public  void quit() {
        driver.quit();
    }
}
