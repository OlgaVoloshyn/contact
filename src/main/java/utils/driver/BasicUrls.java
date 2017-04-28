package utils.driver;

/**
 * Created by Admin on 4/20/2017.
 */
public enum BasicUrls {

    BASIC("http://www.olgav.dxloo.com/contactus"),
    TEST("http://www.olgav.motorboxx.goxloo.com/contactus"),
    LIVE("http://olgav.ixloo.com/contactus");

    private final String url;

    BasicUrls(String url){
        this.url = url;
    }

    public String getURL() {
        return url;
    }
}
