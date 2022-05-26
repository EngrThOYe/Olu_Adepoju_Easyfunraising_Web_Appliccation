package uk.org.easyfunraising.pages;

import uk.org.easyfunraising.commons.DriverManager;

public class BasePage extends DriverManager {
    public HomePage NavigateToUrl(String Url) {
        driver.navigate().to(Url);
        return new HomePage(driver);
    }
}
