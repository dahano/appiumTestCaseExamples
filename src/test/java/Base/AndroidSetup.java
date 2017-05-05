package Base;

import Pages.MainActivity;
import Pages.SearchResultsPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by ofirdahan on 5/1/17.
 */

/**

 * CarGurus Test:

 Open CarGurus App
 Select Make of BMW
 Select Model of 2 Series
 Fill in Zip code of 90210
 Search Used Cars
 Filter to find a 2015 M235i in Black
 Select the first result
 Share the car via email to masonm@fair.com

 */


public class AndroidSetup {
     AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Sim");
        capabilities.setCapability("app","/Users/ofirdahan/Desktop/cargurus/cargurus.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() throws Exception{
        driver.quit();
    }

    @Test
    public void select2SeriesBlackBMW() throws InterruptedException {
        MainActivity mainActivity = new MainActivity();
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        WebElement searchUsedCarButton = driver.findElementByAccessibilityId("Search Used Cars");

        mainActivity.setZipCode(driver, "90210");
        mainActivity.selectCarFrame(driver);
        mainActivity.selectMake(driver, "BMW");
        mainActivity.selectModel(driver, "2 Series");
        searchUsedCarButton.click();
        searchResultsPage.selectFilterButton(driver);
    }


}
