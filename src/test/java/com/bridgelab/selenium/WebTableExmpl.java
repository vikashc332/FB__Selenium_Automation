  package com.bridgelab.selenium;
  import io.github.bonigarcia.wdm.WebDriverManager;
  import org.openqa.selenium.By;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.WebElement;
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.chrome.ChromeOptions;
  import org.testng.annotations.AfterClass;
  import org.testng.annotations.BeforeClass;
  import org.testng.annotations.Test;

  import java.util.List;


   public class WebTableExmpl {


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
      public void tables_Function() {

          // Opening the web page with the specified file path
          driver.get("file:\\C:\\Users\\ADMIN\\Downloads\\WebTable.html");

          // Finding all the rows in the table using XPath
          List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
          int totalRows = allRows.size();
          System.out.println("total number of rows present in the table is :" + totalRows);

          // Finding all the columns (table headers) in the table using XPath
          List<WebElement> allColumns = driver.findElements(By.xpath("//th"));
          int totalColumns = allColumns.size();
          System.out.println("Total number of columns in the table is :" + totalColumns);

          // Finding all the cells (table headers and data cells) in the table using XPath
          List<WebElement> allCells = driver.findElements(By.xpath("//th|//td"));
          int totalCells = allCells.size();
          System.out.println("Total number of cells present in the table is :" + totalCells);
          int countNumberValue = 0;
          int sum = 0;
          for (WebElement cell : allCells) {

              // Getting the text value of each cell
              String cellValue = cell.getText();
              try {

                  // Parsing the cell value as an integer if it represents a number
                  int number = Integer.parseInt(cellValue);
                  System.out.print("" + number);
                  countNumberValue++;
                  sum = sum + number;
                  Thread.sleep(5000);
              } catch
              (Exception e) {

                  // Ignoring any non-numeric values in the cells
              }
          }
          System.out.println("Total count of numeric values is :" + countNumberValue);
          System.out.println("Total sum of all the numeric values is :" + sum);
      }

      @AfterClass
      public void close() {

          // Closing the WebDriver
          driver.close();
      }
   }