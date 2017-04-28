import data.User;
import data.User1;
import data.User2;
import data.UserRepository;
import functionality.IxlooComFunctionality;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.driver.DriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Olya on 4/3/2017.
 */
public class FillContactUsForm {

    private WebDriver driver;

    private User ixlooUser = UserRepository.getIxlooUser();

    private User1 ixlooUserComments = UserRepository.getIxlooUserWithComments();

    private User2 ixlooUserWithoutZip = UserRepository.getIxlooUserWithoutZip();

    private IxlooComFunctionality ixlooComFunctionality;



    @BeforeTest
    public void setDriver(){
        System.setProperty("webdriver.gecko.driver", "C:/Users/Olya/IdeaProjects/waits/waits/contact/src/geckodriver-v0.14.0-win64.exe/geckodriver.exe");
        driver = new FirefoxDriver();
        ixlooComFunctionality = new IxlooComFunctionality();

    }


   @Test
    public void openBrowser() throws InterruptedException {
        driver.get("http://olgav.ixloo.com/contactus");
        ixlooComFunctionality.fillContactUs(ixlooUser);
        Thread.sleep(3000);
   }


    @Test
    public void openBrowserAndFillWithComments() throws InterruptedException {
        driver.get("http://olgav.ixloo.com/contactus");
        ixlooComFunctionality.fillContactUsWithComments(ixlooUserComments);
        Thread.sleep(3000);

    }

    @Test
    public void openBrowserAndFillWithoutZip() throws InterruptedException {
        driver.get("http://olgav.ixloo.com/contactus");
        ixlooComFunctionality.fillContactUsWithoutZip(ixlooUserWithoutZip);
        String ActualZip = driver.findElement(By.name("zip")).getText();
        Assert.assertEquals(ActualZip,"");
        System.out.println("Form can not be sent without ZIP");
        System.out.println("-----------------------------------");
        Thread.sleep(3000);
    }

    @Test
    public void openBrowserAndSubmitEmptyForm() throws InterruptedException {
        driver.get("http://olgav.ixloo.com/contactus");
        ixlooComFunctionality.leaveEmptyContactUs();
        Thread.sleep(3000);
        String ActualName = driver.findElement(By.name("first_name")).getText();
        Assert.assertEquals(ActualName,"");
        System.out.println("Form can not be sent without name");
        String ActualSurname = driver.findElement(By.name("last_name")).getText();
        Assert.assertEquals(ActualSurname,"");
        System.out.println("Form can not be sent without last name");
        String ActualPhone = driver.findElement(By.name("phone")).getText();
        Assert.assertEquals(ActualPhone,"");
        System.out.println("Form can not be sent without phone");
        String ActualEmail = driver.findElement(By.name("email")).getText();
        Assert.assertEquals(ActualEmail,"");
        System.out.println("Form can not be sent without email");
        String ActualZip = driver.findElement(By.name("zip")).getText();
        Assert.assertEquals(ActualZip,"");

    }

    @Test
    public void waitForContactUsForm() throws InterruptedException {
        driver.get("http://olgav.ixloo.com/contactus");
        ixlooComFunctionality.fillContactUsWithComments(ixlooUserComments);

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        
//        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
//        wait.withTimeout(15, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[2]/main/div/div/div/div/div/div[2]/form/div/div/span[1]"))));

        System.out.println("Contact Us form was submit");
    }

//    @AfterTest
//    public void closeBrowser(){
//        driver.quit();
//    }
//
//
}
