import com.google.common.base.Function;
import com.google.common.base.Predicate;
import functionality.IxlooComFunctionality;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.TestTool;

import java.util.concurrent.TimeUnit;

public class WaitTool {

    private WebDriver driver;

    private TestTool testTool;

    private IxlooComFunctionality ixlooComFunctionality;



    @Test
    public void waitForElementPresent() {
        System.setProperty("webdriver.gecko.driver", "C:/Users/Olya/IdeaProjects/waits/waits/contact/src/geckodriver-v0.14.0-win64.exe/geckodriver.exe");

        driver = new FirefoxDriver();
        driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        wait.withTimeout(15, TimeUnit.SECONDS);

        Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver arg0) {
                WebElement element = arg0.findElement(By.id("colorVar"));
                String color = element.getAttribute("style");
                System.out.println("The color if the button is " + color);
                if (color.contains("red")) {
                    return true;
                }
                return false;
            }
        };

        wait.until(function);
    }

    @Test
    public void predicateTest() {
        System.setProperty("webdriver.gecko.driver", "C:/Users/Olya/IdeaProjects/waits/waits/contact/src/geckodriver-v0.14.0-win64.exe/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        wait.withTimeout(2, TimeUnit.MINUTES);
        // wait.ignoring(NoSuchElementException.class); //make sure that this exception is ignored

        Predicate<WebDriver> predicate = new Predicate<WebDriver>() {

            public boolean apply(WebDriver arg0) {
                WebElement element = arg0.findElement(By.id("colorVar"));
                String color = element.getAttribute("style");
                System.out.println("The color if the button is " + color);
                if (color.contains("red")) {
                    return true;
                }
                return false;
            }
        };
        wait.until(predicate);
    }

    @Test
    public void returnWebelementFluentWail() {
        System.setProperty("webdriver.gecko.driver", "C:/Users/Olya/IdeaProjects/waits/waits/contact/src/geckodriver-v0.14.0-win64.exe/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        wait.withTimeout(2, TimeUnit.MINUTES);
        wait.ignoring(NoSuchElementException.class); //make sure that this exception is ignored
        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver arg0) {
                System.out.println("Checking for the element!!");
                WebElement element = arg0.findElement(By.id("target"));
                if (element != null) {
                    System.out.println("Target element found");
                }
                return element;
            }
        };

        wait.until(function);
    }

    @Test
    public void checkColorOfButton(){
        System.setProperty("webdriver.gecko.driver", "C:/Users/Olya/IdeaProjects/waits/waits/contact/src/geckodriver-v0.14.0-win64.exe/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");

        WebElement element = driver.findElement(By.id("doubleClick"));
        String colorActual = element.getAttribute("style");
        System.out.println("The color of the button is " + colorActual);

        testTool = new TestTool(driver);
        testTool.doubleClickOnBtn();

        //FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
//        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
//        wait.withTimeout(15, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.attributeContains(By.id("doubleClick"), "style","color: orange;"));

        WebElement element1 = driver.findElement(By.id("doubleClick"));
        String colorActual1 = element1.getAttribute("style");


        //Actions action = new Actions(driver);
        //action.moveToElement(driver.findElement(By.xpath("//*[@id='doubleClick']"))).doubleClick().perform(); // не спрацьовує подвійний клік

//        ixlooComFunctionality = new IxlooComFunctionality();
//        ixlooComFunctionality.doubleClickFunction();

        //testTool = new TestTool(driver);

        Assert.assertEquals(colorActual1,"color: orange;");
        System.out.println("The color of the button has been changed from white to  " + colorActual);

    }

    @Test
    public void ckeckForAlert(){
        System.setProperty("webdriver.gecko.driver", "C:/Users/Olya/IdeaProjects/waits/waits/contact/src/geckodriver-v0.14.0-win64.exe/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");

        testTool = new TestTool(driver);
        testTool.alertClick();

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.pollingEvery(25, TimeUnit.MILLISECONDS);
        wait.withTimeout(2, TimeUnit.MINUTES);

// check for availability of alert on the page
        if(wait.until(ExpectedConditions.alertIsPresent())==null)
            System.out.println("Alert was not present");
        else
            System.out.println("Alert was present");
    }

    @Test
    public void assertForAllertIsPresent(){
        System.setProperty("webdriver.gecko.driver", "C:/Users/Olya/IdeaProjects/waits/waits/contact/src/geckodriver-v0.14.0-win64.exe/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");

        testTool = new TestTool(driver);
        testTool.alertBoxClick();

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        wait.withTimeout(15, TimeUnit.SECONDS);

        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertNotNull(myAlert, "Alert is not present");
        // нашо той меседж?? він кудись виводиться чи шось перевіряє? ->
        //-> коли тест падає, не виконується, виводиться той меседж
        System.out.println("Alert was present");

    }

    @Test
    public void checkForNewBrowserWindow(){
        System.setProperty("webdriver.gecko.driver", "C:/Users/Olya/IdeaProjects/waits/waits/contact/src/geckodriver-v0.14.0-win64.exe/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");

        testTool = new TestTool(driver);
        testTool.clickToGetNewBrowserWindow();

        WebDriverWait wait = new WebDriverWait (driver, 15);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        System.out.println("Number of opened Browser Windows is 2");
    }
}



//        Wait wait = new FluentWait(driver)
//
//                .withTimeout(30, SECONDS)
//
//                .pollingEvery(5, SECONDS)
//
//                .ignoring(NoSuchElementException.class);
//
//        WebElement foo = wait.until(new Function<WebDriver, Boolean>() {
//
//            @Override
//            public Boolean apply(WebDriver driver) {
//                return driver.findElement(By.id("id")).getText().equals("sdfs");
//            }
//
//
//
//
//
//        });
//        try {
//            // nullify implicitlyWait( )
//            driver.manage().timeouts()
//                    .implicitlyWait(0, TimeUnit.SECONDS);
//            // Create web element
//            WebElement webElement =
//                    new WebDriverWait(driver, timeOutInSecond)
//                            .until(new
//                                           ExpectedConditions<Boolean>() {
//                                               @Override
//                                               public Boolean apply(WebDriver d) {
//                                                   return isElementPresent(d, by);
//                                               }
//                                           });
//            // reset implicitlyWait( )
//            driver.manage().timeouts()
//                    .implicitlyWait(10, TimeUnit.SECONDS);
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }


//    driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
//    // Click on the Button "Timing Alert"
//         driver.findElement(By.name("Timing Alert")).click();
//
//         System.out.println("Timer JavaScript Alert is triggered but it is not yet opened");
//    // Create new WebDriver wait
//    WebDriverWait wait = new WebDriverWait(driver, 10);
//    // Wait for Alert to be present
//    Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
//         System.out.println("Either Pop Up is displayed or it is Timed Out");
//    // Accept the Alert
//         myAlert.accept();
//         System.out.println("Alert Accepted");
//    // Close the main window
//         driver.close();
