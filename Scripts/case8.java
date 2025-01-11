//logout
package day1;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import java.time.Duration;
import java.util.List;
 
public class case8 {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
 
        driver.get("https://okobiscuit-admin.vercel.app/login");
        Thread.sleep(1000);
 
        // Login process
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("superAdmin@gmail.com");
        driver.findElement(By.id("password")).sendKeys("superAdmin00@11");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
 
        // Wait for a few seconds after login
        Thread.sleep(3000);
 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
        // Wait until the profile name <h2> elements are visible
        List<WebElement> profileNames = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h2.text-primary")));
 
        // Iterate through all the <h2> elements and find the one with the desired text
        for (WebElement profileName : profileNames) {
            if (profileName.getText().contains("OKO COOKIES")) {  // Matching based on the text content
                profileName.click();  // Click the profile name
                break;  // Exit loop after finding and clicking the element
            }
        }
 
        // Wait for the Logout button to become visible and click it
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.text-secondary")));
        
        logoutButton.click();  // Click the Logout button
        
        // Check if the page URL is as expected (assuming the logout redirects to the login page)
        String acting_url = driver.getCurrentUrl();
        String desired_url = "https://okobiscuit-admin.vercel.app/login";
 
        if (acting_url.equals(desired_url)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
 
        // Close the driver
//        driver.quit();
    }
}