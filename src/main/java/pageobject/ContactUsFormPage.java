package pageobject;

import data.User;
import data.User1;
import data.User2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AbstractPageObject;
import utils.driver.BasicUrls;
import utils.driver.DriverFactory;

/**
 * Created by Olya on 4/3/2017.
 */
public class ContactUsFormPage extends AbstractPageObject {

    @FindBy(css = "input[name='first_name']")
    private WebElement firstName;

    @FindBy(css = "input[name='last_name']")
    private WebElement lastName;

    @FindBy(css = "input[name='phone']")
    private WebElement phone;

    @FindBy(css = "input[name='email']")
    private WebElement email;

    @FindBy(css = "input[name='international_phone']")
    private WebElement internationalPhone;

    @FindBy(css = "input[name='street']")
    private WebElement street;

    @FindBy(css = "input[name='city']")
    private WebElement city;

    @FindBy(css = "input[name='state']")
    private WebElement state;

    @FindBy(css = "input[name='zip']")
    private WebElement zip;

    @FindBy(css = "textarea[name='comments']")
    private WebElement comments;


    @FindBy(css = ".panel-body > form > div > div > span:nth-of-type(2)")
    private WebElement submit;

    public ContactUsFormPage(WebDriver driver) {
        super(driver);
    }


    public void fillContactInformation(User user) {
        firstName.sendKeys(user.getFirstName());
        lastName.sendKeys(user.getLastName());
        phone.sendKeys(user.getPhoneNumber());
        email.sendKeys(user.getEmail());
        internationalPhone.sendKeys(user.getInternationalPhone());
        street.sendKeys(user.getAddress());
        city.sendKeys(user.getCity());
        state.sendKeys(user.getState());
        zip.sendKeys(user.getZip());
    }

    public void fillContactInformationWithComments(User1 user1) {
        firstName.sendKeys(user1.getFirstName());
        lastName.sendKeys(user1.getLastName());
        phone.sendKeys(user1.getPhoneNumber());
        email.sendKeys(user1.getEmail());
        internationalPhone.sendKeys(user1.getInternationalPhone());
        street.sendKeys(user1.getAddress());
        city.sendKeys(user1.getCity());
        state.sendKeys(user1.getState());
        zip.sendKeys(user1.getZip());
        comments.sendKeys(user1.getComments());
    }

    public void fillContactInformationWithoutZip(User2 user2) {
        firstName.sendKeys(user2.getFirstName());
        lastName.sendKeys(user2.getLastName());
        phone.sendKeys(user2.getPhoneNumber());
        email.sendKeys(user2.getEmail());
        internationalPhone.sendKeys(user2.getInternationalPhone());
        street.sendKeys(user2.getAddress());
        city.sendKeys(user2.getCity());
        state.sendKeys(user2.getState());
    }

    public void clickSubmitButton() {
        submit.click();
    }


    public void openIxlooAdminPage() {
        driver.get("http://olgav.ixloo.com/contactus");
    }

    public void openUrlInBrowser() {
        DriverFactory.getUrlLink();
    }

}