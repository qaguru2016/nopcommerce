import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest {
//    String baseUrl = "https://automationteststore.com";
    String baseUrl = "https://magento.softwaretestingboard.com";
    @Test
    public void launchApp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.name("login[username]"))
                .sendKeys("pradeep.pp@gmail.com");
        driver.findElement(By.name("login[password]")).sendKeys("Test#123");
        driver.findElement(By.id("send2")).click();
        Thread.sleep(3000);
        By byWelcomeMsg = RelativeLocator.with(By.className("logged-in")).above(By.id("search"));
        String welcomeMsg = driver
                .findElement(byWelcomeMsg)
                .getText();
        Assert.assertEquals("Welcome, PRADEEP PANTHALAYIL PARAMBIL!",welcomeMsg,"User not logged in" );


        driver.quit();
    }
}
