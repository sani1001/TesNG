package pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;


import static tests.SeleniumTest.driver;
import static tests.SeleniumTest.*;

public class ProductsPage {
    public static String Formal_Shoes_name_xpath = "/html/body/div[2]/center/h2";
    public static String Sports_shoes_name_xpath = "/html/body/div[3]/center/h2";
    public static String Sneakers_name_xpath = "/html/body/div[4]/center/h2";

    public static String Formal_Shoes_Dropdown_xpath ="//i[@class='fa fa-angle-double-down formalshoedropdown']";
    public static String Sports_shoes_Dropdown_xpath ="/html/body/div[3]/center/div/i[1]";
    public static String Sneakers_Dropdown_xpath ="/html/body/div[4]/center/div/i[1]";

    public static String getFormal_Shoe_name ="/html/body/div[2]/table/tbody/tr[1]/td[1]";
    public static String getSport_Shoe_name ="/html/body/div[3]/table/tbody/tr[1]/td[1]";
    public static String getSneaker_Shoe_name = "/html/body/div[4]/table/tbody/tr[1]/td[1]";


    public static void Formal_shoes_verify_title()  {
        String Expected_titleFS = "Formal Shoes";
        String Actual_TitleFS = driver.findElement(By.xpath(Formal_Shoes_name_xpath)).getText();
        Assert.assertEquals(Expected_titleFS, Actual_TitleFS);
        if(Expected_titleFS.equals(Actual_TitleFS)){
           test.log(Status.PASS,"Test passed for this test Script of title verification of Formal shoes");
           test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver))+"Test passed");
        }
    }

    public static void Sports_shoes_verify_title() {
        String Expected_titleSS = "Sports Shoes";
        String Actual_TitleSS = driver.findElement(By.xpath(Sports_shoes_name_xpath)).getText();
        Assert.assertEquals(Expected_titleSS, Actual_TitleSS);
        if(Expected_titleSS.equals(Actual_TitleSS)){
            test.log(Status.PASS,"Test passed for this test Script of title verification of Sports shoes");
        }
    }
    public static void Sneakers_verify_title() {
        String Expected_titleS = "Sneakers";
        String Actual_TitleS = driver.findElement(By.xpath(Sneakers_name_xpath)).getText();
        Assert.assertEquals(Expected_titleS, Actual_TitleS);
        if(Expected_titleS.equals(Actual_TitleS)){
            test.log(Status.PASS,"Test passed for this test Script of title verification of Sneakers shoes");
        }
    }

    public static void Formal_shoes_verify_dropdown() {
        String Expected_dropdown = "Classic Cheltenham";
        driver.findElement(By.xpath(Formal_Shoes_Dropdown_xpath)).click();
        String Actual_Dropdown = driver.findElement(By.xpath(getFormal_Shoe_name)).getText();
        Assert.assertEquals(Expected_dropdown, Actual_Dropdown.trim());
    }

    public static void Sports_shoes_verify_dropdown() {
        String Expected_dropdown = "Ultimate";
        driver.findElement(By.xpath(Sports_shoes_Dropdown_xpath)).click();
        String Actual_Dropdown = driver.findElement(By.xpath(getSport_Shoe_name)).getText();
        Assert.assertEquals(Expected_dropdown, Actual_Dropdown.trim());

    }
    public static void Sneakers_verify_dropdown() {
        String Expected_dropdown = "Archivo";
        driver.findElement(By.xpath(Sneakers_Dropdown_xpath)).click();
        String Actual_Dropdown = driver.findElement(By.xpath(getSneaker_Shoe_name)).getText();
        Assert.assertEquals(Expected_dropdown, Actual_Dropdown.trim());
    }


}

