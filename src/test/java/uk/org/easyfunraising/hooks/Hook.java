package uk.org.easyfunraising.hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import uk.org.easyfunraising.commons.BrowserManager;

public class Hook extends BrowserManager {
    @Before
    public void setup() {
        launchBrowser("Chrome");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
