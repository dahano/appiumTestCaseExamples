package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {

    public void selectFilterButton(AndroidDriver driver) throws InterruptedException {
        //WebElement clickOnFilterResultsButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc: 'Filter Results']"));
        MobileElement filterResultButton = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[2][@index='1']"));
        filterResultButton.tap(1,10);
//        System.out.println("Filtered Button "+filterResultButton.getAttribute("content-desc"));
    }
}
