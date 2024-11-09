import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver with options (optional, e.g., headless mode)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Optional: Start maximized
        driver = new ChromeDriver(options);
    }

    @Test
    public void testLoginPageTitle() {
        // Navigate to the website
        driver.get("https://example.com/login");

        // Verify the page title
        String title = driver.getTitle();
        assertEquals("Login - Example", title);
    }

    @Test
    public void testLoginFormElements() {
        // Navigate to the login page
        driver.get("https://example.com/login");

        // Check if username, password fields and login button are present
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        assertTrue(usernameField.isDisplayed(), "Username field is not displayed");
        assertTrue(passwordField.isDisplayed(), "Password field is not displayed");
        assertTrue(loginButton.isDisplayed(), "Login button is not displayed");
    }

    @Test
    public void testSuccessfulLogin() {
        // Navigate to the login page
        driver.get("https://example.com/login");

        // Enter username and password (you can change these values to valid credentials)
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("testuser");
        passwordField.sendKeys("password123");
        loginButton.click();

        // Wait for a successful login (e.g., wait for the dashboard to load)
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement dashboard = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dashboard")));

        // Check if the user is redirected to the dashboard
        assertTrue(dashboard.isDisplayed(), "Login failed, dashboard not found.");
    }

    @Test
    public void testUnsuccessfulLogin() {
        // Navigate to the login page
        driver.get("https://example.com/login");

        // Enter incorrect username and password
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("invaliduser");
        passwordField.sendKeys("invalidpassword");
        loginButton.click();

        // Wait for the error message to appear
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("error-message")));

        // Verify that the error message is displayed
        assertTrue(errorMessage.isDisplayed(), "Error message is not displayed for invalid login.");
    }

    @AfterAll
    public static void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
