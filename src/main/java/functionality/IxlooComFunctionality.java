package functionality;

import data.User;
import data.User1;
import data.User2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.ContactUsFormPage;
import pageobject.TestTool;
import utils.driver.DriverFactory;
//import pageobject.PostSubmit;

/**
 * Created by Olya on 4/3/2017.
 */
public class IxlooComFunctionality {

    private TestTool testTool;

    //private PostSubmit postSubmitPage;

    private ContactUsFormPage contactUsFormPage;

    public void fillContactUs(User user){
        contactUsFormPage = new ContactUsFormPage(DriverFactory.getDriver());
        contactUsFormPage.fillContactInformation(user);
        contactUsFormPage.clickSubmitButton();

    }

    public void fillContactUsWithComments(User1 user1) {
        contactUsFormPage = new ContactUsFormPage(DriverFactory.getDriver());
        contactUsFormPage.fillContactInformationWithComments(user1);
        contactUsFormPage.clickSubmitButton();
//        postSubmitPage = new PostSubmit(driver);
//        String title = postSubmitPage.getTitleOfFormText();
//        String content = postSubmitPage.getContentText();
//        String buttonText = postSubmitPage.getButtonOkTest();
//        Assert.assertTrue(title.contains("Contact Us"));
//        Assert.assertTrue(content.contains("Your request has been received.\n" +
//                "A customer service representative will contact you shortly to complete the transaction.\n" +
//                "\n" +
//                "Thank you for using AUTO service."));
//        Assert.assertTrue(buttonText.contains("OK"));
//    }
    }

    public void fillContactUsWithoutZip(User2 user2){
        contactUsFormPage = new ContactUsFormPage(DriverFactory.getDriver());
        contactUsFormPage.fillContactInformationWithoutZip(user2);
        contactUsFormPage.clickSubmitButton();
    }

    public void leaveEmptyContactUs(){
        contactUsFormPage = new ContactUsFormPage(DriverFactory.getDriver());
        contactUsFormPage.clickSubmitButton();


    }

    public void doubleClickFunction(){
        testTool = new TestTool(DriverFactory.getDriver());
        testTool.doubleClick();
    }

    public void openIxlooAdmin() {
       contactUsFormPage = new ContactUsFormPage(DriverFactory.getDriver());
       contactUsFormPage.openIxlooAdminPage();
    }

    public void openUrl(User1 user1){
        contactUsFormPage = new ContactUsFormPage(DriverFactory.getDriver());
        contactUsFormPage.openUrlInBrowser();
        contactUsFormPage.fillContactInformationWithComments(user1);
        contactUsFormPage.clickSubmitButton();
    }
}
