package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by ofirdahan on 5/4/17.
 */
public class MainActivity {
    AndroidDriver driver;

    public void setZipCode(AndroidDriver driver, String zipCodeNumber){
        WebElement zipCode = driver.findElement(By.xpath("//android.widget.EditText[@index='2']"));
        zipCode.sendKeys(zipCodeNumber);
    }

    public void selectCarFrame(AndroidDriver driver){
        WebElement selectCarFrame = driver.findElementByAccessibilityId("Select Car");
        selectCarFrame.click();
    }

    public void selectMake(AndroidDriver driver, String carMake){
        WebElement selectCarMake = driver.findElementByAccessibilityId(carMake);
        selectCarMake.click();
    }

    public void selectModel(AndroidDriver driver, String carModel){
        //WebElement selectMCarModel = driver.findElementByAccessibilityId(carModel);
        WebElement selectCarModel = driver.findElement(By.xpath("//android.view.View[@index='4']"));
        selectCarModel.click();
    }


}
