package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.AbstractPageObject;

/**
 * Created by Admin on 4/10/2017.
 */
public class TestTool extends AbstractPageObject {

        @FindBy(id = "button1")
        private WebElement newBrowserWindow;

        @FindBy(id = "alert")
        private WebElement alertBox;

        @FindBy(id = "timingAlert")
        private WebElement alertBtn;


        @FindBy(id = "doubleClick")
        private WebElement clickBtn;

    public TestTool(WebDriver driver) {
        super(driver);
    }


    public void doubleClick(){
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(By.xpath("//*[@id='doubleClick']"))).build().perform();
    }

    public void alertClick(){
        alertBtn.click();
    }

    public void alertBoxClick(){
        alertBox.click();
    }

    public void clickToGetNewBrowserWindow(){
        newBrowserWindow.click();
    }

    public void doubleClickOnBtn(){
        Actions action = new Actions(driver);
        clickBtn.sendKeys("");
        action.doubleClick(clickBtn).perform();
    }


}
