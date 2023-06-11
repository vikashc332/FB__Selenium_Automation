  package com.bridgelab.selenium;
  import io.github.bonigarcia.wdm.WebDriverManager;
  import org.openqa.selenium.*;
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.chrome.ChromeOptions;
  import org.testng.annotations.*;
  public class WebDrivers_method {
    public WebDriver driver;

    // Sets up the WebDriver before the test suite runs
    @BeforeSuite
    public void setDriver()
    {

        // Create ChromeOptions to configure the ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize the WebDriver with ChromeDriver and options
        driver = new ChromeDriver(options);
    }

    // Runs before the test class to navigate to the Facebook login page
    @BeforeClass
    public void faceBook_Login_Page_get()
    {
        driver.get("https://www.facebook.com/");
    }

    // Test method to manage the Facebook page
    @Test
    public void manage_FBPage() throws InterruptedException {

        // Maximizes the browser window
        driver.manage().window().maximize();
        Thread.sleep(1000);

        // Switches the browser window to fullscreen
        driver.manage().window().fullscreen();
        Thread.sleep(1000);

        // Minimizes the browser window
        driver.manage().window().minimize();
        Thread.sleep(2000);

        // Maximizes the browser window again
        driver.manage().window().maximize();
        Thread.sleep(1000);

        // Prints the window size, position, class, hash code, and cookies information
        System.out.println("Window Size : "+driver.manage().window().getSize());
        System.out.println("Window Position : "+driver.manage().window().getPosition());
        System.out.println("Window Class : "+driver.manage().window().getClass());
        System.out.println("Window hashCode : "+driver.manage().window().hashCode());
        System.out.println("Cookies : "+driver.manage().getCookies());
    }

    // Test method to get the title of the current page
    @Test
    public void getTitle()
    {
        String title = driver.getTitle();
        System.out.println("Title : "+title);
    }


    // Test method to get the current URL
    @Test
    public void getURL()
    {
        String url = driver.getCurrentUrl();
        System.out.println("Current URL : "+url);
    }


    // Test method to get the page source
    @Test
    public void getPageSource()
    {
        String pageSource = driver.getPageSource();
        System.out.println("Page Source : "+pageSource);
    }



    // Test method to navigate to Flipkart and perform navigation actions
    @Test
    public void navigateToFlipkart() throws InterruptedException
    {
        Thread.sleep(3000);

        // Navigates to the Flipkart website
        driver.navigate().to("https://www.flipkart.com/");
        Thread.sleep(5000);

        // Navigates back to the previous page
        driver.navigate().back();
        Thread.sleep(5000);

        // Navigates forward to the next page
        driver.navigate().forward();
        Thread.sleep(5000);

        // Refreshes the current page
        driver.navigate().refresh();
        Thread.sleep(5000);

        // Prints the string representation of the navigation
        String str = driver.navigate().toString();
        System.out.println(str);
    }
    // Test method for handling window handles
    @Test
    public void getWindowHandles()
    {
        System.out.println("Welcome to Window Handles");
    }



    // Test method to switch between different windows
    @Test
    public void switchTo() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(5000);
        driver.switchTo().newWindow(WindowType.WINDOW);
        Thread.sleep(8000);

    }



    // Test method to sleep for 5 seconds
    @Test
    public void sleep_FB() throws InterruptedException {
        Thread.sleep(5000);
    }

    // Runs after each test method to manage logs
    @AfterMethod
    public void manage_Logs()
    {
        System.out.println(driver.manage().logs());
    }


    // Runs after the test class to close the browser window
    @AfterClass
    public void close()
    {
        driver.close();
    }


    // Runs after the test suite to quit the browser session
    @AfterSuite
    public void quit()
    {
        driver.quit();
    }
}

