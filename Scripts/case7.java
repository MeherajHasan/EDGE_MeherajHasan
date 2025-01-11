//deleting order from seller end
package day1;
 
import java.awt.datatransfer.StringSelection;
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class case7 {
 
    public static void main(String[] args) throws InterruptedException {
        // Set up ChromeOptions for remote debugging or other configurations
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
 
        // Navigate to the login page
        driver.get("https://okobiscuit-admin.vercel.app/login");
 
        // Adding some wait time for better understanding
        Thread.sleep(1000);
 
        // Login process
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("shamspahlowan03@gmail.com");
        driver.findElement(By.id("password")).sendKeys("88888888");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
 
        // Wait for a few seconds after login
        Thread.sleep(3000);
 
        driver.get("https://okobiscuit-admin.vercel.app/seller/all-orders");
     // First delete button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.ant-btn.css-1e3s98s.ant-btn-default:nth-of-type(1)")));
        button.click();
 
        driver.findElement(By.xpath("//button[span[text()='Yes']]")).click();
 
 
        // Check the current URL to verify success
        String current = driver.getCurrentUrl();
        String desired = "https://okobiscuit-admin.vercel.app/seller/all-orders";
 
        if (current.equals(desired)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
 
        // Close the browser session
//        driver.quit();
    }
}
