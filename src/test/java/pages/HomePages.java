package pages;

import org.openqa.selenium.By;

import static tests.SeleniumTest.driver;

public class HomePages {
   public static String Hamburger_menu_xpath ="//*[@id=\"menuToggle\"]/input";

   public static String OnlineProduct_Link_Xpath ="//*[@id=\"menu\"]/a[3]/li";

   public static void Click_product_menu(){
      driver.findElement(By.xpath(Hamburger_menu_xpath)).click();
   }
   public static void Click_order_product() throws InterruptedException {
      Thread.sleep(2000);
      driver.findElement((By.xpath(OnlineProduct_Link_Xpath))).click();
   }
}
