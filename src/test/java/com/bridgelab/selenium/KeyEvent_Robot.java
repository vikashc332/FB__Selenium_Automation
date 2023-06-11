package com.bridgelab.selenium;

  import io.github.bonigarcia.wdm.WebDriverManager;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.chrome.ChromeOptions;
  import org.testng.annotations.BeforeMethod;
  import org.testng.annotations.*;
  import java.awt.*;
  import java.awt.event.KeyEvent;

public class KeyEvent_Robot
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

    // Test method to perform key events using Robot class
    @Test
    public void KeyEvent_Using_Robot() throws AWTException, InterruptedException {

        // Create a new instance of Robot class
        Robot robot = new Robot();

        // Simulate key events using keyPress and keyRelease methods
        // Here, each key event is represented by a KeyEvent constant from the KeyEvent class
         robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyRelease(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_K);
        robot.keyRelease(KeyEvent.VK_K);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);

        // Press and hold the CONTROL key
        robot.keyPress(KeyEvent.VK_CONTROL);

        // Press the 'A' key
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);

        // Press the 'C' key
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);

        // Release the CONTROL key
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Simulate pressing the TAB key
       robot.keyPress(KeyEvent.VK_TAB);
       robot.keyRelease(KeyEvent.VK_TAB);

        // Press and hold the CONTROL key
        robot.keyPress(KeyEvent.VK_CONTROL);

        // Simulate pressing the 'V' key
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);

        // Release the CONTROL key
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Sleep for 5 seconds (for demonstration purposes)
        Thread.sleep(5000);
    }
}
