  package com.bridgelab.selenium;

  import io.github.bonigarcia.wdm.WebDriverManager;
  import org.openqa.selenium.By;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.WebElement;
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.chrome.ChromeOptions;
  import org.testng.annotations.BeforeMethod;
  import org.testng.annotations.Test;

   public class WebElements
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

    // Test method to interact with web elements on the login page
    @Test
    public void login() throws InterruptedException {
        WebElement email = driver.findElement(By.cssSelector("input[id = 'email']"));
        email.sendKeys("Vikash@gmail.com");
        //email.clear();

        // Sleep for 5 seconds (for demonstration purposes)
        Thread.sleep(5000);

        // Find the email input field again using XPath and retrieve its location
        WebElement emailId = driver.findElement(By.xpath("//input[@id='email']"));
        int locx = emailId.getLocation().getX();
        int locy = emailId.getLocation().getY();
        System.out.println("Email x :"+locx);
        System.out.println("Email y :"+locy);

        // Enter email again using the second element found
        emailId.sendKeys("Vikash@gmail.com");

        // Find the password input field by name and enter a password
        WebElement pass = driver.findElement(By.name("pass"));
        pass.sendKeys("Vikash");

        // Find the login button by name and click it
        WebElement btn_login = driver.findElement(By.name("login"));
        btn_login.click();
    }
    @Test
    public void webelement() throws InterruptedException {

        // Finding the email WebElement using its name attribute
        WebElement email = driver.findElement(By.name("email"));

        // Getting the height and width of the email WebElement
        int uNameHeight = email.getSize().getHeight();
        int uNameWidth=email.getSize().getWidth();
        System.out.println("User Name Height : "+uNameHeight);
        System.out.println("User Name Width : "+uNameWidth);

        // Checking if the email WebElement is enabled, displayed, and selected
        System.out.println("Email is enable : "+email.isEnabled());
        System.out.println("Email is displayed : "+email.isDisplayed());
        System.out.println("Email is Selected : "+email.isSelected());
        System.out.println("Email Location : "+email.getLocation());

        // Getting the location of the email WebElement
        System.out.println("Email Attribute : "+email.getAttribute("vikas"));
        email.sendKeys("vikas");

        email.clear();
        System.out.println("Email "+email.getSize());
        String atrributeElementType = driver.findElement(By.name("email")).getAttribute("Type");
        System.out.println("Email Attribute Type : "+atrributeElementType);
        Thread.sleep(5000);
        WebElement lable=driver.findElement(By.xpath("//form"));
        String text= lable.getText();
        System.out.println("Text content is : " + text);
        driver.findElement(By.id("pass")).submit();

    }
  }
