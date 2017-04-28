package functionality;

import data.XpathUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.XpathPage;
import utils.driver.DriverFactory;

import java.util.List;

/**
 * Created by Admin on 4/24/2017.
 */
public class XpathFunctionality {

    private XpathPage xpathPage;

    public void fillToolsQaForm(XpathUser xpathUser){
        xpathPage = new XpathPage(DriverFactory.getDriver());
        xpathPage.fillFirstAndLastName(xpathUser);
        xpathPage.getSexOfUserYearsOfExperienceDate(xpathUser);

    }

    public void openPage(){
        xpathPage = new XpathPage(DriverFactory.getDriver());
        xpathPage.openXpathPage();
    }




}
