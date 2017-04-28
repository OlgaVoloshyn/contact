import data.XpathUser;
import data.XpathUserRepository;
import functionality.XpathFunctionality;
import org.testng.annotations.Test;
import testng.AbstractTestCase;

/**
 * Created by Olya on 4/28/2017.
 */
public class XpathTest extends AbstractTestCase{

    private XpathFunctionality xpathFunctionality;
    private XpathUser xpathUser= XpathUserRepository.getXpathUser();

    @Test
    public void ClickOnPageANdFill(){
        xpathFunctionality = new XpathFunctionality();
        xpathFunctionality.openPage();
        xpathFunctionality.fillToolsQaForm(xpathUser);


    }
}
