package pom.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pom.pages.ClothSearchPage;
import pom.pages.MobileSearchPage;
import pom.pages.SearchItemPage;
import pom.utils.ExtentReportManager;
import pom.utils.TreadLocalWebDriver;

public class SearchTest {
 //   private MobileSearchPage mobileSearchPage;
 //   private ClothSearchPage clothSearchPage;
    private SearchItemPage searchItemPage;

    @DataProvider(name = "searchData")
    public Object[][] searchItemData(){
        return new Object[][]{
                {"iphone","Cell Phones & Accessories"},
                {"Men's T-shirts","Clothing, Shoes & Accessories"}
        };
    }

    @BeforeTest
    public void beforeTest(){
        ExtentReportManager.setupReport();
    }

    @BeforeMethod
    public void setup(){
        WebDriver driver = TreadLocalWebDriver.createWebDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
 //       mobileSearchPage = new MobileSearchPage(driver);
 //       clothSearchPage = new ClothSearchPage(driver);
        searchItemPage = new SearchItemPage(driver);
    }

 //   @Test
//    public void searchForIphone(){
 //       mobileSearchPage.searchMobile("iphone");
 //   }
//
 //    @Test
 //   public void searchForMensTShirts(){
//        clothSearchPage.searchClothing("Men's T-Shirt");
//    }
//
  //   @Test
//    public void searchItemIphone(){
  //      searchItemPage.searchItem("iPhone","Cell Phones & Accessories");
 //   }
//
  //   @Test
  //  public void searchItemCloth(){
  //      searchItemPage.searchItem("Men's t-shirt","Clothing, Shoes & Accessories");
  //  }
//

    @Test(dataProvider = "searchData")
     public void searchForItem(String itemName,String categoryName){
        ExtentReportManager.startTest("Search for item "+itemName);
        searchItemPage.searchItem(itemName,categoryName);
     }

    @AfterMethod
    public void tearDown(){
        WebDriver webDriver = TreadLocalWebDriver.getWebDriver();
        if (webDriver !=null){
            webDriver.quit();
            TreadLocalWebDriver.removeWebDriver();
        }
        ExtentReportManager.endTest();
    }
}
