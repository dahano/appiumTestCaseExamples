package Pages;


import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class SearchResultsPage {
    WaitForPageToLoad waitForPageToLoad = new WaitForPageToLoad();

    public void selectFilterButton(AndroidDriver driver) throws InterruptedException {
        WebElement clickOnFilterResultsButton = driver.findElementByAccessibilityId("Filter Results");
        waitForPageToLoad.setTimeToWait(3000);
        clickOnFilterResultsButton.click();
        waitForPageToLoad.setTimeToWait(3000);
    }

    public void selectYearsOption(AndroidDriver driver){
        WebElement yearsOption = driver.findElement(By.xpath("//android.view.View[@index='4']"));

         if(yearsOption.isEnabled()) {
             waitForPageToLoad.setTimeToWait(3000);

             yearsOption.click();
         }
    }

    public void selectAllYears(AndroidDriver driver) {
        WebElement allYears = driver.findElementByAccessibilityId("All Years");
        waitForPageToLoad.setTimeToWait(5000);
        allYears.click();
    }

    public void selectYearEndtoEnd(AndroidDriver driver){
        WebElement year2015 = driver.findElementByAccessibilityId("2 Series");
        waitForPageToLoad.setTimeToWait(3000);
        year2015.click();
    }

    public void selectSearchButton(AndroidDriver driver){
        WebElement searchButton = driver.findElementByAccessibilityId("Search");
        waitForPageToLoad.setTimeToWait(3000);
        searchButton.click();
    }

    public void selectColorOption(AndroidDriver driver){
        WebElement selectColor = driver.findElementByXPath("//android.view.View[@index='10']");
        waitForPageToLoad.setTimeToWait(5000);
        selectColor.click();
    }

    public void chooseColor(AndroidDriver driver, String color){
        WebElement colorOption = driver.findElementByAccessibilityId(color);
        waitForPageToLoad.setTimeToWait(3000);
        colorOption.click();
    }

    public void clickDoneButton(AndroidDriver driver){
        WebElement doneButton = driver.findElementByAccessibilityId("Done");
        waitForPageToLoad.setTimeToWait(3000);
        doneButton.click();
    }

    public void clickReturnButton(AndroidDriver driver){
        WebElement resultsButton = driver.findElement(By.xpath("//android.widget.Button[@index='0']"));
        waitForPageToLoad.setTimeToWait(3000);
        resultsButton.click();
    }

    public void selectFirstRowItem(AndroidDriver driver){
        WebElement firstRowListItem = driver.findElementByAccessibilityId("Featured Listing");
        waitForPageToLoad.setTimeToWait(3000);
        firstRowListItem.click();
    }

}
