package com.bridgelab.selenium;

    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.openqa.selenium.Alert;
    import org.openqa.selenium.By;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.chrome.ChromeOptions;
    import org.testng.annotations.AfterClass;
    import org.testng.annotations.BeforeClass;
    import org.testng.annotations.Test;

   public class JavaScript_Popups {


    public WebDriver driver;
    @BeforeClass
    public void launchChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Setting up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    @Test
    public void simple_Alert() throws InterruptedException
    {
        // Opening the web page
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // Clicking on an element to trigger a simple alert
        driver.findElement(By.id("alertButton")).click();

        // Switching to the alert and capturing its reference
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);

        // Printing the text of the alert
        System.out.println(alert.getText());
        Thread.sleep(2000);

        // Accepting the alert
        alert.accept();
        Thread.sleep(2000);
    }

    @Test
    public void simple_Alert2() throws InterruptedException {

        // Opening the web page
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // Clicking on an element to trigger a timed alert
        driver.findElement(By.id("timerAlertButton")).click();
        Thread.sleep(2000);

        // Switching to the alert and capturing its reference
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);

        // Printing the text of the alert
        System.out.println(alert.getText());
        Thread.sleep(2000);


        // Accepting the alert
        alert.accept();
        Thread.sleep(2000);
    }

    @Test
    public void confirmation_PopUp()
    {
        // Opening the web page
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

        // Clicking on an element to trigger a confirmation pop-up
        driver.findElement(By.id("confirmButton")).click();

        // Switching to the alert and capturing its reference
        Alert alert = driver.switchTo().alert();

        // Printing the text of the alert
        System.out.println(alert.getText());

        // Dismissing the alert
        alert.dismiss();
    }

    @Test
    public void prompt_PopUp() throws InterruptedException {

        // Opening the web page
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

        // Scrolling the window using JavaScriptExecutor
        JavascriptExecutor jsexe = (JavascriptExecutor)driver;
        jsexe.executeScript("window.scrollBy(0,100)");

        // Clicking on an element to trigger a prompt pop-up
        driver.findElement(By.xpath("//button[@id='promtButton']")).click();

        // Switching to the alert and capturing its reference
        Alert alert = driver.switchTo().alert();

        // Printing the text of the alert
        System.out.println(alert.getText());
        Thread.sleep(2000);

        // Entering a value in the prompt and accepting the alert
        alert.sendKeys("vikash chaudhary");
        Thread.sleep(2000);
        //Accepting the alert
        alert.accept();
        Thread.sleep(2000);
    }


    @AfterClass
    public void close()
    {
        //Closing the WebDriver
        driver.close();
    }
 }

