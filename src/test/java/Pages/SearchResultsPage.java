package Pages;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchResultsPage {

    public void selectFilterButton(AndroidDriver driver) throws InterruptedException {
        WebElement clickOnFilterResultsButton = driver.findElementByAccessibilityId("Filter Results");
        clickOnFilterResultsButton.click();
    }

    public void selectYearsOption(AndroidDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 6);
        WebElement yearsOption = driver.findElementByAccessibilityId("\uE258 Years");

         wait.until(ExpectedConditions.elementToBeClickable(yearsOption));
         yearsOption.click();
    }

    public void selectAllYears(AndroidDriver driver) {
        WebElement allYears = driver.findElementByAccessibilityId("All Years");
        allYears.click();
    }

    public void selectYearEndtoEnd(AndroidDriver driver){
        WebElement year2015 = driver.findElementByAccessibilityId("2 Series");
        year2015.click();
    }

    public void selectSearchButton(AndroidDriver driver){
        WebElement searchButton = driver.findElementByAccessibilityId("Search");
        searchButton.click();
    }

    public void selectColorOption(AndroidDriver driver){
        try{
            WebElement selectColor = driver.findElementByXPath("//android.view.View[@index='10']");
            selectColor.click();
        }catch (NoSuchElementException nse){
            nse.printStackTrace();
        }


    }

    public void chooseColor(AndroidDriver driver, String color){
        WebElement colorOption = driver.findElementByAccessibilityId(color);
        colorOption.click();
    }

    public void clickDoneButton(AndroidDriver driver){
        WebElement doneButton = driver.findElementByAccessibilityId("Done");
        doneButton.click();
    }


    public void selectFirstRowItem(AndroidDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement firstRowListItemContDesc = driver.findElementByXPath("//*[1]//*[1]//*[1]//*[1]//*[1]//*[1]//*[8]");
        WebElement firstRowList = driver.findElementByXPath("//android.widget.ListView[@index='7']");

        try{
            if(firstRowList.isDisplayed()){
                firstRowList.click();
            }
        }catch (NoSuchElementException nse){
            wait.until(ExpectedConditions.elementToBeClickable(firstRowListItemContDesc));
            firstRowListItemContDesc.click();
        }

    }

    public void selectShareLink(AndroidDriver driver) throws InterruptedException {
        TouchAction touchAction = new TouchAction(driver);
        try{
            touchAction.tap(988,1801).perform();
        }catch (NoSuchElementException nse){
            touchAction.tap(988,1810).perform();
            nse.printStackTrace();
        }
    }

    public void selectEmailShareLink(AndroidDriver driver){
        try{
            WebElement emailLink = driver.findElementByAccessibilityId("✉ Email");
            emailLink.click();
        }catch (NoSuchElementException nse){
            nse.printStackTrace();
            WebElement emailXPath = driver.findElement(By.xpath("//android.view.View[@index='7'"));
            emailXPath.click();
        }

    }

    public void sendEmailShareLinkTo(AndroidDriver driver, String emailAdress){
            WebElement emailBodyXpath = driver.findElementByXPath("//android.widget.EditText[@index='1']");
            emailBodyXpath.sendKeys(emailAdress);

    }

    public void selectSendEmailButton (AndroidDriver driver){
        WebElement sendEmailButton = driver.findElementByAccessibilityId("Send Email");
        sendEmailButton.click();
    }

}
