import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitWaits {

    public void manageImplicit() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        driver.get("http://somedomain/url_that_delays_loading");
        WebElement myDynamicElement =
                driver.findElement(By.id("myDynamicElement"));
    }


    public void manageImplicit1() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        driver.get("http://somedomain/url_that_delays_loading");
        WebElement myDynamicElement =
                driver.findElement(By.id("myDynamicElement"));
    }

}
