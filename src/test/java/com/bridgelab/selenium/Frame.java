 package com.bridgelab.selenium;

   import io.github.bonigarcia.wdm.WebDriverManager;
   import org.openqa.selenium.By;
   import org.openqa.selenium.WebDriver;
   import org.openqa.selenium.chrome.ChromeDriver;
   import org.openqa.selenium.chrome.ChromeOptions;
   import org.testng.annotations.BeforeSuite;
   import org.testng.annotations.Test;

  public class Frame {
    public WebDriver driver;

    @BeforeSuite
    public void launchChrome() {
        // Create ChromeOptions object
        ChromeOptions options = new ChromeOptions();

        // Add argument to allow remote origins
        options.addArguments("--remote-allow-origins=*");

        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize driver with ChromeDriver and options
        driver = new ChromeDriver(options);
    }

    @Test
    public void frames_Functions() throws InterruptedException {
        // Load the local HTML file in Chrome browser
        driver.get("file:\\C:\\Users\\ADMIN\\Downloads\\javascriptExecutor.html");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Switch to the first frame
        driver.switchTo().frame(0);

        // Find the element with id "t1" and send keys "vikas chaudhary"
        driver.findElement(By.id("t1")).sendKeys("vikas chaudhary");

        // Pause execution for 2 seconds
        Thread.sleep(2000);

        // Switch back to the default content of the page
        driver.switchTo().defaultContent();

        // Find the element with id "t2" and send keys "143"
        driver.findElement(By.id("t2")).sendKeys("143");

        // Pause execution for 2 seconds
        Thread.sleep(2000);
    }
 }

