package pageobject;

import data.XpathUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.AbstractPageObject;

/**
 * Created by Admin on 4/24/2017.
 */
public class XpathPage extends AbstractPageObject{

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastName;

    @FindBy(xpath = ".//*[@id='content']/form/fieldset/div[2]/strong/label")
    private WebElement sexTitle;

    @FindBy(xpath = ".//*[@id='sex-0']")
    private WebElement maleSex;

    @FindBy(xpath = ".//*[@id='sex-1']")
    private WebElement femaleSex;

    @FindBy(xpath = ".//*[@id='content']/form/fieldset/div[3]/strong/label")
    private WebElement yearsOfExperienceTitle;

    @FindBy(xpath = ".//*[@id='exp-0']")
    private WebElement oneYearExperience;

    @FindBy(xpath = ".//*[@id='exp-1']")
    private WebElement twoYearsExperience;

    @FindBy(xpath = ".//*[@id='exp-2']")
    private WebElement threeYearsExperience;

    @FindBy(xpath = ".//*[@id='exp-3']")
    private WebElement fourYearsExperience;

    @FindBy(xpath = ".//*[@id='exp-4']")
    private WebElement fiveYearsExperience;

    @FindBy(xpath = ".//*[@id='exp-5']")
    private WebElement sixYearsExperience;

    @FindBy(xpath = ".//*[@id='exp-6']")
    private WebElement sevenYearsExperience;

    @FindBy(xpath = ".//*[@id='datepicker']")
    private WebElement date;

    @FindBy(xpath = ".//*[@id='content']/form/fieldset/div[4]/strong/label")
    private WebElement professionTitle;

    @FindBy(xpath = ".//*[@id='profession-0']")
    private WebElement manualTesterProfession;

    @FindBy(xpath = ".//*[@id='profession-1']")
    private WebElement automationTesterProfession;

    @FindBy(xpath = ".//*[@id='photo']")
    private WebElement profilePicture;

    @FindBy(xpath = ".//*[@id='content']/form/fieldset/div[11]/strong/label")
    private WebElement automationToolTitle;

    @FindBy(xpath = ".//*[@id='tool-0']")
    private WebElement qtpTool;

    @FindBy(xpath = ".//*[@id='tool-1']")
    private WebElement seleniumIdeTool;

    @FindBy(xpath = ".//*[@id='tool-2']")
    private WebElement seleniumWebdriverTool;

    @FindBy(xpath = ".//*[@id='continents']")
    private WebElement continentsList;

    @FindBy(xpath = ".//*[@id='selenium_commands']/option[1]")
    private WebElement seleniumCommands;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButton;

    public XpathPage(WebDriver webDriver) {
        super(webDriver);

    }

    public void clickOnFields(){
        firstName.click();
        lastName.click();
    }

    public void fillFirstAndLastName(XpathUser xpathUser){
        firstName.sendKeys(xpathUser.getFirstName());
        lastName.sendKeys(xpathUser.getLastName());
    }

    public void getSexOfUserYearsOfExperienceDate(XpathUser xpathUser) {
                //List oRadioButtons = driver.findElements(By.name("Sex"));
        //boolean bValue = oRadioButtons.get(0).isSelected();
//        if(bValue = true) {
//            oRadioButtons.get(1).
//        }else{
//            oRadioButtons.get(0).click();
//        }
        if (!driver.findElement(By.id("sex-0")).isSelected()) {
            driver.findElement(By.id("sex-1")).click();

        }
        threeYearsExperience.click();
        date.sendKeys(xpathUser.getDate());
    }


    public void openXpathPage() {
        driver.get("http://toolsqa.com/automation-practice-form/");
    }
}
