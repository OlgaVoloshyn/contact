package utils.driver;

import java.util.ResourceBundle;

/**
 * Created by Olya on 4/13/2017.
 */
public class PropertyManager {

    private static String browserName;
    private static String browserUrl;
    private static int waitTime;
    private static ResourceBundle bundle;

    public static void getProperties(){
        bundle = ResourceBundle.getBundle("contact");

        browserName = bundle.getString("browser.type");

        //зі стрінги переводимо в інтеджер Integer.parseInt (дістаємо стрінгу з getString - повертаєм її в інтеджер)

        browserUrl = bundle.getString("basic.urls");

        waitTime = Integer.parseInt(bundle.getString("implicit.wait"));

    }

    public static BrowserType getBrowserTypeFromProperties(){
        getProperties();

        BrowserType returnBrowserType = null;

        for (BrowserType browseType: BrowserType.values()){
            if (browserName.equalsIgnoreCase(browseType.toString())){
                returnBrowserType = browseType;
                break;
            }

        }
        return returnBrowserType;

    }

    public static  int getImplicitWait(){
        getProperties();
        return waitTime;
    }

    public static BasicUrls getBrowserUrlFromProperies(){
        getProperties();

        BasicUrls returnBasicUrls = null;

        for (BasicUrls basicUrls: BasicUrls.values()){
            if (browserUrl.equalsIgnoreCase(basicUrls.toString())){
                returnBasicUrls = basicUrls;
                break;
            }

        }
        return returnBasicUrls;

    }

}
