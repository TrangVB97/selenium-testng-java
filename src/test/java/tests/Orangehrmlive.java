package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import  org.testng.annotations.Test;

import java.time.Duration;
import static base.BaseTest.*;

import static java.lang.Thread.sleep;

public class Orangehrmlive {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public  void testBasicFlow()  throws InterruptedException {
//        login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);

//        search
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//ul[@class='oxd-main-menu']/li[1]/a")))
                .click();
        String className = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//ul[@class='oxd-main-menu']/li[1]/a")))
                .getDomProperty("className");
        Assert.assertEquals(className, "oxd-main-menu-item active");

        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .cssSelector("input[placeholder='Search']")))
                .sendKeys("My Info");
        driver.findElement(By.className("oxd-main-menu-item")).click();

//       dropdown list
//         wait.until(ExpectedConditions.elementToBeClickable(By
//                .xpath("//label[contains(text(),'Nationality')]/parent::div/following-sibling::div/div/div")))
//                 .click();
//        wait.until(ExpectedConditions.elementToBeClickable(By
//                .xpath("//div[@role='listbox']//span[text()='Afghan']")))
//                .click();

//        date of birth
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By
//                .xpath("//label[text()='Date of Birth']/parent::div/following-sibling::div")))
//                .click();
//        wait.until(ExpectedConditions.elementToBeClickable(By
//                .xpath("//div[@class='oxd-date-input-calendar']//div[text()='20']")))
//                .click();

//        radio btn
//        wait.until(ExpectedConditions.elementToBeClickable(By
//                .xpath("//input[@type='radio' and @value='2']")))
//                .click();

//        checkbox
        Thread.sleep(500);
        WebElement element = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));

        // Scroll the element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        // Wait until the element is clickable
//        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

//    @AfterMethod
//    public  void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
