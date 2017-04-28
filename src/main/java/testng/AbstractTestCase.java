package testng;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.driver.DriverFactory;

/**
 * Created by Olya on 4/13/2017.
 */
public class AbstractTestCase {

    @BeforeClass
    public void openAdminPage(){
        DriverFactory.getDriver();

    }

    @AfterClass
    public void quitBrowser(){
        DriverFactory.closeDriver();
    }
}
