package Base;

import Pages.MainActivity;
import Pages.SearchResultsPage;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
        capabilities.setCapability("udid", "192.168.56.101:5555");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() throws Exception{
        driver.quit();
    }

    @Test
    public void select2SeriesBlackBMW() throws InterruptedException {
        MainActivity mainActivity = new MainActivity();
        WebElement searchUsedCarButton = driver.findElementByAccessibilityId("Search Used Cars");
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        WaitForPageToLoad waitForPageToLoad = new WaitForPageToLoad();


        mainActivity.setZipCode(driver, "90210");
        mainActivity.selectCarFrame(driver);
        mainActivity.selectMake(driver, "BMW");
        mainActivity.selectModel(driver, "2 Series");
        searchUsedCarButton.click();

        searchResultsPage.selectFilterButton(driver);
        waitForPageToLoad.setTimeToWait(4000);

        searchResultsPage.selectColorOption(driver);
        searchResultsPage.chooseColor(driver,"Black");
        searchResultsPage.clickDoneButton(driver);

        waitForPageToLoad.setTimeToWait(4000);
        searchResultsPage.selectYearsOption(driver);
        searchResultsPage.selectAllYears(driver);
        searchResultsPage.selectYearEndtoEnd(driver);
        searchResultsPage.selectYearEndtoEnd(driver);
        searchResultsPage.selectSearchButton(driver);
        searchResultsPage.selectFirstRowItem(driver);
    }


}
