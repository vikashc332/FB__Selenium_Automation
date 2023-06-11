package com.bridgelab.selenium;
  import io.github.bonigarcia.wdm.WebDriverManager;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.chrome.ChromeOptions;
  import org.testng.annotations.*;
  import org.openqa.selenium.By;
  import org.openqa.selenium.WebElement;

 public class CreateNewAccount
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

    // Test method to perform navigation actions
    @Test
            public void login()
    {

        driver.navigate().to("https://www.flipkart.com/");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.navigate().back();
    }

    // Test method to create a new Facebook account
    @Test
    public void createNewAccount() throws InterruptedException
    {
        // Find and click on the "Create new account" link
        driver.findElement(By.linkText("Create new account")).click();
        Thread.sleep(6000);

        // Fill in the account creation form
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("vikash");
        WebElement surName = driver.findElement(By.name("lastname"));
        surName.sendKeys("chaudhary");
        WebElement mobileOrEmail = driver.findElement(By.name("reg_email__"));
        mobileOrEmail.sendKeys("6206844299");
        WebElement newPass = driver.findElement(By.name("reg_passwd__"));
        newPass.sendKeys("vikas332");
        WebElement brithday = driver.findElement(By.name("birthday_day"));
        brithday.sendKeys("04");
        WebElement brithMonth = driver.findElement(By.name("birthday_month"));
        brithMonth.sendKeys("Agust");
        WebElement brithYear = driver.findElement(By.name("birthday_year"));
        brithYear.sendKeys("1998");
        WebElement gender = driver.findElement(By.name("sex"));
        WebElement male = gender.findElement(By.xpath("//input[@value='2']"));
        male.click();
        Thread.sleep(5000);

        // Click on the "Submit" button
        driver.findElement(By.name("websubmit")).click();
        }

}
