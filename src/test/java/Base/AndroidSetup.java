package Base;

import Pages.MainActivity;
import Pages.SearchResultsPage;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;




public class AndroidSetup {
     AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Sim");
        capabilities.setCapability("app","/Path/To/Your/File/*.apk");
        capabilities.setCapability("udid", "ID OF YOUR EMULATOR");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);}

    @AfterClass
    public void tearDown() throws Exception{
        driver.quit();
    }

    @Test
    public void select2SeriesBlackBMW() throws InterruptedException {
        MainActivity mainActivity = new MainActivity();
        WebElement searchUsedCarButton = driver.findElementByAccessibilityId("Search Used Cars");
        SearchResultsPage searchResultsPage = new SearchResultsPage();


        mainActivity.setZipCode(driver, "90210");
        mainActivity.selectCarFrame(driver);
        mainActivity.selectMake(driver, "BMW");
        mainActivity.selectModel(driver, "2 Series");
        searchUsedCarButton.click();

        searchResultsPage.selectFilterButton(driver);

        searchResultsPage.selectColorOption(driver);
        searchResultsPage.chooseColor(driver,"Black");
        searchResultsPage.clickDoneButton(driver);


        searchResultsPage.selectYearsOption(driver);
        searchResultsPage.selectAllYears(driver);
        searchResultsPage.selectYearEndtoEnd(driver);
        searchResultsPage.selectYearEndtoEnd(driver);
        searchResultsPage.selectSearchButton(driver);

        searchResultsPage.selectFirstRowItem(driver);
        searchResultsPage.selectShareLink(driver);
        searchResultsPage.selectEmailShareLink(driver);
        searchResultsPage.sendEmailShareLinkTo(driver,"EMAIL ADDRESS");
        searchResultsPage.selectSendEmailButton(driver);

    }


}
