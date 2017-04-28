package utils.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Olya on 4/13/2017.
 */
public class DriverFactory {

    private static WebDriver driver;
    private static String urltest;
    private static String urllive;
    private static String urlbasic;

    private static String url;

    private DriverFactory(){
    }

    public static WebDriver getDriver(){
        if(driver == null){
            switch(PropertyManager.getBrowserTypeFromProperties()){

                case FIREFOX:

                    System.setProperty("webdriver.gecko.driver", "C:/Users/Olya/IdeaProjects/waits/waits/contact/src/geckodriver-v0.14.0-win64.exe/geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;


                case CHROME:

                    System.setProperty("webdriver.chrome.driver", "C:/Users/Olya/IdeaProjects/waits/waits/contact/src/chromedriver_win32/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;

                case EXPLORER:
                    System.setProperty("webdriver.ie.driver", "C:/Users/Olya/IdeaProjects/waits/waits/contact/src/Explorer/MicrosoftWebDriver.exe");
                    driver = new EdgeDriver();
                    break;


            }
            setTimeouts();
        }
        return driver;
    }

    public static WebDriver setTimeouts(){
        driver.manage().timeouts().implicitlyWait(PropertyManager.getImplicitWait(), TimeUnit.SECONDS);
        return driver;
    }

    public static String getUrlLink(){
        if(url == null){
            switch(PropertyManager.getBrowserUrlFromProperies()){

                case BASIC:

                    System.setProperty("webdriver.gecko.driver", "C:/Users/Olya/IdeaProjects/waits/waits/contact/src/geckodriver-v0.14.0-win64.exe/geckodriver.exe");
                    driver = new ChromeDriver();
                    //driver.get("http://www.olgav.dxloo.com/contactus");
                    url = driver.getCurrentUrl();

                    //url = driver.getCurrentUrl(BasicUrls.BASIC);
                    break;


                case TEST:

                    System.setProperty("webdriver.chrome.driver", "C:/Users/Olya/IdeaProjects/waits/waits/contact/src/chromedriver_win32/chromedriver.exe");
                    driver = new ChromeDriver();
                    //driver.get("http://www.olgav.motorboxx.goxloo.com/contactus");
                    url = driver.getCurrentUrl();
                    //url = driver.getCurrentUrl(BasicUrls.TEST);
                    break;


                case LIVE:
                    System.setProperty("webdriver.ie.driver", "C:/Users/Olya/IdeaProjects/waits/waits/contact/src/Explorer/MicrosoftWebDriver.exe");
                    driver = new ChromeDriver();
                    //driver.get("http://olgav.ixloo.com/contactus");
                    url = driver.getCurrentUrl();
                    //url = driver.getCurrentUrl(BasicUrls.LIVE);
                    break;


            }
            setTimeouts();
        }
        return url;
//        default:
//        throw new AssertionError("Unknown url " + url);
    }


    public static void closeDriver(){
        if(driver != null){
            driver.close();
            driver.quit();

            driver = null;
        }
    }
}
