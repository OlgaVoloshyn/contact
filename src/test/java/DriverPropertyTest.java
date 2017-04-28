import data.User;
import data.UserRepository;
import functionality.IxlooComFunctionality;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import testng.AbstractTestCase;
import utils.driver.DriverFactory;

/**
 * Created by Olya on 4/13/2017.
 */
public class DriverPropertyTest extends AbstractTestCase{

    private IxlooComFunctionality ixlooComFunctionality;
    private User user = UserRepository.getIxlooUser();

    @Test
    public void openChrome(){
        ixlooComFunctionality = new IxlooComFunctionality();
        ixlooComFunctionality.openIxlooAdmin();
        ixlooComFunctionality.fillContactUs(user);
//        driver = DriverFactory.getDriver();
//        driver.get("http://google.com");
    }

//    @Test
//    public void openBasicUrl(){
//        ixlooComFunctionality = new IxlooComFunctionality();
//        ixlooComFunctionality.openUrl();
//
//    }
}
