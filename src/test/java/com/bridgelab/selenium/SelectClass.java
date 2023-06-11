package com.bridgelab.selenium;

  import io.github.bonigarcia.wdm.WebDriverManager;
  import org.openqa.selenium.By;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.WebElement;
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.chrome.ChromeOptions;
  import org.openqa.selenium.support.ui.Select;
  import org.testng.annotations.AfterClass;
  import org.testng.annotations.BeforeClass;
  import org.testng.annotations.Test;

  import java.util.List;

   public class SelectClass
   {
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
    public void newUser_Registration() throws InterruptedException
    {
        driver.get("file:\\C:\\Users\\ADMIN\\Downloads\\selectOptions.html");
        driver.manage().window().maximize();

        // Locating the dropdown element by its ID
        WebElement element = driver.findElement(By.id("mySelectElement"));

        // Creating a Select object by passing the dropdown element
        Select sct = new Select(element);

        // Checking if the dropdown is a multi-select option dropdown
        Boolean listboxType = sct.isMultiple();
        System.out.println("The list box is Multi Select option list box : "+listboxType);

        // Getting all the options from the dropdown
        List <WebElement>list = sct.getOptions();
        int size = list.size();
        System.out.println("Element Count : "+size);

        // Printing the text of each option in the dropdown
        for(WebElement webElement : list)
        {
            String text = webElement.getText();
            System.out.println(text);
        }

        // Selecting options from the dropdown using different methods
        sct.selectByIndex(0);
        Thread.sleep(2000);
        sct.selectByValue("d");
        Thread.sleep(2000);
        sct.selectByVisibleText("vdda");
        Thread.sleep(2000);
        sct.selectByVisibleText("puri");

        // Getting all the selected options from the dropdown
        List <WebElement> list2 = sct.getAllSelectedOptions();
        int size2 = list2.size();
        System.out.println("Selected element count : "+size2);

        // Printing the text of each selected option
        for (WebElement webElement2 : list2)
        {
            String text2 = webElement2.getText();
            System.out.println(text2);
        }
        Thread.sleep(2000);
//       sct.deselectByVisibleText("option 3");
//        Thread.sleep(2000);
//        sct.deselectByValue("option2");
//        Thread.sleep(2000);
//        sct.deselectByIndex(0);
        Thread.sleep(2000);




    }
 //    @AfterClass
   //   public void close()
     {
         // Closing the WebDriver
    //    driver.close();
      }
    }
