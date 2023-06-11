package com.bridgelab.selenium;

  import io.github.bonigarcia.wdm.WebDriverManager;
  import org.openqa.selenium.By;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.WebElement;
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.chrome.ChromeOptions;
  import org.testng.annotations.BeforeMethod;
  import org.testng.annotations.Test;
  import java.awt.*;
  import java.awt.event.InputEvent;
  import java.awt.event.KeyEvent;

  public class MouseEvent
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

     // Test method to perform mouse events using Robot class
    @Test
    public void mouseEvent_Using_Robot() throws AWTException, InterruptedException {
        Robot robot = new Robot();

        // Simulate mouse wheel scroll up
        robot.mouseWheel(2);
        Thread.sleep(3000);

        // Simulate mouse wheel scroll down
        robot.mouseWheel(-2);
        Thread.sleep(3000);

        // Find the location of the email input field and print its coordinates
        WebElement emailId = driver.findElement(By.xpath("//input[@id='email']"));
        int locx = emailId.getLocation().getX();
        int locy = emailId.getLocation().getY();
        System.out.println("Email x :"+locx);
        System.out.println("Email y :"+locy);

        // Move the mouse to the location of the email input field
        robot.mouseMove(locx,locy);

        // Move the mouse to specific coordinates (950, 550)
        robot.mouseMove(950,550);
        Thread.sleep(3000);

        // Simulate mouse left button press and release
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(5000);

        // Simulate key press (press 'V' key)
        robot.keyPress(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_K);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_S);

    }
}
