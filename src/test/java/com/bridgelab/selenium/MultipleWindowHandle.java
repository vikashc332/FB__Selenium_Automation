package com.bridgelab.selenium;
  import io.github.bonigarcia.wdm.WebDriverManager;
  import org.openqa.selenium.By;
  import org.openqa.selenium.JavascriptExecutor;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.WebElement;
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.chrome.ChromeOptions;
  import org.testng.annotations.AfterTest;
  import org.testng.annotations.BeforeSuite;
  import org.testng.annotations.BeforeTest;
  import org.testng.annotations.Test;

  import java.util.Set;

  public class MultipleWindowHandle {

    private WebDriver driver;

    @BeforeTest
    @BeforeSuite
    public void launchChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    @Test
    public void multipleWindowHandlingTest() throws InterruptedException {
        // Open Facebook in the main window
        driver.get("https://www.facebook.com");
        // Get the current window handle (main window)
        String mainWindowHandle = driver.getWindowHandle();

        // Open 9 new tabs/windows
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 9; i++) {
            js.executeScript("window.open()");
        }

        // Get all the window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to each new tab/window and open Facebook
        int windowCount = 0;
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                driver.get("https://www.facebook.com");

                // Perform any actions in the tab/window
                WebElement emailInput = driver.findElement(By.id("email"));
                emailInput.sendKeys("vikashc3322gmail.com.com");

                WebElement passwordInput = driver.findElement(By.id("pass"));
                passwordInput.sendKeys("vikas332");

                // Sleep for demonstration purposes
                Thread.sleep(2000);

                windowCount++;
                if (windowCount >= 10) {
                    break; // Limit to 10 windows
                }
            }
        }

        // Switch back to the main window
        driver.switchTo().window(mainWindowHandle);
        // Perform any remaining actions in the main window

        // Sleep for demonstration purposes
        Thread.sleep(2000);
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
  }