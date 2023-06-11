package com.bridgelab.selenium;

  import io.github.bonigarcia.wdm.WebDriverManager;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.chrome.ChromeOptions;
  import org.testng.annotations.BeforeMethod;
  import org.apache.commons.io.FileUtils;
  import org.openqa.selenium.*;
  import org.testng.annotations.*;
  import java.io.File;
  import java.io.IOException;

  public class TakeScreenShot
 {
    public WebDriver driver;

     // Method to launch Chrome and set up the driver
    @BeforeMethod
    public void launchChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
    }

     // Test method to capture a screenshot
    @Test
    public void Take_ScreenShort() throws InterruptedException, IOException
    {
        // Sleep for 5 seconds (for demonstration purposes)
        Thread.sleep(5000);

        // Find the mobile number input field by ID and enter a mobile number
        WebElement mobileNumber = driver.findElement(By.id("email"));
        mobileNumber.sendKeys("6206844299");

        // Find the password input field by ID and enter a password
        WebElement pass = driver.findElement(By.id("pass"));
        pass.sendKeys("vikas332");

        // Sleep for 5 seconds (for demonstration purposes)
        Thread.sleep(5000);


        // Take a screenshot using the WebDriver's TakesScreenshot interface
        TakesScreenshot ts = (TakesScreenshot)driver;
        File SFile = ts.getScreenshotAs(OutputType.FILE);

        // Define the destination file path where the screenshot will be saved
        File DFile = new File("C:\\Users\\ADMIN\\OneDrive\\Desktop\\Screenshot\\"+"Facebook.png");

        // Copy the screenshot file to the destination path using FileUtils from Apache Commons IO
        FileUtils.copyFile(SFile, DFile);
    }
}
