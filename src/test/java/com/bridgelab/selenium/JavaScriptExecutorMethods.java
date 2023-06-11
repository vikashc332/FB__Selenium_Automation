  package com.bridgelab.selenium;
  import io.github.bonigarcia.wdm.WebDriverManager;
  import org.openqa.selenium.JavascriptExecutor;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.chrome.ChromeOptions;
  import org.testng.annotations.AfterSuite;
  import org.testng.annotations.BeforeSuite;
  import org.testng.annotations.Test;

  public class JavaScriptExecutorMethods {

    public WebDriver driver;

    // Method to launch Chrome browser
    @BeforeSuite
    public void launchChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

    }



    // Test method for scrolling up and down the page using JavaScriptExecutor
    @Test
    public void scrollUp_And_Down_Function() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        JavascriptExecutor jsexe = (JavascriptExecutor) driver;

        // Scrolling down the page by 1000 pixels
        jsexe.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(5000);

        // Scrolling up the page by 500 pixels
        jsexe.executeScript("window.scrollBy(0,-500)");
        Thread.sleep(5000);
    }


    // Test method for entering text into enabled and disabled fields using JavaScriptExecutor
    @Test
    public void enter_Text_Enable_And_DisableFild() throws InterruptedException {
        driver.get("file:\\C:\\Users\\ADMIN\\Downloads\\javascriptExecutor.html");
        JavascriptExecutor jsExecute = (JavascriptExecutor)driver;
        Thread.sleep(5000);

        // Entering text into an enabled field with id 't1'
        jsExecute.executeScript("document.getElementById('t1').value='vikas chaudhary'");
        Thread.sleep(5000);

        // Clearing the value of a field with id 't2'
        jsExecute.executeScript("document.getElementById('t2').value=''");
        Thread.sleep(5000);

        // Entering text into a disabled field with id 't2'
        jsExecute.executeScript("document.getElementById('t2').value='Software Engineer'");
        Thread.sleep(5000);

        // Changing the type of a field with id 't2' to 'button'
        jsExecute.executeScript("document.getElementById('t2').type='button'");
        Thread.sleep(5000);
    }

    // Method to close the browser
    @AfterSuite //(enabled = false)
    public void close()
    {
        driver.close();
    }
  }

