//user adding order with all mandatory fields
package day1;
 
import java.time.Duration;

import java.util.List;
 
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class case10 {
 
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
 
        driver.get("https://okobiscuit-admin.vercel.app/login");
        Thread.sleep(1000);
 
        // Login process
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("shamspahlowan03@gmail.com");
        driver.findElement(By.id("password")).sendKeys("88888888");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
 
        // Wait for a few seconds after login
        Thread.sleep(3000);
        driver.get("https://okobiscuit-admin.vercel.app/seller/add-order");
 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
        driver.findElement(By.id("shopName")).sendKeys("Milky Way Galaxy");
        driver.findElement(By.id("shopOwnerName")).sendKeys("Meheraj");
        driver.findElement(By.id("location")).sendKeys("Dhaka");
        driver.findElement(By.id("contact")).sendKeys("01324314144");
        driver.findElement(By.id("address")).sendKeys("Dhaka");
        driver.findElement(By.id("deliveryDate")).sendKeys("2025-01-28");
        driver.findElement(By.id("items_0_name")).sendKeys("strabery shake");
        driver.findElement(By.id("items_0_unitPrice")).sendKeys("50");
        driver.findElement(By.id("items_0_quantity")).sendKeys("10");
        
        WebElement submitOrderButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[@type='submit' and contains(@class, 'ant-btn-primary')]/span[text()='Submit Order']")));
 
        // Click the Submit Order button
        submitOrderButton.click();
        
        Thread.sleep(1000);
        
        // Check if the page URL is as expected (assuming the logout redirects to the login page)
        String acting_url = driver.getCurrentUrl();
        String desired_url = "https://okobiscuit-admin.vercel.app/seller/add-order";
 
        if (acting_url.equals(desired_url)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
 
        // Close the driver
//        driver.quit();
	}
 
}
 
 