  package com.bridgelab.selenium;
  import io.github.bonigarcia.wdm.WebDriverManager;
  import org.openqa.selenium.*;
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.chrome.ChromeOptions;
  import org.openqa.selenium.interactions.Actions;
  import org.testng.annotations.AfterSuite;
  import org.testng.annotations.BeforeSuite;
  import org.testng.annotations.Test;
  import java.awt.*;
  import java.awt.event.KeyEvent;

  public class Action_Class {
    public WebDriver driver;

    // Method to launch Chrome browser
    @BeforeSuite
    public void launchChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }



    // Test method for performing a context click action on an element
    @Test
    public void context_Click_Method() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement pass = driver.findElement(By.xpath("//input[@id='pass']"));
        Actions actions = new Actions(driver);
        actions.contextClick(pass).perform();
        Thread.sleep(2000);
    }


    // Test method for performing a drag and drop action
    @Test
    public void dragAndDrop_Method() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.switchTo().frame(0);
        WebElement src = driver.findElement(By.id("draggable"));
        WebElement des = driver.findElement(By.xpath("//p[text()='Drop here']"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(src,des).perform();
//        actions.moveToElement(src).clickAndHold().perform();
        actions.release(des).perform();
        Thread.sleep(5000);
    }


    // Test method for performing a double-click action on an element
    @Test
    public void double_Click_Method() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement pass = driver.findElement(By.xpath("//input[@id='pass']"));
        actions.doubleClick(pass).perform();
        Thread.sleep(5000);
        actions.doubleClick(email).perform();
        Thread.sleep(5000);
    }


    // Test method for performing keyboard actions
    @Test
    public void keyboard_Method() throws InterruptedException, AWTException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.partialLinkText("Forgotten password"));
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.UP).perform();
        Thread.sleep(5000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_UP);
        robot.keyRelease(KeyEvent.VK_UP);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
    }



    // Test method for performing Google shortcut actions
    @Test
    public void google_ShortCut_Method() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement search = driver.findElement(By.name("q"));
        Actions actions = new Actions(driver);
        actions.sendKeys("selenium").perform();
        Thread.sleep(2000);
        actions.keyDown(Keys.CONTROL).sendKeys("C").perform();
        actions.keyUp(Keys.CONTROL).perform();
        Thread.sleep(2000);
        actions.keyDown(Keys.CONTROL).sendKeys("A").perform();
        actions.keyUp(Keys.CONTROL).perform();
        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.TAB);
        actions.keyDown(Keys.CONTROL).sendKeys("I").perform();
        actions.keyUp(Keys.CONTROL).perform();
        Thread.sleep(2000);
        driver.get("https://www.google.com/");
        actions.keyDown(Keys.CONTROL).sendKeys("V").perform();
        actions.keyUp(Keys.CONTROL).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
    }


    @AfterSuite
    public void close()
    {
        driver.close();
    }
  }

