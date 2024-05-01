package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import jdk.javadoc.internal.doclets.toolkit.util.DocFile;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePages;
import pages.ProductsPage;

import java.io.File;


public class SeleniumTest {

   public static WebDriver driver;
  // static ExtentReports reports;
   public static ExtentTest test;
   static ExtentReports extent = new ExtentReports();
    private static DocFile FileUtils;

    @BeforeTest()
    public static void Setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
        extent.attachReporter(spark);
        HomePages.Click_product_menu();
        HomePages.Click_order_product();
    }
    public static String capture(WebDriver driver) {
        File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Destination = new File("src/test/resources/screenshots/" + System.currentTimeMillis() + ".png");
        String errflpath = Destination.getAbsolutePath();
        return errflpath;
    }
    @Test
    void ValidateTitles_OnlineProducts()  {

        test = extent.createTest("Validate shoe title on the product pages", "This test validates shoe title is correctly visible on the online page or not.");
        // Both extent and the report have creat test, but we should use extent (Best practice)
        ProductsPage.Formal_shoes_verify_title();
        ProductsPage.Sports_shoes_verify_title();
        ProductsPage.Sneakers_verify_title();
        extent.flush(); //This is required in order to show the report. otherwise report will not be generted.
    }
    @Test
    void validate_First_Formal_Shoes() {
        test = extent.createTest("Formal shoe table data validation", "This test is used to validate that the formal shoe dropdown has a table and the first element of the table is valid or not?");
        ProductsPage.Formal_shoes_verify_dropdown();
        extent.flush();
    }
    @Test
    void Validate_Second_Formal_Shoes(){
        test = extent.createTest("Sport shoe table data validation", "This test is used to validate that the sport shoe dropdown has a table and the first element of the table is valid or not?");
        ProductsPage.Sports_shoes_verify_dropdown();
        extent.flush();
    }
    @Test
    void Validate_Third_Formal_Shoes(){
        test = extent.createTest("Sneaker shoe table data validation", "This test is used to validate that the Sneaker shoe dropdown has a table and the first element of the table is valid or not?");
        ProductsPage.Sneakers_verify_dropdown();
        extent.flush();
    }

    @AfterSuite
    public static void Cleanup() {
        extent.flush();
    }
}
